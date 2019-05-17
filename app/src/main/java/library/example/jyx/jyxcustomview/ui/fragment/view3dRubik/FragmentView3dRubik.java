package library.example.jyx.jyxcustomview.ui.fragment.view3dRubik;

import android.support.v4.app.Fragment;
import android.view.View;

import com.jyx.mylibrary.annotation.ActivityFragmentInject;
import com.jyx.mylibrary.base.BaseFragment;

import javax.microedition.khronos.opengles.GL10;

import library.example.jyx.jyxcustomview.R;

/**
 * @author jyx
 * @CTime 2019/5/17
 * @explain:
 */

@ActivityFragmentInject(contentViewId = R.layout.fragment_view_3d_rubik)
public class FragmentView3dRubik extends BaseFragment {

    private View3D view3D;
    @Override
    protected void initView(View rootView) {
        view3D = rootView.findViewById(R.id.view3d);
    }

    @Override
    protected void initData() {
        view3D.setRenderer(new View3D.Renderer() {
            @Override
            public int[] getConfigSpec() {
                return new int[6];
            }

            @Override
            public void surfaceCreated(GL10 gl) {

            }

            @Override
            public void sizeChanged(GL10 gl, int width, int height) {

            }

            @Override
            public void drawFrame(GL10 gl) {

            }
        });
    }

    @Override
    protected void initToolBar() {

    }

    @Override
    protected void initMethod() {

    }
}
