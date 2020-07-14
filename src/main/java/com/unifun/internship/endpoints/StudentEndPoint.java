package com.unifun.internship.endpoints;


import com.unifun.internship.orm.Students;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/students")
public class StudentEndPoint {

    @GET
    @Path("student")
    public String getList(){
        return Students.listAll().toString();
    }

    @GET
    @Transactional
    @Path("find_student_by_id")
    public String findStudentById(@QueryParam("id") long id){
        Students student = Students.findById(id);
        if(student != null){
            return student.toString();
        } else {
            return "no such id";
        }
    }

    @GET
    @Transactional
    @Path("add_new_student")
    public String addNewStudent(@QueryParam("group_id") long group_id, @QueryParam("name") String name){
        Students student = new Students(name, group_id);
        student.persist();
        return student.isPersistent() ? "success" : "something went wrong";
    }

}
