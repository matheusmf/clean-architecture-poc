package com.matheusmf.coworking.infrastructure.place.repository;

import com.matheusmf.coworking.domain.place.model.Email;
import com.matheusmf.coworking.domain.place.model.Place;
import com.matheusmf.coworking.domain.place.PlaceRepository;
import com.matheusmf.coworking.domain.place.exception.PlaceNotFound;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCPlaceRepository implements PlaceRepository {

    private final Connection connection;

    public JDBCPlaceRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void register(Place place) {
        try {
            String sql = "INSERT INTO PLACE VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, place.getName());
            ps.setString(2, place.getAddress().getCountry());
            ps.setString(2, place.getAddress().getState());
            ps.setString(2, place.getAddress().getCity());
            ps.setString(2, place.getAddress().getDistrict());
            ps.setString(2, place.getAddress().getStreet());
            ps.setString(2, place.getAddress().getComplement());
            ps.setString(3, place.getEmail());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Place findByName(String name) {
        try {
            String sql = "SELECT id, name, country, state, city, district street, complement, email " +
                    "FROM PLACE WHERE name = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();
            boolean finded = rs.next();
            if (!finded) throw new PlaceNotFound(name);

            String nameFinded = rs.getString("name");
            Email email = new Email(rs.getString("email"));
            Place place = new Place(nameFinded, email);

            long id = rs.getLong("id");
            sql = "SELECT ddd, number FROM PHONE WHERE place_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String number = rs.getString("number");
                String ddd = rs.getString("ddd");
                place.addPhone(ddd, number);
            }

            return place;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Place> listAll() {
        try {
            String sql = "SELECT id, name, country, state, city, district street, complement, email " +
                    "FROM PLACE";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Place> places = new ArrayList<>();
            while (rs.next()) {
                String nameFinded = rs.getString("name");
                Email email = new Email(rs.getString("email"));
                Place place = new Place(nameFinded, email);

                long id = rs.getLong("id");
                sql = "SELECT ddd, number FROM PHONE WHERE place_id = ?";
                PreparedStatement psPhone = connection.prepareStatement(sql);
                psPhone.setLong(1, id);
                ResultSet rsPhone = psPhone.executeQuery();
                while (rsPhone.next()) {
                    String number = rs.getString("number");
                    String ddd = rs.getString("ddd");
                    place.addPhone(ddd, number);
                }
                places.add(place);
            }



            return places;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
