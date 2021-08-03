package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestDeobfuscateOrDecodeFilesOrInformation extends EnterpriseLangTest {

    private static class deobfuscateOrDecodeFilesOrInformation {
        public final UserAccount userAccount = new UserAccount("userAccount");
        public final OS os = new OS("os");
        public final Windows windows = new Windows("windows");
        public final ExternalNetwork externalNetwork = new ExternalNetwork("externalNetwork");
        public final InternalNetwork internalNetwork = new InternalNetwork("internalNetwork");

        public deobfuscateOrDecodeFilesOrInformation() {
            userAccount.addOs(windows);
        }
    }

    @Test
    public void userRights(){
        var model = new deobfuscateOrDecodeFilesOrInformation();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

        model.userAccount.userRights.assertCompromisedInstantaneously();
    }

    @Test
    public void infectedOS(){
        var model = new deobfuscateOrDecodeFilesOrInformation();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.os.deobfuscateOrDecodeFilesOrInformation);
        attacker.attack();

        model.os.obfuscatedFilesOrInformation.assertCompromisedInstantaneously();
        model.os.bypassAntivirus.assertCompromisedInstantaneously();
        model.os.bypassHostIntrusionPrevention.assertCompromisedInstantaneously();
        model.os.bypassSignatureBasedDetection.assertCompromisedInstantaneously();

        model.windows.deobfuscateOrDecodeFilesOrInformation.assertCompromisedInstantaneously();
    }

    @Test
    public void infectedExternalNetwork(){
        var model = new deobfuscateOrDecodeFilesOrInformation();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.externalNetwork.bypassNetworkIntrusionDetection);
        attacker.attack();

        model.externalNetwork.bypassNetworkIntrusionDetection.assertCompromisedInstantaneously();
    }

    @Test
    public void infectedInternalNetwork(){
        var model = new deobfuscateOrDecodeFilesOrInformation();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.internalNetwork.bypassNetworkIntrusionDetection);
        attacker.attack();

        model.internalNetwork.bypassNetworkIntrusionDetection.assertCompromisedInstantaneously();
    }
}