package test.bwie.com.bawaymail.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.model.bean.LoginOutBean;
import test.bwie.com.bawaymail.model.utils.ToastUtil;
import test.bwie.com.bawaymail.presenter.LoginOutPresenter;
import test.bwie.com.bawaymail.view.iview.LoginOutView;

public class LoginOutActivity extends AppCompatActivity implements LoginOutView<LoginOutBean>, View.OnClickListener {

    private ImageView leftImageView;
    private TextView titleTextView;
    private ImageView rightImageView;
    private ImageView headImageView;
    private TextView exitTextView;
    private LinearLayout mainLinearLayout;
    private LoginOutPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_out);
        initView();
        initControl();
    }

    private void initControl() {
        mPresenter=new LoginOutPresenter();
        mPresenter.attachView(this);
    }

    private void initView() {
        leftImageView = (ImageView) findViewById(R.id.leftImageView);
        titleTextView = (TextView) findViewById(R.id.titleTextView);
        rightImageView = (ImageView) findViewById(R.id.rightImageView);
        headImageView = (ImageView) findViewById(R.id.headImageView);
        exitTextView = (TextView) findViewById(R.id.exitTextView);

        exitTextView.setOnClickListener(this);
        mainLinearLayout = (LinearLayout) findViewById(R.id.mainLinearLayout);
    }

    @Override
    public void getDataSuccess(LoginOutBean loginOutBean) {
        ToastUtil.show(this,"退出成功");
        finish();
    }

    @Override
    public void getDataError(String strMsg, int errCode) {
        ToastUtil.show(this,strMsg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.exitTextView:
                mPresenter.getDataFromF();
                break;
        }
    }


    @Override
    public void showOrHideLoading(boolean flag) {

    }
}
