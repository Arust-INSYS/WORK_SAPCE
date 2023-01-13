/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ista.edu.Proyecto_factura.controller;

import ista.edu.Proyecto_factura.model.*;
import ista.edu.Proyecto_factura.service.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 59398
 */
@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;
    

    @GetMapping("/listar")
    public ResponseEntity< List<Cliente>> obtenerLista() {
        return new ResponseEntity<>(clienteService.findByAll(), HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Cliente> crear(@RequestBody Cliente c){
     return new ResponseEntity<>(clienteService.save(c), HttpStatus.CREATED);
    }
    
      @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Cliente> eliminar(@PathVariable Integer id) {
        clienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Cliente> actualizarUsuario(@PathVariable Integer id, @RequestBody Cliente c) {
        Cliente cliente = clienteService.findById(id);
        if (cliente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                cliente.setNombre(c.getNombre());
                cliente.setApellido(c.getApellido());
                cliente.setCedula(c.getCedula());
                return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

    }
    
    //------------------------------------------------
    //METODOS DE FACTURA
    FacturaService facturaService;
    

    @GetMapping("/listar_factura")
    public ResponseEntity< List<Factura>> Lista_factura() {
        return new ResponseEntity<>(facturaService.findByAll(), HttpStatus.OK);
    }
    
    @PostMapping("/crear_factura")
    public ResponseEntity<Factura> crear_factura(@RequestBody Factura f){
     return new ResponseEntity<>(facturaService.save(f), HttpStatus.CREATED);
    }
    
      @DeleteMapping("/eliminar_factura/{id}")
    public ResponseEntity<Factura> eliminar_factura(@PathVariable Integer id) {
        facturaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar_factura/{id}")
    public ResponseEntity<Factura> actualizarUsuario(@PathVariable Integer id, @RequestBody Factura f) {
        Factura factura = facturaService.findById(id);
        if (factura == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                factura.setCliente(f.getCliente());
                factura.setFecha(f.getFecha());
                factura.setDet_factura(f.getDet_factura());
                return new ResponseEntity<>(facturaService.save(factura), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

    }
    //------------------------------------
    //METODOS DETALLE_FACTURA
    DetalleService detalleService;
    

    @GetMapping("/listar_factura")
    public ResponseEntity< List<Detalle_factura>> Lista_detalle() {
        return new ResponseEntity<>(detalleService.findByAll(), HttpStatus.OK);
    }
    
    @PostMapping("/crear_detalle")
    public ResponseEntity<Detalle_factura> crear_detalle(@RequestBody Detalle_factura d){
     return new ResponseEntity<>(detalleService.save(d), HttpStatus.CREATED);
    }
    
      @DeleteMapping("/eliminar_detalle/{id}")
    public ResponseEntity<Factura> eliminar_detalle(@PathVariable Integer id) {
        detalleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar_detalle/{id}")
    public ResponseEntity<Detalle_factura> actualizarUsuario(@PathVariable Integer id, @RequestBody Detalle_factura d) {
        Detalle_factura detalle = detalleService.findById(id);
        if (detalle == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                detalle.setCantidad(d.getCantidad());
                detalle.setFactura(d.getFactura());
                detalle.setNumero_factura(d.getNumero_factura());
                return new ResponseEntity<>(detalleService.save(detalle), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

    }
    //------------------------------------
    //METODOS PRODUCTO
    ProductoService productoService;
    

    @GetMapping("/listar_factura")
    public ResponseEntity< List<Producto>> Lista_producto() {
        return new ResponseEntity<>(productoService.findByAll(), HttpStatus.OK);
    }
    
    @PostMapping("/crear_producto")
    public ResponseEntity<Producto> crear_detalle(@RequestBody Producto p){
     return new ResponseEntity<>(productoService.save(p), HttpStatus.CREATED);
    }
    
      @DeleteMapping("/eliminar_producto/{id}")
    public ResponseEntity<Producto> eliminar_producto(@PathVariable Integer id) {
        productoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar_producto/{id}")
    public ResponseEntity<Producto> actualizarproducto(@PathVariable Integer id, @RequestBody Producto p) {
        Producto producto = productoService.findById(id);
        if (producto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                producto.setNombre(p.getNombre());
                return new ResponseEntity<>(productoService.save(producto), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

    }
    //CAMBIOS EN EL CÓDIGO
}
