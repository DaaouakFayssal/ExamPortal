package com.examun.service;
import com.examun.models.Role;
import com.examun.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepo;

    public Role createNewRole(Role role) {
        return roleRepo.save(role);
    }
}