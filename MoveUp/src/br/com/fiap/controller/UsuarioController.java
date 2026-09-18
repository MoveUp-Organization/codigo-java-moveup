package br.com.fiap.controller;
import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dao.UsuarioDAO;
import br.com.fiap.model.dto.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class UsuarioController {

    //método de cadastro
    public String inserirUsuario(String nomeUsuario, String cpf, String email,String telefone,String senha, String cidade, String bairro, String rua, String numeroResidencia ) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(nomeUsuario);
        usuario.setCpf(cpf);
        usuario.setEmail(email);
        usuario.setTelefone(telefone);
        usuario.setSenha(senha);
        usuario.setCidade(cidade);
        usuario.setBairro(bairro);
        usuario.setRua(rua);
        usuario.setNumeroResidencia(numeroResidencia);

        UsuarioDAO usuarioDAO = new UsuarioDAO(con);
        resultado = usuarioDAO.inserir(usuario);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    /// método de alteração
    public String alterarUsuario(  String nomeUsuario, String cpf, String email,String telefone,String senha, String cidade, String bairro, String rua, String numeroResidencia) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(nomeUsuario);
        usuario.setCpf(cpf);
        usuario.setEmail(email);
        usuario.setTelefone(telefone);
        usuario.setSenha(senha);
        usuario.setCidade(cidade);
        usuario.setBairro(bairro);
        usuario.setRua(rua);
        usuario.setNumeroResidencia(numeroResidencia);
        UsuarioDAO usuarioDAO = new UsuarioDAO(con);
        resultado = usuarioDAO.alterar(usuario);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    //método de exclusão
    public String excluirUsuario(String cpf) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Usuario usuario = new Usuario();
        usuario.setCpf(cpf);
        UsuarioDAO usuarioDAO = new UsuarioDAO(con);
        resultado = usuarioDAO.excluir(usuario);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    //método de leitura
    public String ListarUsuario(String cpf) throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        UsuarioDAO usuarioDAO = new UsuarioDAO(con);

        // Usa o listarTodos() que você já possui na DAO
        ArrayList<Usuario> lista = usuarioDAO.listarTodos();
        ConnectionFactory.fecharConexao(con);

        if (lista != null) {
            for (Usuario u : lista) {
                if (u.getCpf().equals(cpf)) {
                    return "=== DADOS DO USUÁRIO ===\n" +
                            "Nome: " + u.getNomeUsuario() + "\n" +
                            "CPF: " + u.getCpf() + "\n" +
                            "Email: " + u.getEmail() + "\n" +
                            "Senha: " + u.getSenha() + "\n" +
                            "Telefone: " + u.getTelefone() + "\n" +
                            "Cidade: " + u.getCidade() + "\n" +
                            "Bairro: " + u.getBairro() + "\n" +
                            "Rua: " + u.getRua() + "\n" +
                            "Número da Residência: " + u.getNumeroResidencia();
                }
            }
        }
        return "Usuário com o CPF informado não foi encontrado.";
    }

    //métodos de consulta
    public int consultarPontos(Usuario usuario) {
        return usuario.getPontosDisponiveis();
    }

    public int consultarPontosUtilizados(Usuario usuario) {
        return usuario.getPontosUtilizados();
    }

    public int consultarPassagens(Usuario usuario) {
        return usuario.getQuantidadePassagem();
    }
}
