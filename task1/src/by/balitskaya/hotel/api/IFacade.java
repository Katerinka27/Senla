package by.balitskaya.hotel.api;

import by.balitskaya.hotel.model.Guest;
import by.balitskaya.hotel.model.Room;
import by.balitskaya.hotel.model.RoomStatus;
import by.balitskaya.hotel.model.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

public interface IFacade {
    public Room roomGuest(String name);

    public List<Service> servicesGuest(String name);

    public String[] readRooms();

    public String[] readGuest();

    public String[] readServices();

    public void writeInFile();

    public List<Guest> lastGuestsInRoom(int numberRoom);

    public List<Room> roomsInFuture(Date Time);

    public double pricePerRoom(String name);

    public void evictFromRoom(String name);

    public void settleGuestInRoom(String nameGuest, int numberRoom, Date startTime, Date endTime);

    public void changeRoomStatus(int numberRoom, RoomStatus roomStatus);

    public int countGuest();

    public void addServiceToGuest(int numberService, String nameGuest);

    public List<Room> sortedByPriceFreeRoom();

    public List<Room> sortedByCapacityFreeRoom();

    public List<Room> sortedByStarFreeRoom();

    public List<Guest> sortedGuest(Comparator comparator);

    public List<Room> sortedFreeRoom(Comparator comparator);

    public List<Room> sortedRoom(Comparator comparator);

    public List<Service> sortedService(Comparator comparator);

    public List<Room> sortedByPriceRoom();

    public List<Room> sortedByCapacityRoom();

    public List<Room> sortedByStarRoom();

    public List<Guest> sortedByNameGuest();

    public List<Guest> sortedByTimeGuest();

    public List<Service> sortedByPriceService();

    public String printAllRoom();

    public String printInfoAboutRoom(int numberRoom);

    public Object printAllServices();

    public String printAllGuest();

    public void changePriceRoom(int numberRoom, double newPrice);

    public void changePriceService(Integer id, double newPrice);

    public void addService(Service service);

    public int countRoom();

    public int countFreeRoom();

    public void addRoom(Room room);

    public void addGuest(Guest guest);

    public Boolean nameExitstingCheck(String name);
}