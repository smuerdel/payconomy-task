package com.apitask.task.repositories;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface AbstractRepository<T, ID extends Serializable> extends Repository<T, ID> {

    void delete(T entity);

    List<T> findAll();

    Optional<T> findById(ID id);

    T save(T entity);
}
