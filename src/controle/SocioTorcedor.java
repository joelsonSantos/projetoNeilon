/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.Date;

/**
 *
 * @author joelson
 */
public class SocioTorcedor extends Pessoa {
            private int idSocioTorcedor;
            private String modalidadePlano; // (básico, intermadiário, avançado)
            private Date dataFiliacao;
            private String formaPagamento;
            
            public SocioTorcedor(){
            }

            public SocioTorcedor(int idSocioTorcedor ,String modalidadePlano, Date dataFiliacao, String formaPagamento) {
                this.idSocioTorcedor = idSocioTorcedor;
                this.modalidadePlano = modalidadePlano;
                this.dataFiliacao = dataFiliacao;
                this.formaPagamento = formaPagamento;
            }

    public int getIdSocioTorcedor() {
        return idSocioTorcedor;
    }

    public void setIdSocioTorcedor(int idSocioTorcedor) {
        this.idSocioTorcedor = idSocioTorcedor;
    }

    
    public String getModalidadePlano() {
        return modalidadePlano;
    }

    public void setModalidadePlano(String modalidadePlano) {
        this.modalidadePlano = modalidadePlano;
    }

    public Date getDataFiliacao() {
        return dataFiliacao;
    }

    public void setDataFiliacao(Date dataFiliacao) {
        this.dataFiliacao = dataFiliacao;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    @Override
    public String toString() {
        return "SocioTorcedor{" + "modalidadePlano=" + modalidadePlano + ", dataFiliacao=" + dataFiliacao + ", formaPagamento=" + formaPagamento + '}';
    }            
}
