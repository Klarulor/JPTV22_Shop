package main;

import main.utils.SQLConnector;

public class App {
    public void run(){
        (new SQLConnector()).connect();
        Storage storage = new Storage();
        storage.init();
        ConsoleInterface consoleInterface = new ConsoleInterface();
        consoleInterface.load();
    }
}
