package com.javamsdt.spring.webservice;

import java.util.List;

import com.javamsdt.spring.entity.Guest;
import com.javamsdt.spring.entity.Room;
import com.javamsdt.spring.modal.service.GuestService;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GuestRestController {

    private final GuestService guestService;

    public GuestRestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @RequestMapping( value = "/guests",method = RequestMethod.GET)
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }

    @RequestMapping(value = "/guests", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addGuest(@RequestBody Guest guest) {
        guestService.addGuest(guest);
    }
}
