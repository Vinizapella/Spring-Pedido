package com.weg.pedido.mapper;

import com.weg.pedido.dto.request.ProdutoRequestDto;
import com.weg.pedido.dto.response.ProdutoResponseDto;
import com.weg.pedido.model.Categoria;
import com.weg.pedido.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public Produto toEntity(
            ProdutoRequestDto produtoRequestDto,
            Categoria categoria
    ){
        return new Produto(
                produtoRequestDto.nome(),
                produtoRequestDto.preco(),
                categoria
        );
    }


    public ProdutoResponseDto toResponse(
            Produto produto
    ) {
        return new ProdutoResponseDto(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getCategoria().getNome()
        );
    }

}
