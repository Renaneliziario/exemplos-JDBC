package br.com.renan.dao;

import br.com.renan.domain.Cliente;

public interface IClienteDAO {

    public Integer cadastrar (Cliente cliente);
    public Cliente consultar (String codigo);
    public Integer excluir (Cliente clienteBD);
    

}
