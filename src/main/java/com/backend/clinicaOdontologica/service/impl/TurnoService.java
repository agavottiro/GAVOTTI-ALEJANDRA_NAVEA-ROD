package com.backend.clinicaOdontologica.service.impl;

import com.backend.clinicaOdontologica.dto.entrada.turno.TurnoEntradaDto;
import com.backend.clinicaOdontologica.dto.modificacion.TurnoModificacionEntradaDto;
import com.backend.clinicaOdontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaOdontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaOdontologica.dto.salida.turno.TurnoSalidaDto;
import com.backend.clinicaOdontologica.entity.Turno;
import com.backend.clinicaOdontologica.exceptions.BadRequestException;
import com.backend.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.backend.clinicaOdontologica.repository.TurnoRepository;
import com.backend.clinicaOdontologica.service.ITurnoService;
import com.backend.clinicaOdontologica.utils.JsonPrinter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService implements ITurnoService {

    private final Logger LOGGER = LoggerFactory.getLogger(TurnoService.class);

    private final TurnoRepository turnoRepository;

    private final ModelMapper modelMapper;

    @Autowired
    private final PacienteService pacienteService;
    @Autowired
    private final OdontologoService odontologoService;

    @Autowired
    public TurnoService(TurnoRepository turnoRepository, ModelMapper modelMapper, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoRepository = turnoRepository;
        this.modelMapper = modelMapper;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
//        configureMapping();
    }

    public Logger getLOGGER() {
        return LOGGER;
    }

    public TurnoRepository getTurnoRepository() {
        return turnoRepository;
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }

    public PacienteService getPacienteService() {
        return pacienteService;
    }

    public OdontologoService getOdontologoService() {
        return odontologoService;
    }

    @Override
    public TurnoSalidaDto registrarTurno(TurnoEntradaDto turno) throws BadRequestException{

        PacienteSalidaDto pacienteTurno = pacienteService.buscarPacientePorId(turno.getPacienteSalidaDto().getId());
        OdontologoSalidaDto odontologoTurno = odontologoService.buscarOdontologoPorId(turno.getOdontologoSalidaDto().getId());

        TurnoSalidaDto turnoSalidaDto = null;

        if(pacienteTurno.getId() != null && odontologoTurno.getId() != null){
            Turno turnoEntidad = modelMapper.map(turno, Turno.class);

            Turno turnoAPersistir = turnoRepository.save(turnoEntidad);

            turnoSalidaDto = modelMapper.map(turnoAPersistir, TurnoSalidaDto.class);
            LOGGER.info("Turno creado: " + JsonPrinter.toString(turnoSalidaDto));

//            + " para el paciente: " + JsonPrinter.toString(pacienteTurno)+ " con el odontólogo: " + JsonPrinter.toString(odontologoTurno))

        } else if (pacienteTurno.getId() == null && odontologoTurno.getId() == null){
            LOGGER.error("No se pudo registrar el turno. Paciente y Odontólogo no encontrado.");
            throw new BadRequestException("No se han encontrado el odontólogo ni el paciente. No es posible registrar el turno");

        } else if (odontologoTurno.getId() == null){
            LOGGER.error("No se pudo registrar el turno. Odontólogo no encontrado");
            throw new BadRequestException("No se ha encontrado el odontólogo. No es posible regustrar el turno.");
        } else if (pacienteTurno.getId() == null){
            LOGGER.error("No se pudo registrar el turno. Paciente no encontrado");
            throw new BadRequestException("No se ha encontrado al paciente. No es posible registrar el turno");
        }


        return turnoSalidaDto;
    }

    @Override
    public List<TurnoSalidaDto> listarTurnos() {

        List<TurnoSalidaDto> turnos = turnoRepository.findAll()
                .stream()
                .map(turno -> modelMapper.map(turno, TurnoSalidaDto.class))
                .toList();

        if (LOGGER.isInfoEnabled()){
            LOGGER.info("Listado de todos los turnos: {}", JsonPrinter.toString(turnos));
        }
        return turnos;
    }

    @Override
    public TurnoSalidaDto buscarTurnoPorId(Long id) {
        Turno turnoBuscado = turnoRepository.findById(id).orElse(null);
        TurnoSalidaDto turnoEncontrado = null;

        if (turnoBuscado != null){
            turnoEncontrado = modelMapper.map(turnoBuscado, TurnoSalidaDto.class);
            LOGGER.info("Turno encontrado: {}", JsonPrinter.toString(turnoEncontrado));
        } else {
            LOGGER.error("El id de turno no se encuentra registrado en la base de datos.");
        }
        return turnoEncontrado;
    }

    @Override
    public TurnoSalidaDto actualizarTurno(TurnoModificacionEntradaDto turno){

        Turno turnoRecibido = modelMapper.map(turno, Turno.class);
        Turno turnoAActualizar = turnoRepository.findById(turnoRecibido.getId()).orElse(null);

        TurnoSalidaDto turnoSalidaDto = null;

        if(turnoAActualizar != null) {
            turnoAActualizar = turnoRecibido;
            turnoRepository.save(turnoAActualizar);

            turnoSalidaDto = modelMapper.map(turnoAActualizar, TurnoSalidaDto.class);
            LOGGER.warn("Turno actualizado: {}", JsonPrinter.toString(turnoSalidaDto));
        }else {
            LOGGER.error("Turno no encontrado en la base de datos. No fue posible actualizar.");


        }
        return null;
    }

    @Override
    public void eliminarTurno(Long id) throws ResourceNotFoundException{
        if (turnoRepository.findById(id).orElse(null) != null){
            turnoRepository.deleteById(id);
            LOGGER.warn("Se eliminó el turno con id: {}", id);
        }else {
            LOGGER.error("No se encontró el turno con id {}", id);
            throw new ResourceNotFoundException("No se encontró el turno con id " + id);
        }

    }

//    private void configureMapping() {
//        modelMapper.typeMap(TurnoEntradaDto.class, Turno.class)
//                .addMappings(mapper -> mapper.map(TurnoEntradaDto::getPacienteSalidaDto, Turno::setPaciente))
//                .addMappings(mapper -> mapper.map(TurnoEntradaDto::getOdontologoSalidaDto, Turno::setOdontologo));
//        modelMapper.typeMap(Turno.class, TurnoSalidaDto.class)
//                .addMappings(modelMapper -> modelMapper.map(Turno::getPaciente, TurnoSalidaDto::setPacienteSalidaDto))
//                .addMappings(modelMapper -> modelMapper.map(Turno::getOdontologo, TurnoSalidaDto::setOdontologoSalidaDto));
//        modelMapper.typeMap(TurnoModificacionEntradaDto.class, Turno.class)
//                .addMappings(mapper -> mapper.map(TurnoModificacionEntradaDto::getPacienteSalidaDto, Turno::setPaciente))
//                .addMappings(mapper -> mapper.map(TurnoModificacionEntradaDto::getOdontologoSalidaDto, Turno::setOdontologo));
//
//    }
}
