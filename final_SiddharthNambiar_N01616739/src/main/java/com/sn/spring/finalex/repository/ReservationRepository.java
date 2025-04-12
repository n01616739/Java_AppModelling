package com.sn.spring.finalex.repository;

import com.sn.spring.finalex.model.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationRepository extends MongoRepository<Reservation, Integer> {
}
