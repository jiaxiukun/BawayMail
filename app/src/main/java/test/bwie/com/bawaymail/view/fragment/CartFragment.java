package test.bwie.com.bawaymail.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.model.bean.CartDataBean;
import test.bwie.com.bawaymail.model.bean.ClassBean;
import test.bwie.com.bawaymail.model.bean.DelCartBean;
import test.bwie.com.bawaymail.model.utils.Constant;
import test.bwie.com.bawaymail.model.utils.ToastUtil;
import test.bwie.com.bawaymail.presenter.CartPresenter;
import test.bwie.com.bawaymail.view.activity.LoginActivity;
import test.bwie.com.bawaymail.view.adapter.CartAdapter;
import test.bwie.com.bawaymail.view.iview.CartView;


public class CartFragment extends Fragment implements View.OnClickListener, CartView<ClassBean> {

    private TextView titleTextView;
    private TextView cart_unlogin;
    private RecyclerView cart_rlv;
    private SwipeRefreshLayout cart_swipe;
    private CartPresenter mPresenter;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    cart_swipe.setRefreshing(false);
                    break;
                default:
                    break;
            }
        }
    };
    public static CartAdapter mCartAdapter;
    private String mUserKeyString;
    public static TextView calcTextView;
    public static TextView buyTextView;
    public static CartDataBean mCartDataBean;
    private View mView;
    private TextView cart_empty;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_cart, null);
        initView(mView);
        return mView;
    }


    @Override
    public void onResume() {
        super.onResume();
        initControl();
    }

    private void initControl() {
        mPresenter = new CartPresenter();
        mPresenter.attachView(this);
        mCartAdapter = new CartAdapter(getActivity());
        mCartAdapter.setHomePresenter(mPresenter);
        cart_rlv.setAdapter(mCartAdapter);

        mUserKeyString = Constant.mSharedPreferences.getString("userKeyString", "");
        Log.d("zzz", mUserKeyString);
        //獲取登錄狀態。
        boolean user_login = Constant.mSharedPreferences.getBoolean("User_Login", false);
        if (user_login) {
            mPresenter.getCartListDataFromF(mUserKeyString);
            cart_unlogin.setVisibility(View.GONE);
            cart_swipe.setVisibility(View.VISIBLE);
            calcTextView.setVisibility(View.VISIBLE);
            buyTextView.setVisibility(View.VISIBLE);

        } else {
            cart_unlogin.setVisibility(View.VISIBLE);
            cart_swipe.setVisibility(View.GONE);
            cart_empty.setVisibility(View.GONE);
            buyTextView.setVisibility(View.GONE);
            calcTextView.setVisibility(View.GONE);
        }

    }

    private void initView(View view) {
        titleTextView = (TextView) view.findViewById(R.id.titleTextView);
        cart_unlogin = (TextView) view.findViewById(R.id.cart_unlogin);
        cart_unlogin.setOnClickListener(this);
        cart_rlv = (RecyclerView) view.findViewById(R.id.cart_rlv);
        cart_rlv.setOnClickListener(this);
        cart_swipe = (SwipeRefreshLayout) view.findViewById(R.id.cart_swipe);
        cart_swipe.setOnClickListener(this);
        calcTextView = (TextView) view.findViewById(R.id.calcTextView);
        calcTextView.setOnClickListener(this);
        buyTextView = (TextView) view.findViewById(R.id.buyTextView);
        buyTextView.setOnClickListener(this);

        cart_rlv.addItemDecoration(new DividerItemDecoration(
                getActivity(), DividerItemDecoration.VERTICAL));
        cart_rlv.setLayoutManager(new LinearLayoutManager(getActivity()));

        cart_swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getCartListDataFromF(mUserKeyString);
                mHandler.sendEmptyMessageDelayed(1, 3000);
            }
        });

        cart_empty = (TextView) mView.findViewById(R.id.cart_empty);
        cart_empty.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.cart_unlogin:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
        }
    }

    @Override
    public void getCartListData(CartDataBean str) {
        mCartDataBean = str;
        if (str.getDatas().getCart_list().size() != 0) {
            mCartAdapter.setData(str.getDatas().getCart_list().get(0).getGoods());
            mCartAdapter.notifyDataSetChanged();
            cart_rlv.setVisibility(View.VISIBLE);
            cart_empty.setVisibility(View.GONE);
            String total = "共 <font color='#FF5001'>" + str.getDatas().getCart_count() + "</font> 件商品，";
            total += "共 <font color='#FF5001'>" + str.getDatas().getSum() + "</font> 元";
            calcTextView.setText(Html.fromHtml(total));
        } else {
            mCartAdapter.setData(null);
            mCartAdapter.notifyDataSetChanged();
            cart_rlv.setVisibility(View.GONE);
            cart_empty.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void getCartDelData(DelCartBean str) {
        ToastUtil.show(getActivity(), "删除成功");
        mPresenter.getCartListDataFromF(mUserKeyString);
    }


    @Override
    public void showOrHideLoading(boolean flag) {

    }
}
