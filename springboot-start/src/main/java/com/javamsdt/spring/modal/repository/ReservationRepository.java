package com.javamsdt.spring.modal.repository;

import java.sql.Date;

import com.javamsdt.spring.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Iterable<Reservation> findReservationByReservationDate(Date resDate);

}
