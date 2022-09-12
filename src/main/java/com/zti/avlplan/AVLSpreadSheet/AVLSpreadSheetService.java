package com.zti.avlplan.AVLSpreadSheet;

import com.zti.avlplan.AVLItem.Models.AVLTimeline;
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

    @Autowired
    public AVLSpreadSheetService(AVLSpreadSheetRepository avlSpreadSheetRepository) {
        this.avlSpreadSheetRepository = avlSpreadSheetRepository;
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
}
