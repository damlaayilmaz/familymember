package org.example.famtree.model;
import lombok.*;
import jakarta.persistence.*;

@Data
@Entity


public class member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;




}
