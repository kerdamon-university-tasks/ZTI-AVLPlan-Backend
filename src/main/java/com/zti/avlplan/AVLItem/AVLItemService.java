package com.zti.avlplan.AVLItem;

import com.zti.avlplan.AVLItem.Models.AVLSpan;
import com.zti.avlplan.AVLItem.Models.AVLTimeline;
import com.zti.avlplan.AVLItem.Repositories.AVLTimelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

@Service
public class AVLItemService {
    private AVLTimelineRepository avlTimelineRepository;

    @Autowired
    public AVLItemService(AVLTimelineRepository avlTimelineRepository) {
        this.avlTimelineRepository = avlTimelineRepository;
    }

    public List<AVLTimeline> getAVLTimelines(){
        return avlTimelineRepository.findAll();
    }

    public String createAVLTimeline(){
        avlTimelineRepository.save(new AVLTimeline(
                List.of(new AVLSpan(
                        LocalDateTime.of(2022, Month.APRIL, 5, 15, 30),
                        LocalDateTime.of(2022, Month.APRIL, 6, 16, 30),
                        1
                )),
                LocalDate.of(2022, Month.APRIL, 1),
                LocalDate.of(2022, Month.APRIL, 10),
                LocalTime.of(5, 30),
                LocalTime.of(20, 30),
                "Marian Paździoch"
        ));
        return "Zbudowaliśmy go";
    }

    public void addNewAvlTimeline(AVLTimeline avlTimeline) {
        System.out.println(avlTimeline);
    }
}
