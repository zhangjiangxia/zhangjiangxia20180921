package bwie.com.zhangjiangxia20180921;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import bwie.com.zhangjiangxia20180921.data.bean.InfoBaen;
import bwie.com.zhangjiangxia20180921.di.IContract;
import bwie.com.zhangjiangxia20180921.di.presenter.PresenterImpl;
import bwie.com.zhangjiangxia20180921.ui.adaptere.MyAdapter;

public class MainActivity extends AppCompatActivity implements IContract.IView {

    @BindView(R.id.m_expandable)
    ExpandableListView mExpandable;
    @BindView(R.id.m_check)
    CheckBox mCheck;
    @BindView(R.id.m_price)
    TextView mPrice;
    @BindView(R.id.m_num)
    TextView mNum;
    @BindView(R.id.m_jiesuan)
    Button mJiesuan;
    private IContract.IPresenter iPresenter;
    private List<InfoBaen.DataBean> data;
    private MyAdapter myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        iPresenter = new PresenterImpl();
        iPresenter.attData(this);
        iPresenter.infoData();
    }

    @Override
    public void showData(final String msg) {
        runOnUiThread(new Runnable() {



            @Override
            public void run() {
                Gson gson = new Gson();
                InfoBaen infoBaen = gson.fromJson(msg, InfoBaen.class);
                data = infoBaen.getData();
                myadapter = new MyAdapter(MainActivity.this, data);
                mExpandable.setAdapter(myadapter);
                for (int i = 0; i <data.size() ; i++) {
                   mExpandable.expandGroup(i);
                }
                myadapter.setOnChangeLinsenter(new MyAdapter.onChangeLinsenter() {
                    @Override
                    public void shopChang(int i) {
                        boolean shop = myadapter.isShop(i);
                        myadapter.shopall(i,!shop);
                        myadapter.notifyDataSetChanged();
                        refreshall();
                    }

                    @Override
                    public void goodChang(int i, int i1) {
                      myadapter.goodselect(i,i1);
                      myadapter.notifyDataSetChanged();
                      refreshall();
                    }

                    @Override
                    public void goodChang(int i, int i1, int num) {
                     myadapter.numshange(i,i1,num);
                     myadapter.notifyDataSetChanged();
                     refreshall();
                    }
                });
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iPresenter.deleteData(this);
    }

    @OnClick({R.id.m_check, R.id.m_jiesuan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_check:
                boolean allChacked = myadapter.isAllChacked();
                myadapter.chageAll(!allChacked);
                myadapter.notifyDataSetChanged();
//               recreate();
                break;
            case R.id.m_jiesuan:
                break;
        }
    }

    private void refreshall(){
        boolean allChacked = myadapter.isAllChacked();
        mCheck.setChecked(allChacked);

        double allprice=myadapter.allPrice();
        mPrice.setText("总价为：¥"+allprice);
        int sunm=myadapter.allNum();
        mNum.setText("共"+sunm+"件商品");
    }
}
