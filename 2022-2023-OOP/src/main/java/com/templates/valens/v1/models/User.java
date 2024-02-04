package com.templates.valens.v1.models;
import com.templates.valens.v1.models.enums.EAccountStatus;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String email;
    private String userName;

    private String password;

    private EAccountStatus status = EAccountStatus.WAIT_EMAIL_VERIFICATION;

    public User(){}

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User(String email, String userName, String password){
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

}
