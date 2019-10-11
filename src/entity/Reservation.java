package entity;

public class Reservation {

    private int id;
    private String UserId;
    private String RoomId;

    public Reservation(int id, String user, String room) {
        this.id = id;
        this.UserId = user;
        this.RoomId = room;
    }

    public int getId() {
        return id;
    }

    public String getUserId() {
        return UserId;
    }

    public String getRoomId() {
        return RoomId;
    }

}