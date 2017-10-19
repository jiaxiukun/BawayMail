package test.bwie.com.bawaymail.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;
import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.model.bean.LoginBean;
import test.bwie.com.bawaymail.model.utils.RegexUtils;
import test.bwie.com.bawaymail.model.utils.ToastUtil;
import test.bwie.com.bawaymail.presenter.LoginPresenter;
import test.bwie.com.bawaymail.view.iview.LoginView;

public class LoginActivity extends SwipeBackActivity implements View.OnClickListener, LoginView<LoginBean> {

    private ImageView leftImageView;
    private TextView titleTextView;
    private ImageView rightImageView;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private LinearLayout contentLinearLayout;
    private TextView loginTextView;
    private TextView regTextView;
    private TextView backTextView;
    private LinearLayout mainLinearLayout;
    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initData();
    }

    private void initData() {
        regTextView.setOnClickListener(this);
        loginTextView.setOnClickListener(this);
        mPresenter = new LoginPresenter();
        mPresenter.attachView(this);
    }

    private void initView() {
        leftImageView = (ImageView) findViewById(R.id.leftImageView);
        titleTextView = (TextView) findViewById(R.id.titleTextView);
        rightImageView = (ImageView) findViewById(R.id.rightImageView);
        usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        contentLinearLayout = (LinearLayout) findViewById(R.id.contentLinearLayout);
        loginTextView = (TextView) findViewById(R.id.loginTextView);
        regTextView = (TextView) findViewById(R.id.regTextView);
        backTextView = (TextView) findViewById(R.id.backTextView);
        mainLinearLayout = (LinearLayout) findViewById(R.id.mainLinearLayout);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.regTextView:
                Intent intent = new Intent(LoginActivity.this, RegistActivity.class);
                startActivity(intent);
                break;
            case R.id.loginTextView:
                if (!RegexUtils.isPassword(usernameEditText.getText().toString())) {
                    ToastUtil.show(this, "用户名格式不正确");
                    return;
                }

                if (!RegexUtils.isPassword(passwordEditText.getText().toString())) {
                    ToastUtil.show(this, "密码格式不正确");
                    return;
                }

                mPresenter.getLoginData(usernameEditText.getText().toString(), passwordEditText.getText().toString());
                break;
        }
    }

    @Override
    public void getLoginViewSuc(LoginBean o) {
        String s = o.getDatas().getKey();
        Log.d("ccc", "登陆" + s);
        ToastUtil.show(this, "登陆成功");
        finish();
    }

    @Override
    public void getLoginErr(String str, int code) {
        ToastUtil.show(this, str);
    }


    @Override
    public void showOrHideLoading(boolean flag) {

    }
}
