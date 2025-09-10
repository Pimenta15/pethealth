package com.pethealth.controller;

import com.pethealth.model.Tutor;
import com.pethealth.service.TutorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping
    public List<Tutor> listar() {
        return tutorService.listarTodos();
    }

    @PostMapping
    public Tutor criar(@RequestBody Tutor tutor) {
        return tutorService.salvar(tutor);
    }

    @GetMapping("/{id}")
    public Tutor buscar(@PathVariable Long id) {
        return tutorService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        tutorService.deletar(id);
    }
}
