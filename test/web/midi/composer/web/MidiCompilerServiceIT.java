package web.midi.composer.web;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.junit.Before;
import org.junit.Test;

import web.midi.composer.Accord;

public class MidiCompilerServiceIT {

	private MidiCompilerService service;

	@Before
	public void init() throws Exception {
		service = new ResteasyClientBuilder()
		.build().target("http://localhost:8080/web.midi.composer/service")
		.proxy(MidiCompilerService.class);
	}
	
	@Test
	public void getMidiCompilerService() throws Exception {
		assertNotNull(service);
	}
	
	@Test
	public void getMidiResponse() throws Exception {
		List<Accord> noteSheet = Arrays.asList(new Accord(1,new int[]{64,57})
		,new Accord(1,new int[]{62,55})
		,new Accord(1,new int[]{59,52})
		,new Accord(1,new int[]{59,52})
		,new Accord(1,new int[]{64,57})
		,new Accord(1,new int[]{62,55})
		,new Accord(1,new int[]{59,52})
		,new Accord(1,new int[]{59,52}));
		assertEquals(Response.Status.NO_CONTENT,service.compileMidi(noteSheet).getStatusInfo());
		Response compileMidi = service.getMidi();
		assertNotNull(compileMidi);
		assertEquals(Response.Status.OK.getStatusCode(), compileMidi.getStatus());
		assertEquals(75,compileMidi.getLength());
		assertEquals(MediaType.APPLICATION_OCTET_STREAM_TYPE, compileMidi.getMediaType());
	}
}
