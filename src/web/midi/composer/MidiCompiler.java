package web.midi.composer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class MidiCompiler {

	private static final int	VELOCITY = 64;
	
	public byte[] process(List<Accord> accords) {
		Sequence	sequence = null;
		try
		{
			sequence = new Sequence(Sequence.SMPTE_24, 1);
		}
		catch (InvalidMidiDataException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		/* Track objects cannot be created by invoking their constructor
		   directly. Instead, the Sequence object does the job. So we
		   obtain the Track there. This links the Track to the Sequence
		   automatically.
		*/
		Track	track = sequence.createTrack();
		int tick = 0;
		for(Accord accord : accords){
			for(int note:accord.getNotes())
				track.add(createNoteOnEvent(note, tick));		
				tick+=accord.getTick()*5;
			for(int note:accord.getNotes())
					track.add(createNoteOffEvent(note, tick));	
		}
		
		/* Now we just save the Sequence to the file we specified.
		   The '0' (second parameter) means saving as SMF type 0.
		   Since we have only one Track, this is actually the only option
		   (type 1 is for multiple tracks).
		*/
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try
		{
			
			MidiSystem.write(sequence, 0, baos);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	
		return baos.toByteArray();
	}

	private MidiEvent createNoteOffEvent(int note, int tick) {
		return createNoteEvent(ShortMessage.NOTE_OFF,
				   note,
				   0,
				   tick);
	}

	private static MidiEvent createNoteOnEvent(int nKey, long lTick)
	{
		return createNoteEvent(ShortMessage.NOTE_ON,
							   nKey,
							   VELOCITY,
							   lTick);
	}



	private static MidiEvent createNoteEvent(int nCommand,
											 int nKey,
											 int nVelocity,
											 long lTick)
	{
		ShortMessage	message = new ShortMessage();
		try
		{
			message.setMessage(nCommand,
							   0,	// always on channel 1
							   nKey,
							   nVelocity);
		}
		catch (InvalidMidiDataException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		MidiEvent	event = new MidiEvent(message,
										  lTick);
		return event;
	}
}
