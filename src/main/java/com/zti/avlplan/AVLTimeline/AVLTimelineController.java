package com.zti.avlplan.AVLTimeline;

import com.zti.avlplan.AVLTimeline.Exceptions.TimelineNotFoundException;
import com.zti.avlplan.AVLTimeline.Models.AVLTimeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/v1/avlitem")
public class AVLTimelineController {
    private final AVLTimelineService avlTimelineService;

    @Autowired
    public AVLTimelineController(AVLTimelineService avlTimelineService) {
        this.avlTimelineService = avlTimelineService;
    }

    @GetMapping("/timelines")
    public List<AVLTimeline> getAVLTimelines(){
        return avlTimelineService.getAVLTimelines();
    }

    @GetMapping("/timeline/{id}")
    public Optional<AVLTimeline> getAVLTimelineById(@PathVariable String id){
        var timeline = avlTimelineService.getTimelineByID(id);
        if(timeline.isEmpty()){
            throw new TimelineNotFoundException();
        }
        return timeline;
    }
}
