/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.CadastroJogadorController;
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
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JOptionPane;
import static jdk.internal.org.objectweb.asm.commons.GeneratorAdapter.AND;
import persistencia.Conexao;
import visao.CadastroJogador;
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
                JOptionPane.showMessageDialog(null, "idPessoa gerado    "+jogador.getIdPessoa());
            }
            st.executeUpdate("insert into endereco (rua, numero, bairro, cidade, "
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
            
            st.executeUpdate("insert into jogador (categoria, nomeEmpresario, posicao,"
                    + "peso, altura, idPessoa_fk) "
                    + "value ('"+jogador.getCategoria() +"','"
                        +jogador.getNomeEmpresario() +"','"
                        +jogador.getPosicao() +"','"
                        +jogador.getPeso() +"','"
                        +jogador.getAltura() +"','"
                        +jogador.getIdPessoa()
                    +"')");
            
            JOptionPane.showMessageDialog(null, "jogador salvo... ");
            st.executeUpdate("insert into contatos (telefoneResidencial, celular, email, idPessoa_fk)"
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
    
    public static Jogador pesquisa(Jogador nome) throws Exception{
        Jogador jogador = null;
        String nomeJogador= nome.getNome();
        try{
            Conexao conect = new Conexao();
            PreparedStatement st = conect.getConnection().prepareStatement("SELECT * FROM pessoa where nome = ?");
            st.setString(1, nomeJogador);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                jogador = new Jogador();
                jogador.setIdPessoa(rs.getInt("idPessoa"));
                JOptionPane.showMessageDialog(null, "idPessoa primenra pesquisa  "+ jogador.getIdPessoa());
                pesquisaID(jogador);
            }
            
        }catch (Exception e) {
            System.out.println("Problemas Ocorreram");
            e.printStackTrace();
            throw new Exception("Erro na pesquisa");
    
        }
        return jogador;
        
    }
    public static Jogador pesquisaID(Jogador jogadorPesquisa) throws Exception{
        
        int idPessoa = jogadorPesquisa.getIdPessoa();
        JOptionPane.showMessageDialog(null, "idPessoa segunda pesquisa"+ idPessoa);
        try{
            Conexao conect = new Conexao();
            PreparedStatement st = conect.getConnection().prepareStatement("SELECT pessoa.nome, pessoa.sobrenome,"
                    + "pessoa.nacionalidade, pessoa.rg, pessoa.cpf, pessoa.dataNascimento, pessoa.escolaridade,"
                    + "pessoa.instituicao, pessoa.sexo, contatos.telefoneResidencial, contatos.celular, contatos.email,"
                    + "endereco.rua, endereco.numero, endereco.bairro, endereco.cidade, endereco.estado, endereco.pais,"
                    + "endereco.complemento, endereco.cep, jogador.categoria, jogador.nomeEmpresario, jogador.posicao,"
                    + "jogador.peso, jogador.altura "
                    + "FROM pessoa, contatos, endereco, jogador "
                    + "WHERE idPessoa = ? AND idPessoa = contatos.idPessoa_fk AND " 
                    + " idPessoa = endereco.idPessoa_fk AND idPessoa = jogador.idPessoa_fk");
            
            st.setInt(1, idPessoa);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                
                jogadorPesquisa.setNome(rs.getString("pessoa.nome"));
                jogadorPesquisa.setSobreNome(rs.getString("pessoa.sobrenome"));
                jogadorPesquisa.setNacionalidade(rs.getString("pessoa.nacionalidade"));
                jogadorPesquisa.setRg(rs.getString("pessoa.rg"));
                jogadorPesquisa.setCpf(rs.getString("pessoa.cpf"));
                jogadorPesquisa.setDataNascimento(rs.getString("pessoa.dataNascimento"));
                jogadorPesquisa.setEscolaridade(rs.getString("pessoa.escolaridade"));
                jogadorPesquisa.setInstituicao(rs.getString("pessoa.instituicao"));
                jogadorPesquisa.setSexo(rs.getString("pessoa.sexo"));              
                jogadorPesquisa.setContato(new Contato(rs.getString("contatos.telefoneResidencial"), rs.getString("contatos.celular"),
                rs.getString("contatos.email")));

                JOptionPane.showMessageDialog(null, "telefone residencial apos a pesquisa   "+ jogadorPesquisa.contato.getTelefoneResidencial());
                
                jogadorPesquisa.setEndereco(new Endereco((rs.getString("endereco.rua")),
                (rs.getString("endereco.numero")),
                (rs.getString("endereco.bairro")),
                (rs.getString("endereco.cidade")),
                (rs.getString("endereco.estado")),
                (rs.getString("endereco.pais")),
                (rs.getString("endereco.complemento")),
                (rs.getString("endereco.cep"))));
                
                JOptionPane.showMessageDialog(null, "rua apos a pesquisa   "+ jogadorPesquisa.endereco.getRua());
                
                jogadorPesquisa.setCategoria(rs.getString("jogador.categoria"));
                jogadorPesquisa.setNomeEmpresario(rs.getString("jogador.nomeEmpresario"));
                jogadorPesquisa.setPosicao(rs.getString("jogador.posicao"));
                jogadorPesquisa.setPeso(rs.getDouble("jogador.peso"));
                jogadorPesquisa.setAltura(rs.getDouble("jogador.altura"));
                
                System.out.println(jogadorPesquisa.toString());
                JOptionPane.showMessageDialog(null,"toString jogador, "+jogadorPesquisa.toString());
                
            }
        }catch(Exception e){
            System.out.println("Problemas Ocorreram");
            e.printStackTrace();
            throw new Exception("Erro na pesquisa.");
        }
        JOptionPane.showMessageDialog(null, "idPessoa segunda pesquisa"+ jogadorPesquisa.getIdJogador());
        JOptionPane.showMessageDialog(null, "nome segunda pesquisa"+ jogadorPesquisa.getNome());
        //CadastroJogador.preencherTelaJogador(jogadorPesquisa);
        return jogadorPesquisa;
    }
    
   public ArrayList<Jogador> listar() throws SQLException{
       
       ArrayList<Jogador> jogadorLista = new ArrayList<Jogador>();
       try{
           Conexao conect = new Conexao();
           PreparedStatement st = conect.getConnection().prepareStatement("SELECT *"
                    + "FROM pessoa INNER JOIN contatos ON  pessoa.idPessoa = contatos.idPessoa_fk"
                   + " INNER JOIN endereco ON pessoa.idPessoa= endereco.idPessoa_fk "
                   + " INNER JOIN jogador ON pessoa.idPessoa = jogador.idPessoa_fk");
           ResultSet rs = st.executeQuery();
                while(rs.next()){
                    Jogador jogador = new Jogador();
                    jogador.setNome(rs.getString("pessoa.nome"));
                    jogador.setSobreNome(rs.getString("pessoa.sobrenome"));
                    jogador.setDataNascimento(rs.getString("pessoa.dataNascimento"));
                    jogador.setCategoria(rs.getString("jogador.categoria"));
                    jogador.setContato(new Contato((rs.getString("contatos.email"))));
                    jogador.setEndereco(new Endereco((rs.getString("endereco.cidade"))) );

                    jogadorLista.add(jogador);
                }
       }catch(SQLException e){
           
       }
        return jogadorLista;
   }
   
   public static void atualizar (Jogador jogador) throws SQLException{
       JOptionPane.showMessageDialog(null, "metodo de atualizar jogador");
       if (jogador == null){
           JOptionPane.showMessageDialog(null, "O jogador no encontrado...");
           //return;
       }
       try{
            Conexao conect = new Conexao();
            //String sql;
            StringBuilder sql = new StringBuilder();
            //StringBuilder sqlJogador = new StringBuilder();
            //sql.append("UPDATE projetoNeilon.pessoa SET");//JOIN jogador JOIN endereco JOIN contatos SET");
            sql.append("UPDATE pessoa, jogador, endereco, contatos "
                    + "SET pessoa.nome = ?, pessoa.sobrenome = ?, pessoa.nacionalidade = ?,"
                    + "pessoa.rg = ?, pessoa.cpf = ?, pessoa.dataNascimento = ?,"
                    + "pessoa.escolaridade = ?, pessoa.instituicao = ?, pessoa.sexo = ?,"
                    + "jogador.categoria = ?, jogador.nomeEmpresario =?, jogador.posicao =?,"
                    + "jogador.peso =?, jogador.altura=?, jogador.assistencia=?,jogador.mediaGols=?,"
                    + "endereco.rua = ?, endereco.numero = ?, endereco.bairro = ?, endereco.cidade = ?,"
                    + "endereco.estado = ?, endereco.pais = ?, endereco.complemento = ?, endereco.cep = ?,"
                    + "contatos.telefoneResidencial = ?, contatos.celular = ?, contatos.email = ?"
                    + "FROM pessoa JOIN contatos ON  pessoa.idPessoa = contatos.idPessoa_fk"
                   + " JOIN endereco ON pessoa.idPessoa= endereco.idPessoa_fk "
                   + " JOIN jogador ON pessoa.idPessoa = jogador.idPessoa_fk");
            sql.append("WHERE idPessoa =?");
//            String sql =("UPDATE pessao SET nome=?, sobrenome=?, nacionalidade=?, rg=?,"
//                    + "cpf=?, dataNascimento=?, escolaridade=?, instituicao=?, sexo=?"
//                    + "WHERE idPessoa=?");
            PreparedStatement st = conect.getConnection().prepareStatement(sql.toString());
            st.setString(1, jogador.getNome());
            st.setString(2, jogador.getSobreNome());
            st.setString(3, jogador.getNacionalidade());
            st.setString(4, jogador.getRg());
            st.setString(5, jogador.getCpf());
            st.setString(6, jogador.getDataNascimento());
            st.setString(7, jogador.getEscolaridade());
            st.setString(8, jogador.getInstituicao());
            st.setString(9, jogador.getSexo());
            
            st.setString(10, jogador.getCategoria());
            st.setString(11, jogador.getNomeEmpresario());
            st.setString(12, jogador.getPosicao());
            st.setDouble(13, jogador.getPeso());
            st.setDouble(14, jogador.getAltura());
            st.setInt(15, jogador.getAssistencia());
            st.setDouble(16, jogador.getMediaGols());
            st.setString(17, jogador.endereco.getRua());
            st.setString(18, jogador.endereco.getNumero());
            st.setString(19, jogador.endereco.getBairro());
            st.setString(20, jogador.endereco.getCidade());
            st.setString(21 ,jogador.endereco.getEstado());
            st.setString(22, jogador.endereco.getPais());
            st.setString(23, jogador.endereco.getComplemento());
            st.setString(24, jogador.endereco.getCep());
            st.setString(25, jogador.contato.getTelefoneResidencial());
            st.setString(26, jogador.contato.getCelular());
            st.setString(27, jogador.contato.getEmail());
            st.setInt(28, jogador.getIdPessoa());
            
            //sqlJogador.append("UPDATE jogador SET");
            //sqlJogador.append("categoria = ?, nomeEmpresario = ?, posicao = ?, "
            //        + "peso = ?, altura = ?, assistencia = ?, mediaGols = ?");
            //sqlJogador.append("WHERE idPessoa_fk = pessoa.idPessoa");
            st.execute();
            
            JOptionPane.showMessageDialog(null, "Cadastro Atualizado...Jogador DAO");
            
       }catch(SQLException u){
           JOptionPane.showMessageDialog(null, "erro no catch SQL  " + u);
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Erroa ao atualizar o jogador no banco de dados"+ e.getMessage());
       }
        
       
       
   }
   
   public static void delete(int idpessoa) throws SQLException{
       Conexao conexao = new Conexao();
       JOptionPane.showMessageDialog(null, "idPessoa deletada "+ idpessoa);
       String sql ="DELETE FROM pessoa INNER JOIN contatos ON  pessoa.idPessoa = contatos.idPessoa_fk"
                   + " INNER JOIN endereco ON pessoa.idPessoa= endereco.idPessoa_fk "
                   + " INNER JOIN jogador ON pessoa.idPessoa = jogador.idPessoa_fk"
                   + "wherw idPessoa = ? ON DELETE CASCADE "; 
       PreparedStatement st = conexao.getConnection().prepareStatement(sql);
       st.setInt(1, idpessoa);
       st.executeUpdate(sql);
       
       JOptionPane.showMessageDialog(null, "Jogador apagador.....");

       
   }
    
}
