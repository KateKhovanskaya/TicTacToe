package org.example;

import org.example.DevelopersTeam.Developer;
import org.example.DevelopersTeam.Frontender;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        GameWindow gameWindow= new GameWindow();
//        ServerRun myServer = new ServerRun();
//        Chat chat = new Chat();
        Developer dev = new Frontender();
        if(dev instanceof Frontender) ((Frontender) dev).frontendCreating();
    }
}