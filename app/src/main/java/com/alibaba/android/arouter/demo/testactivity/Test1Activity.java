package com.alibaba.android.arouter.demo.testactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.android.arouter.demo.R;
import com.alibaba.android.arouter.demo.testinject.TestObj;
import com.alibaba.android.arouter.demo.testinject.TestParcelable;
import com.alibaba.android.arouter.demo.testservice.HelloService;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.AutowiredDoc;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.annotation.RouteDoc;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.android.arouter.utils.TextUtils;

import java.util.List;
import java.util.Map;

/**
 *
 */
@RouteDoc(desc = "Test activity for aroute", minVer = "7.0.0")
@Route(path = "/test/activity1", extras = ARouterExtraFlags.FLAG_AFTER_LOGIN)
public class Test1Activity extends AppCompatActivity {
    @AutowiredDoc(desc = "name", example = "name")
    @Autowired
    String name = "jack";

    // @AutowiredDoc(desc = "name", example = "na1me")
    @Autowired
    int age = 10;

    /**
     * @description height of a document
     * @limit aa/bb/cc
     * @version
     */
    // @AutowiredDoc(desc = "name", example = "na3me")
    @Autowired
    int height = 175;

    // @AutowiredDoc(desc = "name", example = "n1ame")
    @Autowired(name = "boy")
    boolean girl;

    // @AutowiredDoc(desc = "name", example = "name2")
    @Autowired
    char ch = 'A';

    @AutowiredDoc(desc = "name", example = "name", minVer = "7.7.0")
    @Autowired
    float fl = 12.00f;

    @AutowiredDoc(desc = "name", example = "name", minVer = "7.0.0")
    @Autowired
    double dou = 12.01d;

    @AutowiredDoc(desc = "name", example = "name")
    @Autowired
    TestParcelable pac;

    @AutowiredDoc(desc = "name", example = "name")
    @Autowired
    TestObj obj;

    @AutowiredDoc(desc = "name", example = "name")
    @Autowired
    List<TestObj> objList;

    @AutowiredDoc(desc = "name", example = "name")
    @Autowired
    Map<String, List<TestObj>> map;

    private long high;

    @AutowiredDoc(desc = "name", example = "name")
    @Autowired
    String url;

    @AutowiredDoc(desc = "name", example = "name")
    @Autowired
    HelloService helloService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        ARouter.getInstance().inject(this);
        // No more getter ...
        // name = getIntent().getStringExtra("name");
        // age = getIntent().getIntExtra("age", 0);
        // girl = getIntent().getBooleanExtra("girl", false);
        // high = getIntent().getLongExtra("high", 0);
        // url = getIntent().getStringExtra("url");

        String params = String.format(
                "name=%s,\n age=%s, \n height=%s,\n girl=%s,\n high=%s,\n url=%s,\n pac=%s,\n obj=%s \n ch=%s \n fl = %s, \n dou = %s, \n objList=%s, \n map=%s",
                name,
                age,
                height,
                girl,
                high,
                url,
                pac,
                obj,
                ch,
                fl,
                dou,
                objList,
                map
        );
        helloService.sayHello("Hello moto.");

        ((TextView) findViewById(R.id.test)).setText("I am " + Test1Activity.class.getName());
        ((TextView) findViewById(R.id.test2)).setText(params);
    }
}
