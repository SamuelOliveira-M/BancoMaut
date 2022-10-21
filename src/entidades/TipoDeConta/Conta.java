
package entidades.TipoDeConta;

public class Conta {
    private static int contador;
    private int numero ;
    private int agencia = 1;
    private double saldo = 0 ;

    public Conta(){
        this.numero = ++contador;
    }
    
    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public boolean saca(double quantidade){
        if (this.saldo<quantidade){
            return false;
        }
        else{
            this.saldo -= quantidade;
            return true; 
        }
    }

    public void depositar(double valor){
        this.saldo+=valor;
    }

    public boolean transferir(Conta destino , double valorDebitado,double valorDepositado){

            boolean retirou = this.saca(valorDebitado); 
            if (retirou == false){
                return false;
            }
            else{
                destino.depositar(valorDepositado);
                return true;
            
            }
        }
    }

