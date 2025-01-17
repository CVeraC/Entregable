package com.dh.Entregable.controller;

import com.dh.Entregable.modelo.Odontologo;
import com.dh.Entregable.servicio.IOdontologoServicio;
import com.dh.Entregable.servicio.impl.OdontologoServicioImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/odontologo")
public class OdontologoController {
    private IOdontologoServicio odontologoServicio;

    public OdontologoController() {
        this.odontologoServicio = new OdontologoServicioImpl();
    }

    @GetMapping("/id")
    public String buscarOdontologoPorId(Model model,
                                        @RequestParam Integer id){
    Odontologo odontologo = odontologoServicio.buscarPorId(id);
    model.addAttribute("nombre", odontologo.getNombre());
    model.addAttribute("apellido", odontologo.getApellido());
    return "buscarOdontologo";
    }
}
