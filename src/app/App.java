package app;

import javax.swing.JOptionPane;

import entidades.*;
import menus.*;

public class App {
    public static void main(String[] args) throws Exception {
    
        Notificacao notificacao = new Notificacao();
        Janelas meuMenu = new Janelas();
        Cliente cliente1 = new Cliente(null,null,null,null);
        
        int opcaoSelecionada = 0; 
        
        while (opcaoSelecionada!=2){
            
            opcaoSelecionada = meuMenu.exibeMenuPrinciapal();
            
            if(opcaoSelecionada == 0){ // Cadastro do Cliente
                String nome = JOptionPane.showInputDialog("Digite seu nome: ");
                String cpf = JOptionPane.showInputDialog("Digite seu CPF: ");
                String dataNacimento = JOptionPane.showInputDialog("Digite seu Data de Nacimento: ");
                String seuEmail = JOptionPane.showInputDialog("Digite seu email: ");
                String rua = JOptionPane.showInputDialog("Digite o nome da sua rua: ");
                String bairro    = JOptionPane.showInputDialog("Digite o nome do Bairro: ");
                String numCasa  = JOptionPane.showInputDialog("Digite o numero da sua casa: ");
                
                int tipodeContaEscolhida = meuMenu.exibirOpcoesdeContas(); 

                cliente1.setCpf(cpf);
                cliente1.setNome(nome);
                cliente1.setDateDeNacimento(dataNacimento);
                cliente1.setEmail(seuEmail);
                cliente1.getEndereco().get(opcaoSelecionada).setBairro(bairro);
                cliente1.getEndereco().get(opcaoSelecionada).setLogrador(rua);;
                cliente1.getEndereco().get(opcaoSelecionada).setNumeroCasa(numCasa);;
                
                if (tipodeContaEscolhida==0){
                    cliente1.criarContaPouponca();
                }
                else{
                    cliente1.criarContaCorrente();
                }

            }
            if (opcaoSelecionada==1){
                
                if (cliente1.getNome()!= null && cliente1.getCpf()!= null && cliente1.getEmail()!=null){
                    int opcaodeConta = 0;

                    while(opcaodeConta!=5){
                        opcaodeConta = meuMenu.exibirOpereacaoDeConta();

                        if (opcaodeConta==0){ //Depositar algum valor na conta
                            double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Valor do deposito : "));
                            int contaParaDeposito =  meuMenu.exibirOpcoesdeContas();
                            
                            if (contaParaDeposito == 0 && cliente1.getContaPupancas().size()>0){
                                int numContaParaDeposito =  Integer.parseInt(JOptionPane.showInputDialog("Você deseja depositar em qual conta: : "));
                                
                                cliente1.getContaPupancas().get(numContaParaDeposito).depositar(valorDeposito);
                            
                            }

                            else if (contaParaDeposito == 1 && cliente1.getContaCorrentes().size()>0){
                                int numContaParaDeposito =  Integer.parseInt(JOptionPane.showInputDialog("Você deseja depositar em qual conta: : "));
                                cliente1.getContaCorrentes().get(numContaParaDeposito).depositar(valorDeposito);
            
                            }

                            else{
                                JOptionPane.showMessageDialog(null,"Você não possui essa conta.");
                            }
                            
                        }
                        // Poderia colocar o bloco de ifs abaixo em metudos ?
                        if (opcaodeConta==1){ // Tranferir algum valor de uma conta para outra.
                            int tipoDeconta =  meuMenu.exibirOpcoesdeContas(); 
                            int contaDebitada =  Integer.parseInt(JOptionPane.showInputDialog(" De qual conta você de seja tranferir : "));
                            int tipoDecontaDestenatario =  meuMenu.exibirOpcoesdeContas(); 
                            int contaDestinada =  Integer.parseInt(JOptionPane.showInputDialog("Para qual conta você deseja tranferir : "));
                            double valorDetranferencia = Double.parseDouble(JOptionPane.showInputDialog("Valor da tranferencia : "));

                            if (tipoDeconta==1 && tipoDecontaDestenatario == 1){
                                cliente1.getContaCorrentes().get(contaDebitada).transferir(cliente1.getContaCorrentes().get(contaDestinada), valorDetranferencia,valorDetranferencia);

                            }

                            else if(tipoDeconta==1 && tipoDecontaDestenatario == 0){
                                cliente1.getContaCorrentes().get(contaDebitada).transferir(cliente1.getContaPupancas().get(contaDestinada), valorDetranferencia,valorDetranferencia);
                            }

                            else if(tipoDeconta==0 && tipoDecontaDestenatario == 0){
                                cliente1.getContaPupancas().get(contaDebitada).transferir(cliente1.getContaPupancas().get(contaDestinada), cliente1.getContaPupancas().get(contaDebitada).valorDetransferenciaPoupanca(valorDetranferencia),valorDetranferencia);
                            }

                            else if(tipoDeconta==0 && tipoDecontaDestenatario == 1){
                                cliente1.getContaPupancas().get(contaDebitada).transferir(cliente1.getContaCorrentes().get(contaDestinada), cliente1.getContaPupancas().get(contaDebitada).valorDetransferenciaPoupanca(valorDetranferencia),valorDetranferencia);
                            }
                        }

                        if (opcaodeConta==2){ // Sacar algum falor da conta
                            int tipoDeconta =  meuMenu.exibirOpcoesdeContas();
                            int contaSelecinada =  Integer.parseInt(JOptionPane.showInputDialog("Informe de qual conta você deseja sacar :  "));
                            System.out.println(contaSelecinada);
                            double valorDeSaque= Double.parseDouble(JOptionPane.showInputDialog("Valor do Saque : "));


                            if (tipoDeconta == 0 && cliente1.getContaPupancas().get(contaSelecinada).getSaldo()>valorDeSaque){
                                cliente1.getContaPupancas().get(contaSelecinada).saca(valorDeSaque);
                                
                            }                          
                            else if (tipoDeconta == 1 && cliente1.getContaCorrentes().get(contaSelecinada).getSaldo()>valorDeSaque){
                                cliente1.getContaCorrentes().get(contaSelecinada).saca(valorDeSaque);
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"Não foi possivel realizar o saque, Verifique se seu saldo e suficiente para saque !");
                            }
                        }                       
                        

                        if (opcaodeConta==3){ // ver saldo
                            int tipoDeconta =  meuMenu.exibirOpcoesdeContas();
                            int contaEscolhida =  Integer.parseInt(JOptionPane.showInputDialog("Qual conta vocé deseja ver o saldo : "));
                            
                            if (tipoDeconta==0){
                                JOptionPane.showMessageDialog(null,"Seu saldo é de "+cliente1.getContaPupancas().get(contaEscolhida).getSaldo());    
                            }
                            else if (tipoDeconta==1){
                                JOptionPane.showMessageDialog(null,"Seu saldo é de "+cliente1.getContaCorrentes().get(contaEscolhida).getSaldo());    
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"Infelizmente não foi possivel acesar seu saldo");
                            }
                            
                        }

                        if (opcaodeConta == 4){ // Criar Conta
                            int tipoDeconta =  meuMenu.exibirOpcoesdeContas();
                            if(tipoDeconta == 0){
                                cliente1.criarContaPouponca();
                                JOptionPane.showMessageDialog(null,"Sua Conta Poupança foi Criada, Parabéns ! ");
                            }
                            else if(tipoDeconta==1){
                                cliente1.criarContaCorrente();
                                JOptionPane.showMessageDialog(null,"Sua Conta Corrente foi Criada, Parabéns ! ");
                            }
                            else{
                            JOptionPane.showMessageDialog(null,"Infelizmente não foi possivel criar sua conta, tente novemante ! ");
                            }        
                        }
                    }   
                    }
                else{ 
                    JOptionPane.showMessageDialog(null,"Você precisa cadastrar todos os dados usuário primeiro");
                }
            
            }
    }    
    }
}