package com.backend.clinicaOdontologica.service;

import com.backend.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaOdontologica.entity.Domicilio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
public class PacienteServiceTest {

    @Autowired
    private IPacienteService pacienteService;

    @Test
    public void deberiaAgregarUnPaciente(){
        PacienteEntradaDto paciente = new PacienteEntradaDto("Sofia", "Mansilla", "865465S", LocalDate.of(2021, 05, 26), new Domicilio("Una calle", 98, "Una localidad", "Una provincia"));

        PacienteSalidaDto pacienteAgregado = pacienteService.registrarPaciente(paciente);

        assertTrue(pacienteAgregado.getId() != 0);
    }

    @Test
    public void listarTodosLosPacientes(){
        List<PacienteSalidaDto> listaPacientes =pacienteService.listarPacientes();
        assertFalse(listaPacientes.isEmpty());
    }

    @Test
    public void deberiaEncontrarUnPacientePorSuId(){
        PacienteSalidaDto pacienteEncontrado = pacienteService.buscarPacientePorId(1L);
        assertNotNull(pacienteEncontrado);
    }
}
