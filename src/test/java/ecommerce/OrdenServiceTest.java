package ecommerce;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrdenServiceTest {


    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private OrdenService ordenService;

    private Cliente clienteActivo;
    private Producto productoLaptop;
    private Producto productoMouse;

    @BeforeEach
    void setUp() {
        System.out.println("=== INICIO DEL TEST ===");
        clienteActivo = new Cliente("C001", "Juan Perez");
        productoLaptop = new Producto("P001", "Laptop", 800.0, 10);
        productoMouse = new Producto("P002", "Mouse", 50.0, 5);
        System.out.println("Configuración completada");
    }

    // TEST 1: Orden exitosa con descuento
    @Test
    @DisplayName("Orden exitosa con descuento aplicado")
    void testOrdenExitosaConDescuento() {
        System.out.println(">>> Ejecutando testOrdenExitosaConDescuento");

        // Configurar mocks
        when(clienteRepository.findById("C001")).thenReturn(Optional.of(clienteActivo));
        when(productoRepository.findByCodigo("P001")).thenReturn(Optional.of(productoLaptop));
        when(productoRepository.findByCodigo("P002")).thenReturn(Optional.of(productoMouse));

        // Crear request
        OrdenRequest request = new OrdenRequest();
        request.setClienteId("C001");
        request.setItems(Arrays.asList(
                new ItemRequest("P001", 1),
                new ItemRequest("P002", 2)
        ));

        // Ejecutar
        ResultadoOrden resultado = ordenService.registrarOrden(request);

        // Verificaciones
        System.out.println("Resultado exitoso: " + resultado.isExitoso());
        System.out.println("Mensaje: " + resultado.getMensaje());
        System.out.println("Total esperado: 810.0, Total obtenido: " + resultado.getTotal());

        assertTrue(resultado.isExitoso());
        assertEquals("Orden registrada exitosamente", resultado.getMensaje());
        assertNotNull(resultado.getCodigoOrden());
        assertTrue(resultado.getCodigoOrden().startsWith("OR-"));
        assertEquals(810.0, resultado.getTotal());
        assertEquals(90.0, resultado.getDescuentoAplicado());

        System.out.println(">>> TEST PASÓ CORRECTAMENTE");
    }

    // TEST 2: Orden cancelada por falta de stock
    @Test
    @DisplayName("Orden cancelada por falta de stock")
    void testOrdenCanceladaPorFaltaStock() {
        System.out.println(">>> Ejecutando testOrdenCanceladaPorFaltaStock");

        Producto productoSinStock = new Producto("P003", "Teclado", 100.0, 1);

        when(clienteRepository.findById("C001")).thenReturn(Optional.of(clienteActivo));
        when(productoRepository.findByCodigo("P001")).thenReturn(Optional.of(productoLaptop));
        when(productoRepository.findByCodigo("P003")).thenReturn(Optional.of(productoSinStock));

        OrdenRequest request = new OrdenRequest();
        request.setClienteId("C001");
        request.setItems(Arrays.asList(
                new ItemRequest("P001", 1),
                new ItemRequest("P003", 5)
        ));

        ResultadoOrden resultado = ordenService.registrarOrden(request);

        System.out.println("Resultado exitoso: " + resultado.isExitoso());
        System.out.println("Mensaje: " + resultado.getMensaje());

        assertFalse(resultado.isExitoso());
        assertEquals("Stock insuficiente para: Teclado", resultado.getMensaje());

        System.out.println(">>> TEST PASÓ CORRECTAMENTE");
    }

}