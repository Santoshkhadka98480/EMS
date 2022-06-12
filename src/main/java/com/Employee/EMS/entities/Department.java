package com.Employee.EMS.entities;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name="tbl_department")
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "shortCode", length = 10)
    private String shortCode;

    @Column(name = "status")
    private boolean status;

}
