package by.balitskaya.hotel.util;

public class IdGenerator {
    private static Integer guestIdCounter;
    private static Integer serviceIdCounter;
    private static Integer roomIdCounter;


    public static Integer generateRoomId() {
        return ++roomIdCounter;
    }

    public static Integer generateServiceId() {
        return ++serviceIdCounter;
    }

    public static Integer generateGuestId() {
        return ++guestIdCounter;
    }


    public static void setInitialGuestId(Integer guestId) {
        IdGenerator.guestIdCounter = guestId;
    }

    public static void setInitialServiceId(Integer serviceId) {
        IdGenerator.serviceIdCounter = serviceId;
    }

    public static void setInitialRoomId(Integer roomId) {
        IdGenerator.roomIdCounter = roomId;
    }
}