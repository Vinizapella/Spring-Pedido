package com.weg.pedido.mapper;

import com.weg.pedido.dto.request.CursoRequestDto;
import com.weg.pedido.dto.response.CursoReponseDto;
import com.weg.pedido.model.Curso;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {

    public Curso toEntity(
            CursoRequestDto cursoRequestDto
    ){
        return new Curso(
                cursoRequestDto.nome()
        );
    }

    public CursoReponseDto toResponse(
            Curso curso
    ){
        return new CursoReponseDto(
                curso.getId(),
                curso.getNome(),
                curso.getProfessor().getNome()
        );
    }

}
