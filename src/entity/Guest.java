package entity;

import java.util.HashSet;
import java.util.Set;

public class Guest {

    private String username;
    private String fullname;
    private Double moneyAmount;

    private Double moneyLeft;
    private Set<Integer> reservationIds;

    public String getUsername() {
        return username;
    }

    public String getFullname() {
        return fullname;
    }

    public Double getMoneyAmount() {
        return moneyAmount;
    }

    public Double getMoneyLeft() {
        return moneyLeft;
    }

    public void setMoneyLeft(Double moneyLeft) {
        this.moneyLeft = moneyLeft;
    }

    public Set<Integer> getReservationIds() {
        return reservationIds;
    }

    public void setReservationIds(Set<Integer> reservationIds) {
        this.reservationIds = reservationIds;
    }

    public void addReservationId(Integer reservationId) {
        this.reservationIds.add(reservationId);
    }

    public void removeReservationId(Integer reservationId) {
         this.reservationIds.remove(reservationId);
        }


    public Guest(String username, String fullname, Double moneyAmount) {
        this.username = username;
        this.fullname = fullname;
        this.moneyAmount = moneyAmount;
        this.reservationIds = new HashSet<>();
    }

    public Guest(String username, String fullname, Double moneyAmount, Set<Integer> reservationIds) {
        this.username = username;
        this.fullname = fullname;
        this.moneyAmount = moneyAmount;
        this.reservationIds = reservationIds;
    }

    public boolean isNotNull() {
        return (this != null);
    }

    public String getGuestInfo() {
        StringBuilder s = new StringBuilder("");
        s.append("Guest's username: "+this.getUsername()+"\n");
        s.append("Guest's fullname: "+this.getFullname()+"\n");
        s.append("Guest's initial cash amount:" + this.getMoneyAmount().toString()+"$\n");
        return s.toString();
    }




}
