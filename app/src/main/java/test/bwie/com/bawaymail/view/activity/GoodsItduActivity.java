package test.bwie.com.bawaymail.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.model.bean.AddCartBean;
import test.bwie.com.bawaymail.model.bean.BuyNowBean;
import test.bwie.com.bawaymail.model.bean.GoodsDetailBean;
import test.bwie.com.bawaymail.model.bean.PayDataBean;
import test.bwie.com.bawaymail.model.bean.ShopDetailBean;
import test.bwie.com.bawaymail.model.bean.ShopItemBean;
import test.bwie.com.bawaymail.model.bean.TypeBean;
import test.bwie.com.bawaymail.model.utils.TextUtil;
import test.bwie.com.bawaymail.presenter.TypePresenter;
import test.bwie.com.bawaymail.view.autoview.YoKeyWebView;
import test.bwie.com.bawaymail.view.iview.TypeView;

public class GoodsItduActivity extends AppCompatActivity implements TypeView {
    private ImageView leftImageView;
    private TextView titleTextView;
    private YoKeyWebView mainWebView;
    private ProgressBar mainProgressBar;
    private RelativeLayout mainRelativeLayout;
    private String mLink;
    private TypePresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_itdu);
        initView();
        initControl();
        initListener();
    }
    private void initListener() {
        mainWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                mLink = url;
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });

        mainWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    mainProgressBar.setVisibility(View.GONE);
                } else {
                    if (mainProgressBar.getVisibility() == View.GONE) {
                        mainProgressBar.setVisibility(View.VISIBLE);
                    }
                    mainProgressBar.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                titleTextView.setText(title);
                super.onReceivedTitle(view, title);
            }
        });

    }

    private void initControl() {
        Intent intent = getIntent();
        mLink = intent.getStringExtra("Link");
        titleTextView.setText("商品详细");
        mPresenter=new TypePresenter();
        mPresenter.attachView(this);
        mPresenter.getGoodsIntroduceFromF(mLink);
    }

    private void initView() {
        leftImageView = (ImageView) findViewById(R.id.leftImageView);
        titleTextView = (TextView) findViewById(R.id.titleTextView);
        mainWebView = (YoKeyWebView) findViewById(R.id.mainWebView);
        mainProgressBar = (ProgressBar) findViewById(R.id.mainProgressBar);
        mainRelativeLayout = (RelativeLayout) findViewById(R.id.mainRelativeLayout);
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
        Log.d("zzz",str);
        mainWebView.loadDataWithBaseURL(null, TextUtil.encodeHtml(str), "text/html", "UTF-8", null);
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
