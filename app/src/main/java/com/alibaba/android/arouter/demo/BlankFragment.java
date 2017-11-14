package com.alibaba.android.arouter.demo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.demo.testinject.TestObj;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.AutowiredDoc;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.annotation.RouteDoc;

/**
 * A simple {@link Fragment} subclass.
 */
@RouteDoc(desc = "BlankFragment", example = "BlankFragment")
@Route(path = "/test/fragment")
public class BlankFragment extends Fragment {
    @AutowiredDoc(desc = "BlankFragment", example = "你好")
    @Autowired
    String name;

    @AutowiredDoc(desc = "第二个", example = "BlankFragment")
    @Autowired(required = true)
    TestObj obj;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        return textView;
    }

}
