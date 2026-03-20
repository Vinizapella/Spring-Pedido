package com.weg.pedido.controller;

import com.weg.pedido.dto.request.PedidoRequestDto;
import com.weg.pedido.dto.response.PedidoResponseDto;
import com.weg.pedido.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pedido")
@RestController
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(
            PedidoService pedidoService
    ){
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public PedidoResponseDto salve(
            @RequestBody @Valid PedidoRequestDto pedidoRequest
    ){
        return pedidoService.salve(pedidoRequest);
    }

    @GetMapping
    public List<PedidoResponseDto> all(){
        return pedidoService.all();
    }

    @GetMapping("/{id}")
    public PedidoResponseDto findById(
            @PathVariable Integer id
    ){
        return pedidoService.findbyId(id);
    }

    @PutMapping("/{id}")
    public PedidoResponseDto update(
            @RequestBody @Valid PedidoRequestDto pedidoRequest,
            @PathVariable Integer id
    ){
        return pedidoService.update(pedidoRequest, id);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Integer id
    ){
        pedidoService.delete(id);
    }
}
