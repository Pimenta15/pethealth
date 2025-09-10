package com.pethealth.controller;

import com.pethealth.dto.AgendamentoDTO;
import com.pethealth.model.Agendamento;
import com.pethealth.service.AgendamentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @GetMapping
    public List<AgendamentoDTO> listar() {
        return agendamentoService.listarTodos();
    }

    @PostMapping
    public AgendamentoDTO criar(@RequestBody Agendamento agendamento) {
        return agendamentoService.salvar(agendamento);
    }

    @GetMapping("/{id}")
    public AgendamentoDTO buscar(@PathVariable Long id) {
        return agendamentoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        agendamentoService.deletar(id);
    }
}
