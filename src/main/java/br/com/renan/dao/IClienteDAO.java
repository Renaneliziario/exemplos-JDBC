package br.com.renan.dao;

import br.com.renan.domain.Cliente;

public interface IClienteDAO {

    public Integer cadastrar (Cliente cliente) throws Exception;
    public Cliente consultar (String codigo) throws Exception;
    public Integer excluir (Cliente clienteBD) throws Exception;
    

}
