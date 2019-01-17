/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.JogadorDAO;
import controle.Jogador;

/**
 *
 * @author laiendercamargos
 */
public class CadastroJogadorController {
    public static boolean persistir(Jogador jogador) throws Exception{
        return JogadorDAO.pesrsistir(jogador);
    }
}
