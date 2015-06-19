package web.midi.composer;

public class Accord {

	private int[] notes;
	private int duratation;

	public Accord(){}
	
	public Accord(int tick,int[] notes) {
		this.notes = notes;
		this.duratation = tick;
		 
	}	
	
	public int getDuratation() {
		return duratation;
	}

	public void setDuratation(int tick) {
		this.duratation = tick;
	}

	public int[] getNotes() {
		return notes;
	}

	public void setNotes(int[] notes) {
		this.notes = notes;
	}

}
