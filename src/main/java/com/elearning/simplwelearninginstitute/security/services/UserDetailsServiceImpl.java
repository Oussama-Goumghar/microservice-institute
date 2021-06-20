package com.elearning.simplwelearninginstitute.security.services;

import com.elearning.simplwelearninginstitute.entities.Etudiant;
import com.elearning.simplwelearninginstitute.entities.Institute;
import com.elearning.simplwelearninginstitute.entities.Prof;
import com.elearning.simplwelearninginstitute.service.EtudiantService;
import com.elearning.simplwelearninginstitute.service.InstituteService;
import com.elearning.simplwelearninginstitute.service.ProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	InstituteService instituteService;

	@Autowired
	EtudiantService etudiantService;
	@Autowired
	ProfService profService;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Institute institute = instituteService.findByLogin(login);
		if(institute!=null)  return UserDetailsImpl.build(institute,null,null);
		Etudiant etudiant = etudiantService.findByLogin(login);
		if(etudiant!=null)  return UserDetailsImpl.build(null,etudiant,null);
		Prof prof = profService.findByLogin(login);
		if(prof!=null)  return UserDetailsImpl.build(null,null,prof);
		return null;
	}

}
