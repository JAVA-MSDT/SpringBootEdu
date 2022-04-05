package com.javamsdt.spring.webservice;

import java.util.Date;
import java.util.List;

import com.javamsdt.spring.dto.RoomReservation;
import com.javamsdt.spring.modal.service.ReservationService;
import com.javamsdt.spring.util.DateUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RoomReservationRestController {

    private final ReservationService reservationService;

    private final DateUtils dateUtils;

    public RoomReservationRestController(ReservationService reservationService, DateUtils dateUtils) {
        this.reservationService = reservationService;
        this.dateUtils = dateUtils;
    }

    @RequestMapping(value = "/reservations", method = RequestMethod.GET)
    public List<RoomReservation> getReservation(@RequestParam(value = "date", required = false) String reservationDate) {
        Date date = this.dateUtils.createDateFromDateString(reservationDate);
        return  this.reservationService.getRoomReservationsForDate(date);
    }
}
