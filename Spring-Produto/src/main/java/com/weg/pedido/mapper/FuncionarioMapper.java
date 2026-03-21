package com.weg.pedido.mapper;

import com.weg.pedido.dto.request.FuncionarioRequestDto;
import com.weg.pedido.dto.response.FuncionarioResponseDto;
import com.weg.pedido.model.Funcionario;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

    public Funcionario toEntity(
            FuncionarioRequestDto request
    ) {
        return new Funcionario(
                request.nome(),
                request.cargo(),
                request.salario()
        );
    }

    public FuncionarioResponseDto toResponse(
            Funcionario funcionario
    ) {
        return new FuncionarioResponseDto(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getCargo(),
                funcionario.getSalario(),
                funcionario.getDepartamento().getId(),
                funcionario.getDepartamento().getNome()
        );
    }
}
