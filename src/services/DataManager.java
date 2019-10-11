package services;

import entity.Guest;
import entity.Reservation;
import entity.Room;
import entity.RoomType;

import error.errorHandling;

import java.util.*;

public class DataManager {
    private static final Map<String, Room> rooms = new HashMap<>();
    private static final Map<String, Guest> guests = new HashMap<>();
    private static final Map<Integer, Reservation> reservations = new HashMap<Integer, Reservation>();

    public static void FillInData() {

        // Add rooms
        addRoom("1", RoomType.KING_ROOM, 20.0);
        addRoom("2A", RoomType.DOUBLE_FULL_ROOM, 50.0);
        addRoom("2B", RoomType.DOUBLE_QUEEN_ROOM, 45.0);
        addRoom("3", RoomType.QUEEN_ROOM, 25.0,3);
        addRoom("4", RoomType.KING_ROOM, 22.0);
        addRoom("5", RoomType.KING_ROOM, 20.0);
        addRoom("6C", RoomType.KING_ROOM, 30.0,2);
        addRoom("17", RoomType.DOUBLE_FULL_ROOM, 48.0,1);
        addRoom("21", RoomType.QUEEN_ROOM, 40.0,5);
        addRoom("8", RoomType.DOUBLE_QUEEN_ROOM, 55.0,4);


       // Add Guests
        addGuest("jaba","Jaba Chuchaveljev", 100.0, new HashSet<Integer>(Arrays.asList(4,5)));
        addGuest("vova","Vladimir Nekrasov", 50.0);
        addGuest("sigizmund","Sigizmund Betmambekov", 77.0, new HashSet<Integer>(Arrays.asList(2,3)));
        addGuest("helen","Helen Tompson", 55.0, new HashSet<Integer>(Arrays.asList(1)));

        // Add Reservations
        addReservation(1, "helen", "17");
        addReservation(2, "sigizmund", "6C");
        addReservation(3, "sigizmund", "3");
        addReservation(4, "jaba", "8");
        addReservation(5, "jaba", "21");
    }

    public static void addRoom(String number, RoomType roomType, Double price) {
        rooms.put(number, new Room(number, roomType, price));
    }

    public static void addRoom(String number, RoomType roomType, Double price, Integer reservationId) {
        rooms.put(number, new Room(number, roomType, price, reservationId));
    }

    public static void addGuest(String username, String fullname, Double moneyAmount) {
        guests.put(username, new Guest(username, fullname, moneyAmount));
    }

    public static void addGuest(String username, String fullname, Double moneyAmount, Set<Integer> reservationIds) {
        guests.put(username, new Guest(username, fullname, moneyAmount));
    }

    public static void addReservation(Integer id, String userId, String roomNumber) {
        reservations.put(id, new Reservation(id, userId, roomNumber));
    }

    public static Map<String, Room> getRooms() {
        return rooms;
    }

    public static Map<String, Guest> getGuests() {
        return guests;
    }

    public static Map<Integer, Reservation> getReservations() {
        return reservations;
    }

    public static Room getRoomByNumber(String roomNumber) {
        try {
           Room room = rooms.get(roomNumber);
            return room;
        }
        catch (Exception e) {
            errorHandling.NoSuchRoomException(roomNumber);
            return null;
        }
    }

    public static Guest getGuestByName(String guestName)  {
        try {
            Guest guest = guests.get(guestName);
            return guests.get(guestName);
        }
        catch (Exception e) {
            errorHandling.NoSuchGuestException(guestName);
            return null;
        }
    }

    public static Reservation getReservationById(Integer reservationId) {
        try {
            Reservation reservation = reservations.get(reservationId);
            return reservation;
        }
        catch (Exception e) {
            errorHandling.NoSuchReservationIdException(reservationId);
            return null;
        }

    }
}
