package com.example.kapture_assignment.modal;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public interface ResultEntity {
    Integer getHour();

    String getDay();

    Integer getWeek();

    Integer getMonth();

    Integer getYear();

}