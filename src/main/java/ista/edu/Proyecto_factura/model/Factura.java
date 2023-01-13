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
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Usuario
 */
@Entity
@Getter
@Setter
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_factura")
    private Integer id_factura;
    @Column(name="fecha")
    private Date fecha;
    
    //REALCIONES 
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;
    
    //RELACIONES DETALLE
    //Relaciones
    @OneToMany (mappedBy = "factura")
    private List<Detalle_factura> det_factura;
}
