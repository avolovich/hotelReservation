import entity.Room;
import entity.RoomType;
import entity.Guest;
import entity.Reservation;
import services.DataManager;
import services.Search;

import java.util.*;

public class Main {



    public static void main(String[] args) {
        DataManager.FillInData();
        VerificationTask();

    }



    public static void VerificationTask() {

        Map<String, Room> allRooms = Search.getAllRooms();
        Map<String, Room> availableRooms = Search.getAvailableRooms();
        Map<String, Room> roomsByType = Search.getAvailableRoomsByType(RoomType.DOUBLE_QUEEN_ROOM);
        Map<String, Room> roomsByGuest = Search.getRoomsByGuest(DataManager.getGuestByName("jaba"));
        // Show all Rooms
//        final Set<Map.Entry<String, Room>> roomEntries = rooms.entrySet();
//        System.out.println("-====Rooms List:");
//        for (Map.Entry<String, Room> roomEntry : roomEntries) {
//            System.out.println(roomEntry.getKey()+" => "+ roomEntry.getValue().getRoomInfo());
//        }

        // Show all available rooms by Type

        // Show all customers
        final Set<Map.Entry<String, Guest>> guestEntries = DataManager.getGuests().entrySet();
        System.out.println("-====Guests List:");
        for (Map.Entry<String, Guest> guestEntry : guestEntries) {
            System.out.println(guestEntry.getKey()+" => "+ guestEntry.getValue().getGuestInfo());
        }

        // Show Reservation Info of all customers
        StringBuilder s = new StringBuilder("");
        s.append("-====Guests List (detailed:");
        for (Map.Entry<String, Guest> guestEntry : guestEntries) {
            s.append(">>> User ID:"+guestEntry.getKey());
            s.append(" => ");
            s.append(guestEntry.getValue().getGuestInfo());
            Set<Integer> reservationIds = guestEntry.getValue().getReservationIds();
            if (!(reservationIds.isEmpty() || reservationIds == null)) {
                s.append("Reserved Rooms (");
                s.append(reservationIds.size());
                s.append("):\n");
                Double cashLeft = guestEntry.getValue().getMoneyAmount();
                for(Integer reservation:reservationIds) {
                    String roomId = DataManager.getReservations().get(reservation).getRoomId();
                    s.append(
                            DataManager.getRooms().get(roomId).getRoomInfo());
                cashLeft -= DataManager.getRooms().get(roomId).getPrice();
                }
                s.append("Money Left: "+cashLeft+"$");
            } else {
                s.append("This Guest has no rooms reserved!");
            }
            s.append("\n\n");
        }
        System.out.println(s.toString());



        // Show all reservations
//        final Set<Map.Entry<Integer, Reservation>> reservationEntries = reservations.entrySet();
//        s.delete(0,s.length());
//        String userInfo = "";
//        String roomInfo = "";
//        s.append("-====Reservations List:\n");
//        for (Map.Entry<Integer, Reservation> reservationEntry : reservationEntries) {
//            s.delete(0,s.length()); userInfo = ""; roomInfo = "";
//
//            s.append("Reservation key: ");
//            s.append(reservationEntry.getKey().toString());
//            s.append("\n");
//
//            s.append("User: ");
//            s.append(guests.get(reservationEntry.getValue().getUserId()).getGuestInfo());
//            s.append("=====> Reserved a room \n");
//
//            s.append(rooms.get(reservationEntry.getValue().getRoomId()).getRoomInfo());
//            System.out.println(s.toString());
//        }

        // Show everything




        // Show Rooms Reserved by CustomerID

        // Show detailed information by particular room including customer and reservation

        // Check if room is available

        // Make a reservation

        // Try to make a reservation of the room which is not exist

        // Try to make a reservation by user which is not exist

        // Try to book a room which is already reserved by another customer

        // Try to book a room which is already reserved by this customer

        // Try to book when there are no money enough

        // Cancel Reservation

        // Cancel Reservation if there no such room reserved

        // Cancel Reservation if there no such user


        // Find max value of the map, increment it and add new record with incremented key
//       String maxKey = Collections.max(rooms.keySet());
//        System.out.println("Max value of room keys is: "+maxKey);
//        Integer m1 = Integer.valueOf(maxKey)+1;
//        rooms.put(m1.toString(), new Room(m1.toString(),RoomType.QUEEN_ROOM,BigDecimal.valueOf(m1)));

    }
}
