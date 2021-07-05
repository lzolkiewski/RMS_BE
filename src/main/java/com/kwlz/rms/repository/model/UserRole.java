package com.kwlz.rms.repository.model;

import com.kwlz.rms.repository.model.type.UserRoleType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "user_role", schema = "rms")
public class UserRole {

    @Id
    @EqualsAndHashCode.Exclude
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_generator")
    @SequenceGenerator(name = "user_role_generator", sequenceName = "user_role_seq",
            schema = "rms", allocationSize = 10)
    @Column(updatable = false, nullable = false)
    @Setter(AccessLevel.NONE)
    private BigDecimal id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", length = 64, nullable = false)
    private UserRoleType name;

}
