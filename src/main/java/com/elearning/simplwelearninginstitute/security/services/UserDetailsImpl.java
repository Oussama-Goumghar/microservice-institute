package com.elearning.simplwelearninginstitute.security.services;

import com.elearning.simplwelearninginstitute.entities.Etudiant;
import com.elearning.simplwelearninginstitute.entities.Institute;
import com.elearning.simplwelearninginstitute.entities.Prof;
import com.elearning.simplwelearninginstitute.entities.User;
import lombok.Data;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Data
public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;
	private User user;

	public UserDetailsImpl(Institute institute,Etudiant etudiant,Prof prof) {
		if(institute!=null){
			user = new User();
			user.setType("INSTITUTE");
			user.setId(institute.getId());
			user.setEmail(institute.getEmail());
			user.setPassword(institute.getPassword());
			user.setLogin(institute.getLogin());
		}
		else if(etudiant!=null){
			user = new User();
			user.setType("ETUDIANT");
			user.setId(etudiant.getId());
			user.setEmail(etudiant.getEmail());
			user.setPassword(etudiant.getPassword());
			user.setLogin(etudiant.getLogin());
		}
		else if(prof!=null){
			user = new User();
			user.setType("PROF");
			user.setId(prof.getId());
			user.setEmail(prof.getEmail());
			user.setPassword(prof.getPassword());
			user.setLogin(prof.getLogin());
		}
	}

	public static UserDetailsImpl build(Institute institute,Etudiant etudiant,Prof prof) {
		return new UserDetailsImpl(institute,etudiant,prof);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}
	@Override
	public String getUsername() {
		return user.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}


}
