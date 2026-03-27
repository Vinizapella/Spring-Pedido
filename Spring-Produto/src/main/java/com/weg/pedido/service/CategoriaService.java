package com.weg.pedido.service;

import com.weg.pedido.dto.request.CategoriaRequestDto;
import com.weg.pedido.dto.response.CategoriaResponseDto;
import com.weg.pedido.mapper.CategoriaMapper;
import com.weg.pedido.model.Categoria;
import com.weg.pedido.repositorio.CategoriaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepositorio categoriaRepositorio;

    private final CategoriaMapper categoriaMapper;

    public CategoriaService(
            CategoriaRepositorio categoriaRepositorio,
            CategoriaMapper categoriaMapper
    ) {
        this.categoriaRepositorio = categoriaRepositorio;
        this.categoriaMapper = categoriaMapper;
    }

    public CategoriaResponseDto cadastrarCategoria(
            CategoriaRequestDto categoriaRequestDto
    ) {
        Categoria categoria = categoriaMapper.toEntity(categoriaRequestDto);
        return categoriaMapper.toResponse(categoriaRepositorio.save(categoria));
    }

    public List<CategoriaResponseDto> listarTodasCategorias() {
        return categoriaRepositorio.findAll()
                .stream()
                .map(categoriaMapper::toResponse)
                .toList();
    }

    public CategoriaResponseDto buscarCategoriaPorId(
            Integer id
    ) {
        Categoria categoria = categoriaRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        return categoriaMapper.toResponse(categoria);
    }

    public CategoriaResponseDto atualizarCategoria(
            Integer id,
            CategoriaRequestDto categoriaRequestDto
    ) {
        Categoria categoriaExistente = categoriaRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        categoriaExistente.setNome(categoriaRequestDto.nome());
        return categoriaMapper.toResponse(categoriaRepositorio.save(categoriaExistente));
    }

    public void deletarCategoria(
            Integer id
    ) {
        Categoria categoria = categoriaRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        categoriaRepositorio.delete(categoria);
    }
}


