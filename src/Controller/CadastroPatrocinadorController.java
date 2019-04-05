/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PatrocinadorDAO;
import controle.Patrocinador;

/**
 *
 * @author laiendercamargos
 */
public class CadastroPatrocinadorController {

    public static boolean persistir(Patrocinador patrocinador) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return PatrocinadorDAO.persistir(patrocinador);
    }
    
}
