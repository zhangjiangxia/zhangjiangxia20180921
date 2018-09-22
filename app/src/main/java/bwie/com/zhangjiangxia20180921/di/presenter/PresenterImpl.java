package bwie.com.zhangjiangxia20180921.di.presenter;

import java.lang.ref.WeakReference;

import bwie.com.zhangjiangxia20180921.di.IContract;
import bwie.com.zhangjiangxia20180921.di.model.ModelImpl;

public class PresenterImpl implements IContract.IPresenter<IContract.IView> {
    IContract.IView iView;
    private IContract.IModel iModel;
    private WeakReference<IContract.IView> iViewWeakReference;
    private WeakReference<IContract.IModel> iModelWeakReference;

    @Override
    public void attData(IContract.IView iView) {
    this.iView=iView;
        iModel = new ModelImpl();
        iViewWeakReference = new WeakReference<>(iView);
        iModelWeakReference = new WeakReference<>(iModel);

    }

    @Override
    public void deleteData(IContract.IView iView) {
        iViewWeakReference.clear();
        iModelWeakReference.clear();
    }

    @Override
    public void infoData() {
       iModel.requestData(new IContract.IModel.oncallBack() {
           @Override
           public void stringMsg(String Msg) {
               iView.showData(Msg);
           }
       });
    }
}
