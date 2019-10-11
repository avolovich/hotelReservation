package entity;

public class Room {

    private String number;
    private RoomType type;
    private Double price;
    private Integer reservationId;

    public String getNumber() {
        return number;
    }

    public RoomType getType() {
        return type;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public boolean Available() {
        return (reservationId == null);
    }

    public Room(String number, RoomType type, Double price, int reservationId) {
        this.number = number;
        this.type = type;
        this.price = price;
        this.reservationId = reservationId;
    }

    public Room(String number, RoomType type, Double price) {
        this.number = number;
        this.type = type;
        this.price = price;
    }

    public boolean isNotNull() {
        return (this != null);
    }

    public String getRoomInfo() {
        StringBuilder s = new StringBuilder("");
        s.append("Room number: "+this.getNumber()+", ");
        s.append("Room price: "+this.getPrice().toString()+"$, ");
        s.append("Room type:" + this.getType().getRoomTypeName()+", ");
        s.append("Room reserved:" +this.Available()+"\n");
        return s.toString();
    }




}
