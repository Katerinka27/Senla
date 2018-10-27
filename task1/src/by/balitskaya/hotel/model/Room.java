package by.balitskaya.hotel.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Room {
    private Integer numberRoom;//номер комнаты 0,1,2...
    private Double price;
    private Integer capacity;
    private Integer star;
    private RoomStatus status;
    private GregorianCalendar startTime;
    private GregorianCalendar endTime;
    private List<Guest> pastGuests;

    public Room(){
        price=100.13d;
        capacity=10;
        star=3;
        status=RoomStatus.free;
        pastGuests=new ArrayList<>();
    }
    public Room(int numberRoom){
        this.numberRoom=numberRoom;
        this.pastGuests=new ArrayList<>();
    }
    public Room(double price,int capacity,int star,RoomStatus roomStatus){
        this.price=price;
        this.capacity=capacity;
        this.star=star;
        this.status=roomStatus;
        this.pastGuests=new ArrayList<>();
    }
    public Room(double price,int capacity,int star){
        this.price=price;
        this.capacity=capacity;
        this.star=star;
        this.status=RoomStatus.free;
        this.pastGuests=new ArrayList<>();
    }
    public Room(int numberRoom,double price,int capacity,int star,RoomStatus status,List<Guest> pastGuests){
        this.numberRoom=numberRoom;
        this.price=price;
        this.capacity=capacity;
        this.star=star;
        this.status=status;
        this.pastGuests=pastGuests;
    }
    public int countPastGuest(){
        return pastGuests.size();
    }
    public void addPastGuest(Guest guest) {
        pastGuests.add(guest);
    }


    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public List<Guest> getPastGuests() {
        return pastGuests;
    }

    public void setPastGuests(List<Guest> pastGuests) {
        this.pastGuests = pastGuests;
    }



    public int getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(int numberRoom) {
        this.numberRoom = numberRoom;
    }

    public GregorianCalendar getStartTime() {
        return startTime;
    }

    public void setStartTime(GregorianCalendar startTime) {
        this.startTime = startTime;
    }

    public GregorianCalendar getEndTime() {
        return endTime;
    }

    public void setEndTime(GregorianCalendar endTime) {
        this.endTime = endTime;
    }


    //dodelat
    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("NumberRoom:"+numberRoom+";price:"+price+";capacity:"+capacity+";star:"+star+";status:"+status+";pastGuests:");

        if(pastGuests!=null) {
            for (int i = 0; i < this.pastGuests.size(); i++) {
                if (this.pastGuests.get(i) != null) {
                    stringBuilder.append(pastGuests.get(i).getName() + ",");
                }
                //pastGuests+=this.pastGuests[i]
            }
        }
        return stringBuilder.toString();
    }
}
