package com.dh.Entregable.controller;

import com.dh.Entregable.modelo.Paciente;
import com.dh.Entregable.servicio.IPacienteServicio;
import com.dh.Entregable.servicio.impl.PacienteServicioImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
    private IPacienteServicio pacienteServicio;

    public PacienteController() {
        this.pacienteServicio = new PacienteServicioImpl();
    }

    @GetMapping("/id")
    public String buscarPacientePorId(Model model, @RequestParam Integer id){
        Paciente paciente = pacienteServicio.buscarPorId(id);
        model.addAttribute("nombre", paciente.getNombre());
        model.addAttribute("apellido",paciente.getApellido());
        return "buscarPaciente";
    }

}
