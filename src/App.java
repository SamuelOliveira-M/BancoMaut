import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entidades.*;
import menus.*;

public class App {
    public static void main(String[] args) throws Exception {

    List<Integer> opcao1 = new ArrayList<>();
    opcao1.add(1);
    opcao1.add(2);
    opcao1.add(3);
    List<Integer> opcao2 = new ArrayList<>();
    opcao2.add(1);
    opcao2.add(2);
    opcao2.add(3);
    opcao2.add(4);
    opcao2.add(5);
    opcao2.add(6);

    Janelas meuMenu = new Janelas();
    Conta contas = new Conta();
    Cliente cliente1 = new Cliente(null,null,null);

    

    int opcaoSelecionada = 0; 
    while (opcaoSelecionada!=2){
        
        opcaoSelecionada = meuMenu.exibeMenuPrinciapal(opcao1);
        
        if(opcaoSelecionada == 0){ 
            String nome = JOptionPane.showInputDialog("Digite seu nome: ");
            String cpf = JOptionPane.showInputDialog("Digite seu CPF: ");
            String dataNacimento = JOptionPane.showInputDialog("Digite seu Data de Nacimento: ");
            cliente1.setCpf(cpf);
            cliente1.setNome(nome);
            cliente1.setDateDeNacimento(dataNacimento);
            
        }
        if (opcaoSelecionada==1){
             
            if (cliente1.getNome()!= null && cliente1.getCpf()!= null){;
                int opcaodeConta = 0;

                while(opcaodeConta!=5){
                    opcaodeConta = meuMenu.exibirOpereacaoDeConta(opcao2);
                    
                    if (opcaodeConta==0){ //Depositar algum valor na conta
                        double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Valor do deposito : "));
                        int contaParaDeposito =  Integer.parseInt(JOptionPane.showInputDialog("Conta para deposito : "));
                    
                        cliente1.getContas().get(contaParaDeposito).depositar(valorDeposito);
                    }

                    if (opcaodeConta==1){ // Tranferir algum valor de uma conta para outra.
                        double valorDetranferencia = Double.parseDouble(JOptionPane.showInputDialog("Valor da tranferencia : "));
                        int contaDestinada =  Integer.parseInt(JOptionPane.showInputDialog("Para que conta você deseja tranferir : "));
                    
                        if (cliente1.getContas().get(contaDestinada).getSaldo()<valorDetranferencia){
                                cliente1.getContas().get(contaDestinada).transferir(cliente1.getContas().get(opcaoSelecionada), valorDetranferencia);
                        }
                    }

                    if (opcaodeConta==2){ // Sacar algum valor da conta
                        int contaSelecinada =  Integer.parseInt(JOptionPane.showInputDialog("Informe de qual conta você deseja sacar :  "));
                        double valorDeSaque= Double.parseDouble(JOptionPane.showInputDialog("Valor do Saque : "));


                        if (cliente1.getContas().get(contaSelecinada).getSaldo()<valorDeSaque){
                                cliente1.getContas().get(contaSelecinada).saca(valorDeSaque);
                            
                        }                          
                    }                       
                    

                    if (opcaodeConta==3){
                        int cataEscolhida =  Integer.parseInt(JOptionPane.showInputDialog("Qual conta vocé deseja ver o saldo : "));
                        double saldoConta=cliente1.getContas().get(cataEscolhida).getSaldo();
                        JOptionPane.showMessageDialog(null,"Seu saldo é de "+saldoConta);
                    }

                    if (opcaodeConta == 4){
                        cliente1.criarNovaConta();
                        JOptionPane.showMessageDialog(null,"Sua Conta foi Criada, Parabéns ! ");        
                    }

                          
                }   
                }
            else{ 
                JOptionPane.showMessageDialog(null,"Você precisa cadastrar seu usuário primeiro");
            }
        
        }
}    
}
}