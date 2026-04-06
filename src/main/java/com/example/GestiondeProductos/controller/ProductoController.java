package com.example.GestiondeProductos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GestiondeProductos.model.Producto;
import com.example.GestiondeProductos.service.ProductoService;

@RestController
@RequestMapping("/api/productos")

public class ProductoController {

    private final ProductoService productoService;

    public ProductoController (ProductoService productoService){
        this.productoService = productoService;
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto){
        return productoService.guardarProducto(producto);
    }


    @GetMapping
    public List<Producto> listarTodos(){
        return productoService.obtenerTodos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id){
        boolean eliminado = productoService.eliminarProducto(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
