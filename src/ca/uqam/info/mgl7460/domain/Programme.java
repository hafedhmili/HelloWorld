package ca.uqam.info.mgl7460.domain;

import java.util.Iterator;

public interface Programme {
    public String getCodeProgramme();
    
    public String getTitre();
    
    public String getNombreCredits();
    
    public Cours ajouterCours(Cours unCours);

    public Cours enleverCours(Cours unCours);
    
    public Iterator<Cours> getCours();
}