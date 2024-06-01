package dev.durgresh.MSRTC.Application.repository;

import dev.durgresh.MSRTC.Application.model.BusSchedule;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusScheduleRepository extends JpaRepository<BusSchedule, Integer> {
    List<BusSchedule> findBySourceAndDestination(String source, String destination);

}
