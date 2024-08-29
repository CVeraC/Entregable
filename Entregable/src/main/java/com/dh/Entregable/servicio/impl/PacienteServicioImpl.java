package com.dh.Entregable.servicio.impl;

import com.dh.Entregable.dao.IDao;
import com.dh.Entregable.dao.impl.ImplementacionPaciente;
import com.dh.Entregable.modelo.Paciente;
import com.dh.Entregable.servicio.IPacienteServicio;

import java.util.List;

public class PacienteServicioImpl implements IPacienteServicio {
    private IDao<Paciente> interfazDao;


    public PacienteServicioImpl() {
        this.interfazDao = new ImplementacionPaciente();
    }

    public Paciente guardar(Paciente paciente) {
        return interfazDao.guardar(paciente);
    }
    public void eliminar(Integer id){
        interfazDao.eliminarPorId(id);
    }
    public List<Paciente> listarTodos(){
        return interfazDao.listarTodos();
    }
    public Paciente buscarPorId(Integer id){
        return interfazDao.consultarPorId(id);
    }
    public Paciente actualizar(Paciente paciente){
        return interfazDao.actualizar(paciente);
    }
}
