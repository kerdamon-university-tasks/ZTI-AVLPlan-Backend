package com.zti.avlplan.AVLTimeline.Models;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

public class AVLTimeline {
    @Id private String id;
    private List<AVLSpan> avlSpans;
    private String user;

    public AVLTimeline(List<AVLSpan> AVLSpans, String user) {
        this.avlSpans = AVLSpans;
        this.user = user;
    }

    public AVLTimeline() {
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
                ", user='" + user + '\'' +
                '}';
    }
}
