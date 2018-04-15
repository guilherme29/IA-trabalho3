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
}
