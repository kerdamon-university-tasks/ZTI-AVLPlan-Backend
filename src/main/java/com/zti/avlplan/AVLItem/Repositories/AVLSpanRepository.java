package com.zti.avlplan.AVLItem.Repositories;

import com.zti.avlplan.AVLItem.Models.AVLSpan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AVLSpanRepository extends MongoRepository<AVLSpan, String> {
}
