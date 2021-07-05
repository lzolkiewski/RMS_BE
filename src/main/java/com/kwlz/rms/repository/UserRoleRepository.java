package com.kwlz.rms.repository;

import com.kwlz.rms.repository.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, BigDecimal> {
}
