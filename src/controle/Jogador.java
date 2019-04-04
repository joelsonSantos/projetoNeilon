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
public class Jogador extends Pessoa {
    
    private int idJogador;
    private int assistencia; // contador de assistências dadas em jogo?
    private double mediaGols;
    private String categoria;
    private String nomeEmpresario;
    private String posicao;
    private double peso;
    private double altura;
    InformacoesMedicas informacoa;
    
    public Jogador(){
    }

    public Jogador(int idJogador, int assistencia, double mediaGols, String categoria, String nomeEmpresario, String posicao,
                    double peso, double altura) {
        this.idJogador = idJogador;
        this.assistencia = assistencia;
        this.mediaGols = mediaGols;
        this.categoria = categoria;
        this.nomeEmpresario = nomeEmpresario;
        this.posicao=posicao;
        this.peso=peso;
        this.altura=altura;
    }
    
    public int getIdJogador(){
        return idJogador;
    }
    
    public void setIdJogador(int idJogador){
        this.idJogador = idJogador;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    
    public void setAssistencia(int assistencia) {
        this.assistencia = assistencia;
    }

    public void setMediaGols(double mediaGols) {
        this.mediaGols = mediaGols;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setNomeEmpresario(String nomeEmpresario) {
        this.nomeEmpresario = nomeEmpresario;
    }
    
    public void setPosicao(String posicao){
        this.posicao = posicao;
    }
    
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public int getAssistencia() {
        return assistencia;
    }

    public double getMediaGols() {
        return mediaGols;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getNomeEmpresario() {
        return nomeEmpresario;
    }
    
    public String getPosicao(){
        return posicao;
    }
    
    public double getPeso() {
        return peso;
    }

    public InformacoesMedicas getInformacoa() {
        return informacoa;
    }

    public void setInformacoa(InformacoesMedicas informacoa) {
        this.informacoa = informacoa;
    }
    

    @Override
    public String toString() {
        return "Jogador{" + "idjogador" + "assistencia=" + assistencia + ", mediaGols=" + mediaGols + 
                ", categoria=" + categoria + ", nomeEmpresario=" + nomeEmpresario +", posicao= "+posicao +
                ", peso= "+peso +", altura="+altura +'}';
    }
}
