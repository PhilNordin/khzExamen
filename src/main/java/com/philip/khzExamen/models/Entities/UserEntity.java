package com.philip.khzExamen.models.Entities;
import java.util.Collection;
import java.util.List;

import com.philip.khzExamen.models.Roles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "users")
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // @Column(unique = true) Make values UNIQUE
    @Size(min = 1, max = 64)
    private String username;

    @Size(min = 4, max = 64, message = "Password must contain at least 4-64 chars")
    private String password;

    @Enumerated(EnumType.STRING)
    private Roles role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<OrderEntity> orders;

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean accountEnabled;
    private boolean credentialsNonExpired;

    public UserEntity() {}
    public UserEntity(String username, String password, Roles roles,
                      boolean accountNonExpired, boolean accountNonLocked, boolean accountEnabled, boolean credentialsNonExpired) {
        this.username = username;
        this.password = password;
        this.role = roles;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.accountEnabled = accountEnabled;
        this.credentialsNonExpired = credentialsNonExpired;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        // [GET, POST]
        // From ROLES ([ROLE_ADMIN, GET, POST])
        return role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return accountEnabled;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setAccountEnabled(boolean accountEnabled) {
        this.accountEnabled = accountEnabled;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrder(List<OrderEntity> orders) {
        this.orders = orders;
    }
}