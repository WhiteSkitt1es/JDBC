package com.jdbc.starter.dao;

import com.jdbc.starter.entity.Flight;
import com.jdbc.starter.entity.Ticket;
import com.jdbc.starter.exception.DaoException;
import com.jdbc.starter.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class FlightDao implements Dao<Long, Flight>{
    private static FlightDao INSTANCE;

    private static final String FIND_BY_ID_SQL = """
            SELECT id,
                flight_no,
                departure_date,
                departure_airport_code,
                arrival_date,
                arrival_airport_code,
                aircraft_id,
                status
            FROM flight
            WHERE id = ?
            """;

    private FlightDao() {
    }
    public static FlightDao getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FlightDao();
        }
        return INSTANCE;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Flight save(Flight ticket) {
        return null;
    }

    @Override
    public void update(Flight ticket) {

    }
    public Optional<Flight> findById(Long id, Connection connection) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL);) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Flight flight = null;
            if (resultSet.next()) {
                flight = new Flight(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getTimestamp("departure_date").toLocalDateTime(),
                        resultSet.getString("departure_airport_code"),
                        resultSet.getTimestamp("arrival_date").toLocalDateTime(),
                        resultSet.getString("arrival_airport_code"),
                        resultSet.getInt("aircraft_id"),
                        resultSet.getString("status")
                );
            }
            return Optional.ofNullable(flight);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
    @Override
    public Optional<Flight> findById(Long id) {
        try (Connection connection = ConnectionManager.get();) {
            return findById(id, connection);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Flight> findAll() {
        return null;
    }
}
