package com.example.lenovo.goaaha;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CurrencyList extends AppCompatActivity {
    private ImageView back;
    private List<Country> ls = new ArrayList<Country>();
    private CurrencyAdapter myadapter;
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currency_list);
        //1、修改当前activity的布局文件，加入ListView控件并设置id
        //2、定义数据源，字符串数组
        //3、定义item布局，使用Android内置listview的item布局
        //4、根据数据源与item布局定义adapter
//        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        //5、得到ListView对象，并设置adapter
        getData();
        myadapter = new CurrencyAdapter(this,ls);
        lv = (ListView)findViewById(R.id.CountryLv);
        lv.setAdapter(myadapter);
        //6、给ListView设置item点击监听器，实现点击效果
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(CurrencyList.this,"你点击了"+i+"项",Toast.LENGTH_SHORT).show();
            }
        });

        back = (ImageView) findViewById(R.id.back) ;
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }

    private void getData() {
        ls.add(new Country(0L,"CNY","人民币",R.drawable.china));
        ls.add(new Country(1L,"HKD","港币",R.drawable.china));
        ls.add(new Country(2L,"USD","美元",R.drawable.usa));
        ls.add(new Country(3L,"KRW","韩元",R.drawable.south_korea));
        ls.add(new Country(4L,"JPY","日元",R.drawable.japan));
        ls.add(new Country(5L,"CAD","加拿大元",R.drawable.canada));
    }
}
