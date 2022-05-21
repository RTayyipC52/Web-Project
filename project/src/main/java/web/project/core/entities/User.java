package web.project.core.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import web.project.entities.concretes.Katilimci;
import web.project.entities.concretes.Kurum;

@Entity
@Data
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int userId;

    @Column(name="email")
    @Email
    @NotBlank
    @NotNull
    private String email;

    @Column(name="password")
    @NotBlank
    @NotNull
    private String password;
    
    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private Katilimci katilimci;
    
    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private Kurum kurum;

    /*@OneToOne()
    @JoinColumn(name = "katilimci_id")
    private Katilimci katilimci;*/
}
