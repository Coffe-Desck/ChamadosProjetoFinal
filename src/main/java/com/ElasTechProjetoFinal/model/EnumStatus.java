package com.ElasTechProjetoFinal.model;

import org.springframework.security.core.GrantedAuthority;

public enum EnumStatus implements GrantedAuthority {

    ABERTO("STATUS_ATIVO"),
    EM_ANDAMENTO("Status Em andamento"),
    PENDENTE("Pendente"),
    FECHADO("Fechado"),
    CANCELADO("Cancelado");


    private final String authority;

    EnumStatus(String authority) {
        this.authority = authority;
    }


    @Override
    public String getAuthority() {
        return "";
    }
}
