/*
 * package Tournoi.Via.Web.WebSecurity;
 * 
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.*; import
 * org.springframework.security.authentication.dao.*; import
 * org.springframework.security.config.annotation.authentication.builders.*;
 * import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.*;
 * import org.springframework.security.core.userdetails.UserDetailsService;
 * import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class WebSecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Override
 * 
 * @Bean public UserDetailsService userDetailsService() { return new
 * UserDetailsServiceImpl(); }
 * 
 * @Bean public BCryptPasswordEncoder passwordEncoder() { return new
 * BCryptPasswordEncoder(); }
 * 
 * @Bean public DaoAuthenticationProvider authenticationProvider() {
 * DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
 * authProvider.setUserDetailsService(userDetailsService());
 * authProvider.setPasswordEncoder(passwordEncoder());
 * 
 * return authProvider; }
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception { auth.authenticationProvider(authenticationProvider()); }
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * http.authorizeRequests().antMatchers("/").hasAnyAuthority("USER", "CREATOR",
 * "EDITOR", "ADMIN") .antMatchers("/new").hasAnyAuthority("ADMIN",
 * "CREATOR").antMatchers("/edit/**") .hasAnyAuthority("ADMIN",
 * "EDITOR").antMatchers("/delete/**").hasAuthority("ADMIN")
 * .antMatchers("/h2-console/**").permitAll().anyRequest().authenticated().and()
 * .formLogin()
 * .loginPage("/login").usernameParameter("username").passwordParameter(
 * "password") .permitAll()
 * .and().logout().permitAll().and().exceptionHandling().accessDeniedPage("/403"
 * );
 * 
 * http.csrf().disable(); http.headers().frameOptions().disable(); }
 * 
 * }
 */