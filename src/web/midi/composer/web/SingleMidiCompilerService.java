package web.midi.composer.web;

import java.io.File;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.logging.Logger;

@ApplicationScoped
@Path("/")
public class SingleMidiCompilerService implements MidiCompilerService {

	@GET
	@Path("/midi/test_duhast.midi")
	@Produces({MediaType.APPLICATION_OCTET_STREAM})
	@Override
	public Response getMidi() {
		Logger.getLogger(getClass()).info(new File("/home/dmitriy/Projects/Java/portfolio/web.midi.composer/WebContent/midi/test_duhast.midi"));
		ResponseBuilder response = Response.ok(new File("/home/dmitriy/Projects/Java/portfolio/web.midi.composer/WebContent/midi/test_duhast.midi"));
		return response.build();
	}

}
