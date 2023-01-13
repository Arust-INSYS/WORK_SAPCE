/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ista.edu.Proyecto_factura.service;

import ista.edu.Proyecto_factura.model.Detalle_factura;
import ista.edu.Proyecto_factura.repository.DetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author 59398
 */
@Service
public class DetalleServiceImpl extends GenericServiceImpl<Detalle_factura, Integer> implements DetalleService {

    @Autowired
    DetalleRepository detalleRepository;

    @Override
    public CrudRepository<Detalle_factura, Integer> getDao() {
        return detalleRepository;
    }

}
