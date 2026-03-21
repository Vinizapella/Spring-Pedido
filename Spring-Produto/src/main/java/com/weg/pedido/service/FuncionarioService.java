package com.weg.pedido.service;

import com.weg.pedido.dto.request.FuncionarioRequestDto;
import com.weg.pedido.dto.response.FuncionarioResponseDto;
import com.weg.pedido.mapper.FuncionarioMapper;
import com.weg.pedido.model.Departamento;
import com.weg.pedido.model.Funcionario;
import com.weg.pedido.repositorio.DepartamentoRepositorio;
import com.weg.pedido.repositorio.FuncionarioRepositorio;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepositorio repositorio;
    private final DepartamentoRepositorio departamentoRepositorio;
    private final FuncionarioMapper mapper;


    public FuncionarioService(
            FuncionarioRepositorio repositorio,
            DepartamentoRepositorio departamentoRepositorio,
            FuncionarioMapper mapper
    ) {
        this.repositorio = repositorio;
        this.departamentoRepositorio = departamentoRepositorio;
        this.mapper = mapper;
    }

    public FuncionarioResponseDto cadastrar(
            FuncionarioRequestDto request
    ) {
        Departamento departamento = departamentoRepositorio.findById(request.departamentoId())
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado. ID: " + request.departamentoId()));

        Funcionario funcionario = mapper.toEntity(request);
        funcionario.setDepartamento(departamento);

        Funcionario salvo = repositorio.save(funcionario);
        return mapper.toResponse(salvo);
    }

    public List<FuncionarioResponseDto> listarTodos() {
        return repositorio.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public FuncionarioResponseDto buscarPorId(
            Long id
    ) {
        Funcionario funcionario = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado. ID: " + id));
        return mapper.toResponse(funcionario);
    }

    public List<FuncionarioResponseDto> buscarPorDepartamento(
            Long departamentoId
    ) {
        return repositorio.findByDepartamentoId(departamentoId)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public List<FuncionarioResponseDto> buscarPorNome(
            String nome
    ) {
        return repositorio.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public List<FuncionarioResponseDto> buscarComFiltros(
            Long id,
            String nome
    ) {
        return repositorio.buscarComFiltros(id, nome)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}
