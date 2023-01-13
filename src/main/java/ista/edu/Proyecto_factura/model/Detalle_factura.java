/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ista.edu.Proyecto_factura.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Usuario
 */
@Entity
@Getter
@Setter
public class Detalle_factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Integer id_detalle;
    @Column(name = "numero_factura")
    private Integer numero_factura;
    
    @Column(name = "cantidad")
    private Integer cantidad;
    
    //RELACIONES TABLAS
    //REALCIONES 
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="id_producto", referencedColumnName = "id_producto")
    private Producto producto;
    
    //REALCIONES 
    @ManyToOne
    @JoinColumn(name="id_factura", referencedColumnName = "id_factura")
    private Factura factura;

}
