package com.kwlz.rms.userrole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, BigDecimal> {
}
