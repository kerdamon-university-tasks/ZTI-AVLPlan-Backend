package com.zti.avlplan.AVLSpreadSheet;

import com.zti.avlplan.AVLSpreadSheet.Exceptions.DuplicateTimelinesException;
import com.zti.avlplan.AVLSpreadSheet.Exceptions.MissingTimelineException;
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
import java.util.Objects;
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

    public AVLSpreadSheet getSpreadSheetByID(String id){
        var spreadSheet = avlSpreadSheetRepository.findById(id);
        if(spreadSheet.isEmpty()){
            throw new SpreadSheetNotFoundException();
        }
        return spreadSheet.get();
    }

    public String addNewAvlSpreadSheet(AVLSpreadSheetDTO avlSpreadSheetDTO) {
        List<AVLTimeline> avlTimelines = new ArrayList<>();
        var avlSpreadSheet = new AVLSpreadSheet(avlTimelines, avlSpreadSheetDTO.getEventName(), avlSpreadSheetDTO.getDateTimeFrom(), avlSpreadSheetDTO.getDateTimeTo());
        var createdAVLSpreadSheet = avlSpreadSheetRepository.save(avlSpreadSheet);
        return createdAVLSpreadSheet.getId();
    }

    public void addTimelineToSpreadSheet(String id, String username, AVLTimeline avlTimeline) {
        var result = avlSpreadSheetRepository.findById(id);
        if(result.isEmpty())
            throw new SpreadSheetNotFoundException();
        var spreadSheet = result.get();
        if(spreadSheet.getAVLTimelines().stream().anyMatch(timeline -> Objects.equals(timeline.getUser(), username)))
            throw new DuplicateTimelinesException();
        var returned = avlTimelineRepository.save(avlTimeline);
        spreadSheet.getAVLTimelines().add(returned);
        avlSpreadSheetRepository.save(spreadSheet);
    }

    public void editTimelineInSpreadSheet(String id, String username, AVLTimeline newTimeline) {
        var result = avlSpreadSheetRepository.findById(id);
        if(result.isEmpty())
            throw new SpreadSheetNotFoundException();
        var spreadSheet = result.get();
        var otimeline = spreadSheet.getAVLTimelines().stream().filter(timeline -> Objects.equals(timeline.getUser(), username)).findFirst();
        if(otimeline.isEmpty())
            throw new MissingTimelineException();
        var timeline = otimeline.get();
        timeline.setAVLSpans(newTimeline.getAVLSpans());
        timeline.setUser(newTimeline.getUser());
        var returned = avlTimelineRepository.save(timeline);
        spreadSheet.getAVLTimelines().add(returned);
        avlSpreadSheetRepository.save(spreadSheet);
    }
}
