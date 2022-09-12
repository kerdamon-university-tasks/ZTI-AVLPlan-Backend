package com.zti.avlplan.AVLSpreadSheet;

import com.zti.avlplan.AVLItem.Repositories.AVLTimelineRepository;
import com.zti.avlplan.AVLSpreadSheet.Models.AVLSpreadSheet;
import com.zti.avlplan.AVLSpreadSheet.Repositories.AVLSpreadSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void addNewAvlSpreadSheet(AVLSpreadSheet avlSpreadSheet) {
        avlSpreadSheetRepository.save(avlSpreadSheet);
    }

    public void generateNewAvlSpreadSheet() {
        var avlTimelines = List.of(avlTimelineRepository.findById("631ea77bf6dc7f112c58a891").get(), avlTimelineRepository.findById("631ea885f6dc7f112c58a893").get());
        var avlSpreadSheet = new AVLSpreadSheet(avlTimelines);
        avlSpreadSheetRepository.save(avlSpreadSheet);
    }
}
