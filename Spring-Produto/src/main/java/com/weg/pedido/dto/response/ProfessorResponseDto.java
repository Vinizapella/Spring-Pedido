package com.weg.pedido.dto.response;

import java.util.List;

public record ProfessorResponseDto(

        Integer id,

        String nome,

        String email,

        String especialdiade,

        List<CursoReponseDto> cursos

){
}
