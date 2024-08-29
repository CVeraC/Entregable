package com.dh.Entregable.servicio.impl;

import com.dh.Entregable.dao.IDao;
import com.dh.Entregable.dao.impl.ImplementacionOdontologo;
import com.dh.Entregable.modelo.Odontologo;
import com.dh.Entregable.servicio.IOdontologoServicio;

import java.util.List;

public class OdontologoServicioImpl implements IOdontologoServicio {
    private  IDao<Odontologo> odontologoIDao;

    public OdontologoServicioImpl() {
        this.odontologoIDao = new ImplementacionOdontologo();
    }

    @Override
    public Odontologo guardar (Odontologo odontologo) {
       return odontologoIDao.guardar(odontologo);
    }

    @Override
    public Odontologo buscarPorId(Integer id){
        return  odontologoIDao.consultarPorId(id);
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(Odontologo odontologo) {

    }

    @Override
    public List<Odontologo> listarTodos() {
        return null;
    }
}
