package ca.uqam.info.mgl7460.domain;
import ca.uqam.info.mgl7460.domain.Session;
import java.util.Iterator;

public interface Professeur {
    public String getPrenom();

    public String getNom();

    public Iterator<GroupeCours> getCoursEnseignes(int annee, Session session);
}
