/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.SocioTorcedorDAO;
import controle.SocioTorcedor;
import java.sql.SQLException;
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

    public static boolean persistir(SocioTorcedor socio) throws Exception {
        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return SocioTorcedorDAO.persistir(socio);
    }

    public static SocioTorcedor pesquisaCPF(SocioTorcedor socio) throws Exception {
        return SocioTorcedorDAO.pesquisaCPF(socio);
    }

    public static void atualizar(SocioTorcedor socioAtualizar) throws Exception{
        SocioTorcedorDAO.atualizar(socioAtualizar);
        
    }

    public static void deletar(String cpfSocio) throws SQLException {
        
        SocioTorcedorDAO.delete(cpfSocio);
    }

    public static SocioTorcedor pesquisaSocio(SocioTorcedor socio) throws Exception {
        SocioTorcedorDAO.pesquisaSocio(socio);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return socio;
    }
    

}
