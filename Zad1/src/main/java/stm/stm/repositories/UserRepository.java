package stm.stm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stm.stm.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
