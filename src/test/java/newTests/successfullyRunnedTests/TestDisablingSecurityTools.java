package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestDisablingSecurityTools extends EnterpriseLangTest {

    private static class disablingSecurityTools {
        public final UserAccount userAccount = new UserAccount("userAccount");
        public final OS os = new OS("os");
    }


    @Test
    public void infectedOS(){
        var model = new disablingSecurityTools();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.os.disablingSecurityTools);
        attacker.attack();

        model.os.disablingSecurityTools.assertCompromisedInstantaneously();
        model.os.bypassFileMonitoring.assertCompromisedInstantaneously();
        model.os.bypassSignatureBasedDetection.assertCompromisedInstantaneously();
        model.os.bypassHostIntrusionPrevention.assertCompromisedInstantaneously();
        model.os.bypassLogAnalysis.assertCompromisedInstantaneously();
        model.os.bypassAntivirus.assertCompromisedInstantaneously();
    }
}