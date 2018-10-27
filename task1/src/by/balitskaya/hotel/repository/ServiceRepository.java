package by.balitskaya.hotel.repository;


import by.balitskaya.hotel.api.IServiceRepository;
import by.balitskaya.hotel.model.Service;
import by.balitskaya.hotel.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements IServiceRepository {
    static private ServiceRepository serviceRepository;

    public static ServiceRepository getInstance() {
        if(serviceRepository==null) {
            serviceRepository=new ServiceRepository();
        }
        return serviceRepository;
    }
    private List<Service> services;

    private ServiceRepository() {

        services=new ArrayList<>();
    }

    public void addServiceFromFile(Service service){
        services.add(service);
    }

    public void addService(Service service){
        IdGenerator.setInitialServiceId(getMaxId());
        service.setNumberService(IdGenerator.generateServiceId());
        services.add(service);
    }
    private int getMaxId(){
        int max=0;
        for(Service service:services){
            if(max<service.getNumberService()){
                max=service.getNumberService();
            }
        }
        return max;
    }
    public void changePrice(Integer numberService,double newPrice){
        getService(numberService).setPrice(newPrice);
    }
    public int countService(){
        int countService=0;
        for(Service service:services){
            if(service!=null){
                countService++;
            }
        }
        return countService;
    }
    public Service getService(int numberService){
        for(Service service:services){
            if(service!=null)
            if(service.getNumberService()==numberService)
                return service;
        }
        return null;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }


}
