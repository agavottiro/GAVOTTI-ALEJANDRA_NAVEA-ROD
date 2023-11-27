package com.backend.clinicaOdontologica.dto.entrada.odontologo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoEntradaDto {

    @NotNull(message = "La matrícula del odontólogo no puede ser nula")
    @NotBlank(message = "La matrícula del odontólogo no puede estar vacía")
    @Size(min = 10, message = "La matrícula debe tener mínimo 10 caracteres")
    private String matricula;

    @NotNull(message = "El nombre del odontólogo no puede ser nulo")
    @NotBlank(message = "El nombre del odontólogo no puede estar vacío")
    @Size(max = 50, message = "El nombre del odontólogo no puede tener más de 50 caracteres")

    private String nombre;

    @NotNull(message = "El apellido del odontólogo no puede ser nulo")
    @NotBlank(message = "El apellido del odontólogo no puede estar vacío")
    @Size(max = 50, message = "El apellido del odontólogo no puede tener más de 50 caracteres")

    private String apellido;

    public OdontologoEntradaDto() {
    }

    public OdontologoEntradaDto(String matricula, String nombre, String apellido) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
}
