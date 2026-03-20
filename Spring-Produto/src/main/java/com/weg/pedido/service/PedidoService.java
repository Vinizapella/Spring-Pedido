package com.weg.pedido.service;

import com.weg.pedido.dto.request.PedidoRequestDto;
import com.weg.pedido.dto.response.PedidoResponseDto;
import com.weg.pedido.mapper.PedidoMapper;
import com.weg.pedido.model.Pedido;
import com.weg.pedido.repositorio.PedidoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepositorio pedidoRepositorio;

    private final PedidoMapper pedidoMapper;

    public PedidoService(
            PedidoRepositorio pedidoRepositorio,
            PedidoMapper pedidoMapper
    ){
        this.pedidoRepositorio = pedidoRepositorio;
        this.pedidoMapper = pedidoMapper;
    }

    public PedidoResponseDto salve(
            PedidoRequestDto pedidoRequest
    ){
        Pedido pedido = pedidoMapper.toEntity(pedidoRequest);
        Pedido pedidoRepository = pedidoRepositorio.save(pedido);
        return pedidoMapper.toResponse(pedidoRepository);
    }

    public List<PedidoResponseDto>all(){
        List<Pedido>pedidos = pedidoRepositorio.findAll();

        return pedidos.stream()
                .map(pedidoMapper::toResponse)
                .toList();
    }

    public PedidoResponseDto findbyId(
            Integer id
    ){
        return pedidoRepositorio.findById(id)
                .map(pedidoMapper::toResponse)
                .orElseThrow(()->new RuntimeException("Pedido Não encontrado" +id));
    }

    public PedidoResponseDto update(
            PedidoRequestDto pedidoRequest,
            Integer id
    ){
        Pedido pedido = pedidoRepositorio.findById(id)
                .orElseThrow(()->new RuntimeException("Pedido não encontrado"));

        pedido.setData_pedido(pedidoRequest.data_pedido());

        Pedido pedidoUpdate = pedidoRepositorio.save(pedido);
        return pedidoMapper.toResponse(pedidoUpdate);
    }

    public void delete(
            Integer id
    ){
        if (!pedidoRepositorio.existsById(id)){
            throw new RuntimeException("Pedido não encontrado");
        }
        pedidoRepositorio.deleteById(id);
    }
}
