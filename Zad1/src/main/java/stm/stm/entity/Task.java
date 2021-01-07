package stm.stm.entity;

        import org.apache.tomcat.jni.Local;
        import stm.stm.enums.status;
        import stm.stm.enums.type;

        import javax.persistence.*;
        import java.sql.Timestamp;
        import java.time.LocalDateTime;

@Entity
@Table
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;

    @Column
    private String title;
    @Column
    private String description;
    @Column(columnDefinition="timestamp default CURRENT_TIMESTAMP")
    private LocalDateTime dateAdded;
    @Column
    @Enumerated(EnumType.STRING)
    private stm.stm.enums.type type;
    @Column
    @Enumerated(EnumType.STRING)
    private stm.stm.enums.status status;
    @ManyToOne
    User user;

    public int getTaskId() {
        return taskId;
    }

    public Task() {
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public stm.stm.enums.type getType() {
        return type;
    }

    public void setType(stm.stm.enums.type type) {
        this.type = type;
    }

    public stm.stm.enums.status getStatus() {
        return status;
    }

    public void setStatus(stm.stm.enums.status status) {
        this.status = status;
    }
    public Task(String title, String description, LocalDateTime dateAdded, type type, status status, User user) {
        this.title = title;
        this.description = description;
        this.dateAdded = dateAdded;
        this.type = type;
        this.status = status;
        this.user = user;
    }
}
