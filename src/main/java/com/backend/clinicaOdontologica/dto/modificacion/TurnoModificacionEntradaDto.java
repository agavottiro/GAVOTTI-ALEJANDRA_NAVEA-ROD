package com.backend.clinicaOdontologica.dto.modificacion;

import com.backend.clinicaOdontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class TurnoModificacionEntradaDto {

    @NotNull(message = "Debe proporcionar el id del domicilio que se desea modificar")
    private Long id;

    @FutureOrPresent(message = "La fecha no puede ser anterior al día de hoy")
    @NotNull(message = "La fecha y hora no puede ser nula")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaYHora;

    @NotNull(message = "El odontologo no puede ser nulo")
    @Valid
    private Long odontologo;

    @NotNull(message = "El paciente no puede ser nulo")
    @Valid
    private Long paciente;

    public TurnoModificacionEntradaDto() {
    }

    public TurnoModificacionEntradaDto(Long id, LocalDateTime fechaYHora, Long odontologo, Long paciente) {
        this.id = id;
        this.fechaYHora = fechaYHora;
        this.odontologo = odontologo;
        this.paciente = paciente;
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

    public Long getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Long odontologo) {
        this.odontologo = odontologo;
    }

    public Long getPaciente() {
        return paciente;
    }

    public void setPaciente(Long paciente) {
        this.paciente = paciente;
    }
}
