package com.weg.pedido.controller;

import com.weg.pedido.dto.request.ClienteRequestDto;
import com.weg.pedido.dto.response.ClienteResponseDto;
import com.weg.pedido.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(
            ClienteService clienteService
    ) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ClienteResponseDto cria(
            @RequestBody ClienteRequestDto clienteRequestDto
    ){
        return clienteService.criarCliente(clienteRequestDto);
    }

    @GetMapping
    public List<ClienteResponseDto>listAll(){
        return clienteService.listAll();
    }

    @GetMapping("/{id}")
    public ClienteResponseDto buscaId(
            @PathVariable @Valid Long id
    ){
        return clienteService.buscaCliente(id);
    }

    @GetMapping("/nome/{nome}")
    public ClienteResponseDto buscaNome(
            @PathVariable @Valid String nome
    ){
        return clienteService.buscaNome(nome);
    }

    @PutMapping("/{id}")
    public ClienteResponseDto atualiza(
            @RequestBody ClienteRequestDto clienteRequestDto,
            @PathVariable @Valid Long id
    ){
        return clienteService.update(clienteRequestDto, id);
    }

    @DeleteMapping("/{id}")
    void delete(
            @PathVariable @Valid Long id
    ){
        clienteService.delete(id);
    }

}
