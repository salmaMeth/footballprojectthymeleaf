package Tournoi.Via.Web.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import Tournoi.Via.Web.Model.User;


public interface UserRepository extends CrudRepository<User, Long> {
	 
    @Query("SELECT u FROM User u WHERE u.username = :username")
    public User getUserByUsername(@Param("username") String username);
    
    @Query("SELECT u FROM User u WHERE u.username = :username and  u.password = :password")
    public User getUserByUsernamePassword(@Param("username") String username,@Param("password") String password);
}
