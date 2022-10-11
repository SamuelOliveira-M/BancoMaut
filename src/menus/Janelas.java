package menus;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import entidades.Cliente;

public class Janelas {
   
    public int exibeMenuPrinciapal(List<Integer> opcoes) {
        
        Object[] optionsArray = opcoes.toArray();
        int opcaoSelecionad = JOptionPane.showOptionDialog(null,
        " 1. Cadastrar Usuário\n 2. Lista opções da Conta \n 3. Sair\n",
        "Selecione",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
        optionsArray, null);
        System.out.println(opcaoSelecionad);
                return opcaoSelecionad;
    }

    public int exibirOpereacaoDeConta(List<Integer> opcoes){
        Object[] optionsArray = opcoes.toArray();
        int opcaoSelecionad = JOptionPane.showOptionDialog(null,
        " 1. Depositar\n 2. Transferir\n 3. Sacar\n 4. Ver saldo\n 5. Criar nova conta\n 5. Voltar para menu Principal" ,
        "Selecione",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
        optionsArray, null);
        System.out.println(opcaoSelecionad);
                return opcaoSelecionad;
    }
} 

