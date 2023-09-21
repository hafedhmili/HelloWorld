package ca.uqam.info.mgl7460.implementation;

import java.util.HashMap;

import ca.uqam.info.mgl7460.domain.Cours;
import ca.uqam.info.mgl7460.domain.Etudiant;
import ca.uqam.info.mgl7460.domain.GroupeCours;
import ca.uqam.info.mgl7460.domain.Inscription;
import ca.uqam.info.mgl7460.domain.Programme;
import ca.uqam.info.mgl7460.domain.ServiceDossierAcademique;
import ca.uqam.info.mgl7460.domain.Session;

public class ServiceDossierAcademiqueImpl implements ServiceDossierAcademique {

    public static String INF1120 = "INF1120";

    public static String INF2120 = "INF2120";

    public static String INF3135 = "INF3135";

    public static String INF5151 = "INF5151";

    public static String INF5153 = "INF5153";

    public static String CODEBACC = "7617";

    private HashMap<String,Etudiant> etudiants;

    private HashMap<String,Cours> cours;

    private HashMap<String,Programme> programmes;

    private HashMap<String,GroupeCours> groupesCours;

    public ServiceDossierAcademiqueImpl() {
        etudiants = new HashMap<>();
        cours = new HashMap<>();
        programmes = new HashMap<>();
        groupesCours = new HashMap<>();
    }

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
        creerEtudiants();
        creerCours();
        creerProgrammes();
        creerGroupesCours();
        inscrireEtudiants();
    }
    
    void creerEtudiants() {
        Etudiant etudiant = creerEtudiant("Martin", "Bourgeois", "BOUM12079901");
        etudiants.put(etudiant.getCodePermanent(),etudiant);

        etudiant = creerEtudiant("Josée", "Cyr", "CYRJ05530301");
        etudiants.put(etudiant.getCodePermanent(),etudiant);

        etudiant = creerEtudiant("Mohamed", "Kabir", "KABM05080201");
        etudiants.put(etudiant.getCodePermanent(),etudiant);

        etudiant = creerEtudiant("Ange", "Diawo", "DIAA23580103");
        etudiants.put(etudiant.getCodePermanent(),etudiant);
    }

    void creerCours() {
        Cours inf1120 = creerCours(INF1120, "Programmation 1", "Acquérir une méthode de développement", 3);
        cours.put(inf1120.getSigle(),inf1120);

        Cours inf2120 = creerCours(INF2120, "Programmation II", "Approfondir les concepts de la programmation OO", 3,inf1120);
        cours.put(inf2120.getSigle(),inf2120);

        Cours inf3135 = creerCours(INF3135, "Construction et maintenance de logiciels", "Initier les étudiants à la programmation à l’aide d’un langage impératif et procédural.", 3,inf1120);
        cours.put(inf3135.getSigle(),inf3135);

        Cours inf5151 = creerCours(INF5151, "Génie logiciel: analyse et modélisation", "Explorer les fondements et l’évolution des méthodes d’analyse", 3);
        cours.put(inf5151.getSigle(),inf5151);

        Cours inf5153 = creerCours(INF5153, "Génie logiciel: conception", "Sensibiliser l’étudiant aux difficultés de la conception", 3, inf3135,inf5151);
        cours.put(inf5153.getSigle(),inf5153);
    }

    void creerProgrammes() {
        Programme bacc = creerProgramme(CODEBACC, "Baccalauréat en informatique et génie logiciel", 15);
        bacc.ajouterCours(cours.get(INF1120));
        bacc.ajouterCours(cours.get(INF2120));
        bacc.ajouterCours(cours.get(INF3135));
        bacc.ajouterCours(cours.get(INF5151));
        bacc.ajouterCours(cours.get(INF5153));
    }

    void creerGroupesCours() {
        GroupeCours 
            inf1120_aut_2020 = creerGroupeCours(cours.get(INF1120),2020,Session.Automne,null),
            inf1120_aut_2021 = creerGroupeCours(cours.get(INF1120),2021,Session.Automne,null),
            inf2120_hiv_2021 = creerGroupeCours(cours.get(INF2120),2021,Session.Hiver,null),
            inf2120_hiv_2022 = creerGroupeCours(cours.get(INF2120),2022,Session.Hiver,null),
            inf3135_aut_2021 = creerGroupeCours(cours.get(INF3135),2021,Session.Automne,null),
            inf5151_hiv_2022 = creerGroupeCours(cours.get(INF5151),2022,Session.Hiver, ""),
            inf5153_aut_2022 = creerGroupeCours(cours.get(INF5151),2022,Session.Automne,null);

            groupesCours.put(inf1120_aut_2020.getID(),inf1120_aut_2020);
            groupesCours.put(inf1120_aut_2021.getID(), inf1120_aut_2021);
            groupesCours.put(inf2120_hiv_2021.getID(),inf2120_hiv_2021);
            groupesCours.put(inf2120_hiv_2022.getID(),inf2120_hiv_2022);
            groupesCours.put(inf3135_aut_2021.getID(),inf3135_aut_2021);
            groupesCours.put(inf5151_hiv_2022.getID(),inf5151_hiv_2022);
            groupesCours.put(inf5153_aut_2022.getID(),inf5153_aut_2022);
    }

    void inscrireEtudiants() {
        Etudiant martin = etudiants.get("BOUM12079901") ;
        Etudiant josee = etudiants.get("CYRJ05530301");

        martin.inscrireProgramme(programmes.get(CODEBACC));
        josee.inscrireProgramme(programmes.get(CODEBACC));

        GroupeCours 
            inf1120_aut_2020 = groupesCours.get(INF1120+"-2020-Automne"),
            inf1120_aut_2021 = groupesCours.get(INF1120+"-2021-Automne"),
            inf2120_hiv_2021 = groupesCours.get(INF2120+"-2021-Hiver"),
            inf2120_hiv_2022 = groupesCours.get(INF2120+"-2022-Hiver"),
            inf3135_aut_2021 = groupesCours.get(INF3135+"-2021-Automne"),
            inf5151_hiv_2022 = groupesCours.get(INF5151+"-2022-Hiver"),
            inf5153_aut_2022 = groupesCours.get(INF5151+"-2022-Automne");

        Inscription martin_1120 = martin.inscrireGroupeCours(inf1120_aut_2020),
        martin_2120 = martin.inscrireGroupeCours(inf2120_hiv_2021),
        martin_3135 = martin.inscrireGroupeCours(inf3135_aut_2021),
        martin_5151 = martin.inscrireGroupeCours(inf5151_hiv_2022),
        martin_5153 = martin.inscrireGroupeCours(inf5153_aut_2022);

        Inscription josee_1120 = josee.inscrireGroupeCours(inf1120_aut_2021),
        josee_2120 = josee.inscrireGroupeCours(inf2120_hiv_2022);

        martin.setNoteGroupeCours(martin_1120.getGroupeCours(), 3.3f);
        martin.setNoteGroupeCours(martin_2120.getGroupeCours(),3.7f);
        martin.setNoteGroupeCours(martin_3135.getGroupeCours(),2.7f);
        martin.setNoteGroupeCours(martin_5151.getGroupeCours(),4.0f);

        josee.setNoteGroupeCours(josee_1120.getGroupeCours(),4.3f);
        josee.setNoteGroupeCours(josee_2120.getGroupeCours(),4.3f);
    }

    @Override
    public Etudiant getEtudiantAvecCodePermanent(String code) {
       return etudiants.get(code);
    }

    @Override
    public Cours getCoursAvecSigle(String sigle) {
        return cours.get(sigle);
    }

    @Override
    public Programme getProgrammeAvecCode(String code) {
        return programmes.get(code);
    }

    @Override
    public GroupeCours getGroupeCoursAvecCode(String code) {
        return groupesCours.get(code);
    }
}
