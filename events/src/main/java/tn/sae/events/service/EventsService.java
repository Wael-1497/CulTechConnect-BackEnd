package tn.sae.events.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.sae.events.entity.Events;
import tn.sae.events.repository.EventsRepository;

import java.util.List;

@Service
public class EventsService implements IEventsService {

    @Autowired
    EventsRepository eventsRepository;

    @Override
    public Events createEvent(Events event) {
        return eventsRepository.save(event);
    }

    @Override
    public List<Events> getAllEvents() {
        return eventsRepository.findAll();
    }

    @Override
    public Events getEventById(Integer idEvent) {
        return eventsRepository.findById(idEvent).orElse(null);
    }


    @Override
    public Events updateEvent(Integer idEvent, Events event) {
        event.setId(idEvent);
        return eventsRepository.save(event);
    }
    @Override
    public void deleteEvent(Integer idEvent) {
        eventsRepository.deleteById(idEvent);
    }



    }
