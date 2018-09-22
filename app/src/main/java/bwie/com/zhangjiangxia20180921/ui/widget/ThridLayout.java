package bwie.com.zhangjiangxia20180921.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ThridLayout extends ViewGroup {
    public ThridLayout(Context context) {
        this(context,null);
    }

    public ThridLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ThridLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

        int childCount = getChildCount();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
         measureChildren(measuredWidth,measuredHeight);
        int mplaeft=0;
        int mptop=0;
        int maxheigt=0;
        for (int j = 0; j <childCount ; j++) {
            View v = getChildAt(j);
          maxheigt=  Math.max(maxheigt,v.getMeasuredHeight());
           //换行
            if (mplaeft+v.getMeasuredWidth()>measuredWidth){
                mplaeft=0;
                mptop+=maxheigt;
                maxheigt=0;
            }
            v.layout(mplaeft,mptop,mplaeft+v.getMeasuredWidth(),mptop+v.getMeasuredHeight());
            mplaeft+=v.getMeasuredWidth();
        }

    }
}
