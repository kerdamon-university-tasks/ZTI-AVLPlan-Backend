package com.zti.avlplan.AVLSpreadSheet;

import com.zti.avlplan.AVLSpreadSheet.Models.AVLSpreadSheet;
import com.zti.avlplan.AVLSpreadSheet.Exceptions.SpreadSheetNotFoundException;
import com.zti.avlplan.AVLSpreadSheet.Models.AVLSpreadSheetDTO;
import com.zti.avlplan.AVLTimeline.Models.AVLTimeline;
import com.zti.avlplan.Authentication.AuthenticationService;
import com.zti.avlplan.Authentication.Exceptions.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/v1/avlitem")
@Slf4j
@RequiredArgsConstructor
public class AVLSpreadSheetController {
    private final AVLSpreadSheetService avlSpreadSheetService;
    private final AuthenticationService authenticationService;

    @GetMapping("/spreadsheets")
    public List<AVLSpreadSheet> getAVLSpreadSheets(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader){
        if(!authenticationService.isTokenValid(authorizationHeader)){
            throw new UnauthorizedException();
        }
        return avlSpreadSheetService.getAVLSpreadSheets();
    }

    @GetMapping("/spreadsheet/{id}")
    public AVLSpreadSheet getAVLSpreadSheetById(@PathVariable String id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader){
        if(!authenticationService.isTokenValid(authorizationHeader)){
            throw new UnauthorizedException();
        }
        return avlSpreadSheetService.getSpreadSheetByID(id);
    }

    @PostMapping("/spreadsheet")
    public String postSpreadSheet(@RequestBody AVLSpreadSheetDTO avlSpreadSheetDTO, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader){
        if(!authenticationService.isTokenValid(authorizationHeader)){
            throw new UnauthorizedException();
        }
        var returned = avlSpreadSheetService.addNewAvlSpreadSheet(avlSpreadSheetDTO);
        log.info("returned id spreadsheet {}", returned);
        return returned;
    }

    @PostMapping("/spreadsheet/{id}/timeline")
    public void postTimelineToSpreadSheet(@PathVariable String id, @RequestBody AVLTimeline avlTimeline, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader){
        if(!authenticationService.isTokenValid(authorizationHeader)){
            throw new UnauthorizedException();
        }
        var username = authenticationService.getUserFromToken(authorizationHeader);
        avlSpreadSheetService.addTimelineToSpreadSheet(id, username, avlTimeline);
    }
}
