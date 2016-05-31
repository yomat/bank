package org.yomat;

import java.util.ArrayList;

/**
 * Created by hb on 25/05/2016.
 */
public class Client {

    protected String firstName;
    protected String lastName;
    protected ArrayList<Account> accounts;

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        accounts = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o){
        return (
                o instanceof Client &&
                ((Client)o).firstName.equals(firstName) &&
                ((Client)o).lastName.equals(lastName)
        );
    }

    @Override
    public int hashCode() {
        int iTotal = 17;
        int iConstant = 37;
        iTotal = iTotal * iConstant + toString().hashCode();
        return iTotal;
    }

    @Override
    public String toString(){
        return firstName+"."+lastName;
    }
}
