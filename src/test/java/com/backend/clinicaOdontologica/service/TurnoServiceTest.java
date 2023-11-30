package com.backend.clinicaOdontologica.service;

import com.backend.clinicaOdontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinicaOdontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaOdontologica.dto.entrada.turno.TurnoEntradaDto;
import com.backend.clinicaOdontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaOdontologica.dto.salida.turno.TurnoSalidaDto;
import com.backend.clinicaOdontologica.entity.Domicilio;
import com.backend.clinicaOdontologica.exceptions.BadRequestException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class TurnoServiceTest {

    @Autowired
    private ITurnoService turnoService;
    @Autowired
    private IOdontologoService odontologoService;

    @Autowired
    private IPacienteService pacienteService;

    private PacienteSalidaDto pacienteSalida;

    private PacienteEntradaDto pacienteEntrada;

    private OdontologoSalidaDto odontologoSalida;

    private OdontologoEntradaDto odontologoEntrada;

    private TurnoEntradaDto turno;

    @BeforeEach
    void setUp() {
        odontologoEntrada = new OdontologoEntradaDto("68541", "Juan", "Gonzalez");
        odontologoSalida = odontologoService.registrarOdontologo(odontologoEntrada);

        pacienteEntrada = new PacienteEntradaDto("Sofia", "Mansilla", "865465S", LocalDate.of(2021, 05, 26), new Domicilio("Una calle", 98, "Una localidad", "Una provincia"));
        pacienteSalida = pacienteService.registrarPaciente(pacienteEntrada);

        turno = new TurnoEntradaDto((LocalDateTime.of(2022, 6, 13, 10, 35)),odontologoSalida.getId(), pacienteSalida.getId());

    }


    @Order(1)
    @Test

    public void deberiaRegistrarUnTurno() throws BadRequestException {

        TurnoSalidaDto turnoRegistrado = turnoService.registrarTurno(turno);

        assertTrue(turnoRegistrado.getId() != 0);
    }


    @Order(2)
    @Test
    public void listarTodosLosTurnos() {

        List<TurnoSalidaDto> listaTurnos = turnoService.listarTurnos();
        assertFalse(listaTurnos.isEmpty());
    }


    @Order(3)
    @Test

    public void deberiaEncontrarUnTurnoPorSuId(){
        TurnoSalidaDto turnoEncontrado = turnoService.buscarTurnoPorId(1L);
        assertNotNull(turnoEncontrado);
    }


}
