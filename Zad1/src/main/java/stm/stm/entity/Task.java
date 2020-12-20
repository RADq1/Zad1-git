package stm.stm.entity;

        import stm.stm.enums.type;

        import javax.persistence.*;
        import java.lang.reflect.Type;
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
    @Column
    private LocalDateTime dateAdded = LocalDateTime.now();
    @Column
    private stm.stm.enums.type type;
    @Column
    private stm.stm.enums.status status;

}
