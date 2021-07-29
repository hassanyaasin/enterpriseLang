package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestClipboardData extends EnterpriseLangTest {

    private static class clipboardData {
        public final AdminAccount adminAccount = new AdminAccount("adminAccount");
        public final UserAccount userAccount = new UserAccount("userAccount");
        public final OS os = new OS("os");

        public clipboardData(){
            adminAccount.addOs(os);
            userAccount.addOs(os);
        }
        
    }
    
    @Test
    public void adminCredentials(){
        var model = new clipboardData();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.adminAccount.adminCredentials);
        attacker.attack();

        model.adminAccount.adminRights.assertCompromisedInstantaneously();
        model.os.resourceHijacking.assertCompromisedInstantaneously();
    }

    @Test
    public void userCredentials(){
        var model = new clipboardData();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userCredentials);
        attacker.attack();

        model.userAccount.userRights.assertCompromisedInstantaneously();
        model.os.resourceHijacking.assertCompromisedInstantaneously();
    }
}