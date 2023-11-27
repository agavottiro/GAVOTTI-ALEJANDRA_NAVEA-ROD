package com.backend.clinicaOdontologica.dto.modificacion;

import com.backend.clinicaOdontologica.entity.Domicilio;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class PacienteModificacionEntradaDto {

    @NotNull(message = "Debe proporcionar el id del paciente que se desea modificar")
    private Long id;
    @NotNull(message = "El nombre del paciente no puede ser nula")
    @NotBlank(message = "El nombre del paciente no puede estar vacía")
    @Size(max = 50, message = "El nombre del paciente no puede tener más de 50 caracteres")
    private String nombre;

    @NotNull(message = "El apellido del paciente no puede ser nula")
    @NotBlank(message = "El apellido del paciente no puede estar vacía")
    @Size(max = 50, message = "El apellido del paciente no puede tener más de 50 caracteres")
    private String apellido;

    @NotNull(message = "El dni del paciente no puede ser nula")
    @NotBlank(message = "El dni del paciente no puede estar vacía")
    @Size(max = 50, message = "El dni del paciente no puede tener más de 50 caracteres")
    private String dni;

    @FutureOrPresent(message = "La fecha no puede ser anterior al día de hoy")
    @NotNull(message = "La fecha de ingreso del paciente debe especificarse")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaAlta;

    @NotNull(message = "El domicilio del paciente no puede ser nulo")
    @Valid
    private DomicilioModificacionEntradaDto domicilioModificacionEntradaDto;


    public PacienteModificacionEntradaDto() {
    }

    public PacienteModificacionEntradaDto(Long id, String nombre, String apellido, String dni, LocalDate fechaAlta, DomicilioModificacionEntradaDto domicilioModificacionEntradaDto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaAlta = fechaAlta;
        this.domicilioModificacionEntradaDto = domicilioModificacionEntradaDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public DomicilioModificacionEntradaDto getDomicilioModificacionEntradaDto() {
        return domicilioModificacionEntradaDto;
    }

    public void setDomicilioModificacionEntradaDto(DomicilioModificacionEntradaDto domicilioModificacionEntradaDto) {
        this.domicilioModificacionEntradaDto = domicilioModificacionEntradaDto;
    }
}
