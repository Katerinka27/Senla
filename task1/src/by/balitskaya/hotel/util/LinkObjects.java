package by.balitskaya.hotel.util;

import by.balitskaya.hotel.model.Guest;
import by.balitskaya.hotel.model.Service;
import by.balitskaya.hotel.repository.GuestRepository;
import by.balitskaya.hotel.model.Room;
import by.balitskaya.hotel.repository.RoomRepository;
import by.balitskaya.hotel.repository.ServiceRepository;

import java.util.ArrayList;
import java.util.List;

public class LinkObjects {
    public void link() {
        RoomRepository roomRepository = RoomRepository.getInstance();
        GuestRepository guestRepository = GuestRepository.getGuestRepository();
        ServiceRepository serviceRepository = ServiceRepository.getInstance();
        List<Guest> guests = guestRepository.getGuests();
        for (Guest guest : guests) {
            if (guest != null) {
                List<Service> services = new ArrayList<>();
                for (int i = 0; i < guest.getServices().size(); i++) {
                    if (guest.getServices().get(i) != null) {
                        services.add(serviceRepository.getService(guest.getServices().get(i).getNumberService()));
                    }
                }
                guest.setServices(services);

                if (guest.getRoom() != null) {
                    guest.setRoom(roomRepository.getRoom(guest.getRoom().getNumberRoom()));
                }
            }
        }
        for (Room room : roomRepository.getRooms()) {
            if (room != null) {
                List<Guest> pastGuests = new ArrayList<>();
                for (int i = 0; i < room.getPastGuests().size(); i++) {
                    if (room.getPastGuests().get(i) != null) {
                        pastGuests.add(guestRepository.getGuest(room.getPastGuests().get(i).getName()));
                    }
                }
                room.setPastGuests(pastGuests);
            }
        }
    }
}
