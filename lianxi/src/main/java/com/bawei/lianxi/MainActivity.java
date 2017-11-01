package com.bawei.lianxi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bawei.lianxi.presenter.MainActivityPresenter;
import com.bawei.lianxi.view.MainActivityViewListener;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityViewListener{
    private List<Bean.SongListBean> list;
    private MainActivityPresenter presenter;
    private MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new MyAdapter(MainActivity.this,list);
        presenter = new MainActivityPresenter(this);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent in=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(in);
            }
        });
        presenter.getData(true);

    }

    @Override
    public void callBackSuccess(final Bean bean) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.setData(bean);
            }
        });
    }

    @Override
    public void callBackFailure(int code) {

    }
}
