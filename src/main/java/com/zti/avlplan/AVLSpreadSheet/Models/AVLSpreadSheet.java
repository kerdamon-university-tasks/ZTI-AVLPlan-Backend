package com.zti.avlplan.AVLSpreadSheet.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zti.avlplan.AVLTimeline.Models.AVLTimeline;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.List;

public class AVLSpreadSheet {
    @Id
//    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
    @DocumentReference
    private List<AVLTimeline> AVLTimelines;
    private String eventName;
    private LocalDateTime dateTimeFrom;
    private LocalDateTime dateTimeTo;

    public AVLSpreadSheet() {
    }

    public AVLSpreadSheet(List<AVLTimeline> AVLTimelines, String eventName, LocalDateTime dateTimeFrom, LocalDateTime dateTimeTo) {
        this.AVLTimelines = AVLTimelines;
        this.eventName = eventName;
        this.dateTimeFrom = dateTimeFrom;
        this.dateTimeTo = dateTimeTo;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDateTime getDateTimeFrom() {
        return dateTimeFrom;
    }

    public void setDateTimeFrom(LocalDateTime dateTimeFrom) {
        this.dateTimeFrom = dateTimeFrom;
    }

    public LocalDateTime getDateTimeTo() {
        return dateTimeTo;
    }

    public void setDateTimeTo(LocalDateTime dateTimeTo) {
        this.dateTimeTo = dateTimeTo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<AVLTimeline> getAVLTimelines() {
        return AVLTimelines;
    }

    public void setAVLTimelines(List<AVLTimeline> AVLTimelines) {
        this.AVLTimelines = AVLTimelines;
    }

    @Override
    public String toString() {
        return "AVLSpreadSheet{" +
                "id='" + id + '\'' +
                ", AVLTimelines=" + AVLTimelines +
                '}';
    }
}
