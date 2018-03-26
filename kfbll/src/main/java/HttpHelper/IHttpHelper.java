package HttpHelper;


import java.util.Map;

public interface IHttpHelper {
    void HttpPostData(String url, Map<String,Object> mapobject, OKhttphelper.OKcallback oKcallback);
    void HttpGetData(String url, Map<String,Object> mapobject, OKhttphelper.OKcallback oKcallback);
}
