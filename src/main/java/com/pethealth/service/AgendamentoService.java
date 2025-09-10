package com.pethealth.service;

import com.pethealth.dto.AgendamentoDTO;
import com.pethealth.model.Agendamento;
import com.pethealth.model.Pet;
import com.pethealth.repository.AgendamentoRepository;
import com.pethealth.repository.PetRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final PetRepository petRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository, PetRepository petRepository) {
        this.agendamentoRepository = agendamentoRepository;
        this.petRepository = petRepository;
    }

    public AgendamentoDTO salvar(Agendamento agendamento) {

        // Carrega o pet completo do banco (com tutor)
        Pet pet = petRepository.findById(agendamento.getPet().getId())
                .orElseThrow(() -> new RuntimeException("Pet não encontrado"));
        agendamento.setPet(pet);
    
        // 1️️ Carência do tutor (30 dias)
        if (pet.getTutor() != null && pet.getTutor().getDataCadastro() != null) {
            if (agendamento.getDataConsulta().isBefore(
                    pet.getTutor().getDataCadastro().plusDays(30))) {
                throw new RuntimeException("Tutor ainda está em carência, não pode agendar.");
            }
        }
    
        // 2️️ Limite mensal de agendamentos do pet
        int mes = agendamento.getDataConsulta().getMonthValue();
        int ano = agendamento.getDataConsulta().getYear();
        int agendamentosMes = agendamentoRepository.countByPetIdAndDataConsultaMonth(
                pet.getId(), mes, ano
        );
        if (agendamentosMes >= 3) { // limite: 3 agendamentos/mês
            throw new RuntimeException("Limite mensal de agendamentos do pet atingido.");
        }
    
        // 3️️ Evitar duplicidade na mesma data/hora
        boolean existe = agendamentoRepository.existsByPetIdAndDataConsulta(
                pet.getId(), agendamento.getDataConsulta()
        );
        if (existe) {
            throw new RuntimeException("Já existe um agendamento para esse pet nesta data/hora.");
        }
    
        // 4️️ Salvar agendamento
        Agendamento salvo = agendamentoRepository.save(agendamento);
    
        // 5️️ Retornar DTO
        return toDTO(salvo);
    }
    

    public AgendamentoDTO buscarPorId(Long id) {
        return agendamentoRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
    }

    public void deletar(Long id) {
        agendamentoRepository.deleteById(id);
    }

    public List<AgendamentoDTO> listarTodos() {
        return agendamentoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Converte Agendamento em DTO
    private AgendamentoDTO toDTO(Agendamento a) {
        return AgendamentoDTO.builder()
                .id(a.getId())
                .dataConsulta(a.getDataConsulta())
                .status(a.getStatus())
                .petId(a.getPet().getId())
                .petNome(a.getPet().getNome())
                .build();
    }
}
