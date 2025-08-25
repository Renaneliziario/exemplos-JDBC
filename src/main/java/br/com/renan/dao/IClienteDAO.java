package br.com.renan.dao;

import br.com.renan.domain.Cliente;

public interface IClienteDAO {

    // CREATE
    Integer cadastrar(Cliente cliente) throws Exception;

    // READ
    Cliente consultar(String codigo) throws Exception;
    java.util.List<Cliente> buscarTodos() throws Exception;

    // UPDATE
    Integer atualizar(Cliente cliente) throws Exception;

    // DELETE
    Integer excluir(Cliente cliente) throws Exception;

}