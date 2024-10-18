package org.noctisdev.sciallhexvsg.auth.infraestructure.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "token_types", schema = "sci_all_db")
public class TokenTypeEntity {
    @Id
    @Column(name = "token_type_id", nullable = false)
    private Long id;

    @NotNull
    @Lob
    @Column(name = "type", nullable = false)
    private String type;

}