package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestFileAndDirectoryDiscovery extends EnterpriseLangTest {

    private static class fileAndDirectoryDiscovery {
        public final UserAccount userAccount = new UserAccount("userAccount");
        public final AdminAccount adminAccount = new AdminAccount("adminAccount");
        public final OS os = new OS("os");
        
        public fileAndDirectoryDiscovery() {
            userAccount.addOs(os);
            adminAccount.addOs(os);

        }
    }

    @Test
    public void userRights(){
        var model = new fileAndDirectoryDiscovery();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

        model.userAccount.userRights.assertCompromisedInstantaneously();
    }

    @Test
    public void adminRights(){
        var model = new fileAndDirectoryDiscovery();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.adminAccount.adminRights);
        attacker.attack();

        model.adminAccount.adminRights.assertCompromisedInstantaneously();
    }

    @Test
    public void infectedOS(){
        var model = new fileAndDirectoryDiscovery();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.os.fileAndDirectoryDiscovery);
        attacker.attack();

        model.os.fileAndDirectoryDiscovery.assertCompromisedInstantaneously();
        model.os.automatedCollection.assertCompromisedInstantaneously();
    }
}