package dev.durgresh.MSRTC.Application.service;

import dev.durgresh.MSRTC.Application.model.BusSchedule;
import dev.durgresh.MSRTC.Application.repository.BusScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusScheduleService {
    private BusScheduleRepository busScheduleRepository;

    @Autowired
    public BusScheduleService(BusScheduleRepository busScheduleRepository) {
        this.busScheduleRepository = busScheduleRepository;
    }

    //Method to get all the Bus Schedule
    public List<BusSchedule> getAllBusSchedules(){
        return busScheduleRepository.findAll();
    }

    //Method to save a new Bus Schedule
    public BusSchedule saveBusSchedule(BusSchedule busSchedule){
        return busScheduleRepository.save(busSchedule);
    }

    //Method to update an existing Bus schedule
    public BusSchedule updateBusSchedule(int id, BusSchedule updateBusSchedule){

        BusSchedule existingBusSchedule = busScheduleRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Bus schedule not found with id: "+ id));

        //Update properties of existing bus schedule with properties from updated bus schedule
        existingBusSchedule.setBusNumber(updateBusSchedule.getBusNumber());
        existingBusSchedule.setBusType(updateBusSchedule.getBusType());
        existingBusSchedule.setSource(updateBusSchedule.getSource());
        existingBusSchedule.setDestination(updateBusSchedule.getDestination());
        existingBusSchedule.setDepartureTime(updateBusSchedule.getDepartureTime());
        existingBusSchedule.setArrivalTime(updateBusSchedule.getArrivalTime());
        existingBusSchedule.setStatus(updateBusSchedule.getStatus());
        return busScheduleRepository.save(existingBusSchedule);
    }

    //Method to delete a bus schedule by Id
    public void deleteBusSchedule(int id){
        busScheduleRepository.deleteById(id);
    }

    //Method to find a particular bus as per source to destination
    public List<BusSchedule> findBusScheduleBySourceAndDestination(String source, String destination) {
        return busScheduleRepository.findBySourceAndDestination(source, destination);
    }
}
