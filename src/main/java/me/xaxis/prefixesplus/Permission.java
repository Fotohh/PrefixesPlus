package me.xaxis.prefixesplus;

public enum Permission {

    SET_PREFIX,
    REMOVE_PREFIX,
    ADMIN;

    public String string(PrefixesPlus instance){

        switch (this){

            case SET_PREFIX ->{
                return instance.getConfig().getString("Permission.set_prefix");
            }
            case REMOVE_PREFIX -> {
                return instance.getConfig().getString("Permission.remove_prefix");
            }
            case ADMIN -> {
                return instance.getConfig().getString("Permission.admin");
            }

        }

        return "";

    }

}
