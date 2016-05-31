package org.yomat;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The Bank class is the representation of a bank managing accounts for its clients
 * Created by hb on 25/05/2016.
 */
public class Bank {

    protected String name;
    protected ArrayList<Client> clients;
    protected ArrayList<Account> accounts;
    protected HashMap<String, Client> clientsByName; // TODO <String, ArrayList<Client>>
    protected HashMap<Client, ArrayList<Account>> accountsByClient; // TODO init in constructor

    public Bank(String name) {
        this.name = name;
        clients = new ArrayList<>();
        accounts = new ArrayList<>();
        clientsByName = new HashMap<>();
        accountsByClient = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public Client getClient(String firstName, String lastName) {
        return clientsByName.get(firstName + "." + lastName);
    }

    public void addClient(Client client) {
        clients.add(client);
        clientsByName.put(client.toString(), client);
    }

    public void addClient(String firstName, String lastName) {
        this.addClient(new Client(firstName, lastName));
    }

    public void removeClient(Client client){
        // remove from client listS
        clients.remove(client);
        clientsByName.remove(client);

        // client account list for this bank
        ArrayList<Account> clientBankAccounts = accountsByClient.get(client);

        //remove accounts
        for (Account account : clientBankAccounts){
            // from bank account list
            accounts.remove(account);
            // from client account list
            client.getAccounts().remove(account);
        }

        // remove client - accounts associations
        accountsByClient.remove(client);
    }

    public void removeClient(String firstName, String lastName){
        removeClient(clientsByName.get(clients.toString()));
    }

    public void openAccount(Client client){

    }

}
