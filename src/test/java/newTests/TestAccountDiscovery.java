package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestAccountDiscovery extends EnterpriseLangTest {

    private static class accountDiscovery {
        public final UserAccount userAccount = new UserAccount("userAccount");
        public final OS os = new OS("os");
        public final Computer computer = new Computer("computer");
        
        public accountDiscovery() {
           userAccount.addOs(os);
           computer.addOs(os); 

        }
    }

    @Test
    public void userRights(){
        var model = new accountDiscovery();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

        model.os.accountDiscovery.assertCompromisedInstantaneously();
        model.os.domainDiscovery.assertCompromisedInstantaneously();
    }

    @Test
    public void infectedOS(){
        var model = new accountDiscovery();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

        model.os.accountDiscovery.assertCompromisedInstantaneously();
        model.os.domainDiscovery.assertCompromisedInstantaneously();
    }

    @Test
    public void domainDiscovery(){
        var model = new accountDiscovery();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();
        
        model.os.accountDiscovery.assertCompromisedInstantaneously();
        model.os.domainDiscovery.assertCompromisedInstantaneously();
    }
}