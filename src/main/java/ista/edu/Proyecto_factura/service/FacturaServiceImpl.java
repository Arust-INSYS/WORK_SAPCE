/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ista.edu.Proyecto_factura.service;

import ista.edu.Proyecto_factura.model.Factura;
import ista.edu.Proyecto_factura.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author 59398
 */
@Service
public class FacturaServiceImpl extends GenericServiceImpl<Factura, Integer> implements FacturaService {

    @Autowired
    FacturaRepository facturaRepository;

    @Override
    public CrudRepository<Factura, Integer> getDao() {
        return facturaRepository;
    }

}
