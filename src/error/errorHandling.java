package error;

public class errorHandling extends Exception {

    public static void NoSuchRoomException (String roomNumber) {
        System.out.println("There is no room with such number:"+roomNumber);
    }

    public static void NoSuchGuestException (String guestName) {
        System.out.println("No Guest with username:"+guestName);
    }

    public static void NoSuchReservationIdException (Integer reservationId) {
        System.out.println("No reservation with such id in database: "+reservationId);
    }

    public static void NoSuchRoomForGuestException (String roomNumber, String guestName) {
        System.out.println("Guest "+guestName+" has no reservation for room "+roomNumber);
    }

    public static void RoomAlreadyReservedException (String roomNumber) {
        System.out.println("Room "+roomNumber+" is reserved already");
    }

}
