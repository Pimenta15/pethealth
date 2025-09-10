package com.pethealth.service;

import com.pethealth.model.Tutor;
import com.pethealth.repository.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {
    private final TutorRepository tutorRepository;

    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    public List<Tutor> listarTodos() {
        return tutorRepository.findAll();
    }

    public Tutor salvar(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    public Tutor buscarPorId(Long id) {
        return tutorRepository.findById(id).orElseThrow(() -> new RuntimeException("Tutor não encontrado"));
    }

    public void deletar(Long id) {
        tutorRepository.deleteById(id);
    }
}
