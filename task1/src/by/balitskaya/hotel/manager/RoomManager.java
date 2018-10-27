package by.balitskaya.hotel.manager;

import by.balitskaya.hotel.api.IRoomManager;
import by.balitskaya.hotel.model.Guest;
import by.balitskaya.hotel.model.Room;
import by.balitskaya.hotel.model.RoomStatus;
import by.balitskaya.hotel.repository.GuestRepository;
import by.balitskaya.hotel.repository.ServiceRepository;
import by.balitskaya.hotel.util.sort.SortedByPriceRoom;
import by.balitskaya.hotel.repository.RoomRepository;

import java.util.*;

public class RoomManager implements IRoomManager {
    private static RoomManager roomManager;

    private RoomRepository roomRepository;
    private GuestRepository guestRepository;
    private ServiceRepository serviceRepository;

    private RoomManager() {
        roomRepository = RoomRepository.getInstance();
        guestRepository = GuestRepository.getGuestRepository();
        serviceRepository = ServiceRepository.getInstance();
    }

    public static RoomManager getInstance() {
        if (roomManager == null) {
            roomManager = new RoomManager();
        }
        return roomManager;
    }


    public List<Room> sortedByPrice() {
        List<Room> rooms = roomRepository.getRooms();
        rooms.sort(new SortedByPriceRoom());
        return rooms;
    }

    public void addRoom(Room room) {
        roomRepository.addRoom(room);
    }

    public int getCountRoom() {
        int countRoom = 0;
        for (Room room : roomRepository.getRooms()) {
            if (room != null) {
                countRoom++;
            }
        }
        return countRoom;
    }

    public void changeRoomStatus(int numberRoom, RoomStatus status) {
        roomRepository.getRoom(numberRoom).setStatus(status);

    }

    public void changePrice(int numberRoom, double newPrice) {
            roomRepository.changePrice(numberRoom, newPrice);
    }

    public int countFreeRooms() {
        int freeRooms = 0;
        for (Room room : roomRepository.getRooms()) {
            if (room != null) {
                if (room.getStatus().equals(RoomStatus.free)) {
                    freeRooms++;
                }
            }
        }
        return freeRooms;
    }

    public String informationAboutRoom(int numberRoom) {
        String info = "no found";
            info = roomRepository.getRoom(numberRoom).toString();
        return info;
    }

    public List<Room> sort(Comparator comparator) {
        List<Room> rooms = roomRepository.getRooms();
        rooms.sort(comparator);
        return rooms;
    }

    public List<Room> getFreeRooms() {
        List<Room> rooms = roomRepository.getRooms();
        List<Room> freeRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room != null) {
                if (room.getStatus() == RoomStatus.free) {
                    freeRooms.add(room);
                }
            }
        }
        return freeRooms;
    }

    public List<Room> sortFreeRoom(Comparator comparator) {

        List<Room> freeRooms = getFreeRooms();
        freeRooms.sort(comparator);


        return freeRooms;
    }

    public List<Room> roomInFuture(Date time) {
        List<Room> futureRooms = new ArrayList<>();
        int index = 0;
        for (Room room : roomRepository.getRooms()) {
            if (room != null) {
                if (room.getStatus() == RoomStatus.free) {
                    futureRooms.add(room);
                }
            }
        }
        for (Guest guest : guestRepository.getGuests()) {
            if (guest != null) {
                if (guest.getEndTime() != null) {
                    if (guest.getEndTime().before(time)) {
                        futureRooms.add(guest.getRoom());
                    }
                }
            }
        }
        return futureRooms;
    }

    public String[] toStrings() {
        String[] strings = new String[getCountRoom()];
        int index = 0;
        for (Room room : roomRepository.getRooms()) {
            if (room != null) {
                strings[index++] = room.toString();
            }
        }
        return strings;
    }

    @Override
    public Boolean numberRoomExitstingCheck(Integer numberRoom) {
        for (Room room : roomRepository.getRooms()) {
            if (room.getNumberRoom() == numberRoom) {
                return true;
            }
        }
        return false;
    }

    public Room getGuestRoom(String name) {
        return guestRepository.getGuest(name).getRoom();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Room room : roomRepository.getRooms()) {
            if (room != null) {
                stringBuilder.append(room.toString() + "\n");
            }
        }
        return stringBuilder.toString();
    }


}
