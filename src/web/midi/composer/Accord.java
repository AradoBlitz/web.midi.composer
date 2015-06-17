package web.midi.composer;

public class Accord {

	private int[] notes;

	public Accord(int[] notes) {
		this.notes = notes;
		 
	}

	public int note(int i) {
		
		return notes[i];
	}

	public int[] geNotes() {
		// TODO Auto-generated method stub
		return notes;
	}

}
