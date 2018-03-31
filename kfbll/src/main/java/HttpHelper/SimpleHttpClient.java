package HttpHelper;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import okhttp3.RequestBody;


public class SimpleHttpClient {

    private Builder mBuilder;

    private SimpleHttpClient(Builder builder){
        this.mBuilder = builder;
    }

    public Request builderRequest(){

        Request request = null;

        Request.Builder builder = new Request.Builder();
        if (mBuilder.method.equals("GET")){
            builder.get();
        }else {
            builder.post(buildRequestBody());
            builder.url(mBuilder.url);
        }

        return builder.build();
    }


    private RequestBody buildRequestBody(){
        return  null;
    }


    public void enqueue(BaseCallBack callBack){
         OKHttpManager.getmInstance().request(this,callBack);
    }

    public  static Builder newBuilder(){
        return newBuilder();
    }

    public static class Builder {

        private String url;
        private String method;
        private boolean isJsonParm;
        private List<RequestParm> parms;


        public SimpleHttpClient build(){

            return  new SimpleHttpClient(this);
        }

        public Builder get(){
            method = "GET";
            return this;
        }

        public Builder post(){
            method = "POST";
            return this;
        }

        public Builder json(){
            isJsonParm = true;
            return post();
        }

        public Builder rul(String url){
            this.url = url;
            return this;
        }

        public Builder addParm(String key,Object value){
            if (parms == null){
                parms = new ArrayList<>();
            }
            parms.add(new RequestParm(key,value)) ;
            return  this;
        }
    }

}
