package com.weg.pedido.service;


import com.weg.pedido.dto.request.DepartamentoRequestDto;
import com.weg.pedido.dto.response.DepartamentoResponseDto;
import com.weg.pedido.mapper.DepartamentoMapper;
import com.weg.pedido.model.Departamento;
import com.weg.pedido.repositorio.DepartamentoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    private final DepartamentoRepositorio repositorio;
    private final DepartamentoMapper mapper;

    public DepartamentoService(
            DepartamentoRepositorio repositorio,
            DepartamentoMapper mapper
    ) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    public DepartamentoResponseDto cadastrar(
            DepartamentoRequestDto request
    ) {
        Departamento departamento = mapper.toEntity(request);
        Departamento salvo = repositorio.save(departamento);
        return mapper.toResponse(salvo);
    }

    public List<DepartamentoResponseDto> listarTodos() {
        return repositorio.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public DepartamentoResponseDto buscarPorId(
            Long id
    ) {
        Departamento departamento = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado. ID: " + id));
        return mapper.toResponse(departamento);
    }

    public DepartamentoResponseDto buscarComFuncionarios(Long id) {
        Departamento departamento = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado. ID: " + id));
        return mapper.toResponse(departamento);
    }

}