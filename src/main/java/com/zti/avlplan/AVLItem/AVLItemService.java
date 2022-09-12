package com.zti.avlplan.AVLItem;

import com.zti.avlplan.AVLItem.Models.AVLTimeline;
import com.zti.avlplan.AVLItem.Repositories.AVLTimelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AVLItemService {
    final private AVLTimelineRepository avlTimelineRepository;

    @Autowired
    public AVLItemService(AVLTimelineRepository avlTimelineRepository) {
        this.avlTimelineRepository = avlTimelineRepository;
    }

    public List<AVLTimeline> getAVLTimelines(){
        return avlTimelineRepository.findAll();
    }

    public Optional<AVLTimeline> getTimelineByID(String id){
        return avlTimelineRepository.findById(id);
    }

    public void addNewAvlTimeline(AVLTimeline avlTimeline) {
        avlTimelineRepository.save(avlTimeline);
    }
}
