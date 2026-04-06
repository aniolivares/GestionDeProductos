package com.example.GestiondeProductos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class Producto {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private int precio;
    private String categoria;

}
