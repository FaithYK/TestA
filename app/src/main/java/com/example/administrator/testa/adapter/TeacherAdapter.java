package com.example.administrator.testa.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.testa.R;
import com.example.administrator.testa.bean.TeacherListBean;

import java.util.ArrayList;
import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<
        TeacherAdapter.TeacherViewHolder> implements View.OnClickListener{

    private static final String TAG = "TeacherAdapter";

    private List<TeacherListBean.DataBean.ListBean> teacherData = new ArrayList<>();
    private Context mContext;
    private OnItemClickListener onItemClickListener;
    private RecyclerView teacherDataRecycler;

    public TeacherAdapter(Context context,
                          List<TeacherListBean.DataBean.ListBean> teacherData) {
        this.mContext = context;
        this.teacherData = teacherData;
    }

    //对外提供接口初始化方法
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }

    @NonNull
    @Override
    public TeacherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item,parent,false);

        view.setOnClickListener(this);
        return new TeacherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherViewHolder holder, final int position) {

        Glide.with(mContext)
                .load(teacherData.get(position).getImg())
                .into(holder.teacherImage);
        holder.teacherName.setText(teacherData.get(position).getName());
        holder.teacherTitle.setText("从业八年");
        TextPaint textPaint = holder.teacherTitle.getPaint();
        textPaint.setFakeBoldText(true);
        holder.teacherContent.setText("\u3000\u3000"+teacherData.get(position).getDesc());

    }

    @Override
    public int getItemCount() {
        return teacherData == null ? 0 : teacherData.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        teacherDataRecycler = recyclerView;
    }

    @Override
    public void onClick(View v) {

        //RecyclerView可以计算出这是第几个Child
        int childAdapterPosition = teacherDataRecycler.getChildAdapterPosition(v);
        Log.e(TAG, "onClick: "+childAdapterPosition );
        if (onItemClickListener!=null) {
            onItemClickListener.onItemClick(childAdapterPosition,teacherData.get(childAdapterPosition));
        }
    }

    public static class TeacherViewHolder extends RecyclerView.ViewHolder{

        ImageView teacherImage;
        TextView teacherName;
        TextView teacherTitle;
        TextView teacherContent;
        CardView cardView;

        public TeacherViewHolder(View itemView) {
            super(itemView);

            teacherImage = itemView.findViewById(R.id.teacher_photo);
            teacherName = itemView.findViewById(R.id.teacher_tv_name);
            teacherTitle = itemView.findViewById(R.id.teacher_tv_title);
            teacherContent = itemView.findViewById(R.id.teacher_tv_content);
            cardView = itemView.findViewById(R.id.teacher_card_view);
        }
    }

    /**
     * 接口回调
     * 1、定义接口，定义接口中的方法
     * 2、在数据产生的地方持有接口，并提供初始化方法，在数据产生的时候调用接口的方法
     * 3、在需要处理数据的地方实现接口，实现接口中的方法，并将接口传递到数据产生的地方
     */
    public interface OnItemClickListener{
        void onItemClick(int position, TeacherListBean.DataBean.ListBean teacher);
    }

}
