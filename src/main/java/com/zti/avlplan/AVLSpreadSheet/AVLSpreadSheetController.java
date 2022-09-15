package com.zti.avlplan.AVLSpreadSheet;

import com.zti.avlplan.AVLSpreadSheet.Models.AVLSpreadSheet;
import com.zti.avlplan.AVLSpreadSheet.Exceptions.SpreadSheetNotFoundException;
import com.zti.avlplan.AVLSpreadSheet.Models.AVLSpreadSheetDTO;
import com.zti.avlplan.AVLTimeline.Models.AVLTimeline;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/v1/avlitem")
@Slf4j
public class AVLSpreadSheetController {
    private final AVLSpreadSheetService avlSpreadSheetService;

    @Autowired
    public AVLSpreadSheetController(AVLSpreadSheetService avlSpreadSheetService) {
        this.avlSpreadSheetService = avlSpreadSheetService;
    }

    @GetMapping("/spreadsheets")
    public List<AVLSpreadSheet> getAVLSpreadSheets(){
        return avlSpreadSheetService.getAVLSpreadSheets();
    }

    @GetMapping("/spreadsheet/{id}")
    public AVLSpreadSheet getAVLSpreadSheetById(@PathVariable String id){
        log.info("sending spreadshhet {}", id);
        return avlSpreadSheetService.getSpreadSheetByID(id);
    }

    @PostMapping("/spreadsheet")
    public String postSpreadSheet(@RequestBody AVLSpreadSheetDTO avlSpreadSheetDTO){
        return avlSpreadSheetService.addNewAvlSpreadSheet(avlSpreadSheetDTO);
    }

    @PostMapping("/spreadsheet/{id}/timeline")
    public void patchSpreadSheet(@PathVariable String id, @RequestBody AVLTimeline avlTimeline){
        avlSpreadSheetService.addTimelineToSpreadSheet(id, avlTimeline);
    }
}
