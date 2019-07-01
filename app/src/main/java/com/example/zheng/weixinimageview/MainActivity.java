package com.example.zheng.weixinimageview;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.zheng.weixinimageview.adapter.PhotoPagerAdapter;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TextView tvNum;
    private ArrayList<String> urlList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initParam();
        initView();

    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tvNum = (TextView) findViewById(R.id.tv_num);
        PhotoPagerAdapter viewPagerAdapter = new PhotoPagerAdapter(getSupportFragmentManager(), urlList);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                tvNum.setText(String.valueOf(position + 1) + "/" + urlList.size());
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initParam() {
        //需要加载的网络图片
        String[] urls = {
                "http://a.hiphotos.baidu.com/image/pic/item/00e93901213fb80e3b0a611d3fd12f2eb8389424.jpg",
                "http://b.hiphotos.baidu.com/image/pic/item/5243fbf2b2119313999ff97a6c380cd790238d1f.jpg",
                "http://f.hiphotos.baidu.com/image/pic/item/43a7d933c895d1430055e4e97af082025baf07dc.jpg"
        };

        urlList = new ArrayList<>();
        Collections.addAll(urlList, urls);
    }

}
