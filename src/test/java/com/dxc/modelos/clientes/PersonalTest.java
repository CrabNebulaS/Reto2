package com.dxc.modelos.clientes;

import com.dxc.exceptions.ClienteException;
import com.dxc.modelos.clientes.Cliente;
import com.dxc.persistencia.ClientesInMemoryRepo;
import com.dxc.persistencia.IClientesRepo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonalTest {

    @Test
    void dadoUnCliente_cuandoesOK_entoncesValidarOK() throws Exception {

        IClientesRepo clientesRepo = ClientesInMemoryRepo.getInstance();
        Cliente cl = clientesRepo.getClientById(1);
        assertTrue(cl.validar());
    }

    @Test
    void dadoUnCliente_cuandoNoesOK_entoncesValidarNOK() throws Exception {

        IClientesRepo clientesRepo = ClientesInMemoryRepo.getInstance();
        Cliente cl = clientesRepo.getClientById(1);
        cl.setNombre("A");
        assertFalse(cl.validar());
    }
}