/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

/**
 *
 * @author joelson
 */
public class Patrocinador extends Pessoa {
    
    private int idPatrocinador;
    private String razaoSocial;
    private String cnpj;
    private String inscricaoEstadual;
    private String inscricaoMunicipal;
    private Contato contato;
    public Endereco endereco;
    private String finalidadeLucrativa;

    public Patrocinador( int idPatrocinador,String razaoSocial, String cnpj, String inscricaoEstadual, 
            String inscricaoMunicipal, Contato contato, Endereco endereco, String finalidadeLucrativa) {
        this.idPatrocinador = idPatrocinador;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.inscricaoMunicipal = inscricaoMunicipal;
        this.contato = contato;
        this.endereco = endereco;
        this.finalidadeLucrativa = finalidadeLucrativa;
    }

    public Patrocinador() {
    }

    public int getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(int idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public Contato getContato() {
        return contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getFinalidadeLucrativa() {
        return finalidadeLucrativa;
    }

    public void setFinalidadeLucrativa(String finalidadeLucrativa) {
        this.finalidadeLucrativa = finalidadeLucrativa;
    }
    
    

    @Override
    public String toString() {
        return "Patrocinador{"+"idpatrocinador= " + idPatrocinador + "razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", inscricaoEstadual=" 
                + inscricaoEstadual + ", inscricaoMunicipal=" + inscricaoMunicipal + ", contato=" + contato 
                + ", endereco=" + endereco + ", Finalidade Lucrativa"+finalidadeLucrativa + '}';
    }
}
