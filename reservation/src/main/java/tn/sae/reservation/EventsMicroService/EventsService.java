package tn.sae.reservation.EventsMicroService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "EVENTS",url = "http://localhost:8090")
public interface EventsService {
    @GetMapping("/eventsListReservation")
    List<EventsDTO> readItems();

    @GetMapping("/bookevent/{id}")
    EventsDTO BookRoom(@PathVariable("id") Integer id);
}
