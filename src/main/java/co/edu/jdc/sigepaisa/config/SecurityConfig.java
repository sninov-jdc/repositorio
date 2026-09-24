package co.edu.jdc.sigepaisa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler successHandler() {
        return (request, response, authentication) -> {
            boolean esAdmin = authentication.getAuthorities().stream()
                    .anyMatch(a -> a.getAuthority().equals("ROLE_ADMINISTRADOR"));

            if (esAdmin) {
                response.sendRedirect("/admin/inicio");
            } else {
                response.sendRedirect("/vendedor/inicio");
            }
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/css/**", "/js/**", "/imagenes/**").permitAll()
                        .requestMatchers("/login").permitAll()

                        .requestMatchers("/admin/**").hasRole("ADMINISTRADOR")
                        .requestMatchers("/usuarios/**", "/proveedores/**", "/reportes/**")
                        .hasRole("ADMINISTRADOR")

                        .requestMatchers("/productos/nuevo", "/productos/editar/**",
                                "/productos/guardar", "/productos/desactivar/**")
                        .hasRole("ADMINISTRADOR")

                        .requestMatchers("/vendedor/**").hasAnyRole("ADMINISTRADOR", "VENDEDOR")
                        .requestMatchers("/productos/**", "/ventas/**", "/clientes/**")
                        .hasAnyRole("ADMINISTRADOR", "VENDEDOR")

                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .successHandler(successHandler())
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );

        return http.build();
    }
}