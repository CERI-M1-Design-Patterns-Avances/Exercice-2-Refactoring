package exo2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EtudiantTest {

    Etudiant unEtudiant;

    @BeforeEach
    public void setUp() {
        unEtudiant = new Etudiant("Sophie");
        Matiere tddJava = new Matiere("TDD en Java", Matiere.Discipline.Informatique, 30);
        Matiere anglais = new Matiere("Anglais", Matiere.Discipline.Langues, 50);
        Matiere escalade = new Matiere("Escalade", Matiere.Discipline.Sport, 15);
        unEtudiant.setNote(escalade, 8.0, 5.0);
        unEtudiant.setNote(anglais, 17.0, 19.0);
        unEtudiant.setNote(tddJava, 15.0, 6.0);
    }

    @Test
    public void shouldGetReleveDeNotes() {
        String expected = "Nom : Sophie\n\tMatière      Note Test       Note TP        Moyenne\n";
        expected += "  -----------  --------------  -------------  ------------\n";
        expected += "\tEscalade       8.0            5.0            5.45\n";
        expected += "\tAnglais        17.0           19.0           18.5\n";
        expected += "\tTDD en Java    15.0           6.0            10.5\n";
        expected += "\nMoyenne générale : 11.48\n";
        expected += "Crédits ECTS (European Credits Transfer Scale) obtenus : 80\n";
        assertEquals(expected, unEtudiant.getReleveDeNotes());
    }

}