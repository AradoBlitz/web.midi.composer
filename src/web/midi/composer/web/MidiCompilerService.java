package web.midi.composer.web;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes({MediaType.APPLICATION_JSON})
public interface MidiCompilerService {

	@GET
	@Path("/midi/test_duhast.midi")
	@Produces({MediaType.APPLICATION_OCTET_STREAM})
	Response compileMidi();

}
