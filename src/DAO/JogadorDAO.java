/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

//import Controller.CadastroJogadorController;
//import com.mysql.jdbc.CharsetMapping;
//import com.sun.org.apache.xalan.internal.xsltc.cmdline.getopt.GetOpt;
import controle.Contato;
import controle.Endereco;
import controle.Jogador;
//import controle.Pessoa;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Locale;
import javax.swing.JOptionPane;
//import static jdk.internal.org.objectweb.asm.commons.GeneratorAdapter.AND;
import persistencia.Conexao;
//import visao.CadastroJogador;
//import visao.TelaJogador;


/**
 *
 * @author laiendercamargos
 */
public class JogadorDAO {
    
    public static boolean persistir(Jogador jogador) throws Exception{
        
        try{
            Conexao conect = new Conexao();
            Statement st = conect.getSt();
            java.sql.Date data = new java.sql.Date(jogador.getDataNascimento().getTime());
            st.executeUpdate("insert into pessoa(nome, sobrenome,"
                    + "nacionalidade, rg, cpf, dataNascimento, escolaridade,"
                    + "instituicao, sexo) "
                    + "values('" + jogador.getNome()+ "','"
                            + jogador.getSobreNome() +"','"
                            + jogador.getNacionalidade() +"','"
                            + jogador.getRg() +"','"
                            + jogador.getCpf() +"','"
                            + data +"','"
                            + jogador.getEscolaridade() +"','"
                            + jogador.getInstituicao() +"','"
                            + jogador.getSexo()
                    +"')", Statement.RETURN_GENERATED_KEYS);  
            //JOptionPane.showMessageDialog(null, "pessoa gravada... data ne nascimento  " + jogador.getDataNascimento());
            final ResultSet rs = st.getGeneratedKeys();
            
            if (rs.next()){
                ///final int idResult = rs.getInt(1);
                jogador.setIdPessoa(rs.getInt(1));
                //JOptionPane.showMessageDialog(null, "idPessoa gerado    "+jogador.getIdPessoa());
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
            //JOptionPane.showMessageDialog(null, "endereco salvo... ");
            
            st.executeUpdate("insert into jogador (categoria, nomeEmpresario, posicao,"
                    + "peso, altura, idPessoa_fk) "
                    + "value ('"+jogador.getCategoria() +"','"
                        +jogador.getNomeEmpresario() +"','"
                        +jogador.getPosicao() +"','"
                        +jogador.getPeso() +"','"
                        +jogador.getAltura() +"','"
                        +jogador.getIdPessoa()
                    +"')",Statement.RETURN_GENERATED_KEYS);
            final ResultSet rsJogador = st.getGeneratedKeys();
            if(rsJogador.next()){
                jogador.setIdJogador(rsJogador.getInt(1));
            }
            
            //JOptionPane.showMessageDialog(null, "jogador salvo... ");
            st.executeUpdate("insert into contatos (telefoneResidencial, celular, email, idPessoa_fk)"
                    + "values('"+jogador.getContato().getTelefoneResidencial() +"','"
                        + jogador.getContato().getCelular() +"','"
                        +jogador.getContato().getEmail() +"','"
                        +jogador.getIdPessoa()
                    +"')")  ;
            //JOptionPane.showMessageDialog(null, "Contatos salvo... ");
                conect.fecharConexao();
        } catch (Exception e){
            System.out.println("Problemas Ocorreram ao salvar");
            e.printStackTrace();
            throw new Exception ("Erro ao Salvar Dados!");
        }finally{
            
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
                //JOptionPane.showMessageDialog(null, "idPessoa primenra pesquisa  "+ jogador.getIdPessoa());
                pesquisaID(jogador);
            }
            conect.fecharConexao();
        }catch (Exception e) {
            System.out.println("Problemas Ocorreram");
            e.printStackTrace();
            throw new Exception("Erro na pesquisa");
    
        }
        
        return jogador;
        
    }
    public static Jogador pesquisaID(Jogador jogadorPesquisa) throws Exception{
        
        int idPessoa = jogadorPesquisa.getIdPessoa();
        //JOptionPane.showMessageDialog(null, "idPessoa segunda pesquisa"+ idPessoa);
        try{
            Conexao conect = new Conexao();
            PreparedStatement st = conect.getConnection().prepareStatement("SELECT pessoa.nome, pessoa.sobrenome,"
                    + "pessoa.nacionalidade, pessoa.rg, pessoa.cpf, pessoa.dataNascimento, pessoa.escolaridade,"
                    + "pessoa.instituicao, pessoa.sexo, contatos.telefoneResidencial, contatos.celular, contatos.email,"
                    + "endereco.rua, endereco.numero, endereco.bairro, endereco.cidade, endereco.estado, endereco.pais,"
                    + "endereco.complemento, endereco.cep, jogador.idJogador, jogador.categoria, jogador.nomeEmpresario, jogador.posicao,"
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
                jogadorPesquisa.setDataNascimento(rs.getDate("pessoa.dataNascimento"));
                jogadorPesquisa.setEscolaridade(rs.getString("pessoa.escolaridade"));
                jogadorPesquisa.setInstituicao(rs.getString("pessoa.instituicao"));
                jogadorPesquisa.setSexo(rs.getString("pessoa.sexo"));              
                jogadorPesquisa.setContato(new Contato(rs.getString("contatos.telefoneResidencial"), rs.getString("contatos.celular"),
                rs.getString("contatos.email")));

                //JOptionPane.showMessageDialog(null, "telefone residencial apos a pesquisa   "+ jogadorPesquisa.contato.getTelefoneResidencial());
                
                jogadorPesquisa.setEndereco(new Endereco((rs.getString("endereco.rua")),
                (rs.getString("endereco.numero")),
                (rs.getString("endereco.bairro")),
                (rs.getString("endereco.cidade")),
                (rs.getString("endereco.estado")),
                (rs.getString("endereco.pais")),
                (rs.getString("endereco.complemento")),
                (rs.getString("endereco.cep"))));
                
                //JOptionPane.showMessageDialog(null, "rua apos a pesquisa   "+ jogadorPesquisa.endereco.getRua());
                
                jogadorPesquisa.setIdJogador(rs.getInt("jogador.idJogador"));
                jogadorPesquisa.setCategoria(rs.getString("jogador.categoria"));
                jogadorPesquisa.setNomeEmpresario(rs.getString("jogador.nomeEmpresario"));
                jogadorPesquisa.setPosicao(rs.getString("jogador.posicao"));
                jogadorPesquisa.setPeso(rs.getDouble("jogador.peso"));
                jogadorPesquisa.setAltura(rs.getDouble("jogador.altura"));
                
                //System.out.println(jogadorPesquisa.toString());
                //JOptionPane.showMessageDialog(null,"toString jogador, "+jogadorPesquisa.toString());
                conect.fecharConexao();
            }
        }catch(Exception e){
            System.out.println("Problemas Ocorreram");
            e.printStackTrace();
            throw new Exception("Erro na pesquisa.");
        }
        //JOptionPane.showMessageDialog(null, "idPessoa segunda pesquisa"+ jogadorPesquisa.getIdJogador());
        //JOptionPane.showMessageDialog(null, "nome segunda pesquisa"+ jogadorPesquisa.getNome());
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
                    jogador.setDataNascimento(rs.getDate("pessoa.dataNascimento"));
                    jogador.setCategoria(rs.getString("jogador.categoria"));
                    jogador.setContato(new Contato((rs.getString("contatos.email"))));
                    jogador.setEndereco(new Endereco((rs.getString("endereco.cidade"))) );
                    jogador.setPosicao(rs.getString("jogador.posicao"));

                    jogadorLista.add(jogador);
                    
                }
                conect.fecharConexao();
       }catch(SQLException erro){
           System.out.println("Erro ao listar jogadores " + erro);
           
       }
        return jogadorLista;
   }
   
   public static void atualizar (Jogador jogador) throws SQLException{
       //JOptionPane.showMessageDialog(null, "metodo de atualizar jogador");
       if (jogador == null){
           JOptionPane.showMessageDialog(null, "O jogador no encontrado...");
           //return;
       }
       try{
            Conexao conect = new Conexao();
            String sql;
            //StringBuilder sql = new StringBuilder();
            java.sql.Date data = new java.sql.Date(jogador.getDataNascimento().getTime());

            sql="UPDATE pessoa INNER JOIN contatos ON pessoa.idPessoa= contatos.idPessoa_fk "
                    + "INNER JOIN endereco ON pessoa.idPessoa = endereco.idPessoa_fk "
                    + "INNER JOIN jogador ON pessoa.idPessoa = jogador.idPessoa_fk SET pessoa.nome =?, pessoa.sobrenome =?, "
                    + "pessoa.nacionalidade =?, pessoa.rg =?, pessoa.cpf =?, pessoa.dataNascimento =?, pessoa.escolaridade =?,"
                    + "pessoa.instituicao =?, pessoa.sexo =?, contatos.telefoneResidencial =?, contatos.celular =?, contatos.email =?,"
                    + "endereco.rua =?, endereco.numero =?, endereco.bairro =?, endereco.cidade =?, endereco.estado =?, endereco.pais =?,"
                    + "endereco.complemento =?, endereco.cep =?, jogador.categoria =?, jogador.nomeEmpresario =?, jogador.posicao =?,"
                    + "jogador.peso =?, jogador.altura =? "
                    + "WHERE pessoa.idPessoa = ?";
            
            PreparedStatement st = conect.getConnection().prepareStatement(sql);
            st.setString(1, jogador.getNome());
            st.setString(2, jogador.getSobreNome());
            st.setString(3, jogador.getNacionalidade());
            st.setString(4, jogador.getRg());
            st.setString(5, jogador.getCpf());
            st.setDate(6, data);
            st.setString(7, jogador.getEscolaridade());
            st.setString(8, jogador.getInstituicao());
            st.setString(9, jogador.getSexo());
            st.setString(10, jogador.getContato().getTelefoneResidencial());
            st.setString(11, jogador.getContato().getCelular());
            st.setString(12, jogador.getContato().getEmail());
            st.setString(13, jogador.getEndereco().getRua());
            st.setString(14, jogador.getEndereco().getNumero());
            st.setString(15, jogador.getEndereco().getBairro());
            st.setString(16, jogador.getEndereco().getCidade());
            st.setString(17 ,jogador.getEndereco().getEstado());
            st.setString(18, jogador.getEndereco().getPais());
            st.setString(19, jogador.getEndereco().getComplemento());
            st.setString(20, jogador.getEndereco().getCep());
            st.setString(21, jogador.getCategoria());
            st.setString(22, jogador.getNomeEmpresario());
            st.setString(23, jogador.getPosicao());
            st.setDouble(24, jogador.getPeso());
            st.setDouble(25, jogador.getAltura());
            st.setInt(26, jogador.getIdPessoa());
            st.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cadastro Atualizado..");
            conect.fecharConexao();
       }catch(SQLException u){
           JOptionPane.showMessageDialog(null, "erro no catch SQL  " + u);
           System.err.println("erro SQL " + u);
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Erroa ao atualizar o jogador no banco de dados"+ e.getMessage());
           System.err.println(""+ e.getMessage());
       }
        
       
       
   }
   
   public static void delete(int idpessoa) throws SQLException{
       
       try{
           
           Conexao conexao = new Conexao();
           
           //JOptionPane.showMessageDialog(null, "idPessoa deletada idPessoa" + idpessoa);
           
           String sql ="DELETE FROM pessoa WHERE idPessoa = ? "; 
           PreparedStatement st = conexao.getConnection().prepareStatement(sql);
                st.setInt(1, idpessoa);
                st.executeUpdate();
            
           conexao.fecharConexao();
       }catch(Exception  e ){
           System.err.println("erro no deletar" + e);
           JOptionPane.showMessageDialog(null, "erro ao deletar " +e);
       }
           
       JOptionPane.showMessageDialog(null, "Jogador apagador.....");

       
   }
    
}
