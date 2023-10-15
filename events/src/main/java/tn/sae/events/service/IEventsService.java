package tn.sae.events.service;

import tn.sae.events.entity.Events;

import java.util.List;

public interface IEventsService {
    List<Events> getAllEvents();
    Events getEventById(Integer id);
    Events createEvent(Events event);
    Events updateEvent(Integer id, Events event);
    void deleteEvent(Integer id);

}
