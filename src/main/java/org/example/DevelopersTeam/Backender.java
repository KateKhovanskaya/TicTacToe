package org.example.DevelopersTeam;

public class Backender extends Developer implements BackendAction{
    @Override
    public void backendCreating(){
        System.out.println("Пишет серверный код");
    }
}
