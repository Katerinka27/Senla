package by.balitskaya.hotel.model;

import java.util.*;

public class Guest {
    private int id;
    private String name;//пока что уникальные имена, они будут храниться в комнате старые гости, список имён кто был в комнате
    private Room room;
    private Date startTime;
    private Date endTime;
    //private Service[] services;
    private List<Service> services;

    public Guest(){
        services=new ArrayList<>();
    }
    public Guest(String name)
    {
        this.name=name;
        services=new ArrayList<>();
    }
    public Guest(String name,Date startTime,Date endTime){
        this.name=name;
        this.startTime=startTime;
        this.endTime=endTime;
        services=new ArrayList<>();
    }
    public Guest(String name,Date startTime,Date endTime,Room room,List<Service> services){
        this.name=name;
        this.startTime=startTime;
        this.endTime=endTime;
        this.room=room;
        this.services=services;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {

        StringBuilder string=new StringBuilder();
        string.append("name:"+name+";");
        string.append("numberRoom:");
        if(room!=null) {
            string.append(room.getNumberRoom());
        }
        else {
            string.append(room);
        }
        if(startTime!=null) {
            string.append(";TimeStart:" + startTime.getDate() + "." + startTime.getMonth() + "." + startTime.getYear() + ";");
            string.append("TimeEnd:" + endTime.getDate() + "." + endTime.getMonth() + "." + endTime.getYear());
        }
        string.append(";numberService:");
        for(Service service:services) {
            if (service != null) {
                string.append(service.getNumberService() + ",");
            }
        }
        return string.toString();
    }
}
