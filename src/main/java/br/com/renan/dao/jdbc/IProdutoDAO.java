package br.com.renan.dao.jdbc;

import java.util.List;

import br.com.renan.domain.Produto;

public interface IProdutoDAO {
    
    Integer cadastrar(Produto produto) throws Exception;
    Produto consultar(String codigo) throws Exception;
    List<Produto> buscarTodos() throws Exception;
    Integer atualizar(Produto produto) throws Exception;
    Integer excluir (Produto produto) throws Exception;

}
