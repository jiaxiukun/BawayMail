package test.bwie.com.bawaymail.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.model.bean.AddCartBean;
import test.bwie.com.bawaymail.model.bean.BuyNowBean;
import test.bwie.com.bawaymail.model.bean.ClassBean;
import test.bwie.com.bawaymail.model.bean.GoodsDetailBean;
import test.bwie.com.bawaymail.model.bean.PayDataBean;
import test.bwie.com.bawaymail.model.bean.ShopDetailBean;
import test.bwie.com.bawaymail.model.bean.ShopItemBean;
import test.bwie.com.bawaymail.model.bean.TypeBean;
import test.bwie.com.bawaymail.model.utils.Constant;
import test.bwie.com.bawaymail.presenter.TypePresenter;
import test.bwie.com.bawaymail.view.adapter.BuyGoodsListAdapter;
import test.bwie.com.bawaymail.view.autoview.AutoListView;
import test.bwie.com.bawaymail.view.iview.TypeView;

import static test.bwie.com.bawaymail.view.activity.GoodDetailActivity.mActivity;

public class BuySetupActivity extends AppCompatActivity implements  TypeView<ClassBean> {
    private String cart_id, address_id, ifcart;
    private String vat_hash, offpay_hash, password;
    private String invoice_id, voucher, pd_pay, fcode;
    private String offpay_hash_batch, pay_name, rcb_pay;
    private ImageView leftImageView;
    private TextView titleTextView;
    private ImageView rightImageView;
    private TextView addressTitleTextView;
    private TextView addressTrueNameTetView;
    private TextView addressPhoneTextView;
    private TextView addressContentTextView;
    private RelativeLayout addressRelativeLayout;
    private TextView payTitleTextView;
    private TextView payOnlineTextView;
    private TextView payOfflineTextView;
    private RelativeLayout payRelativeLayout;
    private TextView invoiceTitleTextView;
    private TextView invoiceNoTextView;
    private TextView invoiceYesTextView;
    private RelativeLayout invoiceRelativeLayout;
    private AutoListView goodsListView;
    private ScrollView mainScrollView;
    private TextView calcTextView;
    private TextView confirmTextView;
    private RelativeLayout mainRelativeLayout;
    public static HashMap<String, String> pay_message;
    private ArrayList<HashMap<String, String>> goodsArrayList;
    private BuyGoodsListAdapter goodsAdapter;
    private String buyNowBean;
    private TypePresenter mTypePresenter;
    private String mMUserKeyString;
    private String mStore_id;
    private String mCart_id;
    private String mIfcart;
    private String mAddressId;
    private String mInvoice_id;
    private String mFcode;
    private String mRcb_pay;
    private String mVoucher;
    private String mPd_pay;
    private String mPassword;
    private String mOffpay_hash;
    private String mOffpay_hash_batch;
    private String mVat_hash;
    private String mAddress_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_setup);
        mActivity=this;
        initView();
        createEvent();
        initControl();

    }
    private void initControl() {
        mTypePresenter = new TypePresenter();
        mTypePresenter.attachView(this);


    }

    private void initView() {
        mMUserKeyString = Constant.mSharedPreferences.getString("userKeyString", "");
        mAddressId = Constant.mSharedPreferences.getString("addressId", "");
        leftImageView = (ImageView) findViewById(R.id.leftImageView);
        titleTextView = (TextView) findViewById(R.id.titleTextView);
        rightImageView = (ImageView) findViewById(R.id.rightImageView);
        addressTitleTextView = (TextView) findViewById(R.id.addressTitleTextView);
        addressTrueNameTetView = (TextView) findViewById(R.id.addressTrueNameTetView);
        addressPhoneTextView = (TextView) findViewById(R.id.addressPhoneTextView);
        addressContentTextView = (TextView) findViewById(R.id.addressContentTextView);
        addressRelativeLayout = (RelativeLayout) findViewById(R.id.addressRelativeLayout);
        payTitleTextView = (TextView) findViewById(R.id.payTitleTextView);
        payOnlineTextView = (TextView) findViewById(R.id.payOnlineTextView);
        payOfflineTextView = (TextView) findViewById(R.id.payOfflineTextView);
        payRelativeLayout = (RelativeLayout) findViewById(R.id.payRelativeLayout);
        invoiceTitleTextView = (TextView) findViewById(R.id.invoiceTitleTextView);
        invoiceNoTextView = (TextView) findViewById(R.id.invoiceNoTextView);
        invoiceYesTextView = (TextView) findViewById(R.id.invoiceYesTextView);
        invoiceRelativeLayout = (RelativeLayout) findViewById(R.id.invoiceRelativeLayout);
        goodsListView = (AutoListView) findViewById(R.id.goodsListView);
        mainScrollView = (ScrollView) findViewById(R.id.mainScrollView);
        calcTextView = (TextView) findViewById(R.id.calcTextView);
        confirmTextView = (TextView) findViewById(R.id.confirmTextView);
        mainRelativeLayout = (RelativeLayout) findViewById(R.id.mainRelativeLayout);

        //初始化参数
        titleTextView.setText("确认订单信息");
        rightImageView.setVisibility(View.GONE);
        pay_message = new HashMap<>();

        pay_name = "online";
        payOnlineTextView.setTextColor(Color.WHITE);
        payOnlineTextView.setBackgroundResource(R.drawable.drawable_button_order_press);


        invoiceNoTextView.setTextColor(Color.WHITE);
        invoiceNoTextView.setBackgroundResource(R.drawable.drawable_button_order_press);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       if (requestCode==200&&resultCode==0){
           addressTrueNameTetView.setText(data.getStringExtra("true_name"));
           addressPhoneTextView.setText(data.getStringExtra("mob_phone"));
           addressContentTextView.setText(data.getStringExtra("address"));
           mAddress_id = data.getStringExtra("address_id");
       }
    }

    private void createEvent() {
        Intent intent = getIntent();

        buyNowBean = intent.getStringExtra("BuyNowBean");
        mStore_id = intent.getStringExtra("store_id");
        mCart_id = intent.getStringExtra("cart_id");
        mIfcart = intent.getStringExtra("ifcart");
        Gson gson=new Gson();
        BuyNowBean nowBean = gson.fromJson(buyNowBean, BuyNowBean.class);
        BuyNowBean.DatasBean datas = nowBean.getDatas();
        List<BuyNowBean.DatasBean.StoreCartListBean._$1Bean.GoodsListBean> goods_list = datas.getStore_cart_list()
                .get_$1().getGoods_list();
        BuyNowBean.DatasBean.AddressApiBean address_api = nowBean.getDatas().getAddress_api();
        mVat_hash = datas.getVat_hash();
        mOffpay_hash = address_api.getOffpay_hash();
        mOffpay_hash_batch = address_api.getOffpay_hash_batch();
        BuyGoodsListAdapter adapter=new BuyGoodsListAdapter(BuySetupActivity.this,goods_list);
        goodsListView.setAdapter(adapter);

        addressTitleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuySetupActivity.this, AddressActivity.class);
                startActivityForResult(intent,200);
            }
        });
        payOnlineTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pay_name = "online";
                payOnlineTextView.setTextColor(Color.WHITE);
                payOfflineTextView.setBackgroundResource(R.drawable.drawable_button_order);
                payOnlineTextView.setBackgroundResource(R.drawable.drawable_button_order_press);
                payOfflineTextView.setTextColor(ContextCompat.getColor(BuySetupActivity.this, R.color.greyAdd));
            }
        });

        payOfflineTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pay_name = "offline";
                payOfflineTextView.setTextColor(Color.WHITE);
                payOnlineTextView.setBackgroundResource(R.drawable.drawable_button_order);
                payOfflineTextView.setBackgroundResource(R.drawable.drawable_button_order_press);



                payOnlineTextView.setTextColor(ContextCompat.getColor(BuySetupActivity.this, R.color.greyAdd));
            }

        });
        mFcode = "";
        mRcb_pay = "0";
        mVoucher = "";
        mPd_pay = "0";
        mPassword = "";
        mInvoice_id = "0";
        confirmTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> ajaxParams = new HashMap<>();
                ajaxParams.put("key", mMUserKeyString);
                ajaxParams.put("ifcart", mIfcart);
                ajaxParams.put("cart_id", mCart_id);
                ajaxParams.put("address_id",mAddress_id);
                ajaxParams.put("vat_hash", mVat_hash);
                ajaxParams.put("offpay_hash", mOffpay_hash);
                ajaxParams.put("offpay_hash_batch", mOffpay_hash_batch);
                ajaxParams.put("pay_name", pay_name);
                ajaxParams.put("invoice_id", mInvoice_id);
                ajaxParams.put("voucher", mVoucher);
                ajaxParams.put("pd_pay", mPd_pay);
                ajaxParams.put("password", mPassword);
                ajaxParams.put("fcode", mFcode);
                ajaxParams.put("rcb_pay", mRcb_pay);
                ajaxParams.put("rpt", "");
                ajaxParams.put("pay_message", "");
                mTypePresenter.getGoodsPreIdFromF(ajaxParams);
            }
        });
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
        Toast.makeText(BuySetupActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
        String paySn = str.getDatas().getPay_sn();
        String payment_code = str.getDatas().getPayment_code();
        if(payment_code.equals("online")){
        Intent intent = new Intent(mActivity, PayDataActivity.class);
        intent.putExtra("pay_sn", paySn+"");
        startActivity(intent);
         }
    }

    @Override
    public void showOrHideLoading(boolean flag) {

    }
}
