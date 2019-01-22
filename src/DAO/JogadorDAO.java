/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.CharsetMapping;
import com.sun.org.apache.xalan.internal.xsltc.cmdline.getopt.GetOpt;
import controle.Jogador;
import controle.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import persistencia.Conexao;
import visao.TelaJogador;


/**
 *
 * @author laiendercamargos
 */
public class JogadorDAO {
    
    public static boolean persistir(Jogador jogador) throws Exception{
      
        try{
            Conexao conect = new Conexao();
            Statement st = conect.getSt();
            st.execute("insert into pessoa(nome, sobrenome,"
                    + "nacionalidade, rg, cpf, dataNascimento, escolaridade,"
                    + "instituicao) "
                    + "values('" + jogador.getNome()+ "','"
                            + jogador.getSobreNome() +"','"
                            + jogador.getNacionalidade() +"','"
                            + jogador.getRg() +"','"
                            + jogador.getCpf() +"','"
                            + jogador.getDataNascimento() +"','"
                            + jogador.getEscolaridade() +"','"
                            + jogador.getInstituicao()
                    
                    +"')");  
            
            /*st.execute("insert into endereco(rua, numero, bairro, cidade, "
                    + "estado, pais, complemento, cep, idPessoa_fk)"
                    + " values('"+jogador.getEndereco().getRua()+"','"
                        +jogador.getEndereco().getNumero() +"','"
                        +jogador.getEndereco().getBairro() +"','" 
                        +jogador.getEndereco().getCidade() +"','"
                        +jogador.getEndereco().getEstado() +"','"
                        +jogador.getEndereco().getPais() +"','"
                        +jogador.getEndereco().getComplemento() +"','"
                        +jogador.getEndereco().getCep() +"','"
                        +jogador.getIdPessoa()
                    +"')", st.RETURN_GENERATED_KEYS);
            
            st.execute("insert into jogador (categoria, nomeEmpresario, posicao,"
                    + "peso, altura, idPessoa_fk) "
                    + "value ('"+jogador.getCategoria() +"','"
                        +jogador.getNomeEmpresario() +"','"
                        +jogador.getPosicao() +"','"
                        +jogador.getPeso() +"','"
                        +jogador.getAltura() +"','"
                        +jogador.getIdPessoa()
                    +"')", st.RETURN_GENERATED_KEYS);
            
            st.execute("insert into contatos (telefoneResidencial, celular, email, idPesooa_fk)"
                    + "values('"+jogador.getContato().getTelefoneResidencial() +"','"
                        + jogador.getContato().getCelular() +"','"
                        +jogador.getContato().getEmail() +"','"
                        +jogador.getIdPessoa()
                    +"')", st.RETURN_GENERATED_KEYS)  ;*/
            
            
        } catch (Exception e){
            System.out.println("Problemas Ocorreram ao salvar");
            e.printStackTrace();
            throw new Exception ("Erro ao Salvar Dados!");
        }
        
        try{
            Conexao conect = new Conexao();
            PreparedStatement st = conect.getConnection().prepareStatement("SELECT idPessoa FROM pessoa where idPessoa = ? ");
            //st.setInt(1, idPessoa);
            ResultSet rs = st.executeQuery();
            jogador.setIdPessoa(rs.getInt("idPessoa"));
            JOptionPane.showMessageDialog(null, "idPessao"+jogador.getIdPessoa());
        }catch(Exception e){
            System.out.println("Problemas Ocorreram ao pesquisar");
            e.printStackTrace();
            throw  new Exception("Erro ao pesquisar dados");
        }
        return false;
        
    }
    
    public static Jogador pesquisa(char nome) throws Exception{
        Jogador jogador = null;
        
        try{
            Conexao conect = new Conexao();
            PreparedStatement st = conect.getConnection().prepareStatement("SELECT * FROM pessoa where nome = ?");
            st.setInt(1, nome);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                jogador = new Jogador();
                jogador.setIdPessoa(rs.getInt("idPessoa"));
                jogador.setNome(rs.getString("nome"));
                jogador.setSobreNome(rs.getString("sobrenome"));
                jogador.setNacionalidade(rs.getString("nacionalidade"));
                jogador.setRg(rs.getString("rg"));
                jogador.setCpf(rs.getString("cpf"));
                jogador.setDataNascimento(rs.getString("dataNascimento"));
                jogador.setEscolaridade(rs.getString("escolaridade"));
                jogador.setInstituicao(rs.getString("instituicao"));
                
                
                
            }
        }catch (Exception e) {
            System.out.println("Problemas Ocorreram");
            e.printStackTrace();
            throw new Exception("Erro na pesquisa");
    
        }
        return jogador;
        
    }
   
    
}
