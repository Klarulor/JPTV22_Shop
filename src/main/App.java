package main;

public class App {
    public void run(){
        Storage storage = new Storage();
        storage.init();
        ConsoleInterface consoleInterface = new ConsoleInterface();
        consoleInterface.load();
    }
}
