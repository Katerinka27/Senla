package by.balitskaya.hotel.api;

import by.balitskaya.hotel.model.Guest;
import by.balitskaya.hotel.model.Room;
import by.balitskaya.hotel.model.RoomStatus;

import java.util.List;

public interface IRoomRepository {
    public void addRoomFromFile(Room room);
    public void addRoom(Room room);
    public void addPastGuest(int idRoom, Guest guest);
    public Room getRoom(int numberRoom);
    public void changePrice(int numberRoom, double newPrice);
    public void changeRoomStatus(int id, RoomStatus status);
    public List<Room> getRooms();
    public void setRooms(List<Room> rooms);

}
