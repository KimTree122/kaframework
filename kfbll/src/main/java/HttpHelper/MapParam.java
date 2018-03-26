package HttpHelper;


import java.util.Map;

public  class MapParam {

    private  Map<Object,Object> objectMap;

    MapParam(Map<Object,Object> objectMap){
        this.objectMap = objectMap;
    }

    MapParam(){}

    public  MapParam setParam (String key,String value){
        objectMap.put(key,value);
        return this;
    }

    public MapParam Finish(){
        return  new MapParam(this.objectMap);
    }

//    public Map<Object,Object> getObjectMap(){
//        return objectMap;
//    }


}
