package bwie.com.zhangjiangxia20180921.ui.ativity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import bwie.com.zhangjiangxia20180921.R;
import bwie.com.zhangjiangxia20180921.ui.widget.ThridLayout;

public class ThrdlayoutClass extends AppCompatActivity {

    @BindView(R.id.thrid)
    ThridLayout thrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thrdlayout);
        ButterKnife.bind(this);




    }
}
