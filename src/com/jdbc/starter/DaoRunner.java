package com.jdbc.starter;

import com.jdbc.starter.dao.TicketDao;
import com.jdbc.starter.entity.Ticket;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class DaoRunner {
    public static void main(String[] args) {

    }

    private static void findAllTest() {
        TicketDao ticketDao = TicketDao.getInstance();
        List<Ticket> allTicket = ticketDao.findAll();
        for (Ticket ticket : allTicket) {
            System.out.println(ticket);
        }
    }

    private static void updateTest() {
        TicketDao ticketDao = TicketDao.getInstance();
        Optional<Ticket> maybeTicket = ticketDao.findById(41L);
        System.out.println(maybeTicket);

        maybeTicket.ifPresent(ticket -> {
            ticket.setCost(BigDecimal.valueOf(188.88));
            ticketDao.update(ticket);
        });
    }

    private static void deleteTest(Long id) {
        TicketDao ticketDao = TicketDao.getInstance();
        boolean result = ticketDao.delete(id);
        System.out.println(result);
    }

    private static void saveTest() {
        TicketDao ticketDao = TicketDao.getInstance();
        Ticket ticket = new Ticket();
        ticket.setPassenger_no("1234567");
        ticket.setPassenger_name("Test");
        ticket.setFlight_id(3L);
        ticket.setSeat_no("B3");
        ticket.setCost(BigDecimal.TEN);
        Ticket save = ticketDao.save(ticket);
        System.out.println(save);
    }
}
