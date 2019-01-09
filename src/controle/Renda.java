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
public class Renda {
    
    private String origem;
    private double valor;
    private Date data;

    public Renda() {
    }

    public Renda(String origem, double valor, Date data) {
        this.origem = origem;
        this.valor = valor;
        this.data = data;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getOrigem() {
        return origem;
    }


    public double getValor() {
        return valor;
    }

    public Date getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Renda{" + "origem=" + origem + ", valor=" + valor + ", data=" + data + '}';
    }
    
    
}
