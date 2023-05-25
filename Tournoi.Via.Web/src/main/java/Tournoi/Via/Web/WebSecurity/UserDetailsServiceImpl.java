/*
 * package Tournoi.Via.Web.WebSecurity;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.userdetails.*;
 * 
 * import Tournoi.Via.Web.Repository.UserRepository;
 * 
 * 
 * public class UserDetailsServiceImpl implements UserDetailsService {
 * 
 * @Autowired private UserRepository userRepository;
 * 
 * @Override public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException { Tournoi.Via.Web.Model.User user =
 * userRepository.getUserByUsername(username);
 * 
 * if (user == null) { throw new
 * UsernameNotFoundException("Could not find user"); }
 * 
 * return new MyUserDetails(user); }
 * 
 * }
 */