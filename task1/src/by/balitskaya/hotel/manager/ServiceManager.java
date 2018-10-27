package by.balitskaya.hotel.manager;

import by.balitskaya.hotel.api.IServiseManager;
import by.balitskaya.hotel.model.Service;
import by.balitskaya.hotel.repository.GuestRepository;
import by.balitskaya.hotel.repository.RoomRepository;
import by.balitskaya.hotel.repository.ServiceRepository;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ServiceManager implements IServiseManager {
    private static ServiceManager serviceManager;

    private RoomRepository roomRepository;
    private GuestRepository guestRepository;
    private ServiceRepository serviceRepository;

    private ServiceManager() {
        roomRepository = RoomRepository.getInstance();
        guestRepository = GuestRepository.getGuestRepository();
        serviceRepository = ServiceRepository.getInstance();
    }


    public static ServiceManager getInstance() {
        if (serviceManager == null) {
            serviceManager = new ServiceManager();
        }
        return serviceManager;
    }

    //добавить сервис
    public void addService(Service service) {
        serviceRepository.addService(service);
    }

    public void changePrice(Integer numberService, double newPrice) {
            serviceRepository.changePrice(numberService, newPrice);
    }

    public int getCountServices() {
        int count = 0;
        for (Service service : serviceRepository.getServices()) {
            if (service != null) {
                count++;
            }
        }
        return count;
    }

    public String allServices() {
        return serviceRepository.toString();
    }

    public List<Service> sort(Comparator comparator) {
        List<Service> services = serviceRepository.getServices();
        services.sort(comparator);
        return services;
    }

    public String[] toStrings() {
        String[] strings = new String[getCountServices()];
        int index = 0;
        for (Service service : serviceRepository.getServices()) {
            if (service != null) {
                strings[index++] = service.toString();
            }
        }
        return strings;
    }

    public List<Service> getGuestServices(String name) {
        List<Service> services = new ArrayList<>();
            services = guestRepository.getGuest(name).getServices();
        return services;
    }

    @Override
    public Boolean numberServiceExitstingCheck(Integer numberService) {
        for (Service service : serviceRepository.getServices()) {
            if (service.getNumberService() == numberService) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Service service : serviceRepository.getServices()) {
            if (service != null) {
                stringBuilder.append(service.toString());
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }


}
