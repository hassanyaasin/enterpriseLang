package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestAutomatedExfiltration extends EnterpriseLangTest {

    private static class automatedExfiltration {
        public final Computer computer = new Computer("computer");
        

    }
    
    @Test
    public void automatedExfiltration(){
        var model = new automatedExfiltration();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.computer.attemptExfiltrationOverPhysicalMedium);
        //attacker.addAttackPoint(model.computer.dataCollected);
        //attacker.addAttackPoint(model.computer.dataCompressed);
        //attacker.addAttackPoint(model.computer.dataEncrypted);
        //attacker.addAttackPoint(model.computer.collectVideo);
        //attacker.addAttackPoint(model.computer.collectAudio);
        attacker.attack();
        
        //model.computer.collectVideo.assertCompromisedInstantaneously();
        //model.computer.collectAudio.assertCompromisedInstantaneously();
        model.computer.exfiltrationOverPhysicalMedium.assertCompromisedInstantaneously();
        model.computer.exfiltrationOverUSB.assertCompromisedInstantaneously();
    }

}