package com.example.lixiao.listviewcheck;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 全选
     */
    private Button mBtnAllSelect;
    /**
     * 反选
     */
    private Button mBtnInvertSelect;
    /**
     * 取消
     */
    private Button mBtnCancelSelect;
    private RecyclerView mRcv;
    private List<DataBean> dataList = new ArrayList<>();
    private RcvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    /**
     * 初始化数据
     */
    private void initData() {

        for (int i=0;i<50;i++){
            DataBean bean = new DataBean("商品"+i,false);
            dataList.add(bean);
        }
        //设置适配器
        adapter = new RcvAdapter(dataList,this);
        mRcv.setAdapter(adapter);
    }

    /**
     * 初始化视图
     */
    private void initView() {
        mBtnAllSelect = (Button) findViewById(R.id.btn_all_select);
        mBtnAllSelect.setOnClickListener(this);
        mBtnInvertSelect = (Button) findViewById(R.id.btn_invert_select);
        mBtnInvertSelect.setOnClickListener(this);
        mBtnCancelSelect = (Button) findViewById(R.id.btn_cancel_select);
        mBtnCancelSelect.setOnClickListener(this);
        mRcv = (RecyclerView) findViewById(R.id.rcv);
        //使RecyclerView保持固定的大小,这样会提高RecyclerView的性能。
        mRcv.setHasFixedSize(true);
        //给RecyclerView设置原生的下划线
        mRcv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        //确定布局
        mRcv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_all_select:
                adapter.allSelect();
                break;
            case R.id.btn_invert_select:
                adapter.invertSelect();
                break;
            case R.id.btn_cancel_select:
                adapter.cancelSelect();
                break;
        }
    }
}
