package com.backand.tracker.domains;

import com.backand.tracker.domains.primitives.EmailAddress;
import com.backand.tracker.domains.primitives.Password;
import lombok.Data;

import javax.persistence.*;

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

    @Deprecated
    public User() {}

    public User(String name, EmailAddress emailAddress, Password password) {
        this.username = name;
        this.emailAddress = emailAddress;
        this.password = password;
    }
}
