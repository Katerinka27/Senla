package by.balitskaya.hotel.manager;

import by.balitskaya.hotel.api.IGuestManager;
import by.balitskaya.hotel.model.Guest;
import by.balitskaya.hotel.model.Room;
import by.balitskaya.hotel.model.RoomStatus;
import by.balitskaya.hotel.model.Service;
import by.balitskaya.hotel.repository.GuestRepository;
import by.balitskaya.hotel.repository.RoomRepository;
import by.balitskaya.hotel.repository.ServiceRepository;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class GuestManager implements IGuestManager {
    private static GuestManager guestManager;
    private RoomRepository roomRepository;
    private GuestRepository guestRepository;
    private ServiceRepository serviceRepository;


    private GuestManager() {
        roomRepository = RoomRepository.getInstance();
        guestRepository = GuestRepository.getGuestRepository();
        serviceRepository = ServiceRepository.getInstance();
    }

    public static GuestManager getInstance() {
        if (guestManager == null) {
            guestManager = new GuestManager();
        }
        return guestManager;
    }

    public Boolean isNameExist(String name) {
        for (Guest guest :
                guestRepository.getGuests()) {
            if (guest.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public List<Guest> lastGuests(int numberRoom) {
        Room room = roomRepository.getRoom(numberRoom);
        if (room == null) {

            return null;
        }
        return room.getPastGuests();
    }


    public double pricePerRoom(String name) {
        double allPrice = 0;
        Guest guest = guestRepository.getGuest(name);
        if (guest == null) {

            return -1;
        }
        allPrice += guest.getRoom().getPrice();
        for (Service service : guest.getServices()) {
            if (service != null)
                allPrice += service.getPrice();
        }

        return allPrice;
    }


    //селит гостя в номер,добавить что если не занят то добовляет, и потом еще сравнение по дате
    public void settleInRoom(String name, int numberRoom, Date startTime, Date endTime) {
        Guest guest = guestRepository.getGuest(name);
        if (guest == null) {

            return;
        }
        Room room = roomRepository.getRoom(numberRoom);
        if (room == null) {

            return;
        }
        guest.setStartTime(startTime);
        guest.setEndTime(endTime);
        room.setStatus(RoomStatus.busy);
        guest.setRoom(room);
        room.addPastGuest(guest);
    }

    public void evictFromRoom(String name) {

        guestRepository.getGuest(name).getRoom().setStatus(RoomStatus.free);
        guestRepository.getGuest(name).setRoom(null);

    }

    public void addGuest(Guest guest) {
        guestRepository.addGuest(guest);
    }


    public void addServiceToGuest(int numberService, String nameGuest) {
        List<Service> services;
        List<Guest> guests = guestRepository.getGuests();
        for (Guest guest : guests) {
            if (guest != null) {
                if (guest.getName().equals(nameGuest)) {

                    services = guest.getServices();
                    services.add(serviceRepository.getService(numberService));
                    guest.setServices(services);
                }
            }
        }
        guestRepository.setGuests(guests);
    }

    public List<Guest> sort(Comparator comparator) {
        List<Guest> guests = guestRepository.getGuests();
        guests.sort(comparator);
        return guests;
    }

    public int countGuest() {
        int count = 0;
        for (Guest guest : guestRepository.getGuests()) {
            if (guest != null) {
                count++;
            }
        }
        return count;
    }

    public String[] toStrings() {
        String[] strings = new String[countGuest()];
        int index = 0;
        for (Guest guest : guestRepository.getGuests()) {
            if (guest != null) {
                strings[index++] = guest.toString();
            }
        }
        return strings;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("");
        for (Guest guest : guestRepository.getGuests()) {
            if (guest != null) {
                string.append(guest.toString());
                string.append("\n");
            }
        }
        return string.toString();
    }


}
