package br.com.renan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.renan.dao.ClienteDAO;
import br.com.renan.domain.Cliente;

public class ClienteTest {
	
	@Test
	public void crudTest() throws Exception {
		ClienteDAO dao = new ClienteDAO();

		
		//CREATE		
		Cliente cliente = new Cliente();
		cliente.setCodigo("01");
		cliente.setNome("RENAN QUEIROZ");
		Integer qtd = dao.cadastrar(cliente);
		assertTrue(qtd == 1);
		System.out.println("Qtd inserida: " + qtd);
		
		//READ consultar cliente
		Cliente clienteBD = dao.consultar(cliente.getCodigo());
		assertNotNull(clienteBD);
		assertNotNull(clienteBD.getId());
		assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
		assertEquals(cliente.getNome(), clienteBD.getNome());
		
		//READ buscar todos os clientes
		List<Cliente> clientes = dao.buscarTodos();
		assertNotNull(clientes);
		assertTrue(clientes.size() > 0 );
		assertTrue(clientes.stream().anyMatch(c -> c.getCodigo().equals(cliente.getCodigo())));
		
		//UPDATE atualizar cliente
		clienteBD.setNome("RENAN QUEIROZ ELIZIARIO");
		Integer qtdAtualizada = dao.atualizar(clienteBD);
		assertTrue(qtdAtualizada == 1);
		
		Cliente clienteAtualizado = dao.consultar(cliente.getCodigo());
		assertEquals("RENAN QUEIROZ ELIZIARIO", clienteAtualizado.getNome());
		
		//DELETE excluir e verificar se foi removido
		Integer qtdDel = dao.excluir(clienteAtualizado);
		assertEquals(Integer.valueOf(1), qtdDel);
		
		Cliente clienteRemovido = dao.consultar(cliente.getCodigo());
		assertTrue(clienteRemovido == null);
			
		
	}
	
}

    