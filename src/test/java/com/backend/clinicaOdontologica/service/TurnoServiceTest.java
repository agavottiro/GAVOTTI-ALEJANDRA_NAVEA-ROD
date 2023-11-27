package com.backend.clinicaOdontologica.service;

import com.backend.clinicaOdontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaOdontologica.dto.entrada.turno.TurnoEntradaDto;
import com.backend.clinicaOdontologica.dto.salida.turno.TurnoSalidaDto;
import com.backend.clinicaOdontologica.entity.Domicilio;
import com.backend.clinicaOdontologica.exceptions.BadRequestException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
public class TurnoServiceTest {

    @Autowired
    private ITurnoService turnoService;
    @Autowired
    private IOdontologoService odontologoService;

    @Autowired
    private IPacienteService pacienteService;

    @Test
    public void deberiaRegistrarUnTurno() throws BadRequestException {

        odontologoService.registrarOdontologo(new OdontologoEntradaDto("65452", "Juan", "Gonzalez"));
        pacienteService.registrarPaciente(new PacienteEntradaDto("Sofia", "Mancilla", "865465S", LocalDate.of(2021, 05, 26), new Domicilio("Una calle", 98, "Una localidad", "Una provincia")));

        TurnoEntradaDto turno = new TurnoEntradaDto((LocalDateTime.of(2022, 6, 13, 10, 35)),odontologoService.buscarOdontologoPorId(1L), pacienteService.buscarPacientePorId(2L));

        TurnoSalidaDto turnoRegistrado = turnoService.registrarTurno(turno);

        assertTrue(turnoRegistrado.getId() != 0);
    }

    @Test
    public void listarTodosLosTurnos() throws BadRequestException {
        odontologoService.registrarOdontologo(new OdontologoEntradaDto("86548", "Walter", "Real"));
        pacienteService.registrarPaciente(new PacienteEntradaDto("Ignacio", "Aldana", "865465S", LocalDate.of(2021, 05, 26), new Domicilio("Una calle", 98, "Una localidad", "Una provincia")));

        turnoService.registrarTurno(new TurnoEntradaDto((LocalDateTime.of(2022, 6, 13, 10, 35)),odontologoService.buscarOdontologoPorId(1L), pacienteService.buscarPacientePorId(2L)));
        List<TurnoSalidaDto> listaTurnos = turnoService.listarTurnos();
        assertFalse(listaTurnos.isEmpty());
    }

    @Test
    public void deberiaEncontrarUnTurnoPorSuId(){
        TurnoSalidaDto turnoEncontrado = turnoService.buscarTurnoPorId(4L);
        assertNotNull(turnoEncontrado);
    }


}
