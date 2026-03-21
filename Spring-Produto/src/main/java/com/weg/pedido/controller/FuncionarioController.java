package com.weg.pedido.controller;

import com.weg.pedido.dto.request.FuncionarioRequestDto;
import com.weg.pedido.dto.response.FuncionarioResponseDto;
import com.weg.pedido.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(
            FuncionarioService funcionarioService
    ) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public FuncionarioResponseDto salvar(
            @RequestBody @Valid FuncionarioRequestDto funcionarioRequest
    ) {
        return funcionarioService.cadastrar(funcionarioRequest);
    }

    @GetMapping
    public List<FuncionarioResponseDto> list() {
        return funcionarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public FuncionarioResponseDto searchOne(
            @PathVariable Long id
    ) {
        return funcionarioService.buscarPorId(id);
    }

    @GetMapping("/filtro/departamento")
    public List<FuncionarioResponseDto> searchByDepartamento(
            @PathVariable Long departamentoId
    ) {
        return funcionarioService.buscarPorDepartamento(departamentoId);
    }

    @GetMapping("/filtro/nome")
    public List<FuncionarioResponseDto> searchByNome(
            @PathVariable String nome
    ) {
        return funcionarioService.buscarPorNome(nome);
    }

    @GetMapping("/filtro")
    public List<FuncionarioResponseDto> searchWithFilters(
            @PathVariable Long id,
            @PathVariable String nome
    ) {
        return funcionarioService.buscarComFiltros(id, nome);
    }
}
