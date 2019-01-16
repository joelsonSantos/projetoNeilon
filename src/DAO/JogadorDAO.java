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
                    + "values('" + jogador.getNome()+ "','"
                            + jogador.getSobreNome() +"','"
                            + jogador.getNacionalidade() +"'+'"
                            + jogador.getRg() +"'+'"
                            + jogador.getCpf() +"'+'"
                            + jogador.getDataNascimento() +"'+'"
                            + jogador.getEscolaridade() +"'+'"
                            + jogador.getInstituicao() +"'+'"
                    
                    +"')");
            
        } catch (Exception e){
            System.out.println("Problemas Ocorreram");
            e.printStackTrace();
            throw new Exception ("Erro ao Salvar Dados!");
        }
        return false;
        
    }
   
    
}
