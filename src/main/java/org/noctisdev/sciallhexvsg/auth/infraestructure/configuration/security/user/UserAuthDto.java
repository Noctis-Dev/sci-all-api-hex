package org.noctisdev.sciallhexvsg.auth.infraestructure.configuration.security.user;

import lombok.Data;

@Data
public class UserAuthDto {
    private String email;
    private String password;
}
