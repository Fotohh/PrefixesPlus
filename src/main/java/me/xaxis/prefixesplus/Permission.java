package me.xaxis.prefixesplus;

public enum Permission {

    SET_PREFIX,
    REMOVE_PREFIX,
    ADMIN;

    public String string(PrefixesPlus instance){

        switch (this){

            case SET_PREFIX ->{
                return instance.getConfig().getString("Permissions.set_prefix");
            }
            case REMOVE_PREFIX -> {
                return instance.getConfig().getString("Permissions.remove_prefix");
            }
            case ADMIN -> {
                return instance.getConfig().getString("Permissions.admin");
            }

        }

        return "";

    }

}
