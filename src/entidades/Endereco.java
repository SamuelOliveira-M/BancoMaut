package entidades;
public class Endereco {
    private String logrador ;
    private String bairro;
    private String numeroCasa;
   

    public Endereco(String log,String bair,String numero){
        this.logrador = log;
        this.bairro = bair;
        this.numeroCasa = numero;
    }

    public void setLogrador(String logrador) {
        this.logrador = logrador;
    }

    public String getLogrador() {
        return logrador;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

}   
