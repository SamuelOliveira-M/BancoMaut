package entidades;
import java.util.ArrayList;
import java.util.List;

import entidades.TipoDeConta.ContaCorrente;
import entidades.TipoDeConta.ContaPupanca; 

public class Cliente {
    private String nome;
    private String cpf;
    private String DateDeNacimento;
    private String email;
    private List <Endereco> endereco = new ArrayList<>();
    private List<ContaCorrente>contasCorrente = new ArrayList<>();
    private List<ContaPupanca>contasPouoanca = new ArrayList<>();

    public Cliente(String nome, String cpf, String dateDeNacimento, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.DateDeNacimento = dateDeNacimento;
        this.email = email;
        this.endereco.add(new Endereco(null,null,null));
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDateDeNacimento() {
        return DateDeNacimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDateDeNacimento(String dateDeNacimento) {
        DateDeNacimento = dateDeNacimento;
    }

    public List <Endereco> getEndereco() {
        return endereco;
    }
    
    public List<ContaCorrente> getContaCorrentes() {
        return contasCorrente;
    }

    public List<ContaPupanca> getContaPupancas() {
        return contasPouoanca;
    }

    public void criarContaCorrente(){
        this.contasCorrente.add(new ContaCorrente());
    }

    public void criarContaPouponca(){
        this.contasPouoanca.add(new ContaPupanca());
    }

    public void novoEdereco(){
        this.endereco.add(new Endereco(null,null,null));

    }


}
