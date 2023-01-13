/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ista.edu.Proyecto_factura.service;

import ista.edu.Proyecto_factura.model.Cliente;
import ista.edu.Proyecto_factura.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author 59398
 */
@Service
public class ClienteServiceImpl extends GenericServiceImpl<Cliente, Integer> implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public CrudRepository<Cliente, Integer> getDao() {
        return clienteRepository;
    }

    public Cliente buscarCliente(String cedula) {
        return clienteRepository.buscarCliente(cedula);
    }

}
