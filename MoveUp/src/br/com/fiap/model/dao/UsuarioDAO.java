package br.com.fiap.model.dao;

import br.com.fiap.model.dto.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

   public class UsuarioDAO implements IDAO<Usuario> {
    //atributo
    private Connection con;
    private Usuario usuario;

    //contrutor
    public UsuarioDAO(Connection con) {
        this.con = con;
    }

    //getters/setters
    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }


    public String inserir(Usuario usuario) {
        String sql = "insert into ddd_usuario(nome_usuario, cpf_usuario, email_usuario, senha_usuario, telefone_usuario, cidade_usuario, bairro_usuario, rua_usuario, numero_residencia) values(?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {
            ps.setString(1, usuario.getNomeUsuario());
            ps.setString(2, usuario.getCpf());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getSenha());
            ps.setString(5, usuario.getTelefone());
            ps.setString(6, usuario.getCidade());
            ps.setString(7, usuario.getBairro());
            ps.setString(8, usuario.getRua());
            ps.setString(9, usuario.getNumeroResidencia());
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso.";
            } else {
                return "Erro ao inserir";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public String alterar(Usuario usuario) {
        String sql = " update ddd_usuario set nome_usuario = ?, email_usuario = ?, senha_usuario = ?, telefone_usuario = ?, cidade_usuario = ?, bairro_usuario = ?, rua_usuario = ?, numero_residencia = ? where cpf_usuario = ?";
        try (PreparedStatement ps = getCon().prepareStatement(sql);) {
            ps.setString(1, usuario.getNomeUsuario());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getTelefone());
            ps.setString(5, usuario.getCidade());
            ps.setString(6, usuario.getBairro());
            ps.setString(7, usuario.getRua());
            ps.setString(8, usuario.getNumeroResidencia());
            ps.setString(9, usuario.getCpf());
            if (ps.executeUpdate() > 0) {
                return "Alteração com sucesso.";
            } else {
                return "Erro ao alterar";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public  ArrayList<Usuario> listarTodos(){
        String sql = "select * from ddd_usuario";
        ArrayList<Usuario> listarUsuario = new ArrayList<Usuario>();
        try (PreparedStatement ps = getCon().prepareStatement(sql); ResultSet rs = ps.executeQuery();){
            if (rs != null){
                while (rs.next()){
                    Usuario usuario = new Usuario();
                    usuario.setIdUsuario(rs.getInt(1));
                    usuario.setNomeUsuario(rs.getString(2));
                    usuario.setCpf(rs.getString(3));
                    usuario.setEmail(rs.getString(4));
                    usuario.setSenha(rs.getString(5));
                    usuario.setTelefone(rs.getString(6));
                    usuario.setCidade(rs.getString(7));
                    usuario.setBairro(rs.getString(8));
                    usuario.setRua(rs.getString(9));
                    usuario.setNumeroResidencia(rs.getString(10));
                    listarUsuario.add(usuario);
                }
                return listarUsuario;
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return null;
        }

    }

    public String excluir(Usuario usuario){
        String sql = "delete from ddd_usuario where cpf_usuario = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql);){
            ps.setString(1, usuario.getCpf());
            if (ps.executeUpdate() > 0){
                return "Excluído com sucesso.";
            } else {
                return "Erro ao excluir";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }
}

