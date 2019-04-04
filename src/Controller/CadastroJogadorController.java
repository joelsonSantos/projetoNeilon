/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.JogadorDAO;
import controle.Jogador;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import visao.CadastroJogador;

/**
 *
 * @author laiendercamargos
 */
public class CadastroJogadorController {
    public static boolean persistir(Jogador jogador) throws Exception{
        //JOptionPane.showMessageDialog(null, "Comtroler");
        return JogadorDAO.persistir(jogador);
    }
    
    public static Jogador pesquisa (Jogador nome) throws Exception{
        return JogadorDAO.pesquisa(nome);
    }
    public static Jogador pesquisaID(Jogador idPessoa) throws Exception{
        return JogadorDAO.pesquisaID(idPessoa);
    }
    public  Jogador preencherTelaJogador(Jogador jogador) throws Exception{       
        return jogador;
    }
    public static void atualizar(Jogador jogadorAtualizar) throws SQLException{
         JogadorDAO.atualizar(jogadorAtualizar);
    }
    public static void deletar(int jogadorDeletar) throws SQLException{
        JogadorDAO.delete(jogadorDeletar);
    }
}
