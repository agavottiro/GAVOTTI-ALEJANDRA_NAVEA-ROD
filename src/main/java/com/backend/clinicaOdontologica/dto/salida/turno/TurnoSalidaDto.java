package com.backend.clinicaOdontologica.dto.salida.turno;


import com.backend.clinicaOdontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;

import java.time.LocalDateTime;

public class TurnoSalidaDto {

    private Long id;

    private LocalDateTime fechaYHora;

    private OdontologoSalidaDto odontologoTurnoSalidaDto;

    private PacienteSalidaDto pacienteTurnoSalidaDto;

    public TurnoSalidaDto() {
    }

    public TurnoSalidaDto(Long id, LocalDateTime fechaYHora, OdontologoSalidaDto odontologoTurnoSalidaDto, PacienteSalidaDto pacienteTurnoSalidaDto) {
        this.id = id;
        this.fechaYHora = fechaYHora;
        this.odontologoTurnoSalidaDto = odontologoTurnoSalidaDto;
        this.pacienteTurnoSalidaDto = pacienteTurnoSalidaDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public OdontologoSalidaDto getOdontologoTurnoSalidaDto() {
        return odontologoTurnoSalidaDto;
    }

    public void setOdontologoTurnoSalidaDto(OdontologoSalidaDto odontologoTurnoSalidaDto) {
        this.odontologoTurnoSalidaDto = odontologoTurnoSalidaDto;
    }

    public PacienteSalidaDto getPacienteTurnoSalidaDto() {
        return pacienteTurnoSalidaDto;
    }

    public void setPacienteTurnoSalidaDto(PacienteSalidaDto pacienteTurnoSalidaDto) {
        this.pacienteTurnoSalidaDto = pacienteTurnoSalidaDto;
    }
}
