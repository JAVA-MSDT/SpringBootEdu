package com.javamsdt.spring.util;

import java.util.Date;
import java.util.List;

import com.javamsdt.spring.dto.RoomReservation;
import com.javamsdt.spring.entity.Guest;
import com.javamsdt.spring.entity.Reservation;
import com.javamsdt.spring.entity.Room;
import com.javamsdt.spring.modal.repository.GuestRepository;
import com.javamsdt.spring.modal.repository.ReservationRepository;
import com.javamsdt.spring.modal.repository.RoomRepository;
import com.javamsdt.spring.modal.service.ReservationService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    private final RoomRepository roomRepository;

    private final GuestRepository guestRepository;

    private final ReservationRepository reservationRepository;

    private final ReservationService reservationService;

    private final DateUtils dateUtils;

    public AppStartupEvent(RoomRepository roomRepository,
            GuestRepository guestRepository,
            ReservationRepository reservationRepository,
            ReservationService reservationService, DateUtils dateUtils) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
        this.reservationService = reservationService;
        this.dateUtils = dateUtils;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Room> rooms = roomRepository.findAll();
        rooms.forEach(System.out::println);

        Iterable<Guest> guests = guestRepository.findAll();
        guests.forEach(System.out::println);

        Iterable<Reservation> reservations = reservationRepository.findAll();
        reservations.forEach(System.out::println);

        System.out.println(" =================== ReservationService ===============");
        Date date = this.dateUtils.createDateFromDateString("2022-01-01");
        List<RoomReservation> reservation = this.reservationService.getRoomReservationsForDate(date);
        reservation.forEach(System.out::println);

    }
}
