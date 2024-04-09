package com.example;
import javax.swing.JOptionPane;

import com.example.cadastrocliente.Cliente;
import com.example.dao.ClienteMapDAO;
import com.example.dao.IClienteDAO;

public class App {
    public static IClienteDAO iClienteDAO;

    public static void main(String args[]){
        iClienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null, "Digite 1 para cadastro, 2 para consultar, 3 para excluir, 4 para alterar ou 5 para sair",
                "Clientes", JOptionPane.INFORMATION_MESSAGE);
        while (!isOpcaoValida(opcao)){
            if ("".equals(opcao)) {
                sair();
            }
            opcao = JOptionPane.showInputDialog(null,"VOCÊ É MULA ?? NÃO SABE LER ?? Opção inválida!!! Digite 1 para cadastro, 2 para consultar, 3 para excluir, 4 para alterar ou 5 para sair",
                    "Clientes", JOptionPane.INFORMATION_MESSAGE);
        }

        while (isOpcaoValida(opcao)){
            if ((isOpcaoSair(opcao))){
                sair();
            } else if (isCadastro(opcao)) {
                String dados = JOptionPane.showInputDialog(null, "Digite os dados separados por vírgula -> Nome, Cpf, Endereço, Número",
                        "Cadastrar o Cliente", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);

            } else if (isConsultar(opcao)){
                String dados = JOptionPane.showInputDialog(null, "Digite o Cpf",
                        "Cadastrar o Cliente", JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);
            }
            opcao = JOptionPane.showInputDialog(null, "Digite 1 para cadastro, 2 para consultar, 3 para excluir, 4 para alterar ou 5 para sair",
                    "Clientes", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void consultar(String dados) {
        Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
        if(cliente != null){
            JOptionPane.showMessageDialog(null, "Cliente encontrado" + cliente.toString(),
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private static boolean isConsultar(String opcao) {
        if ("2".equals(opcao)){
            return true;
        }
        return false;
    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");
        Cliente cliente = new Cliente(dadosSeparados[0],dadosSeparados[1],dadosSeparados[2],dadosSeparados[3]);
//        if (dadosSeparados[0] == null || dadosSeparados[1] == null || dadosSeparados[2] == null || dadosSeparados[3] == null) {
//            JOptionPane.showInputDialog(null,"VOCÊ É MULA ?? NÃO SABE LER ?? Digite todos os dados", "Clientes", JOptionPane.INFORMATION_MESSAGE);
//        }
        Boolean isCadastrado = iClienteDAO.cadastrar(cliente);
            if(isCadastrado) {
                JOptionPane.showMessageDialog(null, "Cliente Cadastrado com sucesso",
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                if(isCadastrado) {
                    JOptionPane.showMessageDialog(null, "Cliente Já Cadastrado",
                            "Erro", JOptionPane.INFORMATION_MESSAGE);
                }
            }
    }

    private static boolean isCadastro(String opcao) {
        if ("1".equals(opcao)){
            return true;
        }
        return false;
    }

    private static boolean isOpcaoSair(String opcao) {
        if ("5".equals(opcao)){
            return true;
        }
        return false;
    }

    private static boolean isOpcaoCadastro(String opcao) {
        if ("1".equals(opcao)){
            return true;
        }
        return false;
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Bye Bye, asta la vista Baby", "Sair", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoValida(String opcao) {
        if ("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao)){
            return true;
        }
        return false;
    }
}
