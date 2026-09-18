package br.com.fiap.controller;


import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dao.VoucherDAO;
import br.com.fiap.model.dto.Voucher;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class VoucherController {

    public String inserirVoucher(int idVoucher, int quantidadePassagem, LocalDate dataGeracao, String status, int pontosUtilizados)
         throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Voucher voucher = new Voucher();
        voucher.setIdVoucher(idVoucher);
        voucher.setQuantidadePassagem(quantidadePassagem);
        voucher.setDataGeracao(dataGeracao);
        voucher.setStatus(status);
        voucher.setPontosUtilizados(pontosUtilizados);

        VoucherDAO voucherDAO = new VoucherDAO(con);
        resultado = voucherDAO.inserir(voucher);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
    public String alterarVoucher(int idVoucher, int quantidadePassagem, LocalDate dataGeracao, String status, int pontosUtilizados)
            throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Voucher voucher = new Voucher();
        voucher.setIdVoucher(idVoucher);
        voucher.setQuantidadePassagem(quantidadePassagem);
        voucher.setDataGeracao(dataGeracao);
        voucher.setStatus(status);
        voucher.setPontosUtilizados(pontosUtilizados);

        VoucherDAO voucherDAO = new VoucherDAO(con);
        resultado = voucherDAO.alterar(voucher);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String excluirVoucher(int idVoucher) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();

        Voucher voucher = new Voucher();
        voucher.setIdVoucher(idVoucher);

        VoucherDAO voucherDAO = new VoucherDAO(con);
        resultado = voucherDAO.excluir(voucher);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String listarVoucher(int idVoucher) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        VoucherDAO voucherDAO = new VoucherDAO(con);
        ArrayList<Voucher> lista = voucherDAO.listarTodos();
        ConnectionFactory.fecharConexao(con);

        if (lista != null) {
            for (Voucher v : lista) {
                if (v.getIdVoucher() == idVoucher) {
                    return "=== DADOS DO VOUCHER ===\n" +
                            "ID Voucher: " + v.getIdVoucher() + "\n" +
                            "Quantidade de Passagens: " + v.getQuantidadePassagem() + "\n" +
                            "Data de Geração: " + v.getDataGeracao() + "\n" +
                            "Status: " + v.getStatus() + "\n" +
                            "Pontos Utilizados: " + v.getPontosUtilizados();
                }
            }
        }
        return "Voucher com o ID informado não foi encontrado.";
    }

    //métodos da classe
    public String validarVoucher(int idVoucher) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        VoucherDAO voucherDAO = new VoucherDAO(con);
        ArrayList<Voucher> lista = voucherDAO.listarTodos();
        ConnectionFactory.fecharConexao(con);

        if (lista != null) {
            for (Voucher v : lista) {
                if (v.getIdVoucher() == idVoucher) {
                    if ("Ativo".equalsIgnoreCase(v.getStatus())) {
                        return "Voucher ativo! Pronto para uso nas catracas";
                    } else {
                        return "Erro! Voucher cancelado ou desativado";
                    }
                }
            }
        }
        return "Voucher não encontrado.";
    }

    public String cancelarVoucher(int idVoucher) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        VoucherDAO voucherDAO = new VoucherDAO(con);
        ArrayList<Voucher> lista = voucherDAO.listarTodos();

        if (lista != null) {
            for (Voucher v : lista) {
                if (v.getIdVoucher() == idVoucher) {
                    v.setStatus("Cancelado"); // Troque v.cancelarVoucher() por isto
                    String resultado = voucherDAO.alterar(v);
                    ConnectionFactory.fecharConexao(con);
                    return resultado;
                }
            }
        }
        ConnectionFactory.fecharConexao(con);
        return "Voucher não encontrado.";
    }
}
