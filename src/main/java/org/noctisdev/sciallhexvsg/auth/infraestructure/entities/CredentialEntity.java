package org.noctisdev.sciallhexvsg.auth.infraestructure.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "credentials", schema = "sci_all_db")
public class CredentialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "credential_id", nullable = false)
    private Long id;

    @Size(max = 36)
    @NotNull
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "credential_uuid", nullable = false, length = 36)
    private UUID credentialUuid;

    @NotNull
    @Column(name = "verified_at", nullable = false)
    private LocalDate verifiedAt;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Size(max = 255)
    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "token_id", nullable = false)
    private TokenEntity tokenEntity;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

}