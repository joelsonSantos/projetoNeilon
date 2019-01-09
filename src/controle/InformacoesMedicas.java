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
public class InformacoesMedicas {
    
    private Date dataRevisao;
    private Date proximaRevisao;
    private String restricaoMedicamento;
    private String comentarioMedico; // informações médicas
    private String tipoSanguineo;

    public InformacoesMedicas() {
    }

    public InformacoesMedicas(Date dataRevisao, Date proximaRevisao, String restricaoMedicamento, String comentarioMedico, String tipoSanguineo) {
        this.dataRevisao = dataRevisao;
        this.proximaRevisao = proximaRevisao;
        this.restricaoMedicamento = restricaoMedicamento;
        this.comentarioMedico = comentarioMedico;
        this.tipoSanguineo = tipoSanguineo;
    }

    public void setDataRevisao(Date dataRevisao) {
        this.dataRevisao = dataRevisao;
    }

    public void setProximaRevisao(Date proximaRevisao) {
        this.proximaRevisao = proximaRevisao;
    }

    public void setRestricaoMedicamento(String restricaoMedicamento) {
        this.restricaoMedicamento = restricaoMedicamento;
    }

    public void setComentarioMedico(String comentarioMedico) {
        this.comentarioMedico = comentarioMedico;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public Date getDataRevisao() {
        return dataRevisao;
    }

    public Date getProximaRevisao() {
        return proximaRevisao;
    }

    public String getRestricaoMedicamento() {
        return restricaoMedicamento;
    }

    public String getComentarioMedico() {
        return comentarioMedico;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    @Override
    public String toString() {
        return "InformacoesMedicas{" + "dataRevisao=" + dataRevisao + ", proximaRevisao=" + proximaRevisao + ", restricaoMedicamento=" + restricaoMedicamento + ", comentarioMedico=" + comentarioMedico + ", tipoSanguineo=" + tipoSanguineo + '}';
    }
}
