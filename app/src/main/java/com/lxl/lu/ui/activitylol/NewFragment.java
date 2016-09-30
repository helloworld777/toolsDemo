package com.lxl.lu.ui.activitylol;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ListView;

import com.lxl.lu.toolsample.R;
import com.lxl.lu.ui.widget.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2016/9/30.
 */
public class NewFragment extends Fragment{

    ViewPager viewpager;
    CirclePageIndicator indicator;
    HorizontalScrollView hs;
    ListView listview;

    List<ImageView> imageViewList=new ArrayList<>();
    List<String> datas=new ArrayList<>();
    ArrayAdapter<String> listAdapter;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root=inflater.inflate(R.layout.fragment_new,container,false);
        viewpager= (ViewPager) root.findViewById(R.id.viewpager);
        indicator= (CirclePageIndicator) root.findViewById(R.id.indicator);
        hs= (HorizontalScrollView) root.findViewById(R.id.hs);
        listview= (ListView) root.findViewById(R.id.listview);

        viewpager.setAdapter(pagerAdapter);
        indicator.setViewPager(viewpager);

        for (int i=0;i<10;i++){
            datas.add("this is ."+i);
        }
        listAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,datas);
        listview.setAdapter(listAdapter);
        return root;
    }
    PagerAdapter pagerAdapter=new PagerAdapter() {
        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            if (!imageViewList.isEmpty()&&imageViewList.size()>position){

            }else{
                ImageView imageView=new ImageView(container.getContext());
                imageView.setImageResource(R.drawable.a);
                imageViewList.add(imageView);
                container.addView(imageView);
            }

            return imageViewList.get(position);
        }

        @Override
        public void destroyItem(View container, int position, Object object) {
            super.destroyItem(container, position, object);
        }
    };
}
