package com.zti.avlplan.AVLItem;

import com.zti.avlplan.AVLItem.Exceptions.TimelineNotFoundException;
import com.zti.avlplan.AVLItem.Models.AVLTimeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/v1/avlitem")
public class AVLItemController {
    private final AVLItemService avlItemService;

    @Autowired
    public AVLItemController(AVLItemService avlItemService) {
        this.avlItemService = avlItemService;
    }

    @GetMapping("/timelines")
    public List<AVLTimeline> getAVLTimelines(){
        return avlItemService.getAVLTimelines();
    }

    @GetMapping("/timeline/{id}")
    public Optional<AVLTimeline> getAVLTimelineById(@PathVariable String id){
        var timeline = avlItemService.getTimelineByID(id);
        if(timeline.isEmpty()){
            throw new TimelineNotFoundException();
        }
        return timeline;
    }

    @PostMapping("/timeline")
    public void postTimeline(@RequestBody AVLTimeline avlTimeline){
        avlItemService.addNewAvlTimeline(avlTimeline);
    }
}
