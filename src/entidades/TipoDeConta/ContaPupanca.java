package entidades.TipoDeConta;

public class ContaPupanca extends Conta {
    
    private double taixaDeTransferenciaPoupanca = 0.05;
    private double redimento = 0.1;


    public double valorDetransferenciaPoupanca(double valorTransferencia){
        double valortotalDeTransferencia=(valorTransferencia*this.taixaDeTransferenciaPoupanca)+valorTransferencia;    
        return valortotalDeTransferencia;
    }

    
// Fazer a variação de redimento, mas primeiramente fazer o entendimento de como vai ser isso.

}
