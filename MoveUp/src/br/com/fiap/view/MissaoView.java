package br.com.fiap.view;

import br.com.fiap.controller.MissaoController;
import br.com.fiap.model.dto.Missao;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MissaoView {
    public static void main(String[] args) {
        int idMissao, pontosGerados, pontosDisponiveis;
        String descricao, tipoTransporte, dataAtividadeStr;
        LocalDate dataAtividade;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String[] escolha = {"Inserir", "Alterar", "Excluir", "Listar"};

        int opcao;
        MissaoController missaoController = new MissaoController();

        do {
            try {
                opcao = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo", "Gerenciador de Missão",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);

                switch (opcao) {
                    case 0:
                        idMissao = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da Missão:"));
                        descricao = JOptionPane.showInputDialog("Digite a descrição da missão:");
                        tipoTransporte = JOptionPane.showInputDialog("Digite o tipo de transporte:");
                        pontosGerados = Integer.parseInt(JOptionPane.showInputDialog("Digite os pontos gerados:"));
                        pontosDisponiveis = Integer.parseInt(JOptionPane.showInputDialog("Digite os pontos disponíveis:"));
                        dataAtividadeStr = JOptionPane.showInputDialog("Digite a data da atividade (dd/MM/yyyy):");
                        dataAtividade = LocalDate.parse(dataAtividadeStr, formatter);

                        JOptionPane.showMessageDialog(null, missaoController.inserirMissao(idMissao, descricao, tipoTransporte, pontosGerados, pontosDisponiveis, dataAtividade));
                        break;

                    case 1:
                        idMissao = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da Missão que deseja alterar:"));
                        descricao = JOptionPane.showInputDialog("Digite a nova descrição:");
                        tipoTransporte = JOptionPane.showInputDialog("Digite o novo tipo de transporte:");
                        pontosGerados = Integer.parseInt(JOptionPane.showInputDialog("Digite os novos pontos gerados:"));
                        pontosDisponiveis = Integer.parseInt(JOptionPane.showInputDialog("Digite os novos pontos disponíveis:"));
                        dataAtividadeStr = JOptionPane.showInputDialog("Digite a nova data da atividade (dd/MM/yyyy):");
                        dataAtividade = LocalDate.parse(dataAtividadeStr, formatter);

                        JOptionPane.showMessageDialog(null, missaoController.alterarMissao(idMissao, descricao, tipoTransporte, pontosGerados, pontosDisponiveis, dataAtividade));
                        break;

                    case 2:
                        idMissao = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da Missão para excluir:"));

                        // Agora chama passando apenas o ID
                        JOptionPane.showMessageDialog(null, missaoController.excluirMissao(idMissao));
                        break;

                    case 3:
                        idMissao = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da Missão para buscar:"));
                        JOptionPane.showMessageDialog(null, missaoController.listarMissao(idMissao));
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