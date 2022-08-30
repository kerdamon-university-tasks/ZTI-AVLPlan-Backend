package com.zti.avlplan.AVLItem.Models;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AVLTimeline {
    @Id private String id;
    private List<AVLSpan> AVLSpans;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private LocalTime hourFrom;
    private LocalTime hourTo;
    private String user;

    public AVLTimeline(List<AVLSpan> AVLSpans, LocalDate dateFrom, LocalDate dateTo, LocalTime hourFrom, LocalTime hourTo, String user) {
        this.AVLSpans = AVLSpans;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.hourFrom = hourFrom;
        this.hourTo = hourTo;
        this.user = user;
    }

    public AVLTimeline() {
    }

    public LocalTime getHourFrom() {
        return hourFrom;
    }

    public void setHourFrom(LocalTime hourFrom) {
        this.hourFrom = hourFrom;
    }

    public LocalTime getHourTo() {
        return hourTo;
    }

    public void setHourTo(LocalTime hourTo) {
        this.hourTo = hourTo;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public String getId() {
        return id;
    }

    public List<AVLSpan> getAVLSpans() {
        return AVLSpans;
    }

    public void setAVLSpans(List<AVLSpan> AVLSpans) {
        this.AVLSpans = AVLSpans;
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
                ", AVLSpans=" + AVLSpans +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", hourFrom=" + hourFrom +
                ", hourTo=" + hourTo +
                ", user='" + user + '\'' +
                '}';
    }
}
