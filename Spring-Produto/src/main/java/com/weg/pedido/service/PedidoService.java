package com.weg.pedido.service;

import com.weg.pedido.dto.request.PedidoRequestDto;
import com.weg.pedido.dto.response.PedidoResponseDto;
import com.weg.pedido.mapper.PedidoMapper;
import com.weg.pedido.model.Cliente;
import com.weg.pedido.model.Pedido;
import com.weg.pedido.repositorio.ClienteRepositorio;
import com.weg.pedido.repositorio.PedidoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepositorio pedidoRepositorio;

    private final PedidoMapper pedidoMapper;

    private final ClienteRepositorio clienteRepositorio;


    public PedidoService(
            PedidoRepositorio pedidoRepositorio,
            PedidoMapper pedidoMapper,
            ClienteRepositorio clienteRepositorio
    ) {
        this.pedidoRepositorio = pedidoRepositorio;
        this.pedidoMapper = pedidoMapper;
        this.clienteRepositorio = clienteRepositorio;
    }

    public PedidoResponseDto criarPedido(
            PedidoRequestDto pedidoRequestDto
    ){
        Cliente cliente = clienteRepositorio.findById(pedidoRequestDto.clienteId())
                .orElseThrow(()->new RuntimeException("Cliente Não encontrado"));

        Pedido pedido = pedidoMapper.toEntity(pedidoRequestDto);

        pedidoRepositorio.save(pedido);

        return pedidoMapper.toResponse(pedido);
    }

    public List<PedidoResponseDto>listAll(){
        return pedidoRepositorio.findAll()
                .stream()
                .map(pedidoMapper::toResponse)
                .toList();
    }

    public PedidoResponseDto buscaId(
            Long id
    ){
        Pedido pedido = pedidoRepositorio.findById(id)
                .orElseThrow(()->new RuntimeException("Pedido não encontrado"));

        return pedidoMapper.toResponse(pedido);
    }

    public PedidoResponseDto buscaDescricao(
            PedidoRequestDto pedidoRequestDto,
            Long id
    ){
        Pedido pedido = pedidoRepositorio.findByIdAndDescricao(pedidoRequestDto.descricao(), id);

        if (pedido == null){
            throw new RuntimeException("Pedido não encontrado");
        }

        return pedidoMapper.toResponse(pedido);
    }

    public List<PedidoResponseDto> buscaClienteId(
            Long clienteId
    ){
        Cliente cliente = clienteRepositorio.findById(clienteId)
                .orElseThrow(()->new RuntimeException("Cliente não encontrado"));

        return pedidoRepositorio.findByClienteId(clienteId)
                .stream()
                .map(pedidoMapper::toResponse)
                .toList();
    }

    public PedidoResponseDto atualiza(
            Long id,
            PedidoRequestDto request
    ){

        Pedido pedido = pedidoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));


        pedidoRepositorio.save(pedido);

        return pedidoMapper.toResponse(pedido);
    }

    public void deleta(
            Long id)
    {

        Pedido pedido = pedidoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        pedidoRepositorio.delete(pedido);
    }
}
