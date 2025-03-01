package edu.miu.springdata.lab3.entity.joincolumn;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class UserJC {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToMany
    @JoinColumn(name="userjc_id")
    private List<ReviewJC> reviewjc;

    @OneToOne
    private AddressJC addressJC;

}
