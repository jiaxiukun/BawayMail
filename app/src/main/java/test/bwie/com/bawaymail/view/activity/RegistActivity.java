package test.bwie.com.bawaymail.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.model.bean.RegistBean;
import test.bwie.com.bawaymail.model.utils.RegexUtils;
import test.bwie.com.bawaymail.model.utils.ToastUtil;
import test.bwie.com.bawaymail.presenter.RegistPresenter;
import test.bwie.com.bawaymail.view.iview.RegistView;

public class RegistActivity extends AppCompatActivity implements View.OnClickListener, RegistView<RegistBean> {

    private ImageView leftImageView;
    private TextView titleTextView;
    private ImageView rightImageView;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText passwordRepeatEditText;
    private EditText emailEditText;
    private LinearLayout contentLinearLayout;
    private TextView regTextView;
    private LinearLayout mainLinearLayout;
    private RegistPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        initView();
        initData();
    }

    private void initData() {
        regTextView.setOnClickListener(this);
        presenter = new RegistPresenter();
        presenter.attachView(this);

    }

    private void initView() {
        leftImageView = (ImageView) findViewById(R.id.leftImageView);
        titleTextView = (TextView) findViewById(R.id.titleTextView);
        rightImageView = (ImageView) findViewById(R.id.rightImageView);
        usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        passwordRepeatEditText = (EditText) findViewById(R.id.passwordRepeatEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        contentLinearLayout = (LinearLayout) findViewById(R.id.contentLinearLayout);
        regTextView = (TextView) findViewById(R.id.regTextView);
        mainLinearLayout = (LinearLayout) findViewById(R.id.mainLinearLayout);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.regTextView:
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String passwordRepeat = passwordRepeatEditText.getText().toString();
                String email = emailEditText.getText().toString();

                if (!RegexUtils.isPassword(username)) {
                    ToastUtil.show(this, "用户名格式不正确");
                    return;
                }
                if (!RegexUtils.isPassword(password)) {
                    ToastUtil.show(this, "密码格式不正确");
                    return;
                }
                if (!RegexUtils.isPassword(passwordRepeat)) {
                    ToastUtil.show(this, "确认密码格式不正确");
                    return;
                }
                if (!RegexUtils.isEmail(email)) {
                    ToastUtil.show(this, "邮箱格式不正确");
                    return;
                }
                if (!password.equals(passwordRepeat)) {
                    ToastUtil.show(this, "密码不一样");
                    return;
                }
                regTextView.setEnabled(false);
                regTextView.setText("正在注册...");
                presenter.getDataFromF(username, email, password, passwordRepeat);


                break;
        }
    }

    @Override
    public void getViewSuccess(RegistBean o) {
        Log.d("zzz", o.toString());

        ToastUtil.show(this, "注册成功");
        finish();
    }

    @Override
    public void getViewErr(String str, int code) {

    }


    @Override
    public void showOrHideLoading(boolean flag) {

    }
}
