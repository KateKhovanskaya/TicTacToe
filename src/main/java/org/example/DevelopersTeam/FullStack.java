package org.example.DevelopersTeam;

public class FullStack extends Developer implements BackendAction, FrontendAction{
    @Override
    public void backendCreating(){
        System.out.println("Пишет серверный код");
    }
    @Override
    public void frontendCreating(){
        System.out.println("Пишет формы");
    }
}
