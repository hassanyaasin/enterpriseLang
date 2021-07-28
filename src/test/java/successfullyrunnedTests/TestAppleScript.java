package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestAppleScript extends EnterpriseLangTest {

    private static class appleScript {
        public final UserAccount userAccount = new UserAccount("userAccount");
        public final OS os = new OS("os");
        public final Computer computer = new Computer("computer");
        public final MacOS macOS = new MacOS("macOS");
        
        public appleScript() {
           userAccount.addOs(os);
           computer.addOs(os); 
        }
    }

    @Test
    public void userRights(){
        var model = new appleScript();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

        //model.os.appleScript.assertCompromisedInstantaneously();
        model.os.accountDiscovery.assertCompromisedInstantaneously();
        model.os.domainDiscovery.assertCompromisedInstantaneously();
    }

    @Test
    public void infectedOS(){
        var model = new appleScript();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

        //model.os.appleScript.assertCompromisedInstantaneously();
        model.os.accountDiscovery.assertCompromisedInstantaneously();
        model.os.domainDiscovery.assertCompromisedInstantaneously();
    }

    @Test
    public void domainDiscovery(){
        var model = new appleScript();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();
        
        //model.os.appleScript.assertCompromisedInstantaneously();
        model.os.accountDiscovery.assertCompromisedInstantaneously();
        model.os.domainDiscovery.assertCompromisedInstantaneously();
    }
}