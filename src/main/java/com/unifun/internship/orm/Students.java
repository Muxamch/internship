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

    @OneToOne
    @JoinColumn(name = "group_id")
    public Group group;

    public Students(String name, Long groupId){
        this.name = name;
        this.group = new Group(groupId);
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


    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", group_id=" + group +
                '}';
    }
}
