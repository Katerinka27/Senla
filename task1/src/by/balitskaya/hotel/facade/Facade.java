package by.balitskaya.hotel.facade;

import by.balitskaya.hotel.api.IFacade;
import by.balitskaya.hotel.manager.RoomManager;
import by.balitskaya.hotel.model.Guest;
import by.balitskaya.hotel.model.Room;
import by.balitskaya.hotel.model.RoomStatus;
import by.balitskaya.hotel.model.Service;
import by.balitskaya.hotel.util.FileWorker;
import by.balitskaya.hotel.util.IdGenerator;
import by.balitskaya.hotel.util.LinkObjects;
import by.balitskaya.hotel.util.TextParser;
import by.balitskaya.hotel.util.sort.*;
import by.balitskaya.hotel.manager.GuestManager;
import by.balitskaya.hotel.manager.ServiceManager;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Facade implements IFacade {
    private static Facade facade;

    private RoomManager roomManager;
    private GuestManager guestManager;
    private ServiceManager serviceManager;

    private final String filePath;


    private Facade(final String filePath) {
        this.filePath = filePath;

        TextParser textParser = new TextParser();

        textParser.stringsToServiceRepository(readServices());
        textParser.stringsToGuestRepository(readGuest());
        textParser.stringsToRoomRepository(readRooms());

        roomManager = RoomManager.getInstance();
        guestManager = GuestManager.getInstance();
        serviceManager = ServiceManager.getInstance();

        new LinkObjects().link();
    }

    public static Facade getInstance(String filePath) {
        if (facade == null) {
            facade = new Facade(filePath);
        }
        return facade;
    }

    public static Facade getInstance() {
        if (facade == null) {
            return null;
        }
        return facade;
    }

    public String[] readRooms() {
        FileWorker fileWorker = new FileWorker(filePath, roomManager);
        return fileWorker.readFromFile();

    }

    public String[] readGuest() {
        FileWorker fileWorker = new FileWorker(filePath, guestManager);
        return fileWorker.readFromFile();

    }

    public String[] readServices() {
        FileWorker fileWorker = new FileWorker(filePath, serviceManager);
        return fileWorker.readFromFile();
    }

    public void writeInFile() {
        FileWorker fileWorker = new FileWorker(filePath, roomManager);
        fileWorker.writeInFile(roomManager.toStrings());
        fileWorker = new FileWorker(filePath, serviceManager);
        fileWorker.writeInFile(serviceManager.toStrings());
        fileWorker = new FileWorker(filePath, guestManager);
        fileWorker.writeInFile(guestManager.toStrings());
    }

    public Boolean nameExitstingCheck(String name) {
        return guestManager.isNameExist(name);
    }

    public Boolean numberRoomExitstingCheck(Integer numberRoom) {
        return roomManager.numberRoomExitstingCheck(numberRoom);
    }
    public Boolean numberServiceExitstingCheck(Integer numberService){
        return serviceManager.numberServiceExitstingCheck( numberService);
    }

    public Room roomGuest(String name) {
        return roomManager.getGuestRoom(name);
    }

    public List<Service> servicesGuest(String name) {
        return serviceManager.getGuestServices(name);
    }

    public List<Guest> lastGuestsInRoom(int numberRoom) {
        return guestManager.lastGuests(numberRoom);
    }

    public List<Room> roomsInFuture(Date Time) {
        return roomManager.roomInFuture(Time);
    }

    public double pricePerRoom(String name) {
        return guestManager.pricePerRoom(name);
    }

    public void evictFromRoom(String name) {
        guestManager.evictFromRoom(name);
    }

    public void settleGuestInRoom(String nameGuest, int numberRoom, Date startTime, Date endTime) {
        guestManager.settleInRoom(nameGuest, numberRoom, startTime, endTime);
    }

    public void changeRoomStatus(int numberRoom, RoomStatus roomStatus) {
        roomManager.changeRoomStatus(numberRoom, roomStatus);
    }

    public int countGuest() {
        return guestManager.countGuest();
    }

    public void addServiceToGuest(int numberService, String nameGuest) {
        guestManager.addServiceToGuest(numberService, nameGuest);
    }

    public List<Guest> sortedGuest(Comparator comparator) {
        return guestManager.sort(comparator);
    }

    public List<Room> sortedFreeRoom(Comparator comparator) {
        return roomManager.sortFreeRoom(comparator);
    }

    public List<Room> sortedRoom(Comparator comparator) {
        return roomManager.sort(comparator);
    }

    public List<Service> sortedService(Comparator comparator) {
        return serviceManager.sort(comparator);
    }


    public List<Room> sortedByPriceFreeRoom() {
        return roomManager.sortFreeRoom(new SortedByPriceRoom());
    }

    public List<Room> sortedByCapacityFreeRoom() {
        return roomManager.sortFreeRoom(new SortedByCapacityRoom());
    }


    public List<Room> sortedByStarFreeRoom() {
        return roomManager.sortFreeRoom(new SortedByStarRoom());
    }

    public List<Room> sortedByPriceRoom() {
        return roomManager.sort(new SortedByPriceRoom());
    }

    @Override
    public List<Room> sortedByCapacityRoom() {
        return roomManager.sort(new SortedByCapacityRoom());
    }

    @Override
    public List<Room> sortedByStarRoom() {
        return roomManager.sort(new SortedByStarRoom());
    }

    @Override
    public List<Guest> sortedByNameGuest() {
        return guestManager.sort(new SortedByNameGuest());
    }

    @Override
    public List<Guest> sortedByTimeGuest() {
        return guestManager.sort(new SortedByTimeGuest());
    }

    @Override
    public List<Service> sortedByPriceService() {
        return serviceManager.sort(new SortedByPriceService());
    }

    public String printAllRoom() {
        return roomManager.toString();
    }

    public String printInfoAboutRoom(int numberRoom) {
        return roomManager.informationAboutRoom(numberRoom);
    }


    public Object printAllServices() {
        return serviceManager;
    }

    public String printAllGuest() {
        return guestManager.toString();
    }

    public void changePriceRoom(int numberRoom, double newPrice) {
        roomManager.changePrice(numberRoom, newPrice);
    }

    public void changePriceService(Integer numberService, double newPrice) {
        serviceManager.changePrice(numberService, newPrice);
    }

    public void addService(Service service) {
        serviceManager.addService(service);
    }

    public int countRoom() {
        return roomManager.getCountRoom();
    }

    public int countFreeRoom() {
        return roomManager.countFreeRooms();
    }

    public void addRoom(Room room) {
        roomManager.addRoom(room);
    }

    public void addGuest(Guest guest) {
        guestManager.addGuest(guest);
    }
}
