package br.com.renan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.renan.dao.ProdutoDAO;
import br.com.renan.domain.Produto;

public class ProdutoTest {

	@Test
	public void crudTest() throws Exception {
		ProdutoDAO dao = new ProdutoDAO();
		
		String codigoTeste = "P01";
		Produto produtoExistente = dao.consultar(codigoTeste);
		if (produtoExistente != null ) {
			dao.excluir(produtoExistente);
		}

		//CREATE
		Produto produto = new Produto();
		produto.setCodigo(codigoTeste);
		produto.setNome("Produto Teste");
		produto.setPreco(99.99);
		Integer qtd = dao.cadastrar(produto);
		assertTrue(qtd == 1);

		//READ
		Produto produtoBD = dao.consultar(produto.getCodigo());
		assertNotNull(produtoBD);
		assertNotNull(produtoBD.getId());
		assertEquals(produto.getCodigo(), produtoBD.getCodigo());
		assertEquals(produto.getNome(), produtoBD.getNome());
		assertEquals(produto.getPreco(), produtoBD.getPreco());

		//READ buscar todos
		List<Produto> produtos = dao.buscarTodos();
		assertNotNull(produtos);
		assertTrue(produtos.size() > 0);
		assertTrue(produtos.stream().anyMatch(p -> p.getCodigo().equals(produto.getCodigo())));

		//UPDATE
		produtoBD.setNome("Produto Atualizado");
		produtoBD.setPreco(149.99);
		Integer qtdAtualizada = dao.atualizar(produtoBD);
		assertTrue(qtdAtualizada == 1);

		Produto produtoAtualizado = dao.consultar(produto.getCodigo());
		assertEquals("Produto Atualizado", produtoAtualizado.getNome());
		assertEquals(Double.valueOf(149.99), produtoAtualizado.getPreco());

		//DELETE
		Integer qtdDel = dao.excluir(produtoAtualizado);
		assertEquals(Integer.valueOf(1), qtdDel);

		Produto produtoRemovido = dao.consultar(produto.getCodigo());
		assertNull(produtoRemovido);


	}
}
