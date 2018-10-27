package by.balitskaya.hotel.repository;


import by.balitskaya.hotel.api.IRoomRepository;
import by.balitskaya.hotel.model.Guest;
import by.balitskaya.hotel.model.Room;
import by.balitskaya.hotel.model.RoomStatus;
import by.balitskaya.hotel.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class RoomRepository implements IRoomRepository {
    private static RoomRepository roomRepository;

    private List<Room> rooms;

    private RoomRepository(){
        rooms=new ArrayList<>();
    }
    public static RoomRepository getInstance() {
        if(roomRepository==null) {
            roomRepository=new RoomRepository();
        }
        return roomRepository;
    }
    public int getCountRoom(){
        return rooms.size();
    }
    //add room
    public void addRoomFromFile(Room room){
        rooms.add(room);
    }
    public void addRoom(Room room){
        IdGenerator.setInitialGuestId(getMaxId());
        room.setNumberRoom(IdGenerator.generateRoomId());
        rooms.add(room);
    }
    private int getMaxId(){
        int max=0;
        for(Room room:rooms){
            if(max<room.getNumberRoom()){
                max=room.getNumberRoom();
            }
        }
        return max;
    }


    public void addPastGuest(int numberRoom, Guest guest){
        roomRepository.getRoom(numberRoom).addPastGuest(guest);
    }
    public Room getRoom(int numberRoom){
        for(Room room:rooms){
            if(room!=null){
                if(room.getNumberRoom()==numberRoom){
                    return room;
                }
            }

        }
        return null;
    }
    public void changePrice(int numberRoom,double newPrice)
    {
        Room room=getRoom(numberRoom);
        room.setPrice(newPrice);
        //rooms[numberRoom].setPrice(newPrice);
    }
    public void changeRoomStatus(int numberRoom,  RoomStatus status){
        roomRepository.getRoom(numberRoom).setStatus(status);
    }


    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }


}
