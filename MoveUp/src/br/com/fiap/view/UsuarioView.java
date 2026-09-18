package br.com.fiap.view;

import br.com.fiap.controller.UsuarioController;

import javax.swing.*;

public class UsuarioView {
    public static void main(String[] args) {
        String nomeUsuario, cpf, email, telefone, senha, cidade, bairro, rua, numeroResidencia;
        int idUsuario;
        String[] escolha = {"Inserir", "Alterar", "Excluir", "Listar"};

        int opcao;
        UsuarioController usuarioController = new UsuarioController();
        do {
            try {
                opcao = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo ", "Faça uma escolha", JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);

                switch (opcao){
                    case 0:
                        nomeUsuario = JOptionPane.showInputDialog("Digite seu nome");
                        cpf = JOptionPane.showInputDialog("Digite seu cpf");
                        email = JOptionPane.showInputDialog("Digite seu email");
                        telefone = JOptionPane.showInputDialog("Digite seu telefone");
                        senha = JOptionPane.showInputDialog("Digite uma senha");
                        cidade = JOptionPane.showInputDialog("Digite sua cidade");
                        bairro = JOptionPane.showInputDialog("Digite seu bairro");
                        rua = JOptionPane.showInputDialog("Digite sua rua");
                        numeroResidencia = JOptionPane.showInputDialog("Digite seu número de residência");

                        JOptionPane.showMessageDialog(null, usuarioController.inserirUsuario( nomeUsuario, cpf, email, telefone, senha, cidade, bairro, rua, numeroResidencia));
                        break;
                    case 1:
                        nomeUsuario = JOptionPane.showInputDialog("Digite seu nome");
                        cpf = JOptionPane.showInputDialog("Digite seu cpf");
                        email =JOptionPane.showInputDialog("Digite seu  email");
                        telefone = JOptionPane.showInputDialog("Digite seu telefone");
                        senha = JOptionPane.showInputDialog("Digite uma senha");
                        cidade = JOptionPane.showInputDialog("Digite sua cidade");
                        bairro = JOptionPane.showInputDialog("Digite seu bairro");
                        rua = JOptionPane.showInputDialog("Digite sua rua");
                        numeroResidencia = JOptionPane.showInputDialog("Digite seu número de residência");

                        JOptionPane.showMessageDialog(null, usuarioController.alterarUsuario(nomeUsuario, cpf, email, telefone, senha, cidade, bairro, rua, numeroResidencia));
                        break;
                    case 2:
                        cpf = JOptionPane.showInputDialog("Digite o cpf para excluir o usuário");
                        JOptionPane.showMessageDialog(null, usuarioController.excluirUsuario((cpf)));
                        break;
                    case 3:
                        cpf = JOptionPane.showInputDialog("Digite o CPF do usuário para buscar:");
                        JOptionPane.showMessageDialog(null, usuarioController.ListarUsuario(cpf));
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Opção inválida");


                }
            }catch(Exception e){
                System.out.println("Erro: " + e.getMessage());
            }
        }while (JOptionPane.showConfirmDialog(null,"Deseja Continuar", "Atenção", JOptionPane.YES_NO_OPTION,  JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null,"Fim do programa", "FIM", JOptionPane.INFORMATION_MESSAGE);
    }
}

