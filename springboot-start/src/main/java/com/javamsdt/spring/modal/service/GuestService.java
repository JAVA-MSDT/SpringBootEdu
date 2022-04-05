package com.javamsdt.spring.modal.service;

import java.util.List;
import java.util.stream.Collectors;

import com.javamsdt.spring.entity.Guest;
import com.javamsdt.spring.modal.repository.GuestRepository;
import org.springframework.stereotype.Service;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getAllGuests() {
        return guestRepository.findAll().stream().collect(Collectors.toList());
    }

    public void addGuest(Guest guest) {
        guestRepository.save(guest);
    }
}
