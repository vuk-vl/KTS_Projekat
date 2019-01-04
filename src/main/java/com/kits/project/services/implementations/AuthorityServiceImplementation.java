package com.kits.project.services.implementations;

import com.kits.project.exception.NotFoundException;
import com.kits.project.model.Authority;
import com.kits.project.repositories.AuthorityRepository;
import com.kits.project.services.interfaces.AuthorityServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorityServiceImplementation implements AuthorityServiceInterface {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    @Transactional(readOnly = true)
    public Authority findByName(String name) {
        Authority authority = this.authorityRepository.findByName(name);
        if(authority == null) throw new NotFoundException("Authority with name: " + name + " not found!");
        return authority;
    }
}