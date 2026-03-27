package com.weg.pedido.service;

import com.weg.pedido.dto.request.ClienteRequestDto;
import com.weg.pedido.dto.response.ClienteResponseDto;
import com.weg.pedido.mapper.ClienteMapper;
import com.weg.pedido.model.Cliente;
import com.weg.pedido.repositorio.ClienteRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepositorio clienteRepositorio;

    private final ClienteMapper clienteMapper;

    public ClienteService(
            ClienteRepositorio clienteRepositorio,
            ClienteMapper clienteMapper
    ) {
        this.clienteRepositorio = clienteRepositorio;
        this.clienteMapper = clienteMapper;
    }

    public ClienteResponseDto criarCliente(
            ClienteRequestDto clienteRequestDto
    ){
        Cliente cliente = clienteMapper.toEntity(clienteRequestDto);

        clienteRepositorio.save(cliente);

        return clienteMapper.toResponde(cliente);
    }

    public List<ClienteResponseDto> listAll(){
        return clienteRepositorio.findAll()
                .stream()
                .map(clienteMapper::toResponde)
                .toList();
    }

    public ClienteResponseDto buscaCliente(
            Long id
    ){
        Cliente cliente = clienteRepositorio.findById(id)
                .orElseThrow(()->new RuntimeException("Cliente não econtrado"));
        return  clienteMapper.toResponde(cliente);
    }

    public ClienteResponseDto buscaNome(
            String nome
    ){
        Cliente cliente = clienteRepositorio.findByIdClienteNome(nome);

        if (cliente == null){
            throw new RuntimeException("Cliente não encontrado");
        }

        return clienteMapper.toResponde(cliente);
    }

    public ClienteResponseDto update(
            ClienteRequestDto clienteRequestDto,
            Long id
    ){
        Cliente cliente = clienteRepositorio.findById(id)
                .orElseThrow(()->new RuntimeException("Cliente não encontrado"));

        cliente.setNome(clienteRequestDto.nome());
        cliente.setEmail(clienteRequestDto.email());

        clienteRepositorio.save(cliente);

        return clienteMapper.toResponde(cliente);
    }

    public void delete(
            Long id
    ){
        Cliente cliente = clienteRepositorio.findById(id)
                .orElseThrow(()-> new RuntimeException("Cliente não encontrado"));

        clienteRepositorio.delete(cliente);
    }
}
