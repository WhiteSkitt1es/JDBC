package com.jdbc.starter;

import com.jdbc.starter.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionRunner {
    public static void main(String[] args) throws SQLException {
        long id = 8;
        String deleteFlightSql = "DELETE FROM flight WHERE id = /* ? */" + id;
        String deleteTicketSql = "DELETE FROM ticket WHERE flight_id = /* ? */" + id;
        Connection connection = null;
//        PreparedStatement deleteFlightStatement = null;
//        PreparedStatement deleteTicketStatement = null;
        Statement statement = null;
        try {
            connection = ConnectionManager.open();
            connection.setAutoCommit(false);
//            deleteFlightStatement = connection.prepareStatement(deleteFlightSql);
//            deleteTicketStatement = connection.prepareStatement(deleteTicketSql);
            statement = connection.createStatement();
            statement.addBatch(deleteTicketSql);
            statement.addBatch(deleteFlightSql);

            int[] ints = statement.executeBatch();

//            deleteFlightStatement.setLong(1, id);
//            deleteTicketStatement.setLong(1, id);

//            int deleteTicketResult = deleteTicketStatement.executeUpdate();

//            if(true) {
//                throw new RuntimeException("Опа");
//            }
//            int deleteFlightResult = deleteFlightStatement.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                connection.rollback();
            }
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
//            if (deleteFlightStatement != null) {
//                deleteFlightStatement.close();
//            }
//            if (deleteTicketStatement != null) {
//                deleteTicketStatement.close();
//            }
        }
    }
}
