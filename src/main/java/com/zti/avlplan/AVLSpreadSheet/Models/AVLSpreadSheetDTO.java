package com.zti.avlplan.AVLSpreadSheet.Models;

import com.zti.avlplan.AVLTimeline.Models.AVLTimeline;

import java.util.List;

public class AVLSpreadSheetDTO {
    private List<String> AVLTimelineIds;
    private String eventName;

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
