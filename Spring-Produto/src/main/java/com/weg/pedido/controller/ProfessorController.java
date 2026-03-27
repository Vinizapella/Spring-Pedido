package com.weg.pedido.controller;

import com.weg.pedido.dto.request.ProfessorRequestDto;
import com.weg.pedido.dto.response.ProfessorResponseDto;
import com.weg.pedido.service.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(
            ProfessorService professorService
    ) {
        this.professorService = professorService;
    }

    @PostMapping
    public ProfessorResponseDto save(
            @RequestBody @Valid ProfessorRequestDto professorRequestDto
    ) {
        return professorService.cria(professorRequestDto);
    }

    @GetMapping
    public List<ProfessorResponseDto> listAll() {
        return professorService.listarProfessores();
    }

    @GetMapping("/{id}")
    public ProfessorResponseDto searchOne(
            @PathVariable Integer id
    ) {
        return professorService.findById(id);
    }

    @PutMapping("/{id}")
    public ProfessorResponseDto update(
            @RequestBody @Valid ProfessorRequestDto professorRequestDto,
            @PathVariable Integer id
    ) {
        return professorService.update(professorRequestDto, id);
    }

    @DeleteMapping("/{id}")
    public void deletar(
            @PathVariable Integer id
    ) {
        professorService.delete(id);
    }
}

