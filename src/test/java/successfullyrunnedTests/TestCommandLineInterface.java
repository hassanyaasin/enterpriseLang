package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestCommandLineInterface extends EnterpriseLangTest {

    private static class commandLineInterface {
        public final UserAccount userAccount = new UserAccount("userAccount");
        public final AdminAccount adminAccount = new AdminAccount("adminAccount");
        public final OS os = new OS("os");

        public commandLineInterface() {
           userAccount.addOs(os);
           adminAccount.addOs(os);
        }
        
        
    }
    
    @Test
    public void userCommandLineInterface(){
        var model = new commandLineInterface();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

        model.os.userCommandLineInterface.assertCompromisedInstantaneously();
    }

    @Test
    public void adminCommandLineInterface(){
        var model = new commandLineInterface();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.adminAccount.adminRights);
        attacker.attack();

        model.os.adminCommandLineInterface.assertCompromisedInstantaneously();
    }
}