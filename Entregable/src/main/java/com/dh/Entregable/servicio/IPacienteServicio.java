package com.dh.Entregable.servicio;

import com.dh.Entregable.modelo.Paciente;

import java.util.List;

public interface IPacienteServicio {
   Paciente guardar(Paciente paciente);
    Paciente buscarPorId(Integer id);
    void eliminar(Integer id);
    Paciente actualizar(Paciente paciente);
    List<Paciente> listarTodos();

}
