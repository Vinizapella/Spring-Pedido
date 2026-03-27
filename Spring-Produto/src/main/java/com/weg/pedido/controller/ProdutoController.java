package com.weg.pedido.controller;

import com.weg.pedido.dto.request.ProdutoRequestDto;
import com.weg.pedido.dto.response.ProdutoResponseDto;
import com.weg.pedido.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(
            ProdutoService produtoService
    ) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ProdutoResponseDto cadastrar(
            @RequestBody @Valid ProdutoRequestDto dto
    ) {
        return produtoService.cadastrarProduto(dto);
    }

    @GetMapping
    public List<ProdutoResponseDto> listarTodos() {
        return produtoService.listarTodosProdutos();
    }

    @GetMapping("/categoria/{id}")
    public List<ProdutoResponseDto> buscarPorCategoria(
            @PathVariable Integer id
    ) {
        return produtoService.buscarProdutosPorCategoriaId(id);
    }

    @GetMapping("/nome/{nome}")
    public List<ProdutoResponseDto> buscarPorNome(
            @PathVariable String nome
    ) {
        return produtoService.buscarProdutosPorNome(nome);
    }

    @GetMapping("/{id}/{nome}")
    public ProdutoResponseDto buscarPorIdENome(
            @PathVariable Integer id,
            @PathVariable String nome
    ) {
        return produtoService.buscarProdutoPorIdENome(id, nome);
    }

    @GetMapping("/categoria-nome/{nome}")
    public List<ProdutoResponseDto> buscarPorNomeCategoria(
            @PathVariable String nome
    ) {
        return produtoService.buscarProdutosPorNomeCategoria(nome);
    }
}