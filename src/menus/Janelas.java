package menus;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Janelas {
    
    
    public int exibeMenuPrinciapal() {
        List<Integer> opcao = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            opcao.add(i);
        }
        Object[] optionsArray = opcao.toArray();
        int opcaoSelecionad = JOptionPane.showOptionDialog(null,
        " 1. Cadastrar Usuário\n 2. Lista opções da Conta \n 3. Sair\n",
        "Selecione",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
        optionsArray, null);
        System.out.println(opcaoSelecionad);
                return opcaoSelecionad;
    }

    public int exibirOpereacaoDeConta(){
        List<Integer> opcao = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            opcao.add(i);
        }
        Object[] optionsArray = opcao.toArray();
        int opcaoSelecionad = JOptionPane.showOptionDialog(null,
        " 1. Depositar\n 2. Transferir\n 3. Sacar\n 4. Ver saldo\n 5. Criar nova conta\n 6. Voltar para menu Principal" ,
        "Selecione",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
        optionsArray, null);
        System.out.println(opcaoSelecionad);
                return opcaoSelecionad;
    }

    public int exibirOpcoesdeContas(){
        List<Integer> opcao = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            opcao.add(i);
        }
        Object[] optionsArray = opcao.toArray();
        int opcaoSelecionad = JOptionPane.showOptionDialog(null,
        " 1. Conta Poupança\n 2. Conta Corrente" ,
        "Selecione",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
        optionsArray, null);
        System.out.println(opcaoSelecionad);
                return opcaoSelecionad;
    }

} 

