package ca.uqam.info.mgl7460.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ca.uqam.info.mgl7460.domain.Programme;
import ca.uqam.info.mgl7460.domain.ServiceDossierAcademique;
import ca.uqam.info.mgl7460.implementation.ServiceDossierAcademiqueImpl;

public class DATestCreation {

    private static ServiceDossierAcademique serviceDA= null;

    @BeforeAll
    public void initialiseServiceDossierAcademique() {
        serviceDA = new ServiceDossierAcademiqueImpl();
    }

    @Test
    public void testCreationProgramme() {
        String code = "1822", titre = "Maitrise en Génie Logiciel";
        Programme mgl = serviceDA.creerProgramme(code, titre,45);
        Assertions.assertEquals(code,mgl.getCodeProgramme(),"Wrong program code assigned");
        Assertions.assertEquals(titre, mgl.getTitre(), "Wrong title assigned");
        Assertions.assertEquals(mgl,serviceDA.getProgrammeAvecCode(code),"Cannot retrieve program by code");
    }

    @Test
    public void testCreationEtudiant() {
        String prenom = 
    }

    
}
