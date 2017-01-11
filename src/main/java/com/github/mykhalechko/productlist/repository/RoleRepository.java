package com.github.mykhalechko.productlist.repository;

import com.github.mykhalechko.productlist.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
