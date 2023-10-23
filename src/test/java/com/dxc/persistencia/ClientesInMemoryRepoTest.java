package com.dxc.persistencia;

import com.dxc.exceptions.ClienteException;
import com.dxc.modelos.clientes.Cliente;
import com.dxc.persistencia.ClientesInMemoryRepo;
import com.dxc.persistencia.IClientesRepo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientesInMemoryRepoTest {

    @Test
    void dadounRepositorioClientes_cuandoClienteExiste_entoncesClaseCliente() throws Exception {
        IClientesRepo clientesRepo = ClientesInMemoryRepo.getInstance();
        Cliente cl = clientesRepo.getClientById(1);
        assertNotNull(cl);
    }

    @Test
    void dadounRepositorioClientes_cuandoClienteNoExiste_entoncesExcepcion() {
        IClientesRepo clientesRepo = ClientesInMemoryRepo.getInstance();
        assertThrows(ClienteException.class, () -> {
            Cliente cl = clientesRepo.getClientById(4);
        });
    }
}