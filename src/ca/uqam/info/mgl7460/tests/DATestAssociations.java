package ca.uqam.info.mgl7460.tests;

import java.util.function.Consumer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ca.uqam.info.mgl7460.domain.Cours;
import ca.uqam.info.mgl7460.domain.Programme;
import ca.uqam.info.mgl7460.domain.ServiceDossierAcademique;
import ca.uqam.info.mgl7460.implementation.ServiceDossierAcademiqueImpl;;

public class DATestAssociations {
private static ServiceDossierAcademique serviceDA= null;

    @BeforeAll
    public void initialiseServiceDossierAcademique() {
        serviceDA = new ServiceDossierAcademiqueImpl();
    }

    @Test
    void testLienProgrammeCours() {
        String code = "1822", titre = "Maitrise en Génie Logiciel";
        Programme mgl = serviceDA.creerProgramme(code, titre,45); 
        Cours
            mgl7260 = serviceDA.creerCours("MGL7260", "Exigences et spécifications de systèmes logiciels","Introduction à l'ingénierie des systèmes. - Modèles de processus des exigences logicielles",3),
            mgl7361 = serviceDA.creerCours("MGL7361", "Principes et applications de la conception de logiciels", "Rôle de la conception dans le cycle de vie du logiciel", 3, mgl7260),
            mgl7460 = serviceDA.creerCours("MGL7460", "Réalisation et maintenance de logiciels","Rôle de la réalisation et de la maintenance dans le cycle de vie du logiciel",3,mgl7361);

        mgl.ajouterCours(mgl7260);
        mgl.ajouterCours(mgl7361);
        mgl.ajouterCours(mgl7460);
        boolean found = false;
        mgl.getCours().forEachRemaining(new Consumer<Cours>() {public void accept(Cours crs) {found = found  || crs.equals(mgl7361);}});
        Assertions.assertTrue(found,"On ne trouve pas un cours qui a été ajouté au programme");
    }
        
    @Test
    public void testLienEtudiantInscriptionGroupeCours() {
            
    }
    
}
