package com.jdbc.starter;

import com.jdbc.starter.util.ConnectionManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BlobRunner {
    public static void main(String[] args) throws SQLException, IOException {
        saveImage();
    }
    private static void saveImage() throws SQLException, IOException {
        String sql = """
                UPDATE aircraft
                SET image = ?
                WHERE id = 1;
                """;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionManager.get();
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(sql);
            Blob blob = connection.createBlob();
            blob.setBytes(1, Files.readAllBytes(Path.of("resources", "boeing777.jpg")));
            preparedStatement.setBlob(1, blob);
            preparedStatement.executeUpdate();
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
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
}
