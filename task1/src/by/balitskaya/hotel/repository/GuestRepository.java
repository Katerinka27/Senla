package by.balitskaya.hotel.repository;

import by.balitskaya.hotel.api.IGuestRepository;
import by.balitskaya.hotel.model.Guest;
import by.balitskaya.hotel.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class GuestRepository implements IGuestRepository {
    static private GuestRepository guestRepository;



    private List<Guest> guests;

    private GuestRepository(){
        guests=new ArrayList<>();
    }

    public static GuestRepository getGuestRepository() {
        if(guestRepository==null) {
            guestRepository=new GuestRepository();
        }
        return guestRepository;
    }

    public void addGuestFromFile(Guest guest){
        guests.add(guest);
    }

    public void addGuest(Guest guest) {
        IdGenerator.setInitialGuestId(getMaxId());
        guest.setId(IdGenerator.generateGuestId());
        guests.add(guest);
    }
    private int getMaxId(){
        int max=0;
        for(Guest guest:guests){
            if(max<guest.getId()){
                max=guest.getId();
            }
        }
        return max;
    }
    public int countGuest(){
        return guests.size();
    }
    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }
    public Guest getGuest(String name){
        for(Guest guest:guests){
            if(guest!=null){
                if(guest.getName().equals(name)){
                    return guest;
                }
            }
        }
        return null;
    }
}
