package stm.stm.entity;

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
    private Timestamp dateAdded;
    @Column
    @Enumerated(EnumType.STRING)
    private stm.stm.enums.type type;
    @Column
    @Enumerated(EnumType.STRING)
    private stm.stm.enums.status status;

}
