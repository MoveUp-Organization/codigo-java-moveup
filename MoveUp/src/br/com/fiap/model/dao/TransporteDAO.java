package br.com.fiap.model.dao;

import br.com.fiap.model.dto.Transporte;

import java.sql.*;
import java.util.ArrayList;

public class TransporteDAO implements IDAO<Transporte>{
    private Connection con;
    private Transporte transporte;

    //construtor
    public TransporteDAO(Connection con) {
        this.con = con;
    }

    //getters/setters
    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    //métodos de inserir
    public String inserir(Transporte transporte) {
        String sql = "insert into ddd_transporte(id_transporte, descricao, tipo_transporte, data_geracao, status, pontos_gerados, quantidade_passagem, pontos_utilizados, pontos_disponiveis ) values(?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, transporte.getIdTransporte());
            ps.setString(2, transporte.getDescricao());
            ps.setString(3, transporte.getTipoTransporte());
            ps.setDate(4, Date.valueOf(transporte.getDataGeracao()));
            ps.setString(5, transporte.getStatus());
            ps.setInt(6, transporte.getPontosGerados());
            ps.setInt(7, transporte.getQuantidadePassagem());
            ps.setInt(8, transporte.getPontosUtilizados());
            ps.setInt(9, transporte.getPontosDisponiveis());
            if (ps.executeUpdate() > 0) {
                return "Transporte inserido com sucesso.";
            } else {
                return "Erro ao inserir transporte";
            }

        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }


    public String alterar(Transporte transporte) {

        String sql = "update ddd_transporte set descricao = ?, tipo_transporte = ?, data_geracao = ?, status = ?, pontos_gerados = ?, quantidade_passagem = ?,pontos_utilizados = ?, pontos_disponiveis = ? where id_transporte = ?";

        try (PreparedStatement ps = getCon().prepareStatement(sql)) {

            ps.setString(1, transporte.getDescricao());
            ps.setString(2, transporte.getTipoTransporte());
            ps.setDate(3, Date.valueOf((transporte.getDataGeracao())));
            ps.setString(4, transporte.getStatus());
            ps.setInt(5, transporte.getPontosGerados());
            ps.setInt(6, transporte.getQuantidadePassagem());
            ps.setInt(7, transporte.getPontosUtilizados());
            ps.setInt(8, transporte.getPontosDisponiveis());
            ps.setInt(9, transporte.getIdTransporte());

            if (ps.executeUpdate() > 0) {
                return "Transporte alterado com sucesso.";
            } else {
                return "Erro ao alterar transporte.";
            }

        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public ArrayList<Transporte> listarTodos() {
        String sql = "select * from ddd_transporte order by id_transporte";
        ArrayList<Transporte> listarTransporte = new ArrayList<Transporte>();
        try (PreparedStatement ps = getCon().prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            if (rs != null) {
                while (rs.next()) {
                    Transporte transporte = new Transporte();
                    // Busca pelo NOME da coluna no banco em vez de usar índice por número
                    transporte.setIdTransporte(rs.getInt("id_transporte"));
                    transporte.setDescricao(rs.getString("descricao"));
                    transporte.setTipoTransporte(rs.getString("tipo_transporte"));
                    transporte.setDataGeracao(rs.getDate("data_geracao").toLocalDate());
                    transporte.setStatus(rs.getString("status"));
                    transporte.setPontosGerados(rs.getInt("pontos_gerados"));
                    transporte.setQuantidadePassagem(rs.getInt("quantidade_passagem"));
                    transporte.setPontosUtilizados(rs.getInt("pontos_utilizados"));
                    transporte.setPontosDisponiveis(rs.getInt("pontos_disponiveis"));

                    listarTransporte.add(transporte);
                }
                return listarTransporte;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return null;
        }
    }

    public String excluir(Transporte transporte){
        String sql = "delete from ddd_transporte where id_transporte = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql);){
            ps.setInt(1, transporte.getIdTransporte());
            if (ps.executeUpdate() > 0){
                return "Transporte excluído com sucesso.";
            } else {
                return "Erro ao excluir transporte";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }











}