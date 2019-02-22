/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.CharsetMapping;
import com.sun.org.apache.xalan.internal.xsltc.cmdline.getopt.GetOpt;
import controle.Contato;
import controle.Endereco;
import controle.Jogador;
import controle.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
            JOptionPane.showMessageDialog(null, "Contatos salvo... ");
                
        } catch (Exception e){
            System.out.println("Problemas Ocorreram ao salvar");
            e.printStackTrace();
            throw new Exception ("Erro ao Salvar Dados!");
        }
        
        
        
        return false;
        
    }
    
    public static Jogador pesquisa(String nome) throws Exception{
        Jogador jogador = null;
        Pessoa pessoa = null;
        
        try{
            Conexao conect = new Conexao();
            PreparedStatement st = conect.getConnection().prepareStatement("SELECT * FROM pessoa where nome = ?");
            st.setString(1, nome);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                jogador = new Jogador();
                pessoa =new Pessoa();
                jogador.setIdPessoa(rs.getInt("idPessoa"));
                //pessoa.setIdPessoa(rs.getInt("idPessoa"));
                /*jogador.setNome(rs.getString("nome"));
                jogador.setSobreNome(rs.getString("sobrenome"));
                jogador.setNacionalidade(rs.getString("nacionalidade"));
                jogador.setRg(rs.getString("rg"));
                jogador.setCpf(rs.getString("cpf"));
                jogador.setDataNascimento(rs.getString("dataNascimento"));
                jogador.setEscolaridade(rs.getString("escolaridade"));
                jogador.setInstituicao(rs.getString("instituicao"));*/
                JOptionPane.showMessageDialog(null, "idPessoa"+ jogador.getIdPessoa());
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
        Endereco endereco = null;
        Contato contatos = null;
        Pessoa pessoa = null;
        JOptionPane.showMessageDialog(null, "idPessoa segunda pesquisa"+ idPessoa);
        try{
            Conexao conect = new Conexao();
            PreparedStatement st = conect.getConnection().prepareStatement("SELECT *"
                    + "FROM pessoa, contatos, endereco, jogador "
                    + "WHERE idPessoa = ? AND idPessoa = contatos.idPessoa_fk AND " +
"                    +  idPessoa = endereco.idPessoa_fk AND idPessoa = jogador.idPessoa_fk");
            
            /*pessoa.nome, pessoa.sobrenome, pessoa.nacionalidade, pessoa.rg,"
                    + "pessoa.cpf, pessoa.dataNascimento, pessoa.escolaridade, pessoa.instituicao, pessoa.sexo, contatos.telefoneResidencial,"
                    + "contatos.celular, contatos.email, endereco.rua, endereco.numero, endereco.bairro, endereco.cidade, endereco.estado,"
                    + "endereco.pais, endereco.complemento, endereco.cep, jogagor.categoria, jogador.nomeEmpresario, jogador.posicao, "
                    + "jogador.peso, jogador.altura 
            idPessoa = contatos.idPessoa_fk AND "
                    + " idPessoa = endereco.idPessoa_fk AND idPessoa = jogador.idPessoa_fk
            */
            st.setInt(1, idPessoa);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                pessoa = new Pessoa();
                jogador = new Jogador();
                endereco = new Endereco();
                contatos = new Contato();
                pessoa.setNome(rs.getString("pessoa.nome"));
                pessoa.setSobreNome(rs.getString("pessoa.sobrenome"));
                pessoa.setNacionalidade(rs.getString("pessoa.nacionalidade"));
                pessoa.setRg(rs.getString("pessoa.rg"));
                pessoa.setCpf(rs.getString("pessoa.cpf"));
                pessoa.setDataNascimento(rs.getString("pessoa.dataNascimento"));
                pessoa.setEscolaridade(rs.getString("pessoa.escolaridade"));
                pessoa.setInstituicao(rs.getString("pessoa.instituicao"));
                pessoa.setSexo(rs.getString("pessoa.sexo"));
                contatos.setTelefoneResidencial(rs.getString("contatos.telefoneResidencial"));
                contatos.setCelular(rs.getString("contatos.celular"));
                contatos.setEmail(rs.getString("contatos.email"));
                endereco.setRua(rs.getString("endereco.rua"));
                endereco.setNumero(rs.getString("endereco.numero"));
                endereco.setBairro(rs.getString("endereco.bairro"));
                endereco.setCidade(rs.getString("endereco.cidade"));
                endereco.setEstado(rs.getString("endereco.estado"));
                endereco.setPais(rs.getString("endereco.pais"));
                endereco.setComplemento(rs.getString("endereco.complemento"));
                endereco.setCep(rs.getString("endereco.cep"));
                jogador.setCategoria(rs.getString("jogador.categoria"));
                jogador.setNomeEmpresario(rs.getString("jogador.nomeEmpresario"));
                jogador.setPosicao(rs.getString("jogador.posicao"));
                jogador.setPeso(rs.getDouble("jogador.peso"));
                jogador.setAltura(rs.getDouble("jogador.altura"));
                
                System.out.println(pessoa.toString());
                System.out.println(jogador.toString());
                System.out.println(contatos.toString());
                System.out.println(endereco.toString());
                
            }
        }catch(Exception e){
            System.out.println("Problemas Ocorreram");
            e.printStackTrace();
            throw new Exception("Erro na pesquisa.");
        }
        return jogador;
    }
    
   public static ArrayList<Jogador> listar() throws SQLException{
       Conexao conect = new Conexao();
       ArrayList<Jogador> jogadorLista = new ArrayList<>();
       try{
           System.out.println("listar dados na tabela 4.");
           PreparedStatement st = conect.getConnection().prepareStatement("SELECT pessoa.nome, pessoa.sobrenome, pessoa.dataNascimento,"
                   + "jogador.categoria, contatos.email, endereco.cidade "
                   + "FROM pessoa, contatos, endereco, jogador "
                    + "WHERE idPessoa = contatos.idPessoa_fk AND " +
"                    +  idPessoa = endereco.idPessoa_fk AND idPessoa = jogador.idPessoa_fk");
           System.out.println("listar dados na tabela 5.");
           ResultSet rs = st.executeQuery();
                while(rs.next()){
                    System.out.println("listar dados na tabela 6.");
                    Jogador jogador = new Jogador();
                    Contato contato = new Contato();
                    Endereco endereco = new Endereco();
                    jogador.setNome(rs.getString("pessoa.nome"));
                    System.out.println("pessoa.nome"+jogador.getNome());
                    jogador.setSobreNome(rs.getString("pessoa.sobrenome"));
                    System.out.println("pessoa.sobrenome"+jogador.getSobreNome());
                    jogador.setDataNascimento(rs.getString("pessoa.dataNascimento"));
                    System.out.println("pessoa.dataNascimento"+ jogador.getDataNascimento());
                    jogador.setCategoria(rs.getString("jogador.categoria"));
                    System.out.println("jogador.categoria " +jogador.getCategoria());
                    contato.setEmail(rs.getString("contatos.email"));
                    System.out.println("jogador.contato.email" + contato.getEmail());
                    endereco.setCidade(rs.getString("endereco.cidade"));
                    System.out.println("jogador.endereco.cidade " + endereco.getCidade());
                    System.out.println("listar dados na tabela 9.");
                    System.out.println("jogador.setNome "+jogador.getNome()+ "jogador.setSobrenome "+ jogador.getSobreNome()
                    +"jogador.setDataNascimento"+jogador.getDataNascimento()+"jogador.setCategoria"+jogador.getCategoria()
                    +"jogador.contato.setEmail"+contato.getEmail()+"jogador.endereco.setCidade"+endereco.getCidade());
                    
                    
                    jogadorLista.add(jogador);
                }
       }catch(SQLException e){
           
       }
        return null;
   }
    
}
