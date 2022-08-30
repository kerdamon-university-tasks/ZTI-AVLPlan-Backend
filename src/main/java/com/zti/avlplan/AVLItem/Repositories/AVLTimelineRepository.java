package com.zti.avlplan.AVLItem.Repositories;

import com.zti.avlplan.AVLItem.Models.AVLTimeline;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AVLTimelineRepository extends MongoRepository<AVLTimeline, String> {
}
