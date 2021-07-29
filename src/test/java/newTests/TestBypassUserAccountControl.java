package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestBypassUserAccountControl extends EnterpriseLangTest {

    private static class bypassUserAccountControl {
        public final UserAccount userAccount = new UserAccount("userAccount");
        public final AdminAccount adminAccount = new AdminAccount("adminAccount");
        public final OS os = new OS("os");
        public final Computer computer = new Computer("computer");
        
        public bypassUserAccountControl() {
            userAccount.addOs(os);
            adminAccount.addOs(os);
            computer.addOs(os); 

        }
    }

    @Test
    public void userRights(){
        var model = new bypassUserAccountControl();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

        model.os.bypassUserAccountControl.assertCompromisedInstantaneously();
    }

    @Test
    public void adminRights(){
        var model = new bypassUserAccountControl();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.adminAccount.adminRights);
        attacker.attack();

        model.os.bypassUserAccountControl.assertCompromisedInstantaneously();
    }

    @Test
    public void infectedOS(){
        var model = new bypassUserAccountControl();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.os.bypassUserAccessControl);
        attacker.attack();

        model.os.bypassUserAccountControl.assertCompromisedInstantaneously();
        model.os.executeCode.assertCompromisedInstantaneously();
    }
/*
    @Test
    public void infectedHardware(){
        var model = new bypassUserAccountControl();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.os.bypassUserAccountControl);
        attacker.attack();

        model.computer.infectedWindowsComputer.assertCompromisedInstantaneously();
    }*/
}