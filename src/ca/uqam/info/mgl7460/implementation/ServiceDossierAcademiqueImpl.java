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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'creerEtudiant'");
    }

    @Override
    public Programme creerProgramme(String codeProg, String titre, int nombreCredits) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'creerProgramme'");
    }

    @Override
    public Cours creerCours(String sigle, String titre, String description, int nombreCredits, Cours... prerequis) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'creerCours'");
    }

    @Override
    public GroupeCours creerGroupeCours(Cours crs, int annee, Session session, String enseignant) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'creerGroupeCours'");
    }

    @Override
    public Inscription inscrireEtudiantCours(Etudiant et, GroupeCours gpeCours) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inscrireEtudiantCours'");
    }

    @Override
    public Etudiant inscrireEtudiantProgramme(Etudiant etud, Programme prog) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inscrireEtudiantProgramme'");
    }

    @Override
    public void saisirNote(Etudiant etud, GroupeCours gpeCours, float note) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saisirNote'");
    }

    @Override
    public float getMoyenne(Etudiant etud) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMoyenne'");
    }

    @Override
    public float getNombreCreditsCompletes(Etudiant etud) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNombreCreditsCompletes'");
    }

    @Override
    public void chargerDonnees() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'chargerDonnees'");
    }
    
}
