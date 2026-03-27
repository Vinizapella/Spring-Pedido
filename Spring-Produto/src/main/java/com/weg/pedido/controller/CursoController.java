package com.weg.pedido.controller;

import com.weg.pedido.dto.request.CursoRequestDto;
import com.weg.pedido.dto.response.CursoReponseDto;
import com.weg.pedido.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(
            CursoService cursoService
    ) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public CursoReponseDto save(
            @RequestBody @Valid CursoRequestDto cursoRequestDto
    ) {
        return cursoService.criaCurso(cursoRequestDto);
    }

    @GetMapping
    public List<CursoReponseDto> listAll() {
        return cursoService.cursos();
    }

    @GetMapping("/{id}")
    public CursoReponseDto searchOne(
            @PathVariable Integer id
    ) {
        return cursoService.bucaId(id);
    }

    @GetMapping("/professor/{professorId}")
    public List<CursoReponseDto> cursosProfeId(
            @PathVariable Integer professorId
    ) {
        return cursoService.cursosProfeId(professorId);
    }

    @GetMapping("/busca-nome")
    public List<CursoReponseDto> buscaCursosProfeNome(
            @RequestParam String nome
    ) {
        return cursoService.buscaCursosProfeNome(nome);
    }

    @GetMapping("/detalhe")
    public CursoReponseDto buscaIdNome(
            @RequestParam Integer id,
            @RequestParam String nome
    ) {
        return cursoService.buscaIdNome(id, nome);
    }

    @PutMapping("/{id}")
    public CursoReponseDto update(
            @PathVariable Integer id,
            @RequestBody @Valid CursoRequestDto cursoRequestDto
    ) {
        return cursoService.update(id, cursoRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deletar(
            @PathVariable Integer id
    ) {
        cursoService.delete(id);
    }
}

