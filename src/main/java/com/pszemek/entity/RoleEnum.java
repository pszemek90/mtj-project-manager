package com.pszemek.entity;

public enum RoleEnum {
    ROLE_USER("user"),
    ROLE_MOD("mod"),
    ROLE_ADMIN("admin");

    private final String simpleName;

    RoleEnum(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public static RoleEnum getFromSimpleName(String simpleName){
        for(RoleEnum role : values()){
            if (role.getSimpleName().equals(simpleName)){
                return role;
            }
        }
        return null;
    }
}
