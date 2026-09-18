package br.com.fiap.model.dao;

import br.com.fiap.model.dto.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDAO<T> {
    public String inserir(T objeto) throws ClassNotFoundException, SQLException;
    public String alterar(T objeto) throws ClassNotFoundException, SQLException;
    public String excluir(T objeto) throws ClassNotFoundException, SQLException;
    public ArrayList<T> listarTodos() throws ClassNotFoundException, SQLException;
}

