/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.SocioTorcedorDAO;
import controle.SocioTorcedor;
import javax.swing.JOptionPane;
import visao.TelaSocioTorcedor;

/**
 *
 * @author laiendercamargos
 */
public class SocioTorcedorController {
    //public static boolean persistir(TelaSocioTorcedor socio) throws Exception{
    //   JOptionPane.showMessageDialog(null, "Comtroler");
    //   return SocioTorcedorDAO.persistir(socio);
    //}

    public static boolean persistir(controle.SocioTorcedor socio) throws Exception {
        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return SocioTorcedorDAO.persistir(socio);
    }

    public static SocioTorcedor pesquisaCPF(SocioTorcedor socio) throws Exception {
        return SocioTorcedorDAO.pesquisaCPF(socio);
    }
    

}
