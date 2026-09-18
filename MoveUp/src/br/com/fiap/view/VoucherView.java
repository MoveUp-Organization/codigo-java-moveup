package br.com.fiap.view;

import br.com.fiap.controller.VoucherController;
import br.com.fiap.model.dto.Voucher;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class VoucherView {
    public static void main(String[] args) {
        int idVoucher, quantidadePassagem, pontosUtilizados;
        String status, dataGeracaoStr;
        LocalDate dataGeracao;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String[] escolha = {"Inserir", "Alterar", "Excluir", "Listar"};

        int opcao;
        VoucherController voucherController = new VoucherController();

        do {
            try {
                opcao = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo", "Gerenciador de Voucher",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);

                switch (opcao) {
                    case 0:
                        idVoucher = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do Voucher:"));
                        quantidadePassagem = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de passagens:"));
                        dataGeracaoStr = JOptionPane.showInputDialog("Digite a data de geração (dd/MM/yyyy):");
                        dataGeracao = LocalDate.parse(dataGeracaoStr, formatter);
                        status = JOptionPane.showInputDialog("Digite o status do voucher:");
                        pontosUtilizados = Integer.parseInt(JOptionPane.showInputDialog("Digite os pontos utilizados:"));

                        JOptionPane.showMessageDialog(null, voucherController.inserirVoucher(idVoucher, quantidadePassagem, dataGeracao, status, pontosUtilizados));
                        break;

                    case 1:
                        idVoucher = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do Voucher que deseja alterar:"));
                        quantidadePassagem = Integer.parseInt(JOptionPane.showInputDialog("Digite a nova quantidade de passagens:"));
                        dataGeracaoStr = JOptionPane.showInputDialog("Digite a nova data de geração (dd/MM/yyyy):");
                        dataGeracao = LocalDate.parse(dataGeracaoStr, formatter);
                        status = JOptionPane.showInputDialog("Digite o novo status do voucher:");
                        pontosUtilizados = Integer.parseInt(JOptionPane.showInputDialog("Digite os novos pontos utilizados:"));

                        JOptionPane.showMessageDialog(null, voucherController.alterarVoucher(idVoucher, quantidadePassagem, dataGeracao, status, pontosUtilizados));
                        break;

                    case 2:
                        idVoucher = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do voucher para excluir:"));

                        JOptionPane.showMessageDialog(null, voucherController.excluirVoucher(idVoucher));
                        break;

                    case 3:
                        idVoucher = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do Voucher para buscar:"));
                        JOptionPane.showMessageDialog(null, voucherController.listarVoucher(idVoucher));
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro de formatação: Certifique-se de digitar números válidos para ID e Pontos.", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } while (JOptionPane.showConfirmDialog(null, "Deseja Continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);

        JOptionPane.showMessageDialog(null, "Fim do programa", "FIM", JOptionPane.INFORMATION_MESSAGE);
    }
}