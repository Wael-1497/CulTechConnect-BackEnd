package tn.sae.events.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.sae.events.entity.Events;
import tn.sae.events.service.EventsService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/events")
public class EventsController {

    @Autowired
    EventsService eventsService;

    @PostMapping("/addevent")
    public Events createEvent(@RequestBody Events event) {
        return eventsService.createEvent(event);
    }


    @GetMapping("/allevents")
    public List<Events> getAllEvents() {
        return eventsService.getAllEvents();
    }

    @GetMapping("/event/{idEvent}")
    public Events getEventById(@PathVariable Integer idEvent) {
        return eventsService.getEventById(idEvent);
    }

    @PutMapping("/updateevent/{id}")
    public Events updateEvent(@PathVariable Integer id, @RequestBody Events event) {
        return eventsService.updateEvent(id, event);
    }

    @DeleteMapping("/deleteevent/{idEvent}")
    public void deleteEvent(@PathVariable Integer idEvent) {
        eventsService.deleteEvent(idEvent);
    }
}
