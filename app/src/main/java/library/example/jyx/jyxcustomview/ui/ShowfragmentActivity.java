package library.example.jyx.jyxcustomview.ui;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.jyx.mylibrary.annotation.ActivityFragmentInject;
import com.jyx.mylibrary.base.BaseActivity;
import com.jyx.mylibrary.base.BaseFragmentActivity;
import com.jyx.mylibrary.utils.StatusBarUtils;
import com.jyx.mylibrary.utils.ToastUtils;

import library.example.jyx.jyxcustomview.R;

@ActivityFragmentInject(contentViewId = R.layout.activity_showfragment)
public class ShowfragmentActivity extends BaseFragmentActivity {

    private String listType = "";

    @Override
    protected void initView() {
        listType = getIntent().getStringExtra("listType");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initToolBar() {
        StatusBarUtils.transparencyBar(this);
        StatusBarUtils.setStatusBarStyle(this, false);
        StatusBarUtils.setTopPadding(findViewById(R.id.mToolbarContainer));
    }

    @Override
    protected void initMethod() {
        try {
            Class<?> aClass = Class.forName(listType);
            Object o = aClass.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.show_fl,(Fragment)o)
                    .commit();
            return;
        } catch (ClassNotFoundException e) {
            ToastUtils.show("没有找到类");
        } catch (IllegalAccessException e) {
            ToastUtils.show("异常:"+e.toString());
        } catch (InstantiationException e) {
            ToastUtils.show("异常:"+e.toString());
        }
        finish();
    }
}
