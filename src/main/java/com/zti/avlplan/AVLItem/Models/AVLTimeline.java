package com.zti.avlplan.AVLItem.Models;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

public class AVLTimeline {
    @Id private String id;
    private List<AVLSpan> avlSpans;
    private LocalDateTime dateTimeFrom;
    private LocalDateTime dateTimeTo;
    private String user;

    public AVLTimeline(List<AVLSpan> AVLSpans, LocalDateTime dateTimeFrom, LocalDateTime dateTimeTo, String user) {
        this.avlSpans = AVLSpans;
        this.dateTimeFrom = dateTimeFrom;
        this.dateTimeTo = dateTimeTo;
        this.user = user;
    }

    public AVLTimeline() {
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

    public List<AVLSpan> getAVLSpans() {
        return avlSpans;
    }

    public void setAVLSpans(List<AVLSpan> AVLSpans) {
        this.avlSpans = AVLSpans;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "AVLTimeline{" +
                "id='" + id + '\'' +
                ", AVLSpans=" + avlSpans +
                ", dateFrom=" + dateTimeFrom +
                ", dateTo=" + dateTimeTo +
                ", user='" + user + '\'' +
                '}';
    }
}
