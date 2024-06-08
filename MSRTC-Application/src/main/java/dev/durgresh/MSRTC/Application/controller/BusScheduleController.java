package dev.durgresh.MSRTC.Application.controller;

import dev.durgresh.MSRTC.Application.model.BusSchedule;
import dev.durgresh.MSRTC.Application.service.BusScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/busSchedules")
public class BusScheduleController {
    private BusScheduleService busScheduleService;

    @Autowired
    public BusScheduleController(BusScheduleService busScheduleService) {
        this.busScheduleService = busScheduleService;
    }

    //List of all the bus
    @GetMapping("/list")
    public ResponseEntity<List<BusSchedule>> getAll(){
        List<BusSchedule> busSchedules = busScheduleService.getAllBusSchedules();
        return ResponseEntity.ok(busSchedules);
    }

    //to create new Bus schedule
    @PostMapping
    public ResponseEntity<BusSchedule> create(@RequestBody BusSchedule busSchedule){
        BusSchedule createBusSchedule = busScheduleService.saveBusSchedule(busSchedule);
        return ResponseEntity.status(HttpStatus.CREATED).body(createBusSchedule);
    }

    //update existing bus
    @PutMapping("/{id}")
    public ResponseEntity<BusSchedule> update(@PathVariable int id, @RequestBody BusSchedule updateBusSchedule){
        BusSchedule updatedBusSchedule = busScheduleService.updateBusSchedule(id, updateBusSchedule);
        return ResponseEntity.ok(updatedBusSchedule);
    }

    //Search as per source to destination
    @GetMapping("/search")
    public ResponseEntity<List<BusSchedule>> findBySourceAndDestination(@RequestParam String source,@RequestParam String destination){
        List<BusSchedule> busSchedules = busScheduleService.findBusScheduleBySourceAndDestination(source, destination);
        return ResponseEntity.ok(busSchedules);
    }
}
