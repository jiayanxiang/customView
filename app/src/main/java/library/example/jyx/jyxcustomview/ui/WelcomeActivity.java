package library.example.jyx.jyxcustomview.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.TextView;

import com.jyx.mylibrary.annotation.ActivityFragmentInject;
import com.jyx.mylibrary.base.BaseActivity;
import com.jyx.mylibrary.utils.StatusBarUtils;

import library.example.jyx.jyxcustomview.R;

@ActivityFragmentInject(contentViewId = R.layout.activity_welcome)
public class WelcomeActivity extends BaseActivity {

    private TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        StatusBarUtils.transparencyBar(this);
        StatusBarUtils.setStatusBarStyle(this,false);
    }

    @Override
    protected void initToolBar() {

    }

    @Override
    protected void initMethod() {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                startActivityForNoIntent(MainActivity.class);
                finish();
            }
        }, 5000);//给postDelayed()方法传递延迟参数
    }
}
