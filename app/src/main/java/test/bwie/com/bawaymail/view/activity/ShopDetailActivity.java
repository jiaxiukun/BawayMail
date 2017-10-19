package test.bwie.com.bawaymail.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;
import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.model.bean.AddCartBean;
import test.bwie.com.bawaymail.model.bean.BuyNowBean;
import test.bwie.com.bawaymail.model.bean.ClassBean;
import test.bwie.com.bawaymail.model.bean.GoodsDetailBean;
import test.bwie.com.bawaymail.model.bean.PayDataBean;
import test.bwie.com.bawaymail.model.bean.ShopDetailBean;
import test.bwie.com.bawaymail.model.bean.ShopItemBean;
import test.bwie.com.bawaymail.model.bean.TypeBean;
import test.bwie.com.bawaymail.presenter.ShopItemPresenter;
import test.bwie.com.bawaymail.presenter.TypePresenter;
import test.bwie.com.bawaymail.view.adapter.ShopDetailAdapter;
import test.bwie.com.bawaymail.view.iview.TypeView;

public class ShopDetailActivity extends SwipeBackActivity implements TypeView<ClassBean> {

    private ImageView leftImageView;
    private EditText keywordEditText;
    private Spinner typeSpinner;
    private ImageView rightImageView;
    private Spinner sortSpinner;
    private TextView saleTextView;
    private TextView screenTextView;
    private ImageView listImageView;
    private TextView moneyTextView;
    private EditText moneyStartEditText;
    private TextView moneyLineTextView;
    private EditText moneyEndEditText;
    private TextView moneyUnitTextView;
    private TextView goodsTypeTextView;
    private TextView groupGoodsTextView;
    private TextView xianShiGoodsTextView;
    private TextView giftGoodsTextView;
    private TextView storeTypeTextView;
    private TextView ownShopTextView;
    private RelativeLayout screenRelativeLayout;
    private RecyclerView recycler;
    private SwipeRefreshLayout mainSwipeRefreshLayout;
    private String listTypeString;
    private ShopItemPresenter mItemPresenter;
    private ShopDetailAdapter mAdapter;
    private TypePresenter mTypePresenter;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    mainSwipeRefreshLayout.setRefreshing(false);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(null);
        setContentView(R.layout.activity_shop_detail);
        initView();
        initData();
        initControl();
    }

    private void initControl() {
        mTypePresenter = new TypePresenter();
        mTypePresenter.attachView(this);
        mAdapter = new ShopDetailAdapter(this);
        mAdapter.setPresenter(mTypePresenter);
        recycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recycler.setLayoutManager(new LinearLayoutManager(this));

        recycler.setAdapter(mAdapter);
        mainSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mHandler.sendEmptyMessageDelayed(1, 3000);
            }
        });
        mTypePresenter.getShopItemData("", "1", ShopItemBean.class);

    }

    private void initData() {

        listTypeString = "ver";
        //初始化参数
        typeSpinner.setVisibility(View.GONE);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new String[]{"综合排序", "人气排序", "价格从高到低", "价格从低到高"});
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortSpinner.setAdapter(adapter);

        screenTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (screenRelativeLayout.getVisibility() == View.VISIBLE) {
                    screenRelativeLayout.setVisibility(View.GONE);
                    screenTextView.setTextColor(ContextCompat.getColor(ShopDetailActivity.this, R.color.main));
                } else {
                    screenRelativeLayout.setVisibility(View.VISIBLE);
                    screenTextView.setTextColor(ContextCompat.getColor(ShopDetailActivity.this, R.color.greyAdd));
                }
            }
        });
        listImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listTypeString.equals("ver")) {
                    listImageView.setImageResource(R.mipmap.ic_goods_list_hor);
                    listTypeString = "hor";
                    //setListHor();
                    recycler.setLayoutManager(new GridLayoutManager(ShopDetailActivity.this, 2));

                    recycler.setAdapter(mAdapter);
                } else {
                    listImageView.setImageResource(R.mipmap.ic_goods_list_ver);
                    listTypeString = "ver";
                    //setListVer();
                    recycler.setLayoutManager(new LinearLayoutManager(ShopDetailActivity.this));

                    recycler.setAdapter(mAdapter);
                }
            }
        });
    }

    private void initView() {
        leftImageView = (ImageView) findViewById(R.id.leftImageView);
        keywordEditText = (EditText) findViewById(R.id.keywordEditText);
        typeSpinner = (Spinner) findViewById(R.id.typeSpinner);
        rightImageView = (ImageView) findViewById(R.id.rightImageView);
        sortSpinner = (Spinner) findViewById(R.id.sortSpinner);
        saleTextView = (TextView) findViewById(R.id.saleTextView);
        screenTextView = (TextView) findViewById(R.id.screenTextView);
        listImageView = (ImageView) findViewById(R.id.listImageView);
        moneyTextView = (TextView) findViewById(R.id.moneyTextView);
        moneyStartEditText = (EditText) findViewById(R.id.moneyStartEditText);
        moneyLineTextView = (TextView) findViewById(R.id.moneyLineTextView);
        moneyEndEditText = (EditText) findViewById(R.id.moneyEndEditText);
        moneyUnitTextView = (TextView) findViewById(R.id.moneyUnitTextView);
        goodsTypeTextView = (TextView) findViewById(R.id.goodsTypeTextView);
        groupGoodsTextView = (TextView) findViewById(R.id.groupGoodsTextView);
        xianShiGoodsTextView = (TextView) findViewById(R.id.xianShiGoodsTextView);
        giftGoodsTextView = (TextView) findViewById(R.id.giftGoodsTextView);
        storeTypeTextView = (TextView) findViewById(R.id.storeTypeTextView);
        ownShopTextView = (TextView) findViewById(R.id.ownShopTextView);
        screenRelativeLayout = (RelativeLayout) findViewById(R.id.screenRelativeLayout);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        mainSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.mainSwipeRefreshLayout);
    }


    @Override
    public void getDataSuc(TypeBean t) {

    }

    @Override
    public void getDataErr(String str, int code) {

    }

    @Override
    public void getShopDetailSuc(ShopDetailBean t) {

    }

    @Override
    public void getShopSuc(ShopDetailBean t) {

    }

    @Override
    public void getItemData(ShopItemBean t) {
        final List<ShopItemBean.DatasBean.GoodsListBean> goods_list = t.getDatas().getGoods_list();
        mAdapter.setData(goods_list);
        mAdapter.notifyDataSetChanged();
        mAdapter.setOnitemClickListener(new ShopDetailAdapter.OnitemClickListener() {
            @Override
            public void onClick(int position) {

                Intent intent = new Intent(ShopDetailActivity.this, GoodDetailActivity.class);
                intent.putExtra("id", goods_list.get(position).getGoods_id());
                startActivity(intent);
            }
        });
    }

    @Override
    public void getGoodsDetail(GoodsDetailBean t) {

    }

    @Override
    public void getGoodsItduData(String str) {

    }

    @Override
    public void getGoodsBuyNowData(BuyNowBean str) {

    }

    @Override
    public void getGoodsAddCartData(AddCartBean str) {

    }

    @Override
    public void getGoodsPreIdData(PayDataBean str) {

    }


    @Override
    public void showOrHideLoading(boolean flag) {

    }
}
