package stm.stm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import stm.stm.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = " select * from user  where user_id = ?1 or email = ?2",nativeQuery = true)
    List<User> findByUserIdOrEmail(Integer userId, String email);

}
