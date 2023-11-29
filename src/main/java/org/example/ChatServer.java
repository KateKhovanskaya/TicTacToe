package org.example;

public class ChatServer implements ButtonsListener{
    private boolean isServisWorking;
    private final Listener listener;

    public ChatServer(Listener listener){
        this.listener = listener;
        isServisWorking = false;
    }

    private void startServer(){
        if(!isServisWorking){
            isServisWorking = true;
            listener.messageRes("ServerIsWorking: "+ isServisWorking);
        }else{
            listener.messageRes("Server Is Already Working");
        }
    }

    private void stopServer(){
        if(isServisWorking){
            isServisWorking = false;
            listener.messageRes("ServerIsWorking: "+ isServisWorking);
        }else{
            listener.messageRes("Server Is Already stoped");
        }
    }

    @Override
    public void listeningButtonCommands(boolean status){
        if(status) startServer();
        else stopServer();
    }
}
