package br.com.fiap.view;

import br.com.fiap.controller.TransporteController;
import br.com.fiap.model.dto.Transporte;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TransporteView {
    public static void main(String[] args) {
        int idTransporte, pontosGerados, quantidadePassagem, pontosUtilizados, pontosDisponiveis;
        String descricao, tipoTransporte, status, dataGeracaoStr;
        LocalDate dataGeracao;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String[] escolha = {"Inserir", "Alterar", "Excluir", "Listar"};

        int opcao;
        TransporteController transporteController = new TransporteController();

        do {
            try {
                opcao = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo", "Gerenciador de Transporte",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);

                switch (opcao) {
                    case 0:
                        idTransporte = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do transporte:"));
                        descricao = JOptionPane.showInputDialog("Digite a descrição do transporte:");
                        tipoTransporte = JOptionPane.showInputDialog("Digite o tipo do transporte:");
                        pontosGerados = Integer.parseInt(JOptionPane.showInputDialog("Digite os pontos gerados:"));
                        dataGeracaoStr = JOptionPane.showInputDialog("Digite a data de geração (dd/MM/yyyy):");
                        dataGeracao = LocalDate.parse(dataGeracaoStr, formatter);
                        status = JOptionPane.showInputDialog("Digite o status:");
                        quantidadePassagem = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de passagens:"));
                        pontosUtilizados = Integer.parseInt(JOptionPane.showInputDialog("Digite os pontos utilizados:"));
                        pontosDisponiveis = Integer.parseInt(JOptionPane.showInputDialog("Digite os pontos disponíveis:"));

                        JOptionPane.showMessageDialog(null, transporteController.inserirTransporte(idTransporte, descricao, tipoTransporte, pontosGerados, dataGeracao, status, quantidadePassagem, pontosUtilizados, pontosDisponiveis));
                        break;

                    case 1:
                        idTransporte = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do transporte que deseja alterar:"));
                        descricao = JOptionPane.showInputDialog("Digite a nova descrição:");
                        tipoTransporte = JOptionPane.showInputDialog("Digite o novo tipo:");
                        pontosGerados = Integer.parseInt(JOptionPane.showInputDialog("Digite os novos pontos gerados:"));
                        dataGeracaoStr = JOptionPane.showInputDialog("Digite a nova data de geração (dd/MM/yyyy):");
                        dataGeracao = LocalDate.parse(dataGeracaoStr, formatter);
                        status = JOptionPane.showInputDialog("Digite o novo status:");
                        quantidadePassagem = Integer.parseInt(JOptionPane.showInputDialog("Digite a nova quantidade de passagens:"));
                        pontosUtilizados = Integer.parseInt(JOptionPane.showInputDialog("Digite os novos pontos utilizados:"));
                        pontosDisponiveis = Integer.parseInt(JOptionPane.showInputDialog("Digite os novos pontos disponíveis:"));

                        JOptionPane.showMessageDialog(null, transporteController.alterarTransporte(descricao, tipoTransporte, pontosGerados, dataGeracao, status, quantidadePassagem, pontosUtilizados, pontosDisponiveis));
                        break;

                    case 2:
                        idTransporte = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do transporte para excluir:"));

                        JOptionPane.showMessageDialog(null, transporteController.excluirTransporte(idTransporte));
                        break;

                    case 3:
                        idTransporte = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do Transporte para buscar:"));
                        JOptionPane.showMessageDialog(null, transporteController.ListarTransporte(idTransporte));
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro de formatação: Certifique-se de preencher dados numéricos corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } while (JOptionPane.showConfirmDialog(null, "Deseja Continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);

        JOptionPane.showMessageDialog(null, "Fim do programa", "FIM", JOptionPane.INFORMATION_MESSAGE);
    }
}