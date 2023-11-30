package com.backend.clinicaOdontologica.dto.modificacion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DomicilioModificacionEntradaDto {

    @NotNull(message = "Debe proporcionar el id del domicilio que se desea modificar")
    private Long id;

    @NotNull(message = "El campo no puede ser nulo")
    @NotBlank(message = "El campo no puede estar en blanco")
    private String calle;

    @NotNull(message = "El campo no puede ser nulo")
    @Digits(integer = 8, fraction = 0, message = "El número debe tener 8 dígitos máximo")
    private Integer numero;

    @NotNull(message = "El campo no puede ser nulo")
    @NotBlank(message = "El campo no puede estar en blanco")
    private String localidad;

    @NotNull(message = "El campo no puede ser nulo")
    @NotBlank(message = "El campo no puede estar en blanco")
    private String provincia;

    public DomicilioModificacionEntradaDto() {
    }

    public DomicilioModificacionEntradaDto(Long id, String calle, Integer numero, String localidad, String provincia) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
