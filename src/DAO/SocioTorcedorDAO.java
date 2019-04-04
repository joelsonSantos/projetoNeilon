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

     public static SocioTorcedor pesquisaCPF(SocioTorcedor cpf) throws Exception{
        SocioTorcedor socio = null;
        String cpfSocio= cpf.getCpf();
        try{
            Conexao conect = new Conexao();
            JOptionPane.showMessageDialog(null, "cpf para pesquisa no metodo pesquisa .  " + cpfSocio);
            PreparedStatement st = conect.getConnection().prepareStatement("SELECT * FROM pessoa where cpf = ?");
            //JOptionPane.showMessageDialog(null, "apos o select  ");
            st.setString(1, cpfSocio);
            //JOptionPane.showMessageDialog(null, "apos st.setString  ");
            ResultSet rs = st.executeQuery();
            //JOptionPane.showMessageDialog(null, "apos o resultSet  ");
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "apos o rs.next  ");
                socio = new SocioTorcedor();
                socio.setIdPessoa(rs.getInt("idPessoa"));
                JOptionPane.showMessageDialog(null, "idPessoa primenra pesquisa  "+ socio.getIdPessoa());
                pesquisaSocio(socio);
            }
            
        }catch (Exception e) {
            System.out.println("Problemas Ocorreram  na pesquisa do idPessoa" + e);
            e.printStackTrace();
            throw new Exception("Erro na pesquisa");
    
        }
        return socio;
        
    }
    public static SocioTorcedor pesquisaSocio(SocioTorcedor socio) throws Exception{
        int cpfPesquisa =socio.getIdPessoa();
        try {
            Conexao conect = new Conexao();
            /*PreparedStatement st = conect.getConnection().prepareStatement("SELECT pessoa.nome, pessoa.sobrenome, "
                    + " pessoa.dataNascimento, pessoa.cpf, "
                    + "endereco.rua, endereco.numero, endereco.complemento, endereco.cep, endereco.bairro, "
                    + "endereco.cidade, contatos.telefoneResidencial, contatos.celular, contatos.email, "
                    + "socioTorcedor.modalidadeTorcedor, socioTorcedor.dataFiliacao, socioTorcedor.formaPagamento "
                    + "FROM pessoa, contatos, endereco, socioTorcedor WHERE idPessoa = ? AND "
                    + " pessoa.idPessoa = endereco.idPessoa_fk AND pessoa.idPessoa = contatos.idPessoa_fk "
                    + " AND pessoa.idPessoa = socioTorcedor.idPessoa_fk ");*/
            PreparedStatement st = conect.getConnection().prepareStatement("SELECT pessoa.nome, pessoa.sobrenome, "
                    + " pessoa.cpf, pessoa.dataNascimento, pessoa.rg, pessoa.nacionalidade, pessoa.escolaridade, "
                    + "pessoa.instituicao, pessoa.sexo, "
                    + "contatos.telefoneResidencial, contatos.celular, contatos.email,"
                    + "endereco.rua, endereco.numero, endereco.bairro, endereco.cidade, endereco.estado, endereco.pais, "
                    + "endereco.complemento, endereco.cep, socioTorcedor.modalidadeTorcedor, socioTorcedor.dataFiliacao, "
                    + "socioTorcedor.formaPagamento, socioTorcedor.idSocioTorcedor "
                    + "FROM pessoa, contatos, endereco, socioTorcedor "
                    + "WHERE idPessoa = ? AND idPessoa = contatos.idPessoa_fk AND " 
                    + " idPessoa = endereco.idPessoa_fk AND idPessoa = socioTorcedor.idPessoa_fk");
            st.setInt(1, cpfPesquisa);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                
                socio.setNome(rs.getString("pessoa.nome"));
                socio.setSobreNome(rs.getString("pessoa.sobrenome"));
                socio.setDataNascimento(rs.getDate("pessoa.dataNascimento"));
                socio.setCpf(rs.getString("pessoa.cpf"));
                socio.setRg(rs.getString("pessoa.rg"));
                socio.setNacionalidade(rs.getString("pessoa.nacionalidade"));
                socio.setEscolaridade(rs.getString("pessoa.escolaridade"));
                socio.setInstituicao(rs.getString("pessoa.instituicao"));
                socio.setSexo(rs.getString("pessoa.sexo"));
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
                JOptionPane.showMessageDialog(null, "telefone residencial apos a pesquisa   "+socio.contato.getTelefoneResidencial());
                socio.setModalidadePlano(rs.getString("socioTorcedor.modalidadeTorcedor"));
                socio.setFormaPagamento(rs.getString("socioTorcedor.formaPagamento"));
                socio.setDataFiliacao(rs.getDate("socioTorcedor.dataFiliacao"));
                socio.setIdSocioTorcedor(rs.getInt("socioTorcedor.idSocioTorcedor"));
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
    
public static void atualizar(SocioTorcedor socio) throws SQLException{
    if(socio == null){
        JOptionPane.showMessageDialog(null, "socio torcedor não encontrado. ");
    }
    try {
        Conexao conexao = new Conexao();
        String sql;
        java.sql.Date dataNascimento = new java.sql.Date(socio.getDataNascimento().getTime());
        java.sql.Date dataFiliacao = new java.sql.Date(socio.getDataFiliacao().getTime());
        
        sql = "UPDATE pessoa INNER JOIN contatos ON pessoa.idPessoa = contatos.idPessoa_fk "
                + "INNER JOIN endereco ON pessoa.idPessoa = endereco.idPessoa_fk "
                + "INNER JOIN socioTorcedor ON pessoa.idPessoa = socioTorcedor.idPessoa_fk "
                + "SET pessoa.nome = ? , pessoa.sobrenome = ? , pessoa.nacionalidade = ? , pessoa.rg = ? ,"
                + "pessoa.cpf = ? , pessoa.dataNascimento = ? , pessoa.escolaridade = ? , "
                + "pessoa.instituicao = ? , pessoa.sexo = ? , "
                + "contatos.telefoneResidencial = ? , contatos.celular = ? , contatos.email = ? ,"
                + "endereco.rua = ? , endereco.numero = ? , endereco.bairro = ? , endereco.cidade = ? , endereco.estado = ? , endereco.pais = ? , "
                + "endereco.complemento = ? , endereco.cep = ? , socioTorcedor.modalidadeTorcedor = ? , socioTorcedor.dataFiliacao = ? , "
                + "socioTorcedor.formaPagamento = ? "
                + "WHERE pessoa.idPessoa = ?";
        
        PreparedStatement st = conexao.getConnection().prepareStatement(sql);
        st.setString(1, socio.getNome());
        st.setString(2, socio.getSobreNome());
        st.setString(3, socio.getNacionalidade());
        st.setString(4, socio.getRg());
        JOptionPane.showMessageDialog(null, "cpf alterado no metodo" + socio.getCpf());
        st.setString(5, socio.getCpf());
        st.setDate(6, dataNascimento);
        st.setString(7, socio.getEscolaridade());
        st.setString(8, socio.getInstituicao());
        st.setString(9, socio.getSexo());
        st.setString(10, socio.getContato().getTelefoneResidencial());
        st.setString(11, socio.getContato().getCelular());
        st.setString(12, socio.getContato().getEmail());
        st.setString(13, socio.getEndereco().getRua());
        st.setString(14, socio.getEndereco().getNumero());
        st.setString(15, socio.getEndereco().getBairro());
        st.setString(16, socio.getEndereco().getCidade());
        st.setString(17, socio.getEndereco().getEstado());
        st.setString(18, socio.getEndereco().getPais());
        st.setString(19, socio.getEndereco().getComplemento());
        st.setString(20, socio.getEndereco().getCep());
        st.setString(21, socio.getModalidadePlano());
        st.setDate(22, dataFiliacao);
        st.setString(23, socio.getFormaPagamento());
        st.setInt(24, socio.getIdPessoa());
        st.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Cadastro do Socio Torcedor Atualizada com sucesso.");
        conexao.fecharConexao();
    }catch(SQLException u){
        JOptionPane.showMessageDialog(null, "Erro SQL no atualizar o cadastro " + u);
        System.err.println("ERRO SQL " + u.toString());
    }catch (Exception e) {
        JOptionPane.showMessageDialog(null," Erro ao atualizar o cadastro do socio torcedor  "+e);
        System.err.println("ERRO " + e.toString());
    }
}

public static void delete(String cpfSocio) throws SQLException{
    try {
        Conexao conexao = new Conexao();
        
        String sql = "DELETE FROM pessoa WHERE cpf = ?";
        JOptionPane.showMessageDialog(null, "cpf para ser apagador.   " +cpfSocio);
        PreparedStatement st = conexao.getConnection().prepareStatement(sql);
            st.setString(1, cpfSocio);
            st.executeUpdate();
        conexao.fecharConexao();
    } catch (Exception e) {
        System.err.println("ERRO ao deleter " + e );
    }
    JOptionPane.showMessageDialog(null,"Socio Torcedor apagador com sucesso. " );
}
    
    
}
