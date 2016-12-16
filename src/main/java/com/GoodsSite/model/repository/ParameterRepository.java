package com.GoodsSite.model.repository;

import com.GoodsSite.model.entity.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ParameterRepository  extends JpaRepository<Parameter, Long> {
    @Query("select name from Parameter name where name.parameterName = ?1")
    Parameter findByName(String name);
}
