package tads.eaj.br.produtosmvc.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String username;
    String password;
    Boolean accountExpired;
    Boolean accountLocked;
    Boolean credentialsExpired;
    Boolean enabled;
    Boolean admin;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        HashSet<GrantedAuthority> authorities = new HashSet<>();
        if (isAdmin()){
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
        }else{
            authorities.add(new SimpleGrantedAuthority("USER"));
        }
        return  authorities;
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
        return accountExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Boolean isAdmin() {
        return admin;
    }
}
