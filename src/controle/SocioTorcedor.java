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
            private String modalidadePlano; // (básico, intermadiário, avançado)
            private Date dataFiliacao;
            private String formaPagamento;
            
            public SocioTorcedor(){
            }

            public SocioTorcedor(String modalidadePlano, Date dataFiliacao, String formaPagamento) {
                this.modalidadePlano = modalidadePlano;
                this.dataFiliacao = dataFiliacao;
                this.formaPagamento = formaPagamento;
            }
    
           
            
            
            
}
