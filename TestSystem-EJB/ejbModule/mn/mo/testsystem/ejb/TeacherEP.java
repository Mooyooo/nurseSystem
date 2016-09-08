package mn.mo.testsystem.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import java.util.List;

import mn.mo.testsystem.model.Teacher;

@Stateless
@Path("/teachers")
@Produces("application/json")
@Consumes("application/json")
public class TeacherEP implements TeacherService{

	@PersistenceContext(unitName = "Test-Persistence")
	EntityManager em;

	@POST
	public Response create(final Teacher teacher) {
		// TODO: process the given teacher
		// here we use Teacher#getId(), assuming that it provides the identifier
		// to retrieve the created Teacher resource.
		em.persist(teacher);
		return Response.created(UriBuilder.fromResource(TeacherEP.class).path(String.valueOf(teacher.getId())).build())
				.build();
	}

	@GET
	public List<Teacher> getTeachers() {
		List<Teacher> teachers = null;
		teachers = em.createQuery("FROM Teacher", Teacher.class).getResultList();
		return teachers;
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		// TODO: retrieve the teacher
		Teacher teacher = null;
		teacher = em.find(Teacher.class, id);
		if (teacher == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(teacher).build();
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	public Response update(@PathParam("id") Long id, final Teacher teacher) {
		// TODO: process the given teacher
		if (id == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		if (teacher == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		em.merge(teacher);
		return Response.noContent().build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") final Long id) {
		// TODO: process the teacher matching by the given id
		if (id == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.noContent().build();
	}

}
