package com.backand.tracker.domains.user;

import com.backand.tracker.domains.BaseEntity;
import com.backand.tracker.domains.project.Project;
import com.backand.tracker.domains.project.ProjectRole;
import com.backand.tracker.domains.primitives.EmailAddress;
import com.backand.tracker.domains.primitives.Password;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User extends BaseEntity {
    @Column(name = "username")
    String username;

    @Embedded
    @AttributeOverride(name = "emailAddress", column = @Column(name = "email"))
    private EmailAddress emailAddress;

    @Embedded
    @AttributeOverride(name = "password", column = @Column(name = "password"))
    private Password password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonManagedReference
    @JoinTable(name = "user_project_roles",
            joinColumns = {@JoinColumn(name="user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "project_role_id", referencedColumnName = "id")})
    private List<ProjectRole> projectRoles;

    @Deprecated
    public User() {}

    public User(String name, EmailAddress emailAddress, Password password) {
        this.username = name;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    //    @OneToMany(fetch = FetchType.LAZY)
    //    List<Project> projects;
}
