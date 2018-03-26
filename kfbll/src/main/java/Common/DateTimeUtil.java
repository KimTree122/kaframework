package Common;


import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;

public class DateTimeUtil {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static String getCurrentTime(){
        String time = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        return  time;
    }

}
