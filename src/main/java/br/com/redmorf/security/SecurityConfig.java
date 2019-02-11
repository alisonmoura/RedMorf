package br.com.redmorf.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import br.com.redmorf.model.Usuario;
import br.com.redmorf.repository.UsuarioRepository;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UsuarioRepository usuarioRepository ;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.userDetailsService(userDetailsService())
		.formLogin()
		.defaultSuccessUrl("/index.xhtml").and()
		.csrf()
		.disable()
		.authorizeRequests()
		.antMatchers("/usuario.xhtml")
		.hasRole("ADMIN")
		.antMatchers("/produtos.xhtml")
		.hasRole("ADMIN")
		.anyRequest().authenticated();
		
	}
	
	@Override
	protected UserDetailsService userDetailsService() {
		
		List<Usuario> usuarios = usuarioRepository.findAll();
		 
		List<UserDetails> users = new ArrayList<>();
		 
		for (Usuario u: usuarios){
	      		UserDetails user = new User(u.getLogin(), u.getSenha(), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_"+u.getPerfil()));
		    	users.add(user);
		}
		return new InMemoryUserDetailsManager(users);
	}
}
