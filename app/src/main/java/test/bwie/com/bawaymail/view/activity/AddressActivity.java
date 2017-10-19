package test.bwie.com.bawaymail.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.model.bean.AddressAddBean;
import test.bwie.com.bawaymail.model.bean.AddressBean;
import test.bwie.com.bawaymail.model.bean.AddressEditBean;
import test.bwie.com.bawaymail.model.bean.AreaBean;
import test.bwie.com.bawaymail.model.bean.CityBean;
import test.bwie.com.bawaymail.model.bean.ProvinceBean;
import test.bwie.com.bawaymail.model.utils.Constant;
import test.bwie.com.bawaymail.presenter.AddressPresenter;
import test.bwie.com.bawaymail.view.adapter.AddressAdapter;
import test.bwie.com.bawaymail.view.iview.AddressView;

public class AddressActivity extends AppCompatActivity implements AddressView, View.OnClickListener {

    private ImageView leftImageView;
    private ImageView rightImageView;
    private TextView titleTextView;
    private TextView text_noaddress;
    private RecyclerView rlv_address;
    private SwipeRefreshLayout swipe_address;
    private AddressPresenter mPresenter;
    private String mUserKeyString;
    private AddressAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setBackgroundDrawableResource(null);
        setContentView(R.layout.activity_address);
        initView();
        initControl();
    }
    private void initControl() {
        mPresenter = new AddressPresenter();
        mPresenter.attachView(this);
        mAdapter = new AddressAdapter(AddressActivity.this,AddressActivity.this);
        mAdapter.setHomePresenter(mPresenter);
        rlv_address.setAdapter(mAdapter);

    }


    private void initView() {
        mUserKeyString = Constant.mSharedPreferences.getString("userKeyString", "");
        leftImageView = (ImageView) findViewById(R.id.leftImageView);
        rightImageView = (ImageView) findViewById(R.id.rightImageView);
        titleTextView = (TextView) findViewById(R.id.titleTextView);
        text_noaddress = (TextView) findViewById(R.id.text_noaddress);
        rlv_address = (RecyclerView) findViewById(R.id.rlv_address);
        swipe_address = (SwipeRefreshLayout) findViewById(R.id.swipe_address);

        //初始化参数
        titleTextView.setText("收货地址");
        rightImageView.setImageResource(R.mipmap.ic_action_add);
        rlv_address.addItemDecoration(new DividerItemDecoration(
                AddressActivity.this, DividerItemDecoration.VERTICAL));
        rlv_address.setLayoutManager(new LinearLayoutManager(AddressActivity.this));
        swipe_address.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPresenter.getAddressData(mUserKeyString);
                    }
                }, 1000);
            }
        });
        rightImageView.setOnClickListener(this);
        leftImageView.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getAddressData(mUserKeyString);
    }

    @Override
    public void getAddressData(AddressBean str) {
        final List<AddressBean.DatasBean.AddressListBean> address_list = str.getDatas().getAddress_list();
        mAdapter.setOnItemClickListener(new AddressAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(AddressActivity.this, BuySetupActivity.class);
                String true_name = address_list.get(position).getTrue_name();
                String address = address_list.get(position).getAddress();

                String mob_phone = address_list.get(position).getMob_phone();
                String check = address_list.get(position).getIs_default();
                String address_id = address_list.get(position).getAddress_id();

                intent.putExtra("address_id",address_id);
                intent.putExtra("true_name",true_name);
                intent.putExtra("address",address);
                intent.putExtra("mob_phone",mob_phone);
                intent.putExtra("is_default",check);

                setResult(0,intent);
                finish();
            }


        });
        if (address_list.size() == 0) {
            swipe_address.setVisibility(View.GONE);
            text_noaddress.setVisibility(View.VISIBLE);
        } else {
            mAdapter.setData(address_list);
            mAdapter.notifyDataSetChanged();
            swipe_address.setVisibility(View.VISIBLE);
            text_noaddress.setVisibility(View.GONE);
        }
    }

    @Override
    public void getAddressProvinceData(ProvinceBean str) {

    }

    @Override
    public void getAddressCityData(CityBean str) {

    }

    @Override
    public void getAddressAreaData(AreaBean str) {

    }

    @Override
    public void getAddressAddData(AddressAddBean str) {

    }

    @Override
    public void getAddressEditData(AddressEditBean str) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rightImageView:
                Intent intent = new Intent(AddressActivity.this, AddressEditActivity.class);
                startActivity(intent);
                break;
            case R.id.leftImageView:
                finish();
                break;
        }
    }


    @Override
    public void showOrHideLoading(boolean flag) {

    }
}
