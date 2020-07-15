package com.unifun.internship.orm;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name="tgroups")
public class Group extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    //@OneToMany(fetch = FetchType.LAZY)
    public String group;

    public Group(long groupId, String group){
        this.id = groupId;
        this.group = group;
    }
    public Group(long groupId){
        this.id = groupId;
    }

    public Group(){
    }

    public long getGroupId() {
        return id;
    }



    public String getGroup() {
        return group;
    }


}

