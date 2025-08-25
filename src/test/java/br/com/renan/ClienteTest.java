package br.com.renan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.renan.dao.ClienteDAO;
import br.com.renan.domain.Cliente;

public class ClienteTest {

    @Test
    public void cadastrarTest() throws Exception {
        ClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Renan Queiroz");

        // Garante que não há duplicidade antes de cadastrar
        dao.excluir(cliente);

        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);
        System.out.println("Qtd inserida: " + qtd);

        // Consulta o cliente cadastrado
        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertNotNull(clienteBD.getId());
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        // Exclui o cliente cadastrado
        Integer qtdDel = dao.excluir(clienteBD);
        assertEquals(Integer.valueOf(1), qtdDel);

        // Verifica se o cliente foi removido
        Cliente clienteRemovido = dao.consultar(cliente.getCodigo());
        assertTrue(clienteRemovido == null);
    }
}