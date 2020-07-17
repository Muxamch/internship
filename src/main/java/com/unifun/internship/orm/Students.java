package com.unifun.internship.orm;

import javax.persistence.*;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import java.awt.*;

@Entity
@Table(name="students")
public class Students extends PanacheEntityBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;

    @OneToOne
    @JoinColumn(name = "group_id")
    public Group group;

    public Students(String name, Long groupId){
        this.name = name;
        this.group = new Group(groupId);
    }

    public Students(){

    }

    public void setGroup(Long groupId) {
        this.group.id = groupId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toLowerCase();
    }

    public String getGroup(){
      return this.group.getGroup();
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", group=" + group.getGroup(this.group.id) +
                '}';
    }


}
