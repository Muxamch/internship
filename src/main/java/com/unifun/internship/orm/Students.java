package com.unifun.internship.orm;

import javax.persistence.*;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name="students")
public class Students extends PanacheEntityBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String name;

    public long group_id;

    public Students(String name, Long group_id){
        this.name = name;
        this.group_id = group_id;
    }

    public Students(){

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

    public void setGroup_id(Long group_id){
        this.group_id = group_id;
    }

    @Transient
    public Long getGroup_id(){
        return this.group_id;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", group_id=" + group_id +
                '}';
    }
}
