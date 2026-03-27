package com.weg.pedido.mapper;

import com.weg.pedido.dto.request.ProfessorRequestDto;
import com.weg.pedido.dto.response.ProfessorResponseDto;
import com.weg.pedido.model.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {

    private final CursoMapper cursoMapper;

    public ProfessorMapper(
            CursoMapper cursoMapper
    ) {
        this.cursoMapper = cursoMapper;
    }

    public Professor toEntity(
            ProfessorRequestDto professorRequestDto
    ){
        return new Professor(
            professorRequestDto.nome(),
            professorRequestDto.email(),
            professorRequestDto.especialidade()
        );
    }

    public ProfessorResponseDto toResponse (
            Professor professor
    ){
        return new ProfessorResponseDto(
                professor.getId(),
                professor.getNome(),
                professor.getEmail(),
                professor.getEspecialidade(),
                professor.getCursos()
                        .stream()
                        .map(cursoMapper::toResponse)
                        .toList()
        );
    }

}
