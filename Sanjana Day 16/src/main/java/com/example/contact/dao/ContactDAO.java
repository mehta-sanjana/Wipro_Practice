package com.example.contact.dao;

import com.example.contact.model.Contact;
import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.DataSource;

public class ContactDAO {
    private DataSource ds;
    private String jdbcUrl, jdbcUser, jdbcPass;

    public ContactDAO() throws Exception {
        try {
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/ContactDB");
        } catch (NamingException e) {
            // fallback to system properties (set -Djdbc.url/-Djdbc.user/-Djdbc.pass)
            jdbcUrl = System.getProperty("jdbc.url");
            jdbcUser = System.getProperty("jdbc.user");
            jdbcPass = System.getProperty("jdbc.pass");
        }
    }

    private Connection getConnection() throws SQLException {
        if (ds != null) return ds.getConnection();
        return DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPass);
    }

    public List<Contact> findAll() throws SQLException {
        String sql = "SELECT id, name, email, phone, address FROM contacts ORDER BY name";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            List<Contact> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Contact(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("address")
                ));
            }
            return list;
        }
    }

    public Contact findById(int id) throws SQLException {
        String sql = "SELECT id, name, email, phone, address FROM contacts WHERE id = ?";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Contact(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address")
                    );
                }
                return null;
            }
        }
    }

    public boolean insert(Contact contact) throws SQLException {
        String sql = "INSERT INTO contacts (name, email, phone, address) VALUES (?, ?, ?, ?)";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getEmail());
            ps.setString(3, contact.getPhone());
            ps.setString(4, contact.getAddress());
            int rows = ps.executeUpdate();
            if (rows == 0) return false;
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) contact.setId(keys.getInt(1));
            }
            return true;
        }
    }

    public boolean update(Contact contact) throws SQLException {
        String sql = "UPDATE contacts SET name=?, email=?, phone=?, address=? WHERE id=?";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getEmail());
            ps.setString(3, contact.getPhone());
            ps.setString(4, contact.getAddress());
            ps.setInt(5, contact.getId());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM contacts WHERE id=?";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
