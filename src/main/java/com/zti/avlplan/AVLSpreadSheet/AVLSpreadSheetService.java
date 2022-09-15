package com.zti.avlplan.AVLSpreadSheet;

import com.zti.avlplan.AVLSpreadSheet.Exceptions.SpreadSheetNotFoundException;
import com.zti.avlplan.AVLSpreadSheet.Models.AVLSpreadSheetDTO;
import com.zti.avlplan.AVLTimeline.Exceptions.TimelineNotFoundException;
import com.zti.avlplan.AVLTimeline.Models.AVLTimeline;
import com.zti.avlplan.AVLTimeline.Repositories.AVLTimelineRepository;
import com.zti.avlplan.AVLSpreadSheet.Models.AVLSpreadSheet;
import com.zti.avlplan.AVLSpreadSheet.Repositories.AVLSpreadSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AVLSpreadSheetService {
    final private AVLSpreadSheetRepository avlSpreadSheetRepository;
    final private AVLTimelineRepository avlTimelineRepository;

    @Autowired
    public AVLSpreadSheetService(AVLSpreadSheetRepository avlSpreadSheetRepository, AVLTimelineRepository avlTimelineRepository) {
        this.avlSpreadSheetRepository = avlSpreadSheetRepository;
        this.avlTimelineRepository = avlTimelineRepository;
    }

    public List<AVLSpreadSheet> getAVLSpreadSheets(){
        return avlSpreadSheetRepository.findAll();
    }

    public Optional<AVLSpreadSheet> getSpreadSheetByID(String id){
        return avlSpreadSheetRepository.findById(id);
    }

    public String addNewAvlSpreadSheet(AVLSpreadSheetDTO avlSpreadSheetDTO) {
        List<AVLTimeline> avlTimelines = new ArrayList<>();
        var avlSpreadSheet = new AVLSpreadSheet(avlTimelines, avlSpreadSheetDTO.getEventName(), avlSpreadSheetDTO.getDateTimeFrom(), avlSpreadSheetDTO.getDateTimeTo());
        var createdAVLSpreadSheet = avlSpreadSheetRepository.save(avlSpreadSheet);
        return createdAVLSpreadSheet.getId();
    }

    public void addTimelineToSpreadSheet(String id, AVLTimeline avlTimeline) {
        var result = avlSpreadSheetRepository.findById(id);
        if(result.isEmpty())
            throw new SpreadSheetNotFoundException();
        var spreadSheet = result.get();
        var returned = avlTimelineRepository.save(avlTimeline);
        spreadSheet.getAVLTimelines().add(returned);
        avlSpreadSheetRepository.save(spreadSheet);
    }
}
