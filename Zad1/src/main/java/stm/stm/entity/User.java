package stm.stm.entity;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoinkrementacja
    private int userId;
    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private Boolean status = false; // z automatu false
    @Column
    private LocalDateTime registrationDateTime = LocalDateTime.now(); //aktualna data

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(                                           // adnotacja tworzy tabelkę relacji
            name = "users_to_task",                            // nazwa tabeli
            joinColumns = @JoinColumn(name = "userId"),        // FK z tab users
            inverseJoinColumns = @JoinColumn(name = "taskId")  // FK z tab roles
    )
    private Set<Task> tasks = new HashSet<>();

    public User() {
    }

    public User(String name, String lastName, String email, String password, LocalDateTime registrationDateTime, boolean status) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.registrationDateTime = registrationDateTime;
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDateTime getRegistrationDateTime() {
        return registrationDateTime;
    }

    public void setRegistrationDateTime(LocalDateTime registrationDateTime) {
        this.registrationDateTime = registrationDateTime;
    }
}
