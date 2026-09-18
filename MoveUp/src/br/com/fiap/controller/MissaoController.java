package br.com.fiap.controller;

import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dao.MissaoDAO;
import br.com.fiap.model.dto.Missao;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class MissaoController {
    public String inserirMissao(int idMissao, String descricao, String tipoTransporte, int pontosGerados, int pontosDisponiveis, LocalDate dataAtividade) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Missao missao = new Missao();
        missao.setIdMisssao(idMissao);
        missao.setDescricao(descricao);
        missao.setTipoTransporte(tipoTransporte);
        missao.setPontosGerados(pontosGerados);
        missao.setPontosDisponiveis(pontosDisponiveis);
        missao.setDataAtividade(dataAtividade);
        MissaoDAO missaoDAO = new MissaoDAO(con);
        resultado = missaoDAO.inserir(missao);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String alterarMissao(int idMissao, String descricao, String tipoTransporte, int pontosGerados, int pontosDisponiveis, LocalDate dataAtividade)throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Missao missao = new Missao();
        missao.setIdMisssao(idMissao);
        missao.setDescricao(descricao);
        missao.setTipoTransporte(tipoTransporte);
        missao.setPontosGerados(pontosGerados);
        missao.setPontosDisponiveis(pontosDisponiveis);
        missao.setDataAtividade(dataAtividade);

        MissaoDAO missaoDAO = new MissaoDAO(con);
        resultado = missaoDAO.alterar(missao);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String excluirMissao(int idMissao) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();


        Missao missao = new Missao();
        missao.setIdMisssao(idMissao);

        MissaoDAO missaoDAO = new MissaoDAO(con);
        resultado = missaoDAO.excluir(missao);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
    public String listarMissao(int idMissao) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        MissaoDAO missaoDAO = new MissaoDAO(con);
        ArrayList<Missao> lista = missaoDAO.listarTodos();
        ConnectionFactory.fecharConexao(con);

        if (lista != null) {
            for (Missao m : lista) {
                if (m.getIdMisssao() == idMissao) {
                    return "=== DADOS DA MISSÃO ===\n" +
                            "ID Missão: " + m.getIdMisssao() + "\n" +
                            "Descrição: " + m.getDescricao() + "\n" +
                            "Tipo de Transporte: " + m.getTipoTransporte() + "\n" +
                            "Pontos Gerados: " + m.getPontosGerados() + "\n" +
                            "Pontos Disponíveis: " + m.getPontosDisponiveis() + "\n" +
                            "Data da Atividade: " + m.getDataAtividade();
                }
            }
        }
        return "Missão com o ID informado não foi encontrada.";
    }

    //métodos próprios da classe
    public int gerarPontos(String descricao){
        if (descricao.equalsIgnoreCase("Foto no ônibus" ) ||
                descricao.equalsIgnoreCase("Foto no metrô") ||
                descricao.equalsIgnoreCase("Foto no trem")){
            return (50);

        }else if(descricao.equalsIgnoreCase("Vídeo no ônibus") ||
                descricao.equalsIgnoreCase("Vídeo no metrô") ||
                descricao.equalsIgnoreCase("Vídeo no trem")){
            return (100);

        }else {
            System.out.println("Erro! Atividade fora dos padrões exigidos");
            return (0);
        }

    }

    public double calcularCo2Evitado(double kmPercorrido){
        //0.21 referente a emissão de CO2 que o carro produz na atmosfera a cada 1km
        //0.05 referente ao transporte público
        //subtraindo obtemos a diferença
        double co2CarroPorKm = 0.21;
        double co2TransportePublicoPorKm = 0.05;
        return (co2CarroPorKm - co2TransportePublicoPorKm) * kmPercorrido;
    }
}