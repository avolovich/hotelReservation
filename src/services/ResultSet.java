package services;

import entity.Guest;
import entity.Room;

import java.util.HashMap;
import java.util.Map;

public class ResultSet {
    private Map<String, Room> rooms;
    private Map<String, Guest> guests;
    private Double totalPrice;
    private Double minPrice;
    private Double maxPrice;

    public ResultSet() {
        // nothing here
    }

    public Map<String, Room> getRooms() {
        return rooms;
    }

    public void setRooms(Map<String, Room> rooms) {
        this.rooms = new HashMap<>();
        this.rooms = rooms;
    }

    public Map<String, Guest> getGuests() {
        return guests;
    }

    public void setGuests(Map<String, Guest> guests) {
        this.guests = new HashMap<>();
        this.guests = guests;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }
}
