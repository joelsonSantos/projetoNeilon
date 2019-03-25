/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            
        }catch(SQLException e){
            System.out.println("Problemas Ocorreram ao salvar o socio Torcedor" );
            e.printStackTrace();
            throw new Exception("Erro ao salvar Dados.");
            
        }finally{
            
        }
        return false;

    }
    
    
    
}
