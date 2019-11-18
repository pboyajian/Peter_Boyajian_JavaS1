package com.trilogyed.securersvp.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class RsvpController {
@GetMapping(value = "/publicEvents")
    public String viewPublicEvents(){
    return "Here are the public events.";
}
@GetMapping(value = "/privateEvents")
    public String viewPrivateEvents(Principal principal){
    return "Here are the private events, exclusively for you, "+principal.getName();
}
@GetMapping(value = "/registerPublicEvents")
    public String registerPubicEvents(){
    return "Here are the public registrations.";
}
@GetMapping(value = "/registerPrivateEvents")
    public String registerPrivateEvents(Principal principal){
    return "Here are the private registrations, exclusively for you, "+principal.getName();
}
@GetMapping(value = "/allDone")
    public String logout(){
    return "Logged out";
}
@GetMapping(value = "/guestList")
    public String getGuestList(Principal principal){
    return "Hell, "+principal.getName()+". Because you are an event publisher, you can see this guest list.";
}

    @GetMapping(value = "/eventPublisherList")
    public String getEventPublisherList(Principal principal){
        return "Hell, "+principal.getName()+". You may view a list of event publishers.";
    }

    @DeleteMapping(value = "privateEvent/{id}")
    public String deletePrivateEvent(@PathVariable int id){
    return "Event "+id+" has been deleted.";
    }
}
