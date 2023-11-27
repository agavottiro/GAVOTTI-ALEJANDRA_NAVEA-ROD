package com.backend.clinicaOdontologica.dto.modificacion;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OdontologoModificacionEntradaDto {

    @NotNull(message = "Debe proporcionarse el id del odontólogo que se desea modificar")
    private Long id;

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

    public OdontologoModificacionEntradaDto() {
    }

    public OdontologoModificacionEntradaDto(Long id, String matricula, String nombre, String apellido) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
