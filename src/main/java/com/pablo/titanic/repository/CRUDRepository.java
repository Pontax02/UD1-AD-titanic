package com.pablo.titanic.repository;

import java.util.List;

public interface CRUDRepository <T,ID>{

     List<T> getAll();

     T getById(ID id);

     T save(T persona);

     T update(ID id, T persona);

     T delete(ID id);
}
