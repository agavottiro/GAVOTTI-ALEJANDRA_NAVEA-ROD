package com.backend.clinicaOdontologica.service;

import com.backend.clinicaOdontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinicaOdontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaOdontologica.entity.Odontologo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
public class OdontologoServiceTest {

    @Autowired
    private IOdontologoService odontologoService;

    @Test
    public void deberiaAgregarUnOdontologo(){
        OdontologoEntradaDto odontologo = new OdontologoEntradaDto("68541", "Juan", "Gonzalez");

        OdontologoSalidaDto odontologoAgregado = odontologoService.registrarOdontologo(odontologo);

        assertTrue(odontologoAgregado.getId() != 0);
    }

    @Test
    public void listarTodosLosOdontologos(){
        List<OdontologoSalidaDto> listaOdontologos = odontologoService.listarOdontologos();
        assertFalse(listaOdontologos.isEmpty());
    }

    @Test
    public void deberiaEncontrarUnOdontologoPorSuId(){
        odontologoService.registrarOdontologo(new OdontologoEntradaDto("65452", "Bastian", "Jaque"));
        OdontologoSalidaDto odontologoEncontrado = odontologoService.buscarOdontologoPorId(1L);
        assertNotNull(odontologoEncontrado);
    }


}
