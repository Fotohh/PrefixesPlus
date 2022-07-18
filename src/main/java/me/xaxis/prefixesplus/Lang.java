package me.xaxis.prefixesplus;

public enum Lang {

    NO_PERMISSION,
    SENDER_NOT_PLAYER,
    PLAYER_INVALID,
    KEY_INVALID;

    public String string(PrefixesPlus instance){

        switch (this){

            case NO_PERMISSION ->{
                return instance.getConfig().getString("Lang.no_permission");
            }
            case SENDER_NOT_PLAYER -> {
                return instance.getConfig().getString("Lang.sender_not_player");
            }
            case PLAYER_INVALID -> {
                return instance.getConfig().getString("Lang.invalid_player");
            }
            case KEY_INVALID -> {
                return instance.getConfig().getString("Lang.key_invalid");
            }

        }

        return "";

    }

}
