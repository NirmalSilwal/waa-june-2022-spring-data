package edu.miu.springdata.lab3.entity.jointable;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class UserJT {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int jtid;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToMany
    @JoinTable(name="userjt_reviews",
    joinColumns = @JoinColumn(name="userjt_id"),
    inverseJoinColumns = @JoinColumn(name="reviewjt_id"))
    private List<ReviewJT> reviewsjt;

    @OneToOne
    private AddressJT addressjt;
}