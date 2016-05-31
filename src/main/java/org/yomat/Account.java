package org.yomat;

/**
 * Created by hb on 25/05/2016.
 */
public class Account {

    protected String number;
    protected double balance;
    protected Client client;
    protected Bank bank;

    public Account(Client client, Bank bank) {
        this(client, bank, 0);
    }

    public Account(Client client, Bank bank, double balance) {
        this.client = client;
        this.bank = bank;
        this.balance = balance;
        number = client+"_"+bank+RandomGenerator.nextLong(9223372036854775807L);
        client.getAccounts().add(this);
    }

    public String getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public Client getClient() {
        return client;
    }

    public Bank getBank() {
        return bank;
    }

    public void credit(double amount){
        balance += amount;
    }

    public void debit(double amount){
        balance -= amount;
    }
}
