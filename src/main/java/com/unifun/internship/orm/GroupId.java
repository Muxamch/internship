package com.unifun.internship.orm;

import javax.persistence.*;

@Entity
@Table(name="group_id")
public class GroupId {
    private long group_id;
    private String group;

    static String getGroup(long group_id){
        return "";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getGroup_id(){
        return this.group_id;
    }
    public void setGroup_id(long group_id){
        this.group_id = group_id;
    }

}
