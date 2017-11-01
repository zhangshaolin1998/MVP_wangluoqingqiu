package com.bawei.lianxi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 于俊建 on 2017/10/30.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{
    private Context context;
    private List<Bean.SongListBean>list;
    private OnItemClickListener mOnItemClickListener = null;
    public MyAdapter(Context context, List<Bean.SongListBean> list){
            this.context=context;
            this.list=list;
    }
    public void setData(Bean bean){

        if(this.list == null){
            this.list = new ArrayList<>();
        }
        this.list.addAll(bean.getSong_list());
        notifyDataSetChanged();

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        IViewHolder holder=new IViewHolder(view);
        view.setOnClickListener(this);


        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        IViewHolder viewHolder=new IViewHolder(holder.itemView);
        ViewGroup.LayoutParams params = viewHolder.img.getLayoutParams();//得到item的LayoutParams布局参数
        viewHolder.img.setLayoutParams(params);//把params设置给itemView布局
        viewHolder.tv1.setText(list.get(position).getTitle());
        viewHolder.tv2.setText(list.get(position).getAuthor());
        ImageLoader.getInstance().displayImage(list.get(position).getPic_big(),viewHolder.img,MyApp.getDisp());
        viewHolder.itemView.setTag(position);


    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(view,(int)view.getTag());
        }
    }

    public class IViewHolder extends RecyclerView.ViewHolder{

        private final ImageView img;
        private final TextView tv1;
        private final TextView tv2;

        public IViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);

        }
    }
    //define interface
    public static interface OnItemClickListener {
        void onItemClick(View view , int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

}
