package library.example.jyx.jyxcustomview.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import library.example.jyx.jyxcustomview.R;
import library.example.jyx.jyxcustomview.bean.MainItemBean;

/**
 * @author jyx
 * @CTime 2019/5/17
 * @explain:
 */
public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolder> {

    private Context context;
    private List<MainItemBean> mainItemBeans;

    public MainListAdapter(Context context, List<MainItemBean> mainItemBeans) {
        this.context = context;
        this.mainItemBeans = mainItemBeans;
    }

    @NonNull
    @Override
    public MainListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.main_list_item, viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainListAdapter.ViewHolder viewHolder, final int i) {
        final MainItemBean mainItemBean = mainItemBeans.get(i);
        viewHolder.textView.setText(mainItemBean.getTitle());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onClick(i, mainItemBean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mainItemBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.main_item_txt);
        }
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(int position, MainItemBean mainItemBean);
    }
}
