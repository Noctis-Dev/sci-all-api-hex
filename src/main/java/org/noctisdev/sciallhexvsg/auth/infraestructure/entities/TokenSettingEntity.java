package org.noctisdev.sciallhexvsg.auth.infraestructure.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "token_settings", schema = "sci_all_db")
public class TokenSettingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_settings_id", nullable = false)
    private Long id;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "verify_token_expiration_days")
    private Integer verifyTokenExpirationDays;

    @Column(name = "auth_token_expiration_days")
    private Integer authTokenExpirationDays;

}