package com.GoodsSite.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "parameter_value")
public class ParameterValue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "parameter_value_id")
    private Long parameterValueId;

    @Column(name = "parameter_value_value")
    private String parameterValueValue;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "value")
    private Set<Parameter> parameters;

    public Long getParameterValueId() {
        return parameterValueId;
    }

    public void setParameterValueId(Long parameterValueId) {
        this.parameterValueId = parameterValueId;
    }

    public String getParameterValueValue() {
        return parameterValueValue;
    }

    public void setParameterValueValue(String parameterValueValue) {
        this.parameterValueValue = parameterValueValue;
    }

    public Set<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(Set<Parameter> parameters) {
        this.parameters = parameters;
    }
}
