package com.javamsdt.spring.webservice;

import java.util.List;

import com.javamsdt.spring.entity.Guest;
import com.javamsdt.spring.entity.Room;
import com.javamsdt.spring.modal.service.RoomService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RoomRestController {

    private final RoomService roomService;

    public RoomRestController(RoomService roomService) {
        this.roomService = roomService;
    }

    @RequestMapping(value = "/rooms",method = RequestMethod.GET)
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }
}
