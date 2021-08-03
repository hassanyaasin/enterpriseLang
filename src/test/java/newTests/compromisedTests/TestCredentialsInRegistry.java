package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestCredentialsInRegistry extends EnterpriseLangTest {

    private static class credentialsInRegistry {
        public final UserAccount userAccount = new UserAccount("userAccount");
        public final AdminAccount adminAccount = new AdminAccount("adminAccount");
        public final OS os = new OS("os");
        
        public credentialsInRegistry() {
            userAccount.addOs(os);
            adminAccount.addOs(os);

        }
    }

    @Test
    public void userRights_adminRights(){
        var model = new credentialsInRegistry();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.os.credentialsInRegistry);
        attacker.attack();

        model.os.credentialsInRegistry.assertCompromisedInstantaneously();
    }

    @Test
    public void userCredentials(){
        var model = new credentialsInRegistry();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userCredentials);
        attacker.attack();

        model.userAccount.userCredentials.assertCompromisedInstantaneously();
    }
/*
    @Test
    public void adminRights(){
        var model = new credentialsInRegistry();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.adminAccount.adminRights);
        attacker.attack();

        model.os.credentialsInRegistry.assertCompromisedInstantaneously();
    }
*/
    @Test
    public void adminCredentials(){
        var model = new credentialsInRegistry();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.adminAccount.adminCredentials);
        attacker.attack();

        model.adminAccount.adminCredentials.assertCompromisedInstantaneously();
    }
/*
    @Test
    public void infectedOS(){
        var model = new credentialsInRegistry();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.os.credentialsInRegistry);
        attacker.attack();

        model.os.credentialsInRegistry.assertCompromisedInstantaneously();
    }
*/
}