package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestFileAndDirectoryPermissionsModification extends EnterpriseLangTest {

    private static class fileAndDirectoryPermissionsModification {
        public final UserAccount userAccount = new UserAccount("userAccount");
        public final AdminAccount adminAccount = new AdminAccount("adminAccount");
        public final OS os = new OS("os");
        public final Windows windows = new Windows("windows");
        public final MacOS macOS = new MacOS("macOS");
        
        public fileAndDirectoryPermissionsModification() {
            userAccount.addOs(os);
            adminAccount.addOs(os);
        }
    }

    @Test
    public void userRights(){
        var model = new fileAndDirectoryPermissionsModification();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

        model.userAccount.userRights.assertCompromisedInstantaneously();
    }

    @Test
    public void adminRights(){
        var model = new fileAndDirectoryPermissionsModification();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.adminAccount.adminRights);
        attacker.attack();

        model.adminAccount.adminRights.assertCompromisedInstantaneously();
    }

    @Test
    public void infectedOS(){
        var model = new fileAndDirectoryPermissionsModification();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.os.infectedOS);
        attacker.attack();

        model.os.fileAndDirectoryDiscovery.assertCompromisedInstantaneously();
        //model.os.bypassFileSystemAccessControls.assertCompromisedInstantaneously();
    }
/*
    @Test
    public void infectedWindowsComputer(){
        var model = new fileAndDirectoryPermissionsModification();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.os.fileAndDirectoryPermissionsModification);
        attacker.attack();

        model.os.accessibilityFeatures.assertCompromisedInstantaneously();
        model.windows.logonScripts.assertCompromisedInstantaneously();
    }
*/
     @Test
    public void infectedMacOSComputer(){
        var model = new fileAndDirectoryPermissionsModification();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.os.fileAndDirectoryPermissionsModification);
        attacker.attack();

        model.macOS.attemptBootOrLogonInitializationScripts.assertCompromisedInstantaneously();
        model.macOS.bootOrLogonInitializationScripts.assertCompromisedInstantaneously();
        model.macOS.attemptLogonScripts.assertCompromisedInstantaneously();
        model.macOS.logonScripts.assertCompromisedInstantaneously();
    }
}