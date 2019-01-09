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
public class Pessoa {
      private String nome;
      private String sobreNome;
      private String nacionalidade;
      private String rg;
      private String cpf;
      private String dataNascimento; // DD/MM/AAAA
      private Contato contato;
      private Conta conta;
      private Endereco endereco;
      private String escolaridade;
      private String instituicao;
     
      public Pessoa(){
      }
     
      public Pessoa(String nome, String sobreNome, String nacionalidade, String rg, String cpf, String dataNascimento, Contato contato, Conta conta, Endereco endereco, String escolaridade, String instituicao) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.contato = contato;
        this.conta = conta;
        this.endereco = endereco;
        this.escolaridade= escolaridade;
        this.instituicao= instituicao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }
    
    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getNome() {
        return nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getRg() {
        return rg;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public Contato getContato() {
        return contato;
    }

    public Conta getConta() {
        return conta;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public String getInstituicao() {
        return instituicao;
    }

   
    

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", sobreNome=" + sobreNome + ", nacionalidade=" + nacionalidade + ", rg=" + rg + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", contato=" + contato + ", conta=" + conta + ", endereco=" + endereco +", escolaridade=" + escolaridade +"instituicao="+ instituicao+'}';
    }
}
