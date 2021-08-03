package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestFileSystemPermissionsWeakness extends EnterpriseLangTest {

    private static class fileSystemPermissionsWeakness {
        public final UserAccount userAccount = new UserAccount("userAccount");
        public final AdminAccount adminAccount = new AdminAccount("adminAccount");
        public final OS os = new OS("os");
        public final Windows windows = new Windows("windows");
    }

    @Test
    public void userRights(){
        var model = new fileSystemPermissionsWeakness();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

        model.userAccount.userRights.assertCompromisedInstantaneously();
    }

    @Test
    public void adminRights(){
        var model = new fileSystemPermissionsWeakness();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.adminAccount.adminRights);
        attacker.attack();

        model.adminAccount.adminRights.assertCompromisedInstantaneously();
    }

    @Test
    public void infectedOS(){
        var model = new fileSystemPermissionsWeakness();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.os.infectedOS);
        attacker.attack();

        model.windows.attemptFileSystemPermissionsWeakness.assertCompromisedInstantaneously();
        model.windows.fileSystemPermissionsWeakness.assertCompromisedInstantaneously();
        //model.os.hiddenFileSystem.assertCompromisedInstantaneously();
        //model.os.bypassFileSystemAccessControls.assertCompromisedInstantaneously();
        //model.os.fileSystemLogicalOffsets.assertCompromisedInstantaneously();
        //model.os.fileAndDirectoryDiscovery.assertCompromisedInstantaneously();
        model.os.executeCode.assertCompromisedInstantaneously();
    }
}