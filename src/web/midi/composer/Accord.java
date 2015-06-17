package web.midi.composer;

public class Accord {

	private int[] notes;

	public Accord(){}
	
	public Accord(int[] notes) {
		this.notes = notes;
		 
	}	

	public int[] getNotes() {
		return notes;
	}

	public void setNotes(int[] notes) {
		this.notes = notes;
	}

}
