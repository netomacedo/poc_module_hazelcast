package com.example.hazelcast.shared.interface_message;

import com.example.hazelcast.shared.model.Vehicle;

import java.util.UUID;

/**
 * Created by netof on 09/02/2018.
 */
public interface IVehicleMessage extends ITopicQueueMessage {
    void setVehicle(Vehicle vehicle);
    Vehicle getVehicle();
}
