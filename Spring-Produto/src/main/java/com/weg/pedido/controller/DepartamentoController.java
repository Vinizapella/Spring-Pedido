package com.weg.pedido.controller;

import com.weg.pedido.dto.request.DepartamentoRequestDto;
import com.weg.pedido.dto.response.DepartamentoResponseDto;
import com.weg.pedido.service.DepartamentoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @PostMapping
    public DepartamentoResponseDto salvar(
            @RequestBody @Valid DepartamentoRequestDto departamentoRequest
    ) {
        return departamentoService.cadastrar(departamentoRequest);
    }

    @GetMapping
    public List<DepartamentoResponseDto> list() {
        return departamentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public DepartamentoResponseDto searchOne(
            @PathVariable Long id
    ) {
        return departamentoService.buscarPorId(id);
    }

    @GetMapping("/{id}/funcionarios")
    public DepartamentoResponseDto searchWithFuncionarios(
            @PathVariable Long id
    ) {
        return departamentoService.buscarComFuncionarios(id);
    }
}