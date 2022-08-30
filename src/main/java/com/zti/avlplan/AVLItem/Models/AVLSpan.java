package com.zti.avlplan.AVLItem.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AVLSpan {
    @Id
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
    private LocalDateTime timeFrom;
    private LocalDateTime timeTo;
    private Integer availabilityType;

    public AVLSpan(LocalDateTime timeFrom, LocalDateTime timeTo, Integer availabilityType) {
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.availabilityType = availabilityType;
    }

    public AVLSpan() {
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(LocalDateTime timeFrom) {
        this.timeFrom = timeFrom;
    }

    public LocalDateTime getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(LocalDateTime timeTo) {
        this.timeTo = timeTo;
    }

    public Integer getAvailabilityType() {
        return availabilityType;
    }

    public void setAvailabilityType(Integer availabilityType) {
        this.availabilityType = availabilityType;
    }

    @Override
    public String toString() {
        return "AVLSpan{" +
                "id='" + id + '\'' +
                ", timeFrom=" + timeFrom +
                ", timeTo=" + timeTo +
                ", availabilityType=" + availabilityType +
                '}';
    }
}
