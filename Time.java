import java.lang.Math.*;

class Time{
    public static int getDays(int minutes){
        return minutes/60/24;
    }

    public static int getHours(int minutes){
        return (minutes - getDays(minutes)*60*24) /60;//retira-se os minutos dos dias anteriores primeiro.
    }

    public static int getMins(int minutes){
        return minutes - getDays(minutes)*24*60 - getHours(minutes)*60;
    }

    public static String getTime(int minutes){
        return dayOfWeek(minutes) + " " + getHours(minutes) + ":" + getMins(minutes);
    }

    public static String dayOfWeek(int minutes){
        switch(getDays(minutes)){
            case 0: return "mo";
            case 1: return "tu";
            case 2: return "we";
            case 3: return "th";
            case 4: return "fr";
            case 5: return "sa";
            case 6: return "su";
            default: return "ERRO";
        }
    }
}
