package com.pethealth.controller;

import com.pethealth.model.Pet;
import com.pethealth.service.PetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public List<Pet> listar() {
        return petService.listarTodos();
    }

    @PostMapping
    public Pet criar(@RequestBody Pet pet) {
        return petService.salvar(pet);
    }

    @GetMapping("/{id}")
    public Pet buscar(@PathVariable Long id) {
        return petService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        petService.deletar(id);
    }
}
