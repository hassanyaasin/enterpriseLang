package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestApplicationWindowDiscovery extends EnterpriseLangTest {

    private static class applicationWindowDiscovery {
        public final UserAccount userAccount = new UserAccount("userAccount");
        public final OS os = new OS("os");

        public applicationWindowDiscovery() {
           userAccount.addOs(os);
        }
        
        
    }
    
    @Test
    public void userRights(){
        var model = new applicationWindowDiscovery();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

        model.os.applicationWindowDiscovery.assertCompromisedInstantaneously();
    }
}