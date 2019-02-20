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
import static jdk.internal.org.objectweb.asm.commons.GeneratorAdapter.AND;
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
            
            st.executeUpdate("insert into pessoa(nome, sobrenome,"
                    + "nacionalidade, rg, cpf, dataNascimento, escolaridade,"
                    + "instituicao, sexo) "
                    + "values('" + jogador.getNome()+ "','"
                            + jogador.getSobreNome() +"','"
                            + jogador.getNacionalidade() +"','"
                            + jogador.getRg() +"','"
                            + jogador.getCpf() +"','"
                            + jogador.getDataNascimento() +"','"
                            + jogador.getEscolaridade() +"','"
                            + jogador.getInstituicao() +"','"
                            + jogador.getSexo()
                    +"')", Statement.RETURN_GENERATED_KEYS);  
            JOptionPane.showMessageDialog(null, "pessoa gravada...  ");
            final ResultSet rs = st.getGeneratedKeys();
            
            if (rs.next()){
                ///final int idResult = rs.getInt(1);
                jogador.setIdPessoa(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "idPessao "+jogador.getIdPessoa());
            }
            st.execute("insert into endereco(rua, numero, bairro, cidade, "
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
                    +"')");
            JOptionPane.showMessageDialog(null, "endereco salvo... ");
            
            st.execute("insert into jogador (categoria, nomeEmpresario, posicao,"
                    + "peso, altura, idPessoa_fk) "
                    + "value ('"+jogador.getCategoria() +"','"
                        +jogador.getNomeEmpresario() +"','"
                        +jogador.getPosicao() +"','"
                        +jogador.getPeso() +"','"
                        +jogador.getAltura() +"','"
                        +jogador.getIdPessoa()
                    +"')");
            
            JOptionPane.showMessageDialog(null, "jogador salvo... ");
            st.execute("insert into contatos (telefoneResidencial, celular, email, idPessoa_fk)"
                    + "values('"+jogador.getContato().getTelefoneResidencial() +"','"
                        + jogador.getContato().getCelular() +"','"
                        +jogador.getContato().getEmail() +"','"
                        +jogador.getIdPessoa()
                    +"')")  ;
                
        } catch (Exception e){
            System.out.println("Problemas Ocorreram ao salvar");
            e.printStackTrace();
            throw new Exception ("Erro ao Salvar Dados!");
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
                /*jogador.setNome(rs.getString("nome"));
                jogador.setSobreNome(rs.getString("sobrenome"));
                jogador.setNacionalidade(rs.getString("nacionalidade"));
                jogador.setRg(rs.getString("rg"));
                jogador.setCpf(rs.getString("cpf"));
                jogador.setDataNascimento(rs.getString("dataNascimento"));
                jogador.setEscolaridade(rs.getString("escolaridade"));
                jogador.setInstituicao(rs.getString("instituicao"));*/
                pesquisaID(jogador.getIdPessoa());
            }
            
        }catch (Exception e) {
            System.out.println("Problemas Ocorreram");
            e.printStackTrace();
            throw new Exception("Erro na pesquisa");
    
        }
        return jogador;
        
    }
    public static Jogador pesquisaID(int idPessoa) throws Exception{
        Jogador jogador = null;
        try{
            Conexao conect = new Conexao();
            PreparedStatement st = conect.getConnection().prepareStatement("SELECT pessoa.nome, pessoa.sobrenome, pessoa.nacionalidade, pessoa.rg,"
                    + "pessoa.cpf, pessoa.dataNascimento, pessoa.escolaridade, pessoa.instituicao, pessoa.sexo, contatos.telefoneResidencial,"
                    + "contatos.celular, contatos.email, endereco.rua, endereco.numero, endereco.bairro, endereco.cidade, endereco.estado,"
                    + "endereco.pais, endereco.complemento, endereco.cep, jogagor.categoria, jogador.nomeEmpresario, jogador.posicao, "
                    + "jogador.peso, jogador.altura "
                    + "FROM pessoa, contatos, endereco, jogador "
                    + "WHERE pessoa.idPessoa = contatos.idPessoa_fk AND "
                    + " pessoa.idPessoa = endereco.idPessoa_fk AND pessoa.idPessoa = jogador.idPessoa_fk");
            st.setInt(1, idPessoa);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                
            }
        }catch(Exception e){
            System.out.println("Problemas Ocorreram");
            e.printStackTrace();
            throw new Exception("Erro na pesquisa.");
        }
        return jogador;
    }
   
    
}
