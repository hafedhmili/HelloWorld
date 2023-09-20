package ca.uqam.info.mgl7460.domain;

import java.util.Iterator;

public interface GroupeCours {

    public Cours getCours();

    public int getAnnee();

    public Session getSession();

    public String getEnseignant();

    public Iterator<Inscription> getInscriptions();

    public Iterator<Etudiant> getEtudiantsInscrits();

    public Inscription inscrireEtudiant(Etudiant etud);

    public float getNoteEtudiant(Etudiant etud);

    public void setNoteEtudiant(Etudiant etud, float note);
    
}
