package by.balitskaya.hotel.api;

import by.balitskaya.hotel.model.Room;
import by.balitskaya.hotel.model.RoomStatus;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

public interface IRoomManager {
    public void addRoom(Room room);
    public void changeRoomStatus(int id, RoomStatus status);
    public void changePrice(int numberRoom, double newPrice);
    public int countFreeRooms();
    public String informationAboutRoom(int numberRoom);
    public List<Room> sort(Comparator comparator);
    public List<Room> getFreeRooms();
    public List<Room> sortFreeRoom(Comparator comparator);
    public List<Room> roomInFuture(Date time);
    public String[] toStrings();

    Boolean numberRoomExitstingCheck(Integer numberRoom);
}
