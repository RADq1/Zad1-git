package stm.stm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stm.stm.entity.Task;
@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
}
