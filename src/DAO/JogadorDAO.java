/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controle.Jogador;
import controle.Pessoa;
import java.sql.Statement;
import persistencia.Conexao;
import visao.TelaJogador;

/**
 *
 * @author laiendercamargos
 */
public class JogadorDAO {
    
    public static boolean pesrsistir(Jogador jogador) throws Exception{
      
        try{
            Conexao conect = new Conexao();
            Statement st = (Statement) conect.getSt();
            st.execute("insert into pessoa(nome, sobrenome, "
                    + "nascionalidade, rg, cpf, dataNascimento, escolaridade,"
                    + "instituicao) "
                    + "values('" + jogador+ "'+'"
                    +"')");
            
        }
        return false;
        
    }
    
}
