import java.lang.Math.*;

class Time{
    public static int getDays(double minutes){
        return (int) Math.round(minutes/60/24);
    }

    public static int getHours(double minutes){
        return (int) Math.round((minutes - getDays(minutes)*24*60)/60);//retira-se os minutos dos dias anteiores primeiro.
    }

    public static int getMins(double minutes){
        return (int) Math.round(minutes - getDays(minutes)*24*60 - getHours(minutes)*60);
    }

    public static void printTime(double minutes){
        System.out.print(dayOfWeek(minutes) + " " + getHours(minutes) + ":" + getMins(minutes));
    }

    public static String dayOfWeek(double minutes){
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
