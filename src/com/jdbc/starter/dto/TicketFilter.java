package com.jdbc.starter.dto;

public record TicketFilter(int limit, int offset, String passenger_name, String seat_no) {

}
