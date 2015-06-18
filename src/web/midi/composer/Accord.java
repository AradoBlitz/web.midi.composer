package web.midi.composer;

public class Accord {

	private int[] notes;
	private int tick;

	public Accord(){}
	
	public Accord(int tick,int[] notes) {
		this.notes = notes;
		this.tick = tick;
		 
	}	
	
	public int getTick() {
		return tick;
	}

	public void setTick(int tick) {
		this.tick = tick;
	}

	public int[] getNotes() {
		return notes;
	}

	public void setNotes(int[] notes) {
		this.notes = notes;
	}

}
