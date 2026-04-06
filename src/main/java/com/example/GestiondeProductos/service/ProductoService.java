package com.example.GestiondeProductos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.GestiondeProductos.model.Producto;
import com.example.GestiondeProductos.repository.ProductoRepository;

@Service    

public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    /*CREAR */

    public Producto guardarProducto (Producto producto){
        return productoRepository.save(producto);
    }

    /*LISTAR */

    public List <Producto> obtenerTodos(){
        return productoRepository.findAll();
    }

    public boolean eliminarProducto (Long id){
        if (productoRepository.existsById(id)){
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
