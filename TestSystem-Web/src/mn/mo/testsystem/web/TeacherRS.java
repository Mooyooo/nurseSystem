package mn.mo.testsystem.web;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@RequestScoped
@Path("/teacherList")
@Produces("application/json")
@Consumes("application/json")
public class TeacherRS {

	@GET
	public String listAll() {
		return "Teachers!!!!!!!";
	}

}
