package com.jdbc.starter;

import com.jdbc.starter.dao.TicketDao;
import com.jdbc.starter.dto.TicketFilter;
import com.jdbc.starter.entity.Ticket;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class DaoRunner {
    public static void main(String[] args) {
        Optional<Ticket> ticket = TicketDao.getInstance().findById(5L);
        System.out.println(ticket);
    }

    private static void filterTest() {
        TicketFilter ticketFilter = new TicketFilter(10, 0, "Евгений Кудрявцев", "A1");
        List<Ticket> tickets = TicketDao.getInstance().findAll(ticketFilter);
        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }
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
        ticket.setPassengerNo("1234567");
        ticket.setPassengerName("Test");
        //ticket.setFlightId(3L);
        ticket.setSeatNo("B3");
        ticket.setCost(BigDecimal.TEN);
        Ticket save = ticketDao.save(ticket);
        System.out.println(save);
    }
}
