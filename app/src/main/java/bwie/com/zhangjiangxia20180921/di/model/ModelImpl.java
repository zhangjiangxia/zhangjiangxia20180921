package bwie.com.zhangjiangxia20180921.di.model;

import java.io.IOException;

import bwie.com.zhangjiangxia20180921.data.utils.OkHttpUtils;
import bwie.com.zhangjiangxia20180921.di.IContract;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ModelImpl implements IContract.IModel {
    private static  final  String GETURL="https://www.zhaoapi.cn/product/getCarts?uid=71";
    @Override
    public void requestData(final oncallBack oncallBack) {
        OkHttpUtils.getInstance().get(GETURL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String estring = e.getMessage().toString();
                oncallBack.stringMsg(estring);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responsestring = response.body().string();
                oncallBack.stringMsg(responsestring);
            }
        });
    }
  
}
