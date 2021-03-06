package navigationBar;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.framelibrary.R;
import com.hc.navigationBar.AbsNavigationBar;

/**
 * Created by soft01 on 2017/4/23.
 * 邮箱：450848477@qq.com
 * Version:1.0
 * Description:默认的导航栏样式
 */

public class DefaultNavigationBar extends AbsNavigationBar<DefaultNavigationBar.Builder.DefaultNavigationParams> {

    public DefaultNavigationBar(DefaultNavigationBar.Builder.DefaultNavigationParams params) {
        super(params);
    }

    @Override
    public int bindLayoutId() {
        return R.layout.title_bar;
    }

    @Override
    public void applyView() {

        //绑定效果
        setText(R.id.title, getParams().mTitle);

        setText(R.id.right_text, getParams().mRightText);

        setOnClickListener(R.id.right_text, getParams().mRightClickListener);

        //设置左边按钮默认点击  finish事件
        setOnClickListener(R.id.back, getParams().mLeftClickListener);
    }


    public static class Builder extends AbsNavigationBar.Builder{

        DefaultNavigationParams P;

        public Builder(Context context, ViewGroup parent) {
            super(context, parent);
            P = new DefaultNavigationParams(context, parent);
        }

        public Builder(Context context){
            super(context, null);
            P = new DefaultNavigationParams(context, null);
        }

        @Override
        public DefaultNavigationBar builder() {
            DefaultNavigationBar navigationBar = new DefaultNavigationBar(P);
            return navigationBar;
        }

        //设置title标题
        public DefaultNavigationBar.Builder setTitle(String title){
            P.mTitle = title;
            return this;
        }

        //设置右边的文字
        public DefaultNavigationBar.Builder setRightText(String text){
            P.mRightText = text;
            return this;
        }

        //设置右边的图标
        public DefaultNavigationBar.Builder setRightIcon(String title){
            P.mTitle = title;
            return this;
        }

        //设置左边的按钮点击事件
        public DefaultNavigationBar.Builder setLeftClickListener(View.OnClickListener listener){
            P.mLeftClickListener = listener;
            return this;
        }

        //设置右边的按钮点击事件
        public DefaultNavigationBar.Builder setRightClickListener(View.OnClickListener listener){
            P.mRightClickListener = listener;
            return this;
        }

        //设置所有效果
        public static class DefaultNavigationParams extends AbsNavigationBar.Builder.AbsNavigationParams{

            public String mTitle;
            public String mRightText;

            public View.OnClickListener mRightClickListener;
            public View.OnClickListener mLeftClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((Activity)(mContext)).finish();
                }
            };
            //把设置的效果放进来

            DefaultNavigationParams(Context context, ViewGroup parent) {
                super(context, parent);
            }
        }
    }
}
