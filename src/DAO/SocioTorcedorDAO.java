/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controle.Contato;
import controle.Endereco;
import controle.SocioTorcedor;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import persistencia.Conexao;
import visao.TelaSocioTorcedor;

/**
 *
 * @author laiendercamargos
 */
public class SocioTorcedorDAO {

    public static boolean persistir(controle.SocioTorcedor socio) throws Exception {
        try{
            Conexao conect =new Conexao();
            Statement st = conect.getSt();
            java.sql.Date data = new java.sql.Date(socio.getDataNascimento().getTime());
            st.executeUpdate("insert into pessoa(nome, sobrenome,"
                    + "nacionalidade, rg, cpf, dataNascimento, escolaridade,"
                    + "instituicao, sexo) "
                    + "values('" +socio.getNome() +"','"
                    + socio.getSobreNome()+ "','"
                    + socio.getNacionalidade() + "','"
                    + socio.getRg() +"','"
                    + socio.getCpf() +"','"
                    + data +"','"
                    + socio.getEscolaridade() +"','"
                    + socio.getInstituicao() +"','"
                    + socio.getSexo()
                    +",')",Statement.RETURN_GENERATED_KEYS);
            final ResultSet rs = st.getGeneratedKeys();
            if(rs.next()){
                socio.setIdPessoa(rs.getInt(1));
            }
            
            st.executeUpdate("insert into endereco (rua, numero, bairro, cidade, "
                    + "estado, pais, complemento, cep, idPessoa_fk)"
                    + " values('"+socio.getEndereco().getRua()+"','"
                        +socio.getEndereco().getNumero() +"','"
                        +socio.getEndereco().getBairro() +"','" 
                        +socio.getEndereco().getCidade() +"','"
                        +socio.getEndereco().getEstado() +"','"
                        +socio.getEndereco().getPais() +"','"
                        +socio.getEndereco().getComplemento() +"','"
                        +socio.getEndereco().getCep() +"','"
                        +socio.getIdPessoa()
                    +"')");
            java.sql.Date dataFiliacao = new java.sql.Date(socio.getDataFiliacao().getTime());
            st.executeUpdate("insert into socioTorcedor(modalidadeTorcedor, dataFiliacao, formaPagamento, idPessoa_fk)"
                    + "values('"+socio.getModalidadePlano() + "','"
                        +dataFiliacao +"','"
                        +socio.getFormaPagamento() +"','"
                        +socio.getIdPessoa()
                    +"')");
            
            st.executeUpdate("insert into contatos (telefoneResidencial, celular, email, idPessoa_fk)"
                    + "values('"+socio.getContato().getTelefoneResidencial() +"','"
                        + socio.getContato().getCelular() +"','"
                        +socio.getContato().getEmail() +"','"
                        +socio.getIdPessoa()
                    +"')")  ;
        }catch(SQLException e){
            System.out.println("Problemas Ocorreram ao salvar o socio Torcedor" );
            e.printStackTrace();
            throw new Exception("Erro ao salvar Dados.");
            
        }finally{
            
        }
        return false;

    }

    public static SocioTorcedor pesquisaSocio(SocioTorcedor socio) throws Exception{
        String cpfPesquisa =socio.getCpf();
        try {
            Conexao conect = new Conexao();
            PreparedStatement st = conect.getConnection().prepareStatement("SELECT pessoa.nome, pessoa.sobrenome, pessoa.dataNascimento"
                    + "endereco.rua, endereco.numero, endereco.complemento, endereco.cep, endereco.bairro,"
                    + "endereco.cidade, contatos.telefoneResidencial, contatos.celular, contatos.email,"
                    + "socioTorcedor.modalidadeTorcedor, socioTorcedor.dataFiliacao, socioTorcedor.formaPagamento"
                    + "FROM pessoa, contatos, endereco, socioTorcedor WHERE pessoa.cpf = ? AND "
                    + " pessoa.idPessoa = endereco.idPessoa_fk AND pessoa.idPessoa = contatos.idPessoa_fk"
                    + " AND pessoa.idPessoa = socioTorcedor.idPessoa_fk");
            st.setString(1, cpfPesquisa);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                socio.setNome(rs.getString("pessoa.nome"));
                socio.setSobreNome(rs.getString("pessoa.sobrenome"));
                socio.setDataNascimento(rs.getDate("pessoa.dataNascimento"));
                socio.setEndereco(new Endereco((rs.getString("endereco.rua")),
                    (rs.getString("endereco.numero")),
                    (rs.getString("endereco.bairro")),
                    (rs.getString("endereco.cidade")),
                    (rs.getString("endereco.estado")),
                    (rs.getString("endereco.pais")),
                    (rs.getString("endereco.complemento")),
                    (rs.getString("endereco.cep"))));
                socio.setContato(new Contato(rs.getString("contatos.telefoneResidencial"), 
                        rs.getString("contatos.celular"),
                        rs.getString("contatos.email")));
                socio.setModalidadePlano(rs.getString("socioTorcedor.modalidadeTorcedor"));
                socio.setFormaPagamento(rs.getString("socioTorcedor.formaPagamento"));
                socio.setDataFiliacao(rs.getDate("socioTorcedor.dataFiliacao"));
            }
        } catch (Exception e) {
            System.err.println("Erro na pesquisa" + e);
            e.printStackTrace();
            //throw  new Exception("erro na pesquisa");
        }
        return socio;
    }
    
    public ArrayList<SocioTorcedor> listarSocio() throws SQLException{
        ArrayList<SocioTorcedor> listaSocio = new ArrayList<SocioTorcedor>();
        try {
            Conexao conect = new Conexao();
            PreparedStatement st = conect.getConnection().prepareStatement("SELECT *"
                    + "FROM pessoa INNER JOIN socioTorcedor ON pessoa.idPessoa = socioTorcedor.idPessoa_fk"
                    + " INNER JOIN endereco ON pessoa.idPessoa = endereco.idPessoa_fk");
                    //+ " INNER JOIN contatos ON pessoa.idPessoa = contatos.idPessoa_fk");
            ResultSet rs = st.executeQuery();
                while(rs.next()){
                    SocioTorcedor socio = new SocioTorcedor();
                    socio.setIdSocioTorcedor(rs.getInt("socioTorcedor.idSocioTorcedor"));
                    socio.setNome(rs.getString("pessoa.nome"));
                    socio.setSobreNome(rs.getString("pessoa.sobrenome"));
                    socio.setModalidadePlano(rs.getString("socioTorcedor.modalidadeTorcedor"));
                    socio.setFormaPagamento(rs.getString("socioTorcedor.formaPagamento"));
                    socio.setDataFiliacao(rs.getDate("socioTorcedor.dataFiliacao"));
                    socio.setCpf(rs.getString("pessoa.cpf"));
                    listaSocio.add(socio);
                    
                }
        } catch (SQLException e) {
            System.out.println("erro no listar socios" + e);
        }
        return listaSocio;
    }
    
    
    
}
