package com.jdbc.starter.entity;

import java.math.BigDecimal;

public class Ticket {
    private Long id;
    private String passengerNo;
    private String passengerName;
    private Flight flightId;
    private String seatNo;
    private BigDecimal cost;

    public Ticket(Long id, String passenger_no, String passenger_name, Flight flight_id, String seat_no, BigDecimal cost) {
        this.id = id;
        this.passengerNo = passenger_no;
        this.passengerName = passenger_name;
        this.flightId = flight_id;
        this.seatNo = seat_no;
        this.cost = cost;
    }

    public Ticket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassengerNo() {
        return passengerNo;
    }

    public void setPassengerNo(String passengerNo) {
        this.passengerNo = passengerNo;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Flight getFlightId() {
        return flightId;
    }

    public void setFlightId(Flight flightId) {
        this.flightId = flightId;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Ticket{" +
               "id=" + id +
               ", passenger_no='" + passengerNo + '\'' +
               ", passenger_name='" + passengerName + '\'' +
               ", flight=" + flightId +
               ", seat_no='" + seatNo + '\'' +
               ", cost=" + cost +
               '}';
    }
}
