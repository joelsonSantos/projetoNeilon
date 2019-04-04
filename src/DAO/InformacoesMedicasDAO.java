/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controle.InformacoesMedicas;
import controle.Jogador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import persistencia.Conexao;

/**
 *
 * @author laiendercamargos
 */
public class InformacoesMedicasDAO {
    
    public static boolean persistir(Jogador informacao) throws Exception{
        try{
            
            Conexao conect = new Conexao();
            Statement st = conect.getSt();
            java.sql.Date ultimaConsulta = new java.sql.Date(informacao.getInformacoa().getDataRevisao().getTime());
            java.sql.Date proximaConsulta = new java.sql.Date(informacao.getInformacoa().getProximaRevisao().getTime());
            JOptionPane.showMessageDialog(null, "idJogador.  " + informacao.getInformacoa().getIdJogador());
            st.execute("insert into informacoesMedicas (dataUltimaRevisao, dataProximaRevisao, restricaoMedicamento, "
                + " informacoesMedica, tipoSanguinio, idJogador_fk) values('"+ ultimaConsulta + "','"
                + proximaConsulta + "','"
                + informacao.getInformacoa().getRestricaoMedicamento() + "','"
                + informacao.getInformacoa().getComentarioMedico() +"','"
                + informacao.getInformacoa().getTipoSanguineo() + "','"
                + informacao.getInformacoa().getIdJogador()+
                "')");
            conect.fecharConexao();
            }catch(SQLException u){
            System.err.println("Erro no SQL. " + u);
            u.printStackTrace();
        }catch(Exception e){
            System.err.println("clase DAO erro ao salvar as infomações medicas.. " + e);
            e.printStackTrace();
        
        }
        finally{
           
        }
        
        
        return false;
        
    }
    
    public static Jogador pesquisar(Jogador informacao) throws Exception{
        int idJogador = informacao.getInformacoa().getIdJogador();
        
        try {
            Conexao conect = new Conexao();
            PreparedStatement st = conect.getConnection().prepareStatement("SELECT informacoesMedicas.dataUltimaRevisao,"
                    + "informacoesMedicas.dataProximaRevisao, "
                    + "informacoesMedicas.restricaoMedicamento, "
                    + "informacoesMedicas.informacoesMedica, "
                    + "informacoesMedicas.tipoSanguinio"
                    + "FROM informacoesMedicas"
                    + "WHERE informacoesMedicas.idJogador_fk = ? ");
            
            st.setInt(1, idJogador);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                
                informacao.setInformacoa(new InformacoesMedicas(rs.getInt("informacoesMedicas.idJogador"),
                rs.getDate("informacoesMedicas.dataUltimaRevisao"),
                rs.getDate("informcoesMedicas.dataProximaRevisao"),
                rs.getString("informacoesMedicas.restricaoMedicamento"),
                rs.getString("informacoesMedicas.informacoesMedica"),
                rs.getString("informacoesMedicas.tipoSanguinio")));
                
            }
        } catch (Exception e) {
            System.err.println("Erro na pesquisa de informacoes medicas.  ");
        }
        
        return informacao;
        
    }

    
    
