package mesi.gta.legendarymotorsport.utility

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager

@Configuration
@EnableWebSecurity
class SecurityConfigurator : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
                .antMatchers("/vehicle").hasRole("admin")
                .and().csrf().disable()

//        http.authorizeRequests()
//                .antMatchers("/", "/index").hasRole("user")
//                .and()
//                .formLogin()
//                .and().httpBasic()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
                .withUser("admin").password(encoder().encode("password")).roles("admin", "user")
                .and()
                .withUser("user").password(encoder().encode("password")).roles("user")
    }

    @Bean
    fun encoder() = BCryptPasswordEncoder()

//    @Bean
//    override fun userDetailsServiceBean(): UserDetailsService {
//        val user = User.withDefaultPasswordEncoder()
//                .username("rico")
//                .password("password")
//                .roles("user")
//                .build()
//
//        val modifier = User.withDefaultPasswordEncoder()
//                .username("mesi")
//                .password("password")
//                .roles("modifier")
//                .build()
//
//        return InMemoryUserDetailsManager(user, modifier)
//    }
}