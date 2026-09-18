package br.com.fiap.model.dao;

import br.com.fiap.model.dto.Voucher;

import java.sql.*;
import java.util.ArrayList;

public class VoucherDAO implements IDAO<Voucher> {
    //atributos
    private Connection con;
    private Voucher voucher;

    //construtor
    public VoucherDAO(Connection con) {
        this.con = con;
    }

    //getters/setters
    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String inserir(Voucher voucher) {
        String sql = "insert into ddd_voucher(id_voucher, quantidade_passagem, data_geracao, status_voucher, pontos_utilizados) values(?,?,?,?,?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, voucher.getIdVoucher());
            ps.setInt(2, voucher.getQuantidadePassagem());
            ps.setDate(3, Date.valueOf(voucher.getDataGeracao()));
            ps.setString(4, voucher.getStatus());
            ps.setInt(5, voucher.getPontosUtilizados());
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso.";
            } else {
                return "Erro ao inserir";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public String alterar(Voucher voucher) {
        String sql = "update ddd_voucher set quantidade_passagem = ?, data_geracao = ?, status_voucher = ?, pontos_utilizados = ? where id_voucher = ?";

        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, voucher.getQuantidadePassagem());
            ps.setDate(2, Date.valueOf(voucher.getDataGeracao()));
            ps.setString(3, voucher.getStatus());
            ps.setInt(4, voucher.getPontosUtilizados());
            ps.setInt(5, voucher.getIdVoucher());

            if (ps.executeUpdate() > 0) {
                return "Voucher alterado com sucesso.";
            } else {
                return "Erro ao alterar. ID do voucher não foi encontrado no banco.";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public ArrayList<Voucher> listarTodos() {
        String sql = "select * from ddd_voucher order by id_voucher";
        ArrayList<Voucher> listarVoucher = new ArrayList<Voucher>();
        try (PreparedStatement ps = getCon().prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            if (rs != null) {
                while (rs.next()) {
                    Voucher voucher = new Voucher();

                    voucher.setIdVoucher(rs.getInt("ID_VOUCHER"));
                    voucher.setQuantidadePassagem(rs.getInt("QUANTIDADE_PASSAGEM"));
                    voucher.setDataGeracao(rs.getDate("DATA_GERACAO").toLocalDate());
                    voucher.setStatus(rs.getString("STATUS_VOUCHER"));
                    voucher.setPontosUtilizados(rs.getInt("PONTOS_UTILIZADOS"));

                    listarVoucher.add(voucher);
                }
                return listarVoucher;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL ao listar: " + e.getMessage());
            return null;
        }
    }

    public String excluir(Voucher voucher){
        String sql = "delete from ddd_voucher where id_voucher = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql);){
            ps.setInt(1, voucher.getIdVoucher());
            if (ps.executeUpdate() > 0){
                return "Excluído com sucesso.";
            } else {
                return "Erro ao excluir";
            }
        }catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }
}
