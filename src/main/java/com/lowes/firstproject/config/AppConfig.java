package com.lowes.firstproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.net.http.HttpRequest;
import java.util.ArrayList;

@EnableWebSecurity
@Configuration
public class AppConfig {

    @Autowired
    private HttpSecurity httpSecurity;

    @Bean
    public InMemoryUserDetailsManager create(){

      /*  ArrayList<GrantedAuthority> authority =new ArrayList<>();
        authority.add(new SimpleGrantedAuthority("admin"));
        authority.add(new SimpleGrantedAuthority("user"));

        UserDetails user=new User("ajay","ajay123",authority);

        InMemoryUserDetailsManager inmemo=new InMemoryUserDetailsManager();
        inmemo.createUser(user);
        return  inmemo;*/

        UserDetails ajayUser=User.withUsername("ajay").password("{noop}ajay").authorities("admin").build();
        UserDetails ganga=User.withUsername("ganga").password("{noop}ganga").authorities("user").build();
        UserDetails sai = User.withUsername("sai").password("{noop}sai").authorities("admin").build();
        return new InMemoryUserDetailsManager(ajayUser,ganga,sai);


    }

   /* @Bean
    public PasswordEncoder encoder(){
        return NoOpPasswordEncoder.getInstance();
    }*/



     @Bean
    SecurityFilterChain settingUpCustomSecurity() throws Exception {
      return   httpSecurity
              .authorizeHttpRequests(customizer ->{

            customizer.requestMatchers("/hi").authenticated();
            customizer.requestMatchers("/bye").hasRole("admin");
        }).httpBasic(Customizer.withDefaults()) .formLogin(Customizer.withDefaults())
              .build();




    }
}
