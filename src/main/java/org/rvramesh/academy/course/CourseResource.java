package org.rvramesh.academy.course;

import java.util.Optional;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;


@Path("/api/courses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CourseResource {

    private final CourseService courseService;

    public CourseResource(CourseService courseService) {
        this.courseService = courseService;
    }

    @GET
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Get All Courses", content = @Content(mediaType = "application/json", schema = @Schema(type = SchemaType.ARRAY, implementation = CourseOutputDto.class))) })
    public Response get() {
        return Response.ok(courseService.findAll()).build();
    }

    @GET
    @Path("/{courseId}")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Get Course by courseId", content = @Content(mediaType = "application/json", schema = @Schema(type = SchemaType.OBJECT, implementation = CourseOutputDto.class))),
            @APIResponse(responseCode = "404", description = "No Course found for courseId provided", content = @Content(mediaType = "application/json")), })
    public Response getById(@PathParam("courseId") Long courseId) {
        Optional<CourseOutputDto> optional = courseService.findById(courseId);
        return !optional.isEmpty() ? Response.ok(optional.get()).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @APIResponses(value = {
            @APIResponse(responseCode = "201", description = "Course Created", content = @Content(mediaType = "application/json", schema = @Schema(type = SchemaType.OBJECT, implementation = CourseOutputDto.class))),
            @APIResponse(responseCode = "400", description = "Course already exists for courseId", content = @Content(mediaType = "application/json")), })
    public Response post(@Valid CourseInputDto course) {
        final CourseOutputDto saved = courseService.insert(course);
        return Response.status(Response.Status.CREATED).entity(saved).build();
    }

    @PUT
    @Path("/{courseId}")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Course updated", content = @Content(mediaType = "application/json", schema = @Schema(type = SchemaType.OBJECT, implementation = CourseOutputDto.class))),
            @APIResponse(responseCode = "404", description = "No Course found for courseId provided", content = @Content(mediaType = "application/json")), })
    public Response put(@PathParam("courseId") Long courseId, @Valid CourseInputDto course) {
        final CourseOutputDto saved = courseService.update(courseId, course);
        return Response.ok(saved).build();
    }

}