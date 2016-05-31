package org.yomat;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * Created by Matthias Mailliard on 31/05/2016.
 */
public class TestAccount {

    private static Bank CA, BP;
    private static Client crystal, tina, zoubir;
    private static Account c1_CA, c2_CA, c3_BP, t_CA, z_BP;
    private double c1_pognon = 1000; // CA
    private double c2_pognon = 2000; // CA
    private double c3_pognon = 0;    // BP
    private double t_pognon = 50;    // CA
    private double z_pognon = 700;   // BP

    @Before
    public void init(){
        // Banks
        CA = new Bank("CA"){
            public boolean exist(){return true;}
        };
        BP = new Bank("BP");

        // Users, their accounts
        crystal = new Client("Crystal", "Zoïstra");
        c1_CA = new Account(crystal, CA, c1_pognon);
        c2_CA = new Account(crystal, CA, c2_pognon);
        c3_BP = new Account(crystal, BP, c3_pognon);

        tina = new Client("Tina", "Turner");
        t_CA = new Account(tina, CA, t_pognon);

        zoubir = new Client("Zoubir", "Morebir");
        z_BP = new Account(zoubir, BP, z_pognon);

        // adding clients
        CA.addClient(crystal);
        CA.addClient(tina);
        BP.addClient(crystal);
        BP.addClient(zoubir);

        // adding accounts
        ArrayList<Account> caAccounts = new ArrayList<>();
        for(Account account : new Account[]{c1_CA, c2_CA, t_CA})
            caAccounts.add(account);
        CA.setAccounts(caAccounts);
        ArrayList<Account> bpAccounts = new ArrayList<>();
        for(Account account : new Account[]{c3_BP, z_BP})
            bpAccounts.add(account);
        BP.setAccounts(bpAccounts);
    }

    @Test
    public void testInitStructure(){
        // number of clients
        assertTrue( 2 == CA.getClients().size() );
        assertTrue( 2 == BP.getClients().size() );

        // accounts
        int sum = 0;
        for (Account account : CA.getAccounts())
            sum += account.getBalance();
        assertTrue(3050 == sum);

        for (Account account : BP.getAccounts())
            sum += account.getBalance();
        assertTrue(3750 == sum);
    }
}
