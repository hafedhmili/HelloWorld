package ca.uqam.info.mgl7460.implementation;

import ca.uqam.info.mgl7460.domain.Cours;
import ca.uqam.info.mgl7460.domain.Etudiant;
import ca.uqam.info.mgl7460.domain.GroupeCours;
import ca.uqam.info.mgl7460.domain.Inscription;
import ca.uqam.info.mgl7460.domain.Programme;
import ca.uqam.info.mgl7460.domain.ServiceDossierAcademique;
import ca.uqam.info.mgl7460.domain.Session;

public class ServiceDossierAcademiqueImpl implements ServiceDossierAcademique {

    @Override
    public Etudiant creerEtudiant(String prenom, String nom, String codePermanent) {
        return new EtudiantImpl(prenom, nom, codePermanent);
    }

    @Override
    public Programme creerProgramme(String codeProg, String titre, int nombreCredits) {
        return new ProgrammeImpl(codeProg, titre, nombreCredits);
    }

    @Override
    public Cours creerCours(String sigle, String titre, String description, int nombreCredits, Cours... prerequis) {
        Cours[] coursPrerequis = prerequis;
        Cours nouveauCours = new CoursImpl(sigle,titre,description,nombreCredits);
        for (int i=0; i < prerequis.length; i++) nouveauCours.ajouterPrerequis(coursPrerequis[i]);

        return nouveauCours;
    }

    @Override
    public GroupeCours creerGroupeCours(Cours crs, int annee, Session session, String enseignant) {
        return new GroupeCoursImpl(crs, annee, session, enseignant);
    }

    @Override
    public Inscription inscrireEtudiantCours(Etudiant et, GroupeCours gpeCours) {
        return et.inscrireGroupeCours(gpeCours);
    }

    @Override
    public Etudiant inscrireEtudiantProgramme(Etudiant etud, Programme prog) {
        etud.inscrireProgramme(prog);
        return etud;
    }

    @Override
    public void saisirNote(Etudiant etud, GroupeCours gpeCours, float note) {
        etud.setNoteGroupeCours(gpeCours, note);
    }

    @Override
    public float getMoyenne(Etudiant etud) {
        return etud.getMoyenneCumulative();
    }

    @Override
    public float getNombreCreditsCompletes(Etudiant etud) {
        return etud.getNombreCreditsReussis();
    }

    @Override
    public void chargerDonnees() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'chargerDonnees'");
    }
    
}
