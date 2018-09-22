package bwie.com.zhangjiangxia20180921.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import bwie.com.zhangjiangxia20180921.R;

public class MyView extends LinearLayout implements View.OnClickListener {
    TextView num;
    ImageView add, dec,dec_no;


    private int number = 1;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        num.setText(number+"");
    }

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.zidingyimyview, this);
        num = view.findViewById(R.id.tv_number);
        add = view.findViewById(R.id.im_add);
        dec = view.findViewById(R.id.im_delete);
        dec_no = view.findViewById(R.id.im);
        add.setOnClickListener(this);
        dec.setOnClickListener(this);
        dec.setVisibility(View.GONE);
    }


    onNumChange onNumChange;

    public void setOnNumChange(MyView.onNumChange onNumChange) {
        this.onNumChange = onNumChange;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.im_delete:
                if (number > 1) {
                    dec_no.setVisibility(View.GONE);
                    dec.setVisibility(View.VISIBLE);
                    --number;
                    num.setText(number + "");
                    if (onNumChange != null) {
                        onNumChange.onNumberChange(number);
                    }
                } else {
                    dec.setVisibility(View.GONE);
                    dec_no.setVisibility(View.VISIBLE);
                    Toast.makeText(getContext(), "不能小于一", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.im_add:
                ++number;
                dec_no.setVisibility(View.GONE);
                dec.setVisibility(View.VISIBLE);
                num.setText(number + "");
                if (onNumChange != null) {
                    onNumChange.onNumberChange(number);
                }
                break;
        }
    }

    public interface onNumChange {
        void onNumberChange(int number);

    }
}
