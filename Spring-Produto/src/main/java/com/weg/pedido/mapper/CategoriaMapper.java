package com.weg.pedido.mapper;

import com.weg.pedido.dto.request.CategoriaRequestDto;
import com.weg.pedido.dto.response.CategoriaResponseDto;
import com.weg.pedido.model.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public Categoria toEntity(
            CategoriaRequestDto categoriaRequestDto
    ){
        return new Categoria(
                categoriaRequestDto.nome()
        );
    }


    public CategoriaResponseDto toResponse(
            Categoria categoria
    ) {
        return new CategoriaResponseDto(categoria.getId(), categoria.getNome());
    }
}
