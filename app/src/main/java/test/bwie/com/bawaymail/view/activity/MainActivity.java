package test.bwie.com.bawaymail.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.model.utils.Constant;
import test.bwie.com.bawaymail.view.fragment.CartFragment;
import test.bwie.com.bawaymail.view.fragment.ClassFragment;
import test.bwie.com.bawaymail.view.fragment.HomeFragment;
import test.bwie.com.bawaymail.view.fragment.UserFragment;
import test.bwie.com.bawaymail.view.iview.IHomeView;

public class MainActivity extends AppCompatActivity implements IHomeView, RadioGroup.OnCheckedChangeListener {

    private RadioButton homeRadioButton;
    private RadioButton classRadioButton;
    private RadioButton cartRadioButton;
    private RadioButton userRadioButton;
    private RadioGroup mainRadioGroup;
    private HomeFragment mHomeFragment;
    private ClassFragment mClassFragment;
    private CartFragment mCartFragment;
    private UserFragment mUserFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        Constant.init(this);
    }

    private void initData() {
        mainRadioGroup.setOnCheckedChangeListener(this);
        mHomeFragment = new HomeFragment();
        mClassFragment = new ClassFragment();
        mCartFragment = new CartFragment();
        mUserFragment = new UserFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.tabcontent, mHomeFragment,"homeFragment").commit();
        getSupportFragmentManager().beginTransaction().add(R.id.tabcontent, mClassFragment,"classFragment").commit();
        getSupportFragmentManager().beginTransaction().add(R.id.tabcontent, mCartFragment,"cartFragment").commit();
        getSupportFragmentManager().beginTransaction().add(R.id.tabcontent, mUserFragment,"userFragment").commit();
        getSupportFragmentManager().beginTransaction().show(mHomeFragment).hide(mCartFragment).hide(mClassFragment).hide(mUserFragment).commit();
    }


    @Override
    public void callbackStr(Object o) {

    }

    @Override
    public void showOrHideLoading(boolean flag) {

    }

    @Override
    public void callbackErr(String err, int code) {

    }

    private void initView() {
        homeRadioButton = (RadioButton) findViewById(R.id.homeRadioButton);
        classRadioButton = (RadioButton) findViewById(R.id.classRadioButton);
        cartRadioButton = (RadioButton) findViewById(R.id.cartRadioButton);
        userRadioButton = (RadioButton) findViewById(R.id.userRadioButton);
        mainRadioGroup = (RadioGroup) findViewById(R.id.mainRadioGroup);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.homeRadioButton:
                getSupportFragmentManager().beginTransaction().show(mHomeFragment).hide(mCartFragment).hide(mClassFragment).hide(mUserFragment).commit();
                break;
            case R.id.classRadioButton:
                getSupportFragmentManager().beginTransaction().show(mClassFragment).hide(mCartFragment).hide(mHomeFragment).hide(mUserFragment).commit();
                break;
            case R.id.cartRadioButton:
                getSupportFragmentManager().beginTransaction().show(mCartFragment).hide(mHomeFragment).hide(mClassFragment).hide(mUserFragment).commit();
                break;
            case R.id.userRadioButton:
                getSupportFragmentManager().beginTransaction().show(mUserFragment).hide(mCartFragment).hide(mClassFragment).hide(mHomeFragment).commit();
                break;
        }
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
