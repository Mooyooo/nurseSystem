package mn.mo.testsystem.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import mn.mo.testsystem.model.Teacher;

@Local
public interface TeacherService {

	public Response create(final Teacher teacher);

	public List<Teacher> getTeachers();

	public Response findById(@PathParam("id") final Long id);

	public Response update(@PathParam("id") Long id, final Teacher teacher);
}
