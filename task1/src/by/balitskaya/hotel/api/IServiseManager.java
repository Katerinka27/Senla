package by.balitskaya.hotel.api;

import by.balitskaya.hotel.model.Service;

import java.util.List;

public interface IServiсeManager {
    public void addService(Service service);
    public void changePrice(Integer idService, double newPrice);
    public int getCountServices();
    public String allServices();
    public String[] toStrings() ;
    public List<Service> getGuestServices(String name);

    Boolean numberServiceExitstingCheck(Integer numberService);
}
