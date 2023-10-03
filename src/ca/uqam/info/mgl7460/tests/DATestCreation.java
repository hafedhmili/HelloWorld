package ca.uqam.info.mgl7460.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ca.uqam.info.mgl7460.domain.Cours;
import ca.uqam.info.mgl7460.domain.Etudiant;
import ca.uqam.info.mgl7460.domain.GroupeCours;
import ca.uqam.info.mgl7460.domain.Programme;
import ca.uqam.info.mgl7460.domain.ServiceDossierAcademique;
import ca.uqam.info.mgl7460.domain.Session;
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
        String prenom = "Martin", nom = "Bourgeois", codePermanent = "BOUM12079901";
        Etudiant etud = serviceDA.creerEtudiant(prenom,nom, codePermanent);
        Assertions.assertEquals(etud.getPrenom(),prenom);
        Assertions.assertEquals(etud.getNom(), nom);
        Assertions.assertEquals(etud.getCodePermanent(),codePermanent);
        Assertions.assertEquals(serviceDA.getEtudiantAvecCodePermanent(codePermanent),etud, "Cannot retrieve student by code permanent");       
    }

    @Test
    public void testCreationCours() {
        String sigle = "INF1120", titre = "Programmation 1", description = "Acquérir une méthode de développement";
        Cours inf1120 = serviceDA.creerCours(sigle, titre, description, 3);
        Assertions.assertEquals(inf1120.getSigle(),sigle, "Mauvais sigle");
        Assertions.assertEquals(inf1120.getTitre(), titre,"Mauvais titre");
        Assertions.assertEquals(inf1120.getDescription(), description,"Mauvaise description");
        Assertions.assertEquals(serviceDA.getCoursAvecSigle(sigle),inf1120, "Ne peut accéder aux cours par sigle");       
    }

    @Test
    public void testCreationGroupeCours() {
        String sigle = "INF1120", titre = "Programmation 1", description = "Acquérir une méthode de développement";
        Cours inf1120 = serviceDA.creerCours(sigle, titre, description, 3);
        int annee = 2023; Session session = Session.Automne; String professeur = "Tournesol";
        GroupeCours groupeCours = serviceDA.creerGroupeCours(inf1120, annee, session, professeur);
        Assertions.assertEquals(groupeCours.getCours(),inf1120, "GroupeCours non associé au bon cours");
        Assertions.assertEquals(groupeCours.getAnnee(),annee,"Groupe cours non associé à la bonne année");
        Assertions.assertEquals(groupeCours.getSession(), session,"Groupe cours associé à la mauvaise session");
        Assertions.assertEquals(groupeCours.getEnseignant(),professeur, "Non attribué au bon professeur");       
    }
}
