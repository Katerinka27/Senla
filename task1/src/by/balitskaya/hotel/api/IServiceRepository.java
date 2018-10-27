package by.balitskaya.hotel.api;

import by.balitskaya.hotel.model.Service;

public interface IServiceRepository {
    public void addServiceFromFile(Service service);
    public void addService(Service service);
    public void changePrice(Integer numberService, double newPrice);
    public int countService();
    public Service getService(int numberService);

}
