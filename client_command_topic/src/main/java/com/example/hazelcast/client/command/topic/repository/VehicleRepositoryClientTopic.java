package com.example.hazelcast.client.command.topic.repository;

import com.example.hazelcast.shared.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by netof on 11/01/2018.
 */
@Repository
public interface VehicleRepositoryClientTopic extends JpaRepository<Vehicle, Long> {


}
