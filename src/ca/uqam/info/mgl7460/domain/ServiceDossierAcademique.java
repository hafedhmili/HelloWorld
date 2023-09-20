package ca.uqam.info.mgl7460.domain;

public interface ServiceDossierAcademique {

    public Etudiant creerEtudiant(String prenom, String nom, String codePermanent);

    public Programme creerProgramme(String codeProg, String titre, int nombreCredits);

    public Cours creerCours(String sigle, String titre, String description, int nombreCredits, Cours... prerequis);

    public GroupeCours creerGroupeCours(Cours crs, int annee, Session session, String enseignant);

    public Inscription inscrireEtudiantCours(Etudiant et, GroupeCours gpeCours);

    public Etudiant inscrireEtudiantProgramme(Etudiant etud, Programme prog);

    public void saisirNote(Etudiant etud, GroupeCours gpeCours);

    public float getMoyenne(Etudiant etud);

    public float getNombreCreditsCompletes(Etudiant etud);

    public void chargerDonnees();
    
}
