package com.javamsdt.spring.modal.service;

import java.util.List;
import java.util.stream.Collectors;

import com.javamsdt.spring.entity.Room;
import com.javamsdt.spring.modal.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll().stream().collect(Collectors.toList());
    }
}
