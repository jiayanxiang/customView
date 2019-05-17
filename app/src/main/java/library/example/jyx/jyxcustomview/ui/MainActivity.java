package library.example.jyx.jyxcustomview.ui;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toolbar;

import com.jyx.mylibrary.annotation.ActivityFragmentInject;
import com.jyx.mylibrary.base.BaseActivity;
import com.jyx.mylibrary.utils.StatusBarUtils;

import java.util.ArrayList;
import java.util.List;

import library.example.jyx.jyxcustomview.R;
import library.example.jyx.jyxcustomview.bean.MainItemBean;
import library.example.jyx.jyxcustomview.ui.adapter.MainListAdapter;
import library.example.jyx.jyxcustomview.ui.fragment.view3dRubik.FragmentView3dRubik;

@ActivityFragmentInject(contentViewId = R.layout.activity_main)
public class MainActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private List<MainItemBean> mainItemBeanList = new ArrayList<>();
    private MainListAdapter adapter;

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.recycler_view);
    }

    @Override
    protected void initData() {
        mainItemBeanList.clear();
        recyclerView.setLayoutManager(new LinearLayoutManager(getSelfActivity()));
        adapter = new MainListAdapter(getSelfActivity(), mainItemBeanList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new MainListAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position, MainItemBean mainItemBean) {
                Intent intent = new Intent();
                intent.putExtra("listType",mainItemBean.getListType());
                startActivityForIntent(ShowfragmentActivity.class,intent);
            }
        });
    }

    @Override
    protected void initToolBar() {
        StatusBarUtils.transparencyBar(this);
        StatusBarUtils.setStatusBarStyle(this, false);
        StatusBarUtils.setTopPadding(findViewById(R.id.view));
        Toolbar toolbar = (Toolbar) findViewById(com.jyx.mylibrary.R.id.toolbar);
        toolbar.setNavigationIcon(null);
    }

    @Override
    protected void initMethod() {
        loadData();
        adapter.notifyDataSetChanged();
    }

    //每次条目再次加载
    private void loadData() {
        mainItemBeanList.add(MainItemBean.cresteItem("01",FragmentView3dRubik.class.getName()));
    }
}
