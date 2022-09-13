package com.zti.avlplan.AVLTimeline.Repositories;

import com.zti.avlplan.AVLTimeline.Models.AVLTimeline;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AVLTimelineRepository extends MongoRepository<AVLTimeline, String> {
}
