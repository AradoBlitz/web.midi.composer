package web.midi.composer;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MidiCompilerTest {

	
	
	private byte[] duhastMidiBytes;
	private static final File testMidiFile = new File("./WebContent/midi/test_duhast.midi");
	
	@Before
	public void init() throws Exception{
		FileInputStream in = new FileInputStream(testMidiFile);
		try{
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int token;
			while((token=in.read())!=-1)
				baos.write(token);
			duhastMidiBytes = baos.toByteArray();
		} finally{
			in.close();
		}
	}

	@Test
	public void checkTestFileSize() throws Exception {
		
		assertEquals(140, testMidiFile.length());		
		assertEquals("Result length of byte array should be equal to file length.",140, duhastMidiBytes.length);
	}
	
	@Test
	public void processNoteSheet() throws Exception {
		
		MidiCompiler midiBuilder = new MidiCompiler();
		List<Accord> noteSheet = Arrays.asList(new Accord(32,new int[]{64,57})
										,new Accord(32,new int[]{62,55})
										,new Accord(2,new int[]{59,52})
										,new Accord(2,new int[]{59,52})
										,new Accord(1,new int[]{64,57})
										,new Accord(1,new int[]{62,55})
										,new Accord(2,new int[]{59,52})
										,new Accord(1,new int[]{59,52}));
		
		assertArrayEquals(duhastMidiBytes, midiBuilder.process(noteSheet));
	}
}
