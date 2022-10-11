package entidades;
import java.util.ArrayList;
import java.util.List; 

public class Cliente {
    private String nome;
    private String cpf;
    private String DateDeNacimento;
    private List <Endereco> endereco = new ArrayList<>();
    private List<Conta>contas = new ArrayList<>();
    

    public Cliente(String nome, String cpf, String dateDeNacimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.DateDeNacimento = dateDeNacimento;
        this.endereco.add(new Endereco(null,null,null));
        this.contas.add(new Conta());
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
    
    public List<Conta> getContas() {
        return contas;
    }

    public void criarNovaConta(){
        this.contas.add(new Conta());
    }
    public void novoEdereco(){
        this.endereco.add(new Endereco(null,null,null));

    }


}
