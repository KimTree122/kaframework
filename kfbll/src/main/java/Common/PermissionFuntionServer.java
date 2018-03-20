package Common;


import com.kim.kfdao.Model.PermissionFuntion;
import java.util.ArrayList;
import java.util.List;

public class PermissionFuntionServer {

    private List<PermissionFuntion> mpermissionlist;

    public PermissionFuntionServer(List<PermissionFuntion> pflist){
        mpermissionlist = new ArrayList<>();
        mpermissionlist.addAll(pflist);
    }

    public List<PermissionFuntion> FilterPermissionFuntion(int FatherID){
        List<PermissionFuntion> newpflist = new ArrayList<>();
        for (PermissionFuntion funtion : mpermissionlist) {
            if ( funtion.getFID() == FatherID){
                newpflist.add(funtion);
            }
        }
        return  newpflist;
    }

}
