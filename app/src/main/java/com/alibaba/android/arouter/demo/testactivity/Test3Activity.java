package com.alibaba.android.arouter.demo.testactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.android.arouter.demo.R;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.AutowiredDoc;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.annotation.RouteDoc;

/**
 * 自动注入的测试用例
 */
@RouteDoc(desc = "Test3Activity", example = "Test3Activity")
@Route(path = "/test/activity3")
public class Test3Activity extends AppCompatActivity {
    @AutowiredDoc(desc = "arg", example = "arg", minVer = "2.2.2")
    @Autowired
    String name;

    @AutowiredDoc(desc = "arg", example = "arg", limit = "12|23|23")
    @Autowired
    int age;

    @AutowiredDoc(desc = "arg", example = "arg", limit = "boy")
    @Autowired(name = "boy")
    boolean girl;

    // 这个字段没有注解，是不会自动注入的
    private long high;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        String params = String.format("nam1e=%s, age=%s, girl=%s, high=%s", name, age, girl, high);

        ((TextView)findViewById(R.id.test)).setText("I am " + Test3Activity.class.getName());
        ((TextView)findViewById(R.id.test2)).setText(params);
    }
}
