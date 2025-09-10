package com.pethealth.service;

import com.pethealth.model.Pet;
import com.pethealth.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> listarTodos() {
        return petRepository.findAll();
    }

    public Pet salvar(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet buscarPorId(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pet não encontrado"));
    }

    public void deletar(Long id) {
        petRepository.deleteById(id);
    }
}
