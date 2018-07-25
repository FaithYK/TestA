package com.example.administrator.testa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.administrator.testa.adapter.TeacherAdapter;
import com.example.administrator.testa.bean.TeacherListBean;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements TeacherAdapter.OnItemClickListener{

    public List<TeacherListBean.DataBean.ListBean> teacherBean;
    private TeacherAdapter teacherAdapter;
    private RecyclerView teacherRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setEvent();
    }

    private void initViews() {
        teacherRecyclerView = findViewById(R.id.recyclerView);
    }

    private void setEvent() {

        InputStream inputStream =null;
        try {
            inputStream = getAssets().open("TeacherList.json");
            String teachersData = convertStraemToString(inputStream);
            Gson gson = new Gson();
            TeacherListBean listBean = gson.fromJson(teachersData,TeacherListBean.class);
            teacherBean = listBean.getData().getList();
            //设置布局管理器
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                    MainActivity.this);
            teacherRecyclerView.setLayoutManager(linearLayoutManager);
            teacherAdapter = new TeacherAdapter(MainActivity.this,teacherBean);
            teacherRecyclerView.setAdapter(teacherAdapter);
            teacherAdapter.setOnItemClickListener(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String convertStraemToString(InputStream inputStream){

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;

        try {
            while ((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return  stringBuilder.toString();
    }

    @Override
    public void onItemClick(int position, TeacherListBean.DataBean.ListBean teacher) {

    }
}
