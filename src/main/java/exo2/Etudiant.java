package exo2;

import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

public class Etudiant {
	
	private String nom;
	private Set<Note> notes = new LinkedHashSet<>();
	
	public Etudiant(String nom) {
		this.nom = nom;
	}

	public void setNote(Matiere matiere, double noteExamenTerminal, double noteTravauxPratiques) {
		Note g = new Note(matiere, noteExamenTerminal, noteTravauxPratiques);
		notes.add(g);
	}

	public String getReleveDeNotes() {
		String releveDeNotes = "Nom : " + nom + "\n";
		releveDeNotes += String.format("%-14s", "\tMatière");
		releveDeNotes += String.format("%-16s", "Note Test");
		releveDeNotes += String.format("%-15s", "Note TP");
		releveDeNotes += String.format("%s", "Moyenne\n");
		releveDeNotes += String.format("%-15s", "  -----------");
		releveDeNotes += String.format("%-16s", "--------------");
		releveDeNotes += String.format("%-15s", "-------------");
		releveDeNotes += "------------\n";

		int credits = 0;
		double moyenneGenerale = 0.0;

		for(Note note : notes) {
			releveDeNotes += "\t" + String.format("%-15s",note.getMatiere().getNom());
			releveDeNotes += String.format("%-15s",note.getNoteExamenTerminal());
			releveDeNotes += String.format("%-15s",note.getNoteTravauxPratiques());
			
			double moyenne = 0;
			switch (note.getMatiere().getDiscipline()) {
				case Sport :
					moyenne = 0.15 * note.getNoteExamenTerminal() + 0.85 * note.getNoteTravauxPratiques();
					break;
				case Langues:
					moyenne = 0.25 * note.getNoteExamenTerminal() + 0.75 * note.getNoteTravauxPratiques();
					break;
				case Informatique:
					moyenne = (note.getNoteExamenTerminal() + note.getNoteTravauxPratiques()) / 2;
					break;
			}
			releveDeNotes += moyenne + "\n";
			
			moyenneGenerale += moyenne;
			if (moyenne > 10)
				credits += note.getMatiere().getCredits();
		}

		moyenneGenerale /= notes.size();
		releveDeNotes += "\nMoyenne générale : " + String.format(Locale.US,"%.2f\n", moyenneGenerale);
		releveDeNotes += "Crédits ECTS (European Credits Transfer Scale) obtenus : " + credits + "\n";

		return releveDeNotes;
	}

}
