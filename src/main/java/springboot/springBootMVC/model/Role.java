package springboot.springBootMVC.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;
import java.util.Set;
/**
 * C @Data падает с stackoverflow
 */
@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "role")
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @Override
    public String getAuthority() {
        return getName();
    }
}


