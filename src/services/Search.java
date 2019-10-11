package services;

import entity.Guest;
import entity.Reservation;
import entity.Room;
import entity.RoomType;

import javax.xml.crypto.Data;
import java.util.*;

public class Search {

    public static Map<String, Room> getAllRooms() {
        return DataManager.getRooms();
        // What if no rooms?
    }


    public static Map<String, Room> getAvailableRooms() {
        final Set<Map.Entry<String, Room>> roomEntries = DataManager.getRooms().entrySet();
        Map<String, Room> availableRooms = new HashMap<>();
        for (Map.Entry<String, Room> roomEntry : roomEntries) {
            if ((roomEntry.getValue().Available())) {
                availableRooms.put(roomEntry.getKey(),roomEntry.getValue());
            }
        }
        return availableRooms;
        // What if no available rooms??
    }

    public static Map<String, Room> getAvailableRoomsByType(RoomType roomType) {
        Map<String, Room> availableRoomsByType = new HashMap<>();
        final Set<Map.Entry<String, Room>> roomEntries = DataManager.getRooms().entrySet();
        for (Map.Entry<String, Room> roomEntry : roomEntries) {
            if (((roomEntry.getValue().Available())) && (roomEntry.getValue().getType().equals(roomType))) {
                availableRoomsByType.put(roomEntry.getKey(),roomEntry.getValue());
            }
        }
        return availableRoomsByType;
        // What if no available rooms by that type?
    }

    public static Map<String, Room> getRoomsByGuest(Guest guest) {
        if (guest != null) {
            Map<String, Room> roomsByGuest = new HashMap<>();
            Set<Integer> reservations = guest.getReservationIds();
            if (!(reservations.isEmpty())) {
                for (Integer reservation:reservations) {
                    String nextRoomId = DataManager.getReservations().get(reservation).getRoomId();
                    Room nextRoomData = DataManager.getRoomByNumber(nextRoomId);
                    roomsByGuest.put(nextRoomId, nextRoomData);
                }
            }
            return roomsByGuest;    // We return empty Map if there are no reservations for this user
        } else {
            return null;            // Or null if there is no such user at all
        }
    }


    public static Double getTotalPrice(Map<String, Room> rooms) {
        if (!rooms.isEmpty()) {
            Double totalPrice = 0.0;
                Set<Map.Entry<String, Room>> roomEntries = rooms.entrySet();
                for (Map.Entry<String, Room> roomEntry : roomEntries) {
                    totalPrice += roomEntry.getValue().getPrice();
                }
            return totalPrice;
        } else
        {
            return null;
        }
    }


    public static ResultSet getResultSetByGuest(Guest guest) {
        if (guest != null) {
            ResultSet resultSet = new ResultSet();
            Map<String, Room> roomsByGuest = new HashMap<>();
            Set<Integer> reservations = guest.getReservationIds();
            if (!(reservations.isEmpty())) {
                Double totalPrice = 0.0;
                for (Integer reservation:reservations) {
                    String nextRoomId = DataManager.getReservations().get(reservation).getRoomId();
                    Room nextRoomData = DataManager.getRoomByNumber(nextRoomId);
                    roomsByGuest.put(nextRoomId, nextRoomData);
                    totalPrice += nextRoomData.getPrice();
                }
                resultSet.setRooms(roomsByGuest);
                resultSet.setTotalPrice(totalPrice);
            }
            return resultSet;    // We return empty Map if there are no reservations for this user
        } else {
            return null;            // Or null if there is no such user at all
        }
    }

//    public static ResultSet getResultSetByGuest(String guestName) {
//        Guest guest = DataManager.getGuestByName(guestName);
//        if (guest != null) {
//            ResultSet resultSet = new ResultSet();
//            Map<String, Room> roomsByGuest = new HashMap<>();
//            Set<Integer> reservations = guest.getReservationIds();
//            if (!(reservations.isEmpty())) {
//                Double totalPrice = 0.0;
//                for (Integer reservation:reservations) {
//                    String nextRoomId = DataManager.getReservations().get(reservation).getRoomId();
//                    Room nextRoomData = DataManager.getRoomByNumber(nextRoomId);
//                    roomsByGuest.put(nextRoomId, nextRoomData);
//                    totalPrice += nextRoomData.getPrice();
//                }
//                resultSet.setRooms(roomsByGuest);
//                resultSet.setTotalPrice(totalPrice);
//            }
//            return resultSet;    // We return empty Map if there are no reservations for this user
//        } else {
//            return null;            // Or null if there is no such user at all
//        }
//    }

    public static void SearchMain() {

    }



}
