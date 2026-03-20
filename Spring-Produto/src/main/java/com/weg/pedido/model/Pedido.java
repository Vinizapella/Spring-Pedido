package com.weg.pedido.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Pedido")
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Date data_pedido;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens;

    public Pedido(Date data_pedido) {
        this.data_pedido = data_pedido;
    }
}
