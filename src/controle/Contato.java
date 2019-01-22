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
public class Contato {
    private int idContato;
    private String telefoneResidencial;
    private String telefoneComercial;
    private String celular;
    private String email;
    
    public Contato(){
       this(null, null, null, null);
    }
    
    public Contato(String telefoneResidencial, String celular, String email){
        this.telefoneResidencial=telefoneResidencial;
        this.celular= celular;
        this.email=email;
    }

    public Contato(String telefoneResidencial, String telefoneComercial, String celular, String email) {
        this.telefoneResidencial = telefoneResidencial;
        this.telefoneComercial = telefoneComercial;
        this.celular = celular;
        this.email = email;
    }

    public int getIdContato() {
        return idContato;
    }

    public void setIdContato(int idContato) {
        this.idContato = idContato;
    }
    
    
    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    public void setTelefoneComercial(String telefoneComercial) {
        this.telefoneComercial = telefoneComercial;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public String getTelefoneComercial() {
        return telefoneComercial;
    }

    public String getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Contato{" + "idContato= " + idContato + "telefoneResidencial=" + telefoneResidencial + ", telefoneComercial=" + telefoneComercial + ", celular=" + celular + ", email=" + email + '}';
    }
   
}
