package com.weg.pedido.service;

import com.weg.pedido.dto.request.ProdutoRequestDto;
import com.weg.pedido.dto.response.ProdutoResponseDto;
import com.weg.pedido.mapper.ProdutoMapper;
import com.weg.pedido.model.Categoria;
import com.weg.pedido.model.Produto;
import com.weg.pedido.repositorio.CategoriaRepositorio;
import com.weg.pedido.repositorio.ProdutoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepositorio produtoRepositorio;

    private final CategoriaRepositorio categoriaRepositorio;

    private final ProdutoMapper produtoMapper;

    public ProdutoService(
            ProdutoRepositorio produtoRepositorio,
            CategoriaRepositorio categoriaRepositorio,
            ProdutoMapper produtoMapper
    ) {
        this.produtoRepositorio = produtoRepositorio;
        this.categoriaRepositorio = categoriaRepositorio;
        this.produtoMapper = produtoMapper;
    }

    public ProdutoResponseDto cadastrarProduto(
            ProdutoRequestDto produtoRequestDto
    ) {
        Categoria categoria = categoriaRepositorio.findById(produtoRequestDto.categoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Produto produto = produtoMapper.toEntity(produtoRequestDto, categoria);
        return produtoMapper.toResponse(produtoRepositorio.save(produto));
    }

    public List<ProdutoResponseDto> listarTodosProdutos() {
        return produtoRepositorio.findAll()
                .stream()
                .map(produtoMapper::toResponse)
                .toList();
    }

    public List<ProdutoResponseDto> buscarProdutosPorCategoriaId(
            Integer categoriaId
    ) {
        return produtoRepositorio.findByCategoriaId(categoriaId)
                .stream()
                .map(produtoMapper::toResponse)
                .toList();
    }

    public List<ProdutoResponseDto> buscarProdutosPorNome(
            String nome
    ) {
        return produtoRepositorio.findByNome(nome)
                .stream()
                .map(produtoMapper::toResponse)
                .toList();
    }

    public ProdutoResponseDto buscarProdutoPorIdENome(
            Integer id, String nome
    ) {
        Produto produto = produtoRepositorio.findByIdAndNome(id, nome)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return produtoMapper.toResponse(produto);
    }

    public List<ProdutoResponseDto> buscarProdutosPorNomeCategoria(
            String nomeCategoria
    ) {
        return produtoRepositorio.findByCategoriaNome(nomeCategoria)
                .stream()
                .map(produtoMapper::toResponse)
                .toList();
    }

}