/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

//import java.beans.Statement;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author laiendercamargos
 */
public class Conexao {
    
    private com.mysql.jdbc.Connection con;
    public Statement st;
    private String url = "jdbc:mysql://localhost:3306/projetoNeilon";
    private String user = "root";
    private String pass = "";
    public ResultSet rs;
    
    public Conexao() throws SQLException{
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            this.con = (com.mysql.jdbc.Connection) DriverManager.getConnection(this.url, this.user, this.pass);
            this.st = (Statement) this.con.createStatement();
            JOptionPane.showMessageDialog(null,"Dados gravados com Sucesso!");
            
                
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            JOptionPane.showMessageDialog(null,"Erro na Conexao");
        }finally{
            JOptionPane.showMessageDialog(null, "finalizar");
            //con.close();
            //st.close();
        }
    }
    /*public static void fecharConexao(Connection conn) throws SQLException{
        try {
            if (conn != null){
                conn.close();
                System.out.println("Fechada a conexao como banco de dados.");
            }catch(Exception e){
                    System.out.println("Nao foi possive fechar a conexao com o banco e dados"+e.getMessge());
            }
        }
    
    }*/
    public com.mysql.jdbc.Connection getCon(){
        return this.con;
    }
    public void setCon(com.mysql.jdbc.Connection con){
        this.con = con;
    }
    public Statement getSt(){
        return this.st;
    }
    public void setSt(Statement st){
        this.st = st;
    }
    public String getPass(){
        return this.pass;
    }
    public void setPass(String pass){
        this.pass = pass;
    }
    public String getUrl(){
        return this.url;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public String getUser(){
        return this.user;
    }
    public void setUser(String user){
        this.user = user;
    }    
    public Connection getConnection(){
        return this.con;        
    }
    
}
