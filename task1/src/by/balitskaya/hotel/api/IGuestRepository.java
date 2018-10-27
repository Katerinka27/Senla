package by.balitskaya.hotel.api;

import by.balitskaya.hotel.model.Guest;

import java.util.List;

public interface IGuestRepository {
    public void addGuestFromFile(Guest guest);
    public void addGuest(Guest guest);
    public List<Guest> getGuests();
    public void setGuests(List<Guest> guests);
    public Guest getGuest(String name);
}
