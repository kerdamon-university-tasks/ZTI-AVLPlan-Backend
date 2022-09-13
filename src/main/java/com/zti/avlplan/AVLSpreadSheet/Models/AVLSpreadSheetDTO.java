package com.zti.avlplan.AVLSpreadSheet.Models;

import com.zti.avlplan.AVLTimeline.Models.AVLTimeline;

import java.time.LocalDateTime;
import java.util.List;

public class AVLSpreadSheetDTO {
    private List<String> AVLTimelineIds;
    private String eventName;
    private LocalDateTime dateTimeFrom;
    private LocalDateTime dateTimeTo;

    public AVLSpreadSheetDTO(List<String> AVLTimelineIds, String eventName, LocalDateTime dateTimeFrom, LocalDateTime dateTimeTo) {
        this.AVLTimelineIds = AVLTimelineIds;
        this.eventName = eventName;
        this.dateTimeFrom = dateTimeFrom;
        this.dateTimeTo = dateTimeTo;
    }

    public AVLSpreadSheetDTO() {
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

    public List<String> getAVLTimelineIds() {
        return AVLTimelineIds;
    }

    public void setAVLTimelineIds(List<String> AVLTimelineIds) {
        this.AVLTimelineIds = AVLTimelineIds;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
