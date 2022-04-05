package com.javamsdt.spring.web;

import java.util.Date;
import java.util.List;

import com.javamsdt.spring.dto.RoomReservation;
import com.javamsdt.spring.modal.service.ReservationService;
import com.javamsdt.spring.util.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reservation")
public class RoomReservationController {

    private final ReservationService reservationService;

    private final DateUtils dateUtils;

    public RoomReservationController(ReservationService reservationService,
            DateUtils dateUtils) {
        this.reservationService = reservationService;
        this.dateUtils = dateUtils;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getReservation(@RequestParam(value = "date", required = false) String reservationDate, Model model) {
        Date date = this.dateUtils.createDateFromDateString(reservationDate);
        List<RoomReservation> reservations = this.reservationService.getRoomReservationsForDate(date);
        model.addAttribute("roomReservations", reservations);
        return "roomreservation";
    }
}
