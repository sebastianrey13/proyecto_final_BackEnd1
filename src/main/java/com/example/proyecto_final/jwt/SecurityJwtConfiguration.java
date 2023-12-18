package com.example.proyecto_final.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.example.proyecto_final.model.AppUserRole.ADMIN;
import static com.example.proyecto_final.model.AppUserRole.USER;

@Configuration
@EnableWebSecurity
public class SecurityJwtConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/","/**/index.html","/**/index.css","/**/iniciar_sesion.js","/**/db_clinica").permitAll()
                .antMatchers("/**/clinica.html","/**/odontologo.html","/**/paciente.html","/**/turno.html","/**/cruds.css").permitAll()
                .antMatchers("/**/cruds.css","/**/crud_odontologo.js","/**/crud_paciente.js","/**/crud_turno.js","/**/menu.js").permitAll()
                .antMatchers("/pacientes/buscarTodos","/odontologos/buscarTodos","/turnos/crear","/turnos/buscar").hasAnyAuthority(USER.name(), ADMIN.name())
                .antMatchers("/pacientes/**","/odontologos/**","/turnos/**").hasAuthority(ADMIN.name())
                .antMatchers("/autenticar").permitAll()
                .antMatchers("/registrarse").permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}