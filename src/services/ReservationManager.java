package services;

import entity.Guest;
import entity.Reservation;
import entity.Room;
import error.errorHandling;
import java.util.Collections;
import java.util.Map;


import static services.DataManager.getRoomByNumber;

public class ReservationManager {



    public static boolean addReservation(String username, String roomNumber) throws Exception {
        // Check such guest and room exists
            Guest guest = DataManager.getGuestByName(username);
            Room room = DataManager.getRoomByNumber(roomNumber);
        if (guest == null || room == null) {
            return false; // User or Room does not exist
        }
        else {
            if (room.Available()) {  // Check such room is available
                Map<String, Room> rooms = Search.getRoomsByGuest(guest);
                if ((Search.getTotalPrice(rooms)+room.getPrice()<guest.getMoneyAmount())) // Check user has enough money for reservation
                {
                    // make a reservation
                    Map<Integer, Reservation> reservations = DataManager.getReservations();

                    int newReservationId = Collections.max(reservations.keySet());          // Find max ID of reservations table

                        newReservationId++;                                                     // and increment it

                    reservations.put(newReservationId, new Reservation(newReservationId,username,roomNumber)); //  add a record to reservations

                    guest.addReservationId(newReservationId);                   // - add reservation id to user's data
                    room.setReservationId(newReservationId);                    // - add reservation id to room's data
                    return true;
                }
                else {
                    return false; // Not enough money
                }
            }
            else {
                return false;   // Room is not available
            }
        }

        }


    public static boolean removeResevation(String username, String roomNumber) {
        // Check such guest and room exists
        Guest guest = DataManager.getGuestByName(username);
        if (guest == null) {
            return false; // User does not exist
        } else {
            ResultSet resultSet = Search.getResultSetByGuest(guest);
            try {
            Room room = resultSet.getRooms().get(roomNumber);   // here should be exception if there is no such key in map or resultset is null
            Integer reservationId = room.getReservationId();    // if it didn't happen - we take reservation ID
            DataManager.getReservations().remove(reservationId);  // then find it in our database map and remove it
                DataManager.getRooms().get(roomNumber).setReservationId(null);  // removing the link to reservation if from Room object
                guest.removeReservationId(reservationId);                       // removing the link from Guest object
                return true;
            } catch (Exception e) {
                errorHandling.NoSuchRoomForGuestException(roomNumber,username);
                return false;
            }
        }

       }
}
