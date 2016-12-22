package com.github.mykhalechko.productlist.dao;

import com.github.mykhalechko.productlist.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}
