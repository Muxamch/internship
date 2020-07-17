package com.unifun.internship.orm;

import com.unifun.internship.endpoints.StudentEndPoint;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tgroups")
public class Group extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String group;
//    @OneToMany
//    public Students students;

    public Group(Long groupId, String group){
        this.id = groupId;
        this.group = group;
    }
    public Group(Long groupId){
        this.id = groupId;
    }

    public Group(){
    }

    public long getGroupId() {
        return id;
    }



    public String getGroup(Long id) {
        return group;
    }

    public String getGroup() {
        return this.group;
    }

}

