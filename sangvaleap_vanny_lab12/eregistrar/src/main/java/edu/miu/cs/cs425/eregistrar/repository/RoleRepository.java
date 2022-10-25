package edu.miu.cs.cs425.eregistrar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.cs.cs425.eregistrar.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
