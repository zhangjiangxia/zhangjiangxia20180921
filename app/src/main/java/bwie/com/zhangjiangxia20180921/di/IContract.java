package bwie.com.zhangjiangxia20180921.di;

public interface IContract {
    interface IView{
     void showData(String msg);
    }
    interface IModel{
        interface oncallBack{
            void stringMsg(String Msg);
        }
     void requestData(oncallBack oncallBack);
    }
    interface IPresenter<IView>{
      void  attData(IView iView);
      void  deleteData(IView iView);
      void  infoData();
    }
}
