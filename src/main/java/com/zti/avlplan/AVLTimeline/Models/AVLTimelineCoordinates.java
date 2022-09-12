package com.zti.avlplan.AVLTimeline.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;

public class AVLTimelineCoordinates {
    @Id
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
    private Integer quarterIndex;
    private Integer day;

    public AVLTimelineCoordinates(Integer quarterIndex, Integer day) {
        this.quarterIndex = quarterIndex;
        this.day = day;
    }

    public AVLTimelineCoordinates() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getQuarterIndex() {
        return quarterIndex;
    }

    public void setQuarterIndex(Integer quarterIndex) {
        this.quarterIndex = quarterIndex;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}
