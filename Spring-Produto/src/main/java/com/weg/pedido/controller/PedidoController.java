package com.weg.pedido.controller;

import com.weg.pedido.dto.request.PedidoRequestDto;
import com.weg.pedido.dto.response.PedidoResponseDto;
import com.weg.pedido.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(
            PedidoService pedidoService
    ) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public PedidoResponseDto cria(
            @RequestBody @Valid PedidoRequestDto pedidoRequestDto
    ){
        return pedidoService.criarPedido(pedidoRequestDto);
    }

    @GetMapping
    public List<PedidoResponseDto> listAll(){
        return pedidoService.listAll();
    }

    @GetMapping("/{id}")
    public PedidoResponseDto buscaId(
            @PathVariable Long id
    ){
        return pedidoService.buscaId(id);
    }

    @GetMapping("/{id}/descricao")
    public PedidoResponseDto buscaDescricao(
            @RequestBody PedidoRequestDto pedidoRequestDto,
            @PathVariable Long id
    ){
        return pedidoService.buscaDescricao(pedidoRequestDto, id);
    }

    @GetMapping("/cliente/{clienteId}")
    public List<PedidoResponseDto> buscaClienteId(
            @PathVariable Long clienteId
    ){
        return pedidoService.buscaClienteId(clienteId);
    }

    @PutMapping("/{id}")
    public PedidoResponseDto atualiza(
            @PathVariable Long id,
            @RequestBody @Valid PedidoRequestDto pedidoRequestDto
    ){
        return pedidoService.atualiza(id, pedidoRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleta(
            @PathVariable Long id
    ){
        pedidoService.deleta(id);
    }
}
