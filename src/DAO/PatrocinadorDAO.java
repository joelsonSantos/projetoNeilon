/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controle.Patrocinador;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.spi.DirStateFactory;
import persistencia.Conexao;

/**
 *
 * @author laiendercamargos
 */
public class PatrocinadorDAO {

    public static boolean persistir(Patrocinador patrocinador) {
        try {
            Conexao conect = new Conexao();
            Statement st = conect.getSt();
            
            st.executeUpdate("INSERT INTO patrocinador (razaoSocial, cnpf, instricaoEstadual, inscricaoMunicipal, finalidadeLucrativa, idEndereco_fk)"
                    + "values('"+patrocinador.getRazaoSocial()+ "','"
                    + patrocinador.getCnpj()+ "','"
                    + patrocinador.getInscricaoEstadual() +"','"
                    + patrocinador.getInscricaoMunicipal() + "','"
                    + patrocinador.getFinalidadeLucrativa() +"','"
                    + patrocinador.getEndereco().getIdEndereco()+ "','"
            + "')", Statement.RETURN_GENERATED_KEYS);
            
            final ResultSet rs= st.getGeneratedKeys();
            if (rs.next()){
                patrocinador.setIdPatrocinador(rs.getInt(1));
            }
            st.executeUpdate("INSERT INTO endereco (rua, numero, bairro, cidade, estato, pais, "
                    + "complemento, cep, webSite, idPatrocinador_fk) values ('" + patrocinador.getEndereco().getRua() + "','"
                    + patrocinador.getEndereco().getNumero() + "','"
                    + patrocinador.getEndereco().getBairro() + "','"
                    + patrocinador.getEndereco().getCidade() + "','"
                    + patrocinador.getEndereco().getEstado() + "','"
                    + patrocinador.getEndereco().getPais() + "','"
                    + patrocinador.getEndereco().getComplemento() + "','"
                    + patrocinador.getEndereco().getCep() + "','"
                    + patrocinador.getIdPatrocinador()
                    +"')");
            
            st.executeUpdate("INSERT INTO contatos (telefoneComercial, celular, email, webSite, idPatrocinador_fk) "
                    + "values ('" + patrocinador.getContato().getTelefoneComercial() +"','"
                    + patrocinador.getContato().getCelular() + "','"
                    + patrocinador.getContato().getEmail() + "','"
                    + patrocinador.getContato().getWebSite() +"','" 
                    + patrocinador.getIdPatrocinador() + "','"
                    +"')");
            
            
            conect.fecharConexao();
        } catch (Exception e) {
            System.err.println("Erro ao salvar o patrocinador " + e);
            e.printStackTrace();
        }
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return false;
    }
    
}
