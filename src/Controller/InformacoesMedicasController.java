/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.InformacoesMedicasDAO;
import controle.InformacoesMedicas;
import controle.Jogador;

import java.sql.SQLException;

/**
 *
 * @author laiendercamargos
 */
public class InformacoesMedicasController {
    
    public static boolean persistir(Jogador informcoes) throws SQLException, Exception{
        return InformacoesMedicasDAO.persistir(informcoes);
    }

    //public Jogador pesquisa(Jogador informacoes) throws Exception {
        //return InformacoesMedicasDAO.pesquisar(informacoes);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // }
    
}
