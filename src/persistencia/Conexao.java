/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.beans.Statement;
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
    private String url = "jdbc:mysql://localhost:3306/projetoNeilo";
    private String user = "root";
    private String pass = "";
    public ResultSet rs;
    
    public Conexao() throws SQLException{
        try{
            JOptionPane.showMessageDialog(null,"Dados gravados com Sucesso!");
            Class.forName("com.mysql.jdbc.Driver");
            this.con = (com.mysql.jdbc.Connection) DriverManager.getConnection(this.url, this.user, this.pass);
            this.st = (Statement) this.con.createStatement();
            
                
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            JOptionPane.showMessageDialog(null,"Erro na Conexao");
        }finally{
            //con.close();
            //st.close();
        }
    }
    
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
