package com.backend.clinicaOdontologica.dto.entrada.paciente;

import com.backend.clinicaOdontologica.entity.Domicilio;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteEntradaDto {


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
    private Domicilio domicilioEntradaDto;

    public PacienteEntradaDto() {
    }

    public PacienteEntradaDto(String nombre, String apellido, String dni, LocalDate fechaAlta, Domicilio domicilioEntradaDto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaAlta = fechaAlta;
        this.domicilioEntradaDto = domicilioEntradaDto;
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

    public Domicilio getDomicilioEntradaDto() {
        return domicilioEntradaDto;
    }

    public void setDomicilioEntradaDto(Domicilio domicilioEntradaDto) {
        this.domicilioEntradaDto = domicilioEntradaDto;
    }
}
