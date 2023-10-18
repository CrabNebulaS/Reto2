package com.dxc.controladores;

import com.dxc.exceptions.ClienteException;
import com.dxc.modelos.clientes.Cliente;
import com.dxc.persistencia.ClientesInMemoryRepo;
import com.dxc.persistencia.IClientesRepo;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClientesControllerTest {

    private final PrintStream stdOut = System.out;
    private final ByteArrayOutputStream outCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outCaptor));
    }
    @AfterEach
    public void restoreOut() {
        System.setOut(new PrintStream(stdOut));
    }

    @Test
    @Order(1)
    void dadoUsuarioConsultaDetalle_cuandoHayClientes_entoncesObtieneDatosCliente() throws Exception {
        //given
        int long1 = ClientesController.numeroClientes();
        //when
        ClientesController.mostrarDetalle(1);
        //then
        assertEquals(3, long1);


        IClientesRepo clientesRepo = ClientesInMemoryRepo.getInstance();
        Cliente cl = clientesRepo.getClientById(1);
        assertTrue(cl.validar());
    }

    @Test
    @Order(2)
    void dadoUsuarioConsultaDetalle_cuandoClienteNoExiste_entoncesError() {
        //given
        int long1 = ClientesController.numeroClientes();
        //when
        ClientesController.mostrarDetalle(4);
        //then
        assertEquals(3, long1);

        IClientesRepo clientesRepo = ClientesInMemoryRepo.getInstance();
        assertThrows(ClienteException.class, () -> {
            Cliente cl = clientesRepo.getClientById(4);
        });
    }

    @Test
    @Order(3)
    void dadoUsuarioQuiereConsultar_cuandoHayClientes_entoncesObtieneListaClientes() {
        //given
        int long1 = ClientesController.numeroClientes();
        //when
        ClientesController.mostrarLista();
        //then
        assertEquals(3, long1);
    }

    @Test
    @Order(4)
    void dadoUsuarioQuiereConsultar_cuandoNoHayClientes_entoncesObtieneListaVacia() {
        //given
        ClientesController.eliminar(1);
        ClientesController.eliminar(2);
        ClientesController.eliminar(3);
        int long1 = ClientesController.numeroClientes();
        //when
        ClientesController.mostrarLista();
        //then
        assertEquals(0, long1);
    }

    @Test
    @Order(5)
    void dadoUsuarioQuiereAltaCliente_cuandoDatosOK_entoncesAltaOK() {
        String[] datos = {
                "personal",
                "Carlos Sanchez",
                "emaile@gmail.com",
                "C/Huelva 13, Barcelona",
                "2023-10-18",
                "12345678Z"
        };
        ClientesController.add(datos);
        String respuesta = outCaptor.toString();

        //restoreOut();
        //System.out.println(respuesta);

        assertTrue(respuesta.contains("Cliente añadido"));
    }
}