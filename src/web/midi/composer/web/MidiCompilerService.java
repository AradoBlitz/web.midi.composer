package web.midi.composer.web;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import web.midi.composer.Accord;

@Consumes({MediaType.APPLICATION_JSON})
public interface MidiCompilerService {

	@GET
	@Path("/midi/test_duhast.midi")
	@Produces({MediaType.APPLICATION_OCTET_STREAM})
	Response getMidi();

	@POST
	@Path("/midi/compile")
	@Consumes({MediaType.APPLICATION_JSON})
	Response compileMidi(List<Accord> noteSheet);

}
