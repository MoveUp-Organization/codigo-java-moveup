package br.com.fiap.model.dao;

import br.com.fiap.model.dto.Missao;


import java.sql.*;
import java.util.ArrayList;


public class MissaoDAO implements  IDAO<Missao>{
    //atributos
    private Connection con;
    private Missao missao;

    //contrutor
    public MissaoDAO(Connection con) {
        this.con = con;
    }

    //getters/setters
    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String inserir(Missao missao) {
        String sql = "insert into ddd_missao(id_missao, descricao_missao, tipo_transporte, pontos_gerados, pontos_disponiveis, data_atividade ) values(?,?,?,?,?,?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setInt(1, missao.getIdMisssao());
            ps.setString(2, missao.getDescricao());
            ps.setString(3, missao.getTipoTransporte());
            ps.setInt(4, missao.getPontosGerados());
            ps.setInt(5, missao.getPontosDisponiveis());
            ps.setDate(6, Date.valueOf(missao.getDataAtividade()));
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso.";
            } else {
                return "Erro ao inserir";
            }

        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public String alterar(Missao missao) {
        String sql = "update ddd_missao set descricao_missao = ?, tipo_transporte = ?, pontos_gerados = ?, pontos_disponiveis = ?, data_atividade = ? where id_missao = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql);) {
            ps.setString(1, missao.getDescricao());
            ps.setString(2, missao.getTipoTransporte());
            ps.setInt(3, missao.getPontosGerados());
            ps.setInt(4, missao.getPontosDisponiveis());
            ps.setDate(5, Date.valueOf(missao.getDataAtividade()));
            ps.setInt(6, missao.getIdMisssao());
            if (ps.executeUpdate() > 0) {
                return "Alteração com sucesso.";
            } else {
                return "Erro ao alterar";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public ArrayList<Missao> listarTodos(){
        String sql = "select * from ddd_missao order by id_missao";
        ArrayList<Missao> listarMissao = new ArrayList<Missao>();
        try (PreparedStatement ps = getCon().prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            if (rs != null) {
                while (rs.next()) {
                     Missao missao = new Missao();
                     missao.setIdMisssao(rs.getInt(1));
                     missao.setDescricao(rs.getString(2));
                     missao.setTipoTransporte(rs.getString(3));
                     missao.setPontosGerados(rs.getInt(4));
                     missao.setPontosDisponiveis(rs.getInt(5));
                     missao.setDataAtividade(rs.getDate(6).toLocalDate());
                     listarMissao.add(missao);

                }
                return listarMissao;
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return null;
        }
    }

    public String excluir(Missao missao){
        String sql = "delete from ddd_missao where id_missao = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql);){
            ps.setInt(1, missao.getIdMisssao());
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

