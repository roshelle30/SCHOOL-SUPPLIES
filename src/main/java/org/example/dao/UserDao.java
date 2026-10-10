package org.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public boolean registerUser(String full_name, String username, String password_hash, String role){
        String sql = "INSERT INTO users(full_name, username, password_hash, role, status) VALUES (?, ?, ?, ?, 'PENDING')";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1, full_name);
            pstmt.setString(2, username);
            pstmt.setString(3, password_hash);
            pstmt.setString(4, role.toUpperCase());
            pstmt.executeUpdate();
            System.out.println("Successful Registration, Waiting for Admin Approval! ");
            return true;

        }catch (SQLException e){
            System.err.println("Failed: "+ e.getMessage());
            return false;
        }
    }

    public String loginUser(String username, String password_hash) {
        String sql = "SELECT * FROM users WHERE username = ? AND password_hash = ?";
        String logSql = "INSERT INTO activity_logs (user_id, action) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password_hash);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int userId = rs.getInt("user_id");
                String role = rs.getString("role");
                String status = rs.getString("status");

                if ("PENDING".equalsIgnoreCase(status)) {
                    System.out.println("Login Failed: Your account is PENDING for Admin approval.");
                    return null;
                }

                // DIRI DAPITA GI-IBUTANG ANG BAG-ONG CODE:
                // Gigamit nato ang role aron moingon og "Logged in as: ADMIN" sa database
                try (PreparedStatement logStmt = conn.prepareStatement(logSql)) {
                    logStmt.setInt(1, userId);
                    logStmt.setString(2, "Logged in as: " + role.toUpperCase());
                    logStmt.executeUpdate();
                } catch (SQLException logEx) {
                    System.err.println("Failed to record activity log: " + logEx.getMessage());
                }

                System.out.println("\nLogin Successful! Welcome, " + rs.getString("full_name"));
                return role;
            } else {
                System.out.println("Login Failed: Invalid username or password.");
                return null;
            }

        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
            return null;
        }
    }
}