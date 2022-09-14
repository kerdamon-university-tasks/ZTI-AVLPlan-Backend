package com.zti.avlplan.AVLTimeline.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;

public class AVLSpan {
    @Id
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
    private AVLTimelineCoordinates timeFrom;
    private AVLTimelineCoordinates timeTo;

    public AVLSpan(AVLTimelineCoordinates timeFrom, AVLTimelineCoordinates timeTo) {
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
    }

    public AVLSpan() {
    }

    public String getId() {
        return id;
    }

    public AVLTimelineCoordinates getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(AVLTimelineCoordinates timeFrom) {
        this.timeFrom = timeFrom;
    }

    public AVLTimelineCoordinates getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(AVLTimelineCoordinates timeTo) {
        this.timeTo = timeTo;
    }

    @Override
    public String toString() {
        return "AVLSpan{" +
                "id='" + id + '\'' +
                ", timeFrom=" + timeFrom +
                ", timeTo=" + timeTo +
                '}';
    }
}
