/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.sun.org.apache.xalan.internal.xsltc.cmdline.getopt.GetOpt;
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
            st.execute("insert into pessoa (nome, sobrenome,"
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
            
            /*st.execute("insert into endereco(rua, numero, bairro, cidade, "
                    + "estado, pais, complemento, cep)"
                    + " values('"+jogador.getEndereco().getRua()+"','"
                        +jogador.getEndereco().getNumero() +"','"
                        +jogador.getEndereco().getBairro() +"','" 
                        +jogador.getEndereco().getCidade() +"','"
                        +jogador.getEndereco().getEstado() +"','"
                        +jogador.getEndereco().getPais() +"','"
                        +jogador.getEndereco().getComplemento() +"','"
                        +jogador.getEndereco().getCep() + "','"
                    +"')");
            
            st.execute("insert into jogador (categoria, nomeEmpresario, posicao"
                    + "peso, altura) "
                    + "value ('"+jogador.getCategoria() +"','"
                        +jogador.getNomeEmpresario() +"','"
                        +jogador.getPosicao() +"','"
                        +jogador.getPeso() +"','"
                        +jogador.getAltura() +"','"
                    +"')");
            
            st.execute("insert into contatos (telefoneResidencial, celular, email)"
                    + "values('"+jogador.getContato().getTelefoneResidencial() +"','"
                        + jogador.getContato().getCelular()+"','"
                        +jogador.getContato().getEmail()+"','"
                    +"')");*/
            
            
        } catch (Exception e){
            System.out.println("Problemas Ocorreram");
            e.printStackTrace();
            throw new Exception ("Erro ao Salvar Dados!");
        }
        return false;
        
    }
   
    
}
