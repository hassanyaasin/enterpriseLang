package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestStoredDataManipulation extends EnterpriseLangTest {

    private static class storedDataManipulation {
        public final UserAccount userAccount = new UserAccount("userAccount");
        public final AdminAccount adminAccount = new AdminAccount("adminAccount");
        public final OS os = new OS("os");

        public storedDataManipulation() {
            userAccount.addOs(os);
            adminAccount.addOs(os);
        }
    }

    @Test
    public void userRights(){
        var model = new storedDataManipulation();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

        model.userAccount.userRights.assertCompromisedInstantaneously();
    }

    @Test
    public void adminRights(){
        var model = new storedDataManipulation();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.adminAccount.adminRights);
        attacker.attack();

        model.adminAccount.adminRights.assertCompromisedInstantaneously();
    }

    @Test
    public void infectedOS(){
        var model = new storedDataManipulation();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.os.storedDataManipulation);
        attacker.attack();

        model.os.storedDataManipulation.assertCompromisedInstantaneously();
    }
}