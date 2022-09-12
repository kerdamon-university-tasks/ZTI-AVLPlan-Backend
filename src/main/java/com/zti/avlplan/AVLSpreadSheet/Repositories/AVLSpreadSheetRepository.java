package com.zti.avlplan.AVLSpreadSheet.Repositories;

import com.zti.avlplan.AVLSpreadSheet.Models.AVLSpreadSheet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AVLSpreadSheetRepository extends MongoRepository<AVLSpreadSheet, String> {
}
