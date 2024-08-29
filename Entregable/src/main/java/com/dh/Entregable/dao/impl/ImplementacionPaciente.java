package com.dh.Entregable.dao.impl;

import com.dh.Entregable.dao.BD;
import com.dh.Entregable.dao.IDao;
import com.dh.Entregable.modelo.Paciente;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImplementacionPaciente implements IDao<Paciente> {
    private static final Logger LOGGER = Logger.getLogger(ImplementacionPaciente.class);

    @Override
    public Paciente guardar(Paciente paciente) {
        Connection connection = null;

        try {
            LOGGER.info("Estamos guardando un paciente");

            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO PACIENTES (" +
                            "NOMBRE, APELLIDO, DOMICILIO, DNI, FECHA_ALTA) VALUES" +
                            "(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS
            );

            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setString(3, paciente.getDomicilio());
            preparedStatement.setString(4, paciente.getDni());
            preparedStatement.setDate(5, Date.valueOf(paciente.getFechaAlta()));


            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            while (rs.next()) {
                paciente.setId(rs.getInt(1));
                System.out.println(("Se guardo el paciente con nombre" +
                        paciente.getNombre()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        LOGGER.info("Guardamos el paciente con nombre" + paciente.getNombre());
        return paciente;

    }

    @Override
    public List<Paciente> listarTodos() {
        Connection connection = null;

        List<Paciente> pacienteList = new ArrayList<>();
        Paciente paciente = null;

        try {
            connection = BD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECY * FROM PACIENTES"
            );

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                paciente = new Paciente(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getDate(6).toLocalDate());

                pacienteList.add(paciente);

                System.out.println(paciente.toString());
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return pacienteList;
        }



    @Override
    public Paciente consultarPorId(Integer id) {
        return null;
    }

    @Override
    public void eliminarPorId(Integer id) {

    }

    @Override
    public Paciente actualizar(Paciente paciente) {
        return null;
    }

}





