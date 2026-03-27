package com.weg.pedido.controller;

import com.weg.pedido.dto.request.CategoriaRequestDto;
import com.weg.pedido.dto.response.CategoriaResponseDto;
import com.weg.pedido.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(
            CategoriaService categoriaService
    ) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public CategoriaResponseDto cadastrar(
            @RequestBody @Valid CategoriaRequestDto dto
    ) {
        return categoriaService.cadastrarCategoria(dto);
    }

    @GetMapping
    public List<CategoriaResponseDto> listarTodas() {
        return categoriaService.listarTodasCategorias();
    }

    @GetMapping("/{id}")
    public CategoriaResponseDto buscarPorId(
            @PathVariable Integer id
    ) {
        return categoriaService.buscarCategoriaPorId(id);
    }

    @PutMapping("/{id}")
    public CategoriaResponseDto atualizar(
            @PathVariable Integer id,
            @RequestBody @Valid CategoriaRequestDto dto
    ) {
        return categoriaService.atualizarCategoria(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(
            @PathVariable Integer id
    ) {
        categoriaService.deletarCategoria(id);
    }
}
