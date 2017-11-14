package com.alibaba.android.arouter.demo.testactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import com.alibaba.android.arouter.demo.R;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.AutowiredDoc;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.annotation.RouteDoc;

@RouteDoc(desc = "Test2Activity", example = "Test2Activity")
@Route(path = "/test/activity2")
public class Test2Activity extends AppCompatActivity {
    @AutowiredDoc(desc = "key1", example = "key1")
    @Autowired
    String key1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        String value = getIntent().getStringExtra("key1");
        if (!TextUtils.isEmpty(value)) {
            Toast.makeText(this, "exist param :" + value, Toast.LENGTH_LONG).show();
        }

        setResult(999);
    }
}
