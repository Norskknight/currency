package entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user_roles")
public class UserRole implements Serializable{

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;
    @Column(name = "user_name")
    private String userId;
    @Column(name = "role_name")
    private String role;

    public UserRole() {
    }


    public UserRole(User user) {
        this.userId = user.getUserId();
        this.role = "registered-user";
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String password) {
        this.role = password;
    }
}