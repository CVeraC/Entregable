package com.dh.Entregable.dao;

import java.util.List;

public interface IDao<T> {
    //CRUD

    //crear
    T guardar(T t);

    //consultar todos los T
    List<T> listarTodos();

    //consultar por id
    T consultarPorId(Integer id);

    //eliminar
    void eliminarPorId(Integer id);

    //actualizar
    T actualizar(T t);
}


