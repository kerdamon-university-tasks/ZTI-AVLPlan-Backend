package com.zti.avlplan.AVLSpreadSheet;

import com.zti.avlplan.AVLSpreadSheet.Models.AVLSpreadSheet;
import com.zti.avlplan.AVLSpreadSheet.Exceptions.SpreadSheetNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/v1/avlitem")
public class AVLSpreadSheetController {
    private final AVLSpreadSheetService avlSpreadSheetService;

    @Autowired
    public AVLSpreadSheetController(AVLSpreadSheetService avlSpreadSheetService) {
        this.avlSpreadSheetService = avlSpreadSheetService;
    }

    @GetMapping("/spreadsheet")
    public List<AVLSpreadSheet> getAVLSpreadSheets(){
        return avlSpreadSheetService.getAVLSpreadSheets();
    }

    @GetMapping("/spreadsheet/{id}")
    public Optional<AVLSpreadSheet> getAVLSpreadSheetById(@PathVariable String id){
        var spreadSheet = avlSpreadSheetService.getSpreadSheetByID(id);
        if(spreadSheet.isEmpty()){
            throw new SpreadSheetNotFoundException();
        }
        return spreadSheet;
    }

    @PostMapping("/spreadsheet")
    public void postSpreadSheet(@RequestBody AVLSpreadSheet avlSpreadSheet){
        avlSpreadSheetService.addNewAvlSpreadSheet(avlSpreadSheet);
    }

}
