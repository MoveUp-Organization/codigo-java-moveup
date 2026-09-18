package br.com.fiap.controller;

import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dao.TransporteDAO;
import br.com.fiap.model.dto.Transporte;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;


public class TransporteController {

    //método inserir
    public String inserirTransporte(int idTransporte, String descricao, String tipoTransporte, int pontosGerados, LocalDate dataGeracao, String status, int quantidadePassagem, int pontosUtilizados, int pontosDisponiveis) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();

        Transporte transporte = new Transporte();
        transporte.setIdTransporte(idTransporte);
        transporte.setDescricao(descricao);
        transporte.setTipoTransporte(tipoTransporte);
        transporte.setDataGeracao(dataGeracao);
        transporte.setStatus(status);
        transporte.setPontosGerados(pontosGerados);
        transporte.setQuantidadePassagem(quantidadePassagem);
        transporte.setPontosUtilizados(pontosUtilizados);
        transporte.setPontosDisponiveis(pontosDisponiveis);

        TransporteDAO transporteDAO = new TransporteDAO(con);
        resultado = transporteDAO.inserir(transporte);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String alterarTransporte(String descricao, String tipoTransporte, int pontosGerados, LocalDate dataGeracao, String status, int quantidadePassagem, int pontosUtilizados, int pontosDisponiveis) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Transporte transporte = new Transporte();

        transporte.setDescricao(descricao);
        transporte.setTipoTransporte(tipoTransporte);
        transporte.setDataGeracao(dataGeracao);
        transporte.setStatus(status);
        transporte.setPontosGerados(pontosGerados);
        transporte.setQuantidadePassagem(quantidadePassagem);
        transporte.setPontosUtilizados(pontosUtilizados);
        transporte.setPontosDisponiveis(pontosDisponiveis);

        TransporteDAO transporteDAO = new TransporteDAO(con);
        resultado = transporteDAO.alterar(transporte);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }



    public String excluirTransporte(int idTransporte) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();

        Transporte transporte = new Transporte();
        transporte.setIdTransporte(idTransporte);

        TransporteDAO transporteDAO = new TransporteDAO(con);
        resultado = transporteDAO.excluir(transporte);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    // método de leitura
    public String ListarTransporte(int idTransporte) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        TransporteDAO transporteDAO = new TransporteDAO(con);
        ArrayList<Transporte> lista = transporteDAO.listarTodos();
        ConnectionFactory.fecharConexao(con);

        if (lista != null) {
            for (Transporte t : lista) {
                if (t.getIdTransporte() == idTransporte) {
                    return "=== DADOS DO TRANSPORTE ===\n" +
                            "ID Transporte: " + t.getIdTransporte() + "\n" +
                            "Descrição: " + t.getDescricao() + "\n" +
                            "Tipo de Transporte: " + t.getTipoTransporte() + "\n" +
                            "Data de Geração: " + t.getDataGeracao() + "\n" +
                            "Status: " + t.getStatus() + "\n" +
                            "Pontos Gerados: " + t.getPontosGerados() + "\n" +
                            "Quantidade de Passagens: " + t.getQuantidadePassagem() + "\n" +
                            "Pontos Utilizados: " + t.getPontosUtilizados() + "\n" +
                            "Pontos Disponíveis: " + t.getPontosDisponiveis();
                }
            }
        }
        return "Transporte com o ID informado não foi encontrado.";
    }

    // métodos de conversão
    public void converterOnibus(Transporte transporte) {

        transporte.setQuantidadePassagem(1);
        transporte.setPontosUtilizados(589);
        transporte.setStatus("Ativo");
        transporte.setDataGeracao(LocalDate.now());
    }

    public void converterMetroETrem(Transporte transporte) {

        transporte.setQuantidadePassagem(1);
        transporte.setPontosUtilizados(600);
        transporte.setStatus("Ativo");
        transporte.setDataGeracao(LocalDate.now());
    }
}