package com.mateo;

public class Main {

    public static void main(String[] args) {
        ClientsService clientService = new ClientsService();
        // Clients Grzegorz = clientService.createUser();
        // clientService.printData(Grzegorz);
        // FileHandling.Writer("/Users/mateuszosinski/Desktop/Java/Projects/src/com/mateo/users.txt", Clients.toFile(Grzegorz));
        clientService.login();
    }
}
