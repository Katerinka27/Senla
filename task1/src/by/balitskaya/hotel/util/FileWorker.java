package by.balitskaya.hotel.util;

import com.danco.training.TextFileWorker;
import by.balitskaya.hotel.manager.GuestManager;
import by.balitskaya.hotel.manager.RoomManager;
import by.balitskaya.hotel.manager.ServiceManager;

public class FileWorker {
    TextFileWorker textFileWorker;

    public FileWorker(String filePath, RoomManager roomManager) {
        textFileWorker = new TextFileWorker(filePath+ "/Rooms.txt");
    }
    public FileWorker(String filePath, ServiceManager serviceManager) {
        textFileWorker = new TextFileWorker(filePath+ "/Services.txt");
    }
    public FileWorker(String filePath, GuestManager guestManager) {
        textFileWorker = new TextFileWorker(filePath+ "/Guests.txt");
    }


    public String[] readFromFile() {
        return textFileWorker.readFromFile();
    }

    public void writeInFile(String[] strings) {
        textFileWorker.writeToFile(strings);
    }
}