package HttpHelper;

import android.net.Uri;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.MediaType;
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
            builder.url(buildGetRequestParm());
            builder.get();
        }else {
            builder.post(buildRequestBody());
            builder.url(mBuilder.url);
        }

        return builder.build();
    }


    private RequestBody buildRequestBody(){
        if (mBuilder.isJsonParm){
            JsonObject jsonObject = new JsonObject();
            for (RequestParm p: mBuilder.parms){
                jsonObject.addProperty(p.getKey(),p.getValue().toString());
            }
            String json = jsonObject.toString();
            return RequestBody.create(MediaType.parse("application/json; charset=utf-8"),json);
        }

        FormBody.Builder builder = new FormBody.Builder();
        for (RequestParm p : mBuilder.parms){
            builder.add(p.getKey(),p.getValue()==null?"":p.getValue().toString());
        }

        return  builder.build();
    }


    public void enqueue(BaseCallBack callBack){
         OKHttpManager.getmInstance().request(this,callBack);
    }

    public  static Builder newBuilder(){
        return new Builder();
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
            return post();
        }

        public Builder addParm(String key,Object value){
            if (parms == null){
                parms = new ArrayList<>();
            }
            parms.add(new RequestParm(key,value)) ;
            return  this;
        }
    }

    public String buildGetRequestParm(){
        if (mBuilder.parms.size() <=0){
            return this.mBuilder.url;
        }
        Uri.Builder builder = Uri.parse(mBuilder.url).buildUpon();
        for (RequestParm p : mBuilder.parms){
            builder.appendQueryParameter(p.getKey(),p.getValue()==null?"":p.getValue().toString());
        }
        String url = builder.build().toString();
        return  url;
    }

}
