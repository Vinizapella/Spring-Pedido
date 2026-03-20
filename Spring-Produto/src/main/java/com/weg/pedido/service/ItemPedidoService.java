package com.weg.pedido.service;

import com.weg.pedido.dto.request.ItemPedidoRequestDto;
import com.weg.pedido.dto.response.ItemPedidoResponseDto;
import com.weg.pedido.mapper.ItemPedidoMapper;
import com.weg.pedido.model.ItemPedido;
import com.weg.pedido.model.Pedido;
import com.weg.pedido.repositorio.ItemPedidoRepositorio;
import com.weg.pedido.repositorio.PedidoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    private final ItemPedidoRepositorio itemPedidoRepositorio;
    private final PedidoRepositorio pedidoRepositorio;
    private final ItemPedidoMapper itemPedidoMapper;

    public ItemPedidoService(
             ItemPedidoRepositorio itemPedidoRepositorio,
             PedidoRepositorio pedidoRepositorio,
             ItemPedidoMapper itemPedidoMapper
    ) {
        this.itemPedidoRepositorio = itemPedidoRepositorio;
        this.pedidoRepositorio = pedidoRepositorio;
        this.itemPedidoMapper = itemPedidoMapper;
    }

    public ItemPedidoResponseDto save(
            ItemPedidoRequestDto itemPedidoRequestDto
    ){
        try {
            Pedido pedido = pedidoRepositorio.findById(itemPedidoRequestDto.idPedido())
                    .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

            ItemPedido itemPedido = itemPedidoMapper.toEntity(itemPedidoRequestDto);

            itemPedido.setPedido(pedido);

            ItemPedido itemPedido1 = itemPedidoRepositorio.save(itemPedido);

            return itemPedidoMapper.toResponse(itemPedido1);

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ItemPedidoResponseDto>list(){

        List<ItemPedido> pedidos = itemPedidoRepositorio.findAll();

        return pedidos.stream()
                .map(itemPedidoMapper::toResponse)
                .toList();

    }

    public ItemPedidoResponseDto searchOne(
            ItemPedidoRequestDto itemPedidoRequestDto,
            Integer id
    ){

        return itemPedidoRepositorio.findById(id)
                .map(itemPedidoMapper::toResponse)
                .orElseThrow(()->new RuntimeException("Item não encontrado"));
    }

    public ItemPedidoResponseDto update(
            ItemPedidoRequestDto itemPedidoRequestDto,
            Integer id
    ){

        Pedido pedido = pedidoRepositorio.findById(itemPedidoRequestDto.idPedido())
                .orElseThrow(()-> new RuntimeException("Pedido não encontrado"));

        ItemPedido itemPedido = itemPedidoRepositorio.findById(id)
                .orElseThrow(()->new RuntimeException("produto não encontrado"));

        itemPedido.setNomeProduto(itemPedidoRequestDto.nomeProduto());

        itemPedido.setQuantidade(itemPedidoRequestDto.quantidade());

        itemPedido.setPrecoUnitario(itemPedidoRequestDto.precoUnitario());

        itemPedido.setPedido(pedido);

        itemPedidoRepositorio.save(itemPedido);

        return itemPedidoMapper.toResponse(itemPedido);

    }

    public void delete(
            Integer id
    ){

        if (!itemPedidoRepositorio.existsById(id)){
            throw new RuntimeException("Pedido não existe");
        }

        itemPedidoRepositorio.deleteById(id);


    }
}
