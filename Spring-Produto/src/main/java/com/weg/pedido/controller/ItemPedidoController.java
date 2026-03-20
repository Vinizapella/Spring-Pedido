package com.weg.pedido.controller;

import com.weg.pedido.dto.request.ItemPedidoRequestDto;
import com.weg.pedido.dto.response.ItemPedidoResponseDto;
import com.weg.pedido.service.ItemPedidoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;

    public ItemPedidoController(
            ItemPedidoService itemPedidoService
    ){
        this.itemPedidoService = itemPedidoService;
    }

    @PostMapping
    public ItemPedidoResponseDto salvar(
            @RequestBody @Valid ItemPedidoRequestDto itemPedidoRequestDto
    ){
        return itemPedidoService.save(itemPedidoRequestDto);
    }

    @GetMapping
    public List<ItemPedidoResponseDto> pedidos(){
        return itemPedidoService.list();
    }

    @GetMapping("/{id}")
    public ItemPedidoResponseDto searchOne (
            @PathVariable Integer id
    ){
        return itemPedidoService.searchOne(null, id);
    }

    @PutMapping("/{id}")
    public ItemPedidoResponseDto update(
            @RequestBody @Valid ItemPedidoRequestDto itemPedidoRequestDto,
            @PathVariable Integer id
    ){
        return itemPedidoService.update(itemPedidoRequestDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Integer id
    ){
        itemPedidoService.delete(id);
    }


}
