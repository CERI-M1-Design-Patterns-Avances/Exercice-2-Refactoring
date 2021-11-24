package exo2;

public class Note {

	private Matiere matiere;
	private double noteExamenTerminal, noteTravauxPratiques;
	
	public Note(Matiere matiere, double noteExamenTerminal, double noteTravauxPratiques) {
		this.matiere = matiere;
		this.noteExamenTerminal = noteExamenTerminal;
		this.noteTravauxPratiques = noteTravauxPratiques;
	}

	public double getNoteExamenTerminal() {
		return noteExamenTerminal;
	}

	public double getNoteTravauxPratiques() {
		return noteTravauxPratiques;
	}

	public Matiere getMatiere() {
		return matiere;
	}

}
