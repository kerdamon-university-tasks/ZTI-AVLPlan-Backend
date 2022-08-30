package com.zti.avlplan.AVLItem;

import com.zti.avlplan.AVLItem.Models.AVLTimeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/timeline")
    public void postTimeline(@RequestBody AVLTimeline avlTimeline){
        avlItemService.addNewAvlTimeline(avlTimeline);
    }
}
