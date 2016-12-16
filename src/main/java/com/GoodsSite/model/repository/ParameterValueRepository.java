package com.GoodsSite.model.repository;

import com.GoodsSite.model.entity.ParameterValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ParameterValueRepository extends JpaRepository<ParameterValue, Long> {
    @Query("select pvalue from ParameterValue pvalue where pvalue.parameterValueValue = ?1")
    ParameterValue findByValue(String name);
}
