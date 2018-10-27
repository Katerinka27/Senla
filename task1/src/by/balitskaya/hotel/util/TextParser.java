package by.balitskaya.hotel.util;

import by.balitskaya.hotel.model.Guest;
import by.balitskaya.hotel.model.Room;
import by.balitskaya.hotel.model.RoomStatus;
import by.balitskaya.hotel.model.Service;
import by.balitskaya.hotel.repository.GuestRepository;
import by.balitskaya.hotel.repository.RoomRepository;
import by.balitskaya.hotel.repository.ServiceRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TextParser {
    public ServiceRepository stringsToServiceRepository(String[] strings) {
        ServiceRepository serviceRepository = ServiceRepository.getInstance();
        if (strings == null) {
            return serviceRepository;
        }
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] != null) {
                String[] stringsNameElementAndElement = strings[i].split(";|:");
                int numberService = Integer.parseInt(stringsNameElementAndElement[1]);
                double price = Double.parseDouble(stringsNameElementAndElement[3]);
                String info = stringsNameElementAndElement[5];

                serviceRepository.addServiceFromFile(new Service(numberService, price, info));
            }
        }

        return serviceRepository;
    }

    private RoomStatus parseToStatus(String string) {
        if (string.equals("free"))
            return RoomStatus.free;
        if (string.equals("busy"))
            return RoomStatus.busy;
        if (string.equals("repairable"))
            return RoomStatus.repairable;
        if (string.equals("serviced"))
            return RoomStatus.serviced;
        return RoomStatus.free;

    }

    public RoomRepository stringsToRoomRepository(String[] strings) {
        RoomRepository roomRepository = RoomRepository.getInstance();
        if (strings == null) {
            return roomRepository;
        }
        for (int i = 0; i < strings.length; i++) {
            String[] stringsObject = strings[i].split(":|;|,");
            int numberRoom = Integer.parseInt(stringsObject[1]);
            double price = Double.parseDouble(stringsObject[3]);
            int capacity = Integer.parseInt(stringsObject[5]);
            int star = Integer.parseInt(stringsObject[7]);
            RoomStatus status = parseToStatus(stringsObject[9]);
            int index = 11;
            List<Guest> pastGuest = new ArrayList<>();//Guest[stringsObject.length-index];
            for (int j = index; j < stringsObject.length; j++) {
                pastGuest.add(new Guest(stringsObject[j]));
            }
            roomRepository.addRoomFromFile(new Room(numberRoom, price, capacity, star, status, pastGuest));

        }
        return roomRepository;
    }

    private Date parseToCalendar(String string) {
        String[] strings = string.split("\\.");
        return new Date(Integer.parseInt(strings[2]), Integer.parseInt(strings[1]), Integer.parseInt(strings[0]));
    }

    public GuestRepository stringsToGuestRepository(String[] strings) {
        GuestRepository guestRepository = GuestRepository.getGuestRepository();
        for (String stringObject : strings) {
            if (stringObject != null) {
                String[] stringsObject = stringObject.split(";|,|:");
                String name = stringsObject[1];
                Room numberRoom;
                if (!stringsObject[3].equals("null")) {
                    numberRoom = new Room(Integer.parseInt(stringsObject[3]));
                } else {
                    numberRoom = null;
                }
                Date timeStart = null;
                Date endTime = null;
                int indexStartNumberServices = 5;
                if (stringsObject[4].equals("TimeStart")) {
                    timeStart = parseToCalendar(stringsObject[5]);
                    endTime = parseToCalendar(stringsObject[7]);
                    indexStartNumberServices = 9;
                }
                List<Service> services = new ArrayList<>();
                for (int i = indexStartNumberServices; i < stringsObject.length; i++) {
                    services.add(new Service(Integer.parseInt(stringsObject[i])));
                }
                guestRepository.addGuestFromFile(new Guest(name, timeStart, endTime, numberRoom, services));
            }
        }
        return guestRepository;
    }

}
