package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestBypassUserAccountControl extends EnterpriseLangTest {

    private static class bypassUserAccountControl {
        public final UserAccount userAccount = new UserAccount("userAccount");
        public final AdminAccount adminAccount = new AdminAccount("adminAccount");
      //  public final OS os = new OS("os",false,false,false,false,false,false,false,false,false,
        //false,false,false,false,false,false,false,false,false,false,
        //false,false,false,false,false,false,false,false);
        public final OS os = new OS("os");
        public final Computer computer = new Computer("computer");
        public final Windows windows = new Windows("windows");
        
        public bypassUserAccountControl() {
            userAccount.addOs(windows);
            adminAccount.addOs(windows);
            computer.addOs(windows);
            //os.addOs(windows);
        }
    }

    @Test
    public void userRights(){
        var model = new bypassUserAccountControl();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

        model.userAccount.userRights.assertCompromisedInstantaneously();
    }

    @Test
    public void adminRights(){
        var model = new bypassUserAccountControl();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.adminAccount.adminRights);
        attacker.attack();

        model.adminAccount.adminRights.assertCompromisedInstantaneously();
    }

    @Test
    public void infectedOS(){
        var model = new bypassUserAccountControl();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.os.infectedOS);
        attacker.attack();

        //model.windows.bypassUserAccountControl.assertCompromisedInstantaneously();
        model.os.bypassHostIntrusionPrevention.assertCompromisedInstantaneously();
        model.os.bypassHostForensicAnalysis.assertCompromisedInstantaneously();
        //model.os.bypassUserAccessControl.assertCompromisedInstantaneously();
        model.os.executeCode.assertCompromisedInstantaneously();
    }

    @Test
    public void infectedHardware(){
        var model = new bypassUserAccountControl();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.os.bypassUserAccountControl);
        attacker.attack();

        model.computer.infectedComputer.assertCompromisedInstantaneously();
    }
}