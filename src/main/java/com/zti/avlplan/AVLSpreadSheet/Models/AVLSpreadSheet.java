package com.zti.avlplan.AVLSpreadSheet.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zti.avlplan.AVLItem.Models.AVLSpan;
import org.springframework.data.annotation.Id;

import java.util.List;

public class AVLSpreadSheet {
    @Id
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
    private List<AVLSpan> AVLTimeline;
}
