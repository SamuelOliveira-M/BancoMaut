package entidades.TipoDeConta;

import java.util.ArrayList;

public class ContaCorrente extends Conta {
    
    private float chequeEspecial = 300;
    private int numTraferencia;
    private double taxaDetransferenciacorrente = 0.02;
    private int quantadeDeChquesExpecial;
    private ArrayList<Double> parcelasDoChequeExpecial = new ArrayList<>();
    
    public float getChequeEspecial() {
        return chequeEspecial;
    }

    public int getNumTraferencia() {
        return numTraferencia;
    }

    public double debitacaoDoChequeexpecial(float valorDoDeposito, double valorDaParcela){ 
        if (this.quantadeDeChquesExpecial>=1){
            double descontoDoChequeExpecial = valorDoDeposito - valorDaParcela; 
            this.parcelasDoChequeExpecial.remove(0);
            return descontoDoChequeExpecial;
        }
        else{
            return 0;
        }
    }
    
    public void  contadorTranferencia(boolean transferencias){
        if (transferencias==true){
            this.numTraferencia=numTraferencia+1;
        }
    }

    public double valorDeTaxaDetransferenciacorrente(double valorTransferencia){
        if (this.numTraferencia>2){
            double valortotalDeTransferencia=(valorTransferencia*this.taxaDetransferenciacorrente)+valorTransferencia;    
            return valortotalDeTransferencia;
        }
        else {
            return valorTransferencia;
        }
    }

    public float acrescimoDoChequeespecial(){
        if (this.quantadeDeChquesExpecial>=1){
            return 0;

        }
        else{
            double valorDaParcela = chequeEspecial/2;
            this.parcelasDoChequeExpecial.add(valorDaParcela);    
            this.parcelasDoChequeExpecial.add(valorDaParcela);
            return this.chequeEspecial;
        }

    }


}   
    

