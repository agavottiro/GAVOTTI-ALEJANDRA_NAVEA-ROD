package com.backend.clinicaOdontologica.service;

import com.backend.clinicaOdontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinicaOdontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaOdontologica.entity.Odontologo;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import java.util.List;

import static org.junit.Assert.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class OdontologoServiceTest {


    @Autowired
    private IOdontologoService odontologoService;

    private static OdontologoEntradaDto odontologo;

    @BeforeAll
    static void setUp() {
        odontologo = new OdontologoEntradaDto("68541", "Juan", "Gonzalez");

    }

    @Order(1)
    @Test
    public void deberiaAgregarUnOdontologo(){
                OdontologoSalidaDto odontologoAgregado = odontologoService.registrarOdontologo(odontologo);

        assertTrue(odontologoAgregado.getId() != 0);
    }

    @Order(2)
    @Test
    public void listarTodosLosOdontologos(){
        List<OdontologoSalidaDto> listaOdontologos = odontologoService.listarOdontologos();
        assertFalse(listaOdontologos.isEmpty());
    }

    @Order(3)
    @Test
    public void deberiaEncontrarUnOdontologoPorSuId(){
        OdontologoSalidaDto odontologoEncontrado = odontologoService.buscarOdontologoPorId(1L);
        assertNotNull(odontologoEncontrado);
    }


}
