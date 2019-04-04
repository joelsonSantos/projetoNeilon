/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controle.InformacoesMedicas;
import controle.Jogador;
import java.sql.SQLException;
import java.sql.Statement;
import persistencia.Conexao;

/**
 *
 * @author laiendercamargos
 */
public class InformacoesMedicasDAO {
    
    public static boolean persistir(Jogador informacao) throws SQLException{
        try{
            Conexao conect = new Conexao();
        Statement st = conect.getSt();
        java.sql.Date ultimaConsulta = new java.sql.Date(informacao.getInformacoa().getDataRevisao().getTime());
        java.sql.Date proximaConsulta = new java.sql.Date(informacao.getInformacoa().getProximaRevisao().getTime());
        st.executeUpdate("insert into informacoesMedicas (dataUltimaRevisao, dataProximaRevisao, restricaoMedicamento, "
                + " informacoesMedicas, tipoSanguinio, idJogador_fk) values('"+ ultimaConsulta + "','"
                + proximaConsulta + "','"
                + informacao.getInformacoa().getRestricaoMedicamento() + "','"
                + informacao.getInformacoa().getComentarioMedico() +"','"
                + informacao.getInformacoa().getTipoSanguineo() + "','"
                + informacao.getIdJogador()+
                "')");
        
        }catch(Exception e){
            System.err.println("erro ao salvar as infomações medicas.. " + e);
            e.printStackTrace();
        }finally{
            
        }
        
        
        return false;
        
    }
}
