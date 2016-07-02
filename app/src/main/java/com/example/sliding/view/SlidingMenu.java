package com.example.sliding.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.example.administrator.qqsliding.R;

/**
 * Created by Administrator on 2016/7/2.
 */
public class SlidingMenu extends HorizontalScrollView{
    private LinearLayout mWrapper;
    private ViewGroup mMenu;
    private ViewGroup mContent;
    private int screenwidth;
    private int menuwidth;
    private int menuRightMargin ;
    private boolean once = false;

    /**
     * 使用了自定义属性时调用此构造方法
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public SlidingMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //获取自定义的属性
        TypedArray array=context.getTheme().obtainStyledAttributes(attrs, R.styleable.SlidingMenu,defStyleAttr,0);
    int count =array.getIndexCount();//获取自定义属性的数量
        //System.out.print(count);
        Log.i("info",String.valueOf(count));
        for(int i=0;i<count;i++){
              int att= array.getIndex(i);
            switch (att){
                case R.styleable.SlidingMenu_rightmargin:
                    menuRightMargin =array.getDimensionPixelSize(att,(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,50,context.getResources().getDisplayMetrics()));
            break;
            }

        }
        array.recycle();
    }

    public SlidingMenu(Context context, AttributeSet attrs) {
        //super(context, attrs);
        this(context,attrs,0);
       // WindowManager windowManager= (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
       // DisplayMetrics outMetrics=new DisplayMetrics();
       // windowManager.getDefaultDisplay().getMetrics(outMetrics);
       // screenwidth=outMetrics.widthPixels;
        //把DP转化为SP
        //menuRightMargin= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,50,context.getResources().getDisplayMetrics());
    }

  //  public SlidingMenu(Context context) {
    //    this(context,null);
   // }

    /**
     * 设置子类和自己的宽和高
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!once) {
            mWrapper = (LinearLayout) getChildAt(0);
            mMenu = (ViewGroup) mWrapper.getChildAt(0);
            mContent = (ViewGroup) mWrapper.getChildAt(1);
            menuwidth=mMenu.getLayoutParams().width = screenwidth - menuRightMargin;
            mContent.getLayoutParams().width = screenwidth;


           once=true;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    /**
     * 通过设置偏移量，将menu隐藏
     * @param changed
     * @param l
     * @param t
     * @param r
     * @param b
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if(changed){
            this.scrollTo(menuwidth,0);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action=ev.getAction();
        switch (action){
            case MotionEvent.ACTION_UP:
                int scrollX=getScrollX();
                if(scrollX>menuwidth/2){
                    this.smoothScrollTo(menuwidth,0);

                }
                else {
                    this.smoothScrollTo(0,0);
                }
                return true;
        }
        return super.onTouchEvent(ev);
    }
}
