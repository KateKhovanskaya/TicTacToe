package org.example.DevelopersTeam;

public class Frontender extends Developer implements FrontendAction{
    @Override
    public void frontendCreating(){
        System.out.println("Пишет формы");
    }
}
