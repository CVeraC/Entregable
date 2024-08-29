package com.dh.Entregable.dao.impl;

import com.dh.Entregable.dao.BD;
import com.dh.Entregable.dao.IDao;
import com.dh.Entregable.modelo.Odontologo;
import org.apache.log4j.Logger;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImplementacionOdontologo implements IDao<Odontologo> {
    private static final Logger LOGGER = Logger.getLogger(ImplementacionPaciente.class);

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;

        try {
            LOGGER.info("Estamos Guardando un odontologo");

            connection = BD.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO ODONTOLOGOS (" +
                            "NOMBRE, APELLIDO, NUMEROMATRICULA) VALUES " +
                            "(?,?,?)", Statement.RETURN_GENERATED_KEYS
            );


            preparedStatement.setString(1, odontologo.getNombre());
            preparedStatement.setString(2, odontologo.getApellido());
            preparedStatement.setString(3, odontologo.getNumeroMatricula());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();

            while (rs.next()) {
                odontologo.setId(rs.getInt(1));
                System.out.println("Se guardo el odontologo con nombre" +
                        odontologo.getNombre());
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
        LOGGER.info("Guardamos el odontologo con nombre" + odontologo.getNombre());
        return odontologo;

    }

    @Override
    public List<Odontologo> listarTodos() {
        Connection connection = null;

        List<Odontologo> odontologoList = new ArrayList<>();
        Odontologo odontologo = null;

        try {
            connection = BD.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM ODONTOLOGOS"
            );

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                odontologo = new Odontologo(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4)
                );

                odontologoList.add(odontologo);

                System.out.println(odontologo.toString());
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
        return odontologoList;
    }

    @Override
    public Odontologo consultarPorId(Integer id) {
        Connection connection = null;
        Odontologo odontologo = null;

        try {
            connection = BD.getConnection();
            PreparedStatement psBuscarPorId = connection.prepareStatement(
                    "SELECT * FROM ODONTOLOGOS WHERE ID=?"
            );
            psBuscarPorId.setInt(1, id);
            ResultSet rs = psBuscarPorId.executeQuery();

            while (rs.next()) {
                odontologo = new Odontologo();
                odontologo.setId(rs.getInt(1));
                odontologo.setNombre(rs.getString(2));
                odontologo.setApellido(rs.getString(3));
                odontologo.setNumeroMatricula(rs.getString(4));
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

        return odontologo;

    }

    @Override
    public void eliminarPorId(Integer id) {

    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        return null;
    }
}








