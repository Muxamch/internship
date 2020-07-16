package com.unifun.internship.endpoints;


import com.unifun.internship.orm.Group;
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
    public String addNewStudent(@QueryParam("group_id") long groupId, @QueryParam("name") String name){
        Students student = new Students(name, groupId);
        try {
            student.persist();
        } catch (Exception e) {
            return "no_such_group_id";
        }
        return student.isPersistent() ? "success" : "something went wrong";
    }

    @GET
    @Transactional
    @Path("edit_by_id")
    public String editById(@QueryParam("group_id") Long groupId, @QueryParam("name") String name, @QueryParam("id") long id){
        Students student = Students.findById(id);
        if(student != null){
            student.name = name;
            if(groupId !=null){
                try {
                    student.setGroup(groupId);
                } catch (Exception e) {
                    return "no such id group";
                }
            }
            return "success";
        } else {
            return "no such id";
        }
    }

}
