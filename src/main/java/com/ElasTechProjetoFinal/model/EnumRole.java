package com.ElasTechProjetoFinal.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Getter
@NoArgsConstructor
public enum EnumRole implements GrantedAuthority {
  
   ADMIN("Role ADMIN"),
    USER("Role USER"),
    TECHNICIAN("Role TECHNICIAN");

    private String authority;

    EnumRole(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
