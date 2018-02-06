package com.example.hazelcast.client.command.topic.controller;
import com.example.hazelcast.client.command.topic.service.VehicleRestCommandServiceClient;
import com.example.hazelcast.shared.model.Vehicle;
import com.example.hazelcast.shared.topic.TopicNames;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;
import com.hazelcast.core.Message;
import com.hazelcast.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by netof on 29/01/2018.
 */
@RestController
public class VehicleCommandRestController implements TopicNames{

    @Autowired
    VehicleRestCommandServiceClient vehicleRestCommandServiceClient;

    public void deleteVehicle(Vehicle vehicle){
        vehicleRestCommandServiceClient.deleteVehicle(vehicle.getVehicleId());
    }

    public void updateVehicle(Vehicle vehicle)throws Exception{
        HazelcastInstance client = HazelcastClient.getHazelcastClientByName("ClientCommandTopicInstance");
        final Vehicle[] vehicleMessage = {new Vehicle()};
        ITopic<Vehicle> topic = client.getTopic(VEHICLES_TOPIC);
        topic.addMessageListener(new MessageListener<Vehicle>() {
            @Override
            public void onMessage(Message<Vehicle> message) {
                vehicleMessage[0] = message.getMessageObject();
            }
        });

        vehicleRestCommandServiceClient.updateVehicle(vehicleMessage[0]);
    }

    public void save(Vehicle vehicle) throws Exception {
        vehicle = vehicleRestCommandServiceClient.save(vehicle);
    }
}
