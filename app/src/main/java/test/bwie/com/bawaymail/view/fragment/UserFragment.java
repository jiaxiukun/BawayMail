package test.bwie.com.bawaymail.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.model.utils.Constant;
import test.bwie.com.bawaymail.view.activity.AddressActivity;
import test.bwie.com.bawaymail.view.activity.LoginActivity;
import test.bwie.com.bawaymail.view.activity.LoginOutActivity;


public class UserFragment extends Fragment implements View.OnClickListener {

    private ImageView headImageView;
    private TextView usernameTextView;
    private TextView collectionGoodsTextView;
    private TextView collectionStoreTextView;
    private TextView myFootprintTextView;
    private RelativeLayout userRelativeLayout;
    private TextView orderTextView;
    private TextView orderWaitPayTextView;
    private TextView orderWaitDriveTextView;
    private TextView orderWaitReceiptTextView;
    private TextView orderWaitCommentTextView;
    private TextView orderWaitRefundTextView;
    private LinearLayout orderLinearLayout;
    private TextView propertyTextView;
    private TextView propertyMoneyTextView;
    private TextView propertyCardTextView;
    private TextView propertyVouchersTextView;
    private TextView propertyRedTextView;
    private TextView propertyIntegralTextView;
    private LinearLayout propertyLinearLayout;
    private TextView addressTextView;
    private TextView settingTextView;
    private LinearLayout mainLinearLayout;
    private ScrollView mainScrollView;
    private boolean mUser_login;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, null);
        initView(view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mUser_login = Constant.mSharedPreferences.getBoolean("User_Login", false);
        if (mUser_login){
            String user_username = Constant.mSharedPreferences.getString("User_Username", "");

            usernameTextView.setText(user_username);
        }else{
            usernameTextView.setText("请登录");
        }
    }

    private void initView(View view) {
        headImageView = (ImageView) view.findViewById(R.id.headImageView);
        usernameTextView = (TextView) view.findViewById(R.id.usernameTextView);
        collectionGoodsTextView = (TextView) view.findViewById(R.id.collectionGoodsTextView);
        collectionStoreTextView = (TextView) view.findViewById(R.id.collectionStoreTextView);
        myFootprintTextView = (TextView) view.findViewById(R.id.myFootprintTextView);
        userRelativeLayout = (RelativeLayout) view.findViewById(R.id.userRelativeLayout);
        orderTextView = (TextView) view.findViewById(R.id.orderTextView);
        orderWaitPayTextView = (TextView) view.findViewById(R.id.orderWaitPayTextView);
        orderWaitDriveTextView = (TextView) view.findViewById(R.id.orderWaitDriveTextView);
        orderWaitReceiptTextView = (TextView) view.findViewById(R.id.orderWaitReceiptTextView);
        orderWaitCommentTextView = (TextView) view.findViewById(R.id.orderWaitCommentTextView);
        orderWaitRefundTextView = (TextView) view.findViewById(R.id.orderWaitRefundTextView);
        orderLinearLayout = (LinearLayout) view.findViewById(R.id.orderLinearLayout);
        propertyTextView = (TextView) view.findViewById(R.id.propertyTextView);
        propertyMoneyTextView = (TextView) view.findViewById(R.id.propertyMoneyTextView);
        propertyCardTextView = (TextView) view.findViewById(R.id.propertyCardTextView);
        propertyVouchersTextView = (TextView) view.findViewById(R.id.propertyVouchersTextView);
        propertyRedTextView = (TextView) view.findViewById(R.id.propertyRedTextView);
        propertyIntegralTextView = (TextView) view.findViewById(R.id.propertyIntegralTextView);
        propertyLinearLayout = (LinearLayout) view.findViewById(R.id.propertyLinearLayout);
        addressTextView = (TextView) view.findViewById(R.id.addressTextView);
        addressTextView.setOnClickListener(this);
        settingTextView = (TextView) view.findViewById(R.id.settingTextView);
        mainLinearLayout = (LinearLayout) view.findViewById(R.id.mainLinearLayout);
        mainScrollView = (ScrollView) view.findViewById(R.id.mainScrollView);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
         initData();
    }

    private void initData() {
       headImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.headImageView:
                if(mUser_login){
                    Intent user=new Intent(getActivity(), LoginOutActivity.class);
                    startActivity(user);
                }else{
                    Intent login=new Intent(getActivity(), LoginActivity.class);
                    startActivity(login);
                }
                break;
            case R.id.usernameTextView:
                if(mUser_login){
                    Intent user=new Intent(getActivity(), LoginOutActivity.class);
                    startActivity(user);
                }else{
                    Intent intent=new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.addressTextView:
                Intent intent=new Intent(getActivity(), AddressActivity.class);
                startActivity(intent);
                break;
        }
    }
}
