package test.bwie.com.bawaymail.view.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.readystatesoftware.viewbadger.BadgeView;

import java.util.ArrayList;
import java.util.List;

import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.model.bean.AddCartBean;
import test.bwie.com.bawaymail.model.bean.BuyNowBean;
import test.bwie.com.bawaymail.model.bean.GoodsDetailBean;
import test.bwie.com.bawaymail.model.bean.PayDataBean;
import test.bwie.com.bawaymail.model.bean.ShopDetailBean;
import test.bwie.com.bawaymail.model.bean.ShopItemBean;
import test.bwie.com.bawaymail.model.bean.TypeBean;
import test.bwie.com.bawaymail.model.utils.Constant;
import test.bwie.com.bawaymail.model.utils.ToastUtil;
import test.bwie.com.bawaymail.presenter.TypePresenter;
import test.bwie.com.bawaymail.view.adapter.DetailPicAdapter;
import test.bwie.com.bawaymail.view.adapter.GoodsCmdAdapter;
import test.bwie.com.bawaymail.view.autoview.DetailListView;
import test.bwie.com.bawaymail.view.autoview.MoveImageView;
import test.bwie.com.bawaymail.view.iview.TypeView;

public class GoodDetailActivity extends AppCompatActivity implements View.OnClickListener, TypeView, GoodsCmdAdapter.AddClickListener, Animator.AnimatorListener {

    private ImageView leftImageView;
    private TextView titleTextView;
    private ImageView rightImageView;
    private ImageView right1ImageView;
    private LinearLayout topLinearLayout;
    private ViewPager goodsViewPager;
    private TextView nameTextView;
    private TextView jingleTextView;
    private TextView pricePromotionTextView;
    private TextView priceTextView;
    private TextView saleNumTextView;
    private TextView activityTextView;
    private TextView activityNameTextView;
    private TextView activityRemarkTextView;
    private LinearLayout activityLinearLayout;
    private TextView addressTextView;
    private TextView addressTipTextView;
    private TextView choose1TextView;
    private TextView choose2TextView;
    private LinearLayout chooseLinearLayout;
    private TextView commentTextView;
    private TextView commentNumTextView;
    private LinearLayout commentLinearLayout;
    private TextView bodyTextView;
    private TextView storeTextView;
    private TextView storeDescTextView;
    private TextView storeDescStatusTextView;
    private TextView storeServerTextView;
    private TextView storeServerStatusTextView;
    private TextView storeDeliveryTextView;
    private TextView storeDeliveryStatusTextView;
    private LinearLayout storeLinearLayout;
    private TextView goodsTitleTextView;
    private DetailListView mainListView;
    private LinearLayout scrollLinearLayout;
    private ScrollView mainScrollView;
    private TextView kefuTextView;
    private TextView cartTextView;
    private TextView joinCartTextView;
    private TextView buyTextView;
    private LinearLayout bottomLinearLayout;
    private TextView backgroundTextView;
    private ImageView qrCodeCloseImageView;
    private View qrCode1LineView;
    private ImageView qrCodeContentImageView;
    private View qrCode2LineView;
    private TextView qrCodeOtherTextView;
    private RelativeLayout qrCodeRelativeLayout;
    private ImageView chooseImageView;
    private TextView chooseNameTextView;
    private TextView choosePriceTextView;
    private TextView chooseStorageTextView;
    private View chooseLine3View;
    private TextView chooseNumberTextView;
    private Button chooseAddButton;
    private EditText chooseNumberEditText;
    private Button chooseSubButton;
    private RelativeLayout chooseNumberRelativeLayout;
    private View chooseLine4View;
    private Button chooseBuyButton;
    private Button chooseCartButton;
    private RelativeLayout chooseRelativeLayout;
    private RelativeLayout mainRelativeLayout;
    private TypePresenter mTypePresenter;
    private GoodsCmdAdapter goodsCmdAdapter;
    private String mS;
    public static Activity mActivity;
    private Activity mMActivity;
    private String mUserKeyString;
    private String mCart_id;
    private int count;
    private BadgeView badge;
//    private List<View> list=new ArrayList<>();
    private List<ImageView> list=new ArrayList<>();
//    private ImageView[] imageViews;
    //动画时间
    private int AnimationDuration = 1000;
    //正在执行的动画数量
    private int number = 0;
    //是否完成清理
    private boolean isClean = false;
    private FrameLayout animation_viewGroup;
    private Handler myHandler = new Handler(){
        public void handleMessage(Message msg){
            switch(msg.what){
                case 0:
                    //用来清除动画后留下的垃圾
                    try{
                        animation_viewGroup.removeAllViews();
                    }catch(Exception e){

                    }

                    isClean = false;

                    break;
                default:
                    break;
            }
        }
    };
    private ImageView mCurImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_detail);
        animation_viewGroup = createAnimLayout();
        initView();

        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        goodsViewPager.setFocusable(true);
        mainListView.setFocusable(false);
    }

    private void initData() {
        mTypePresenter = new TypePresenter();
        mTypePresenter.attachView(this);
        Intent intent = getIntent();
        mS = intent.getStringExtra("id");
        titleTextView.setText("商品详细");
        goodsCmdAdapter = new GoodsCmdAdapter(this);
        goodsCmdAdapter.setListener(this);
        goodsCmdAdapter.setHomePresenter(mTypePresenter );
        mainListView.setAdapter(goodsCmdAdapter);
        mTypePresenter.getGoodsFromF(mS,GoodsDetailBean.class);

    }

    private void initView() {
        leftImageView = (ImageView) findViewById(R.id.leftImageView);
        titleTextView = (TextView) findViewById(R.id.titleTextView);
        rightImageView = (ImageView) findViewById(R.id.rightImageView);
        right1ImageView = (ImageView) findViewById(R.id.right1ImageView);
        topLinearLayout = (LinearLayout) findViewById(R.id.topLinearLayout);
        goodsViewPager = (ViewPager) findViewById(R.id.goodsViewPager);
        nameTextView = (TextView) findViewById(R.id.nameTextView);
        jingleTextView = (TextView) findViewById(R.id.jingleTextView);
        pricePromotionTextView = (TextView) findViewById(R.id.pricePromotionTextView);
        priceTextView = (TextView) findViewById(R.id.priceTextView);
        saleNumTextView = (TextView) findViewById(R.id.saleNumTextView);
        activityTextView = (TextView) findViewById(R.id.activityTextView);
        activityNameTextView = (TextView) findViewById(R.id.activityNameTextView);
        activityRemarkTextView = (TextView) findViewById(R.id.activityRemarkTextView);
        activityLinearLayout = (LinearLayout) findViewById(R.id.activityLinearLayout);
        addressTextView = (TextView) findViewById(R.id.addressTextView);
        addressTipTextView = (TextView) findViewById(R.id.addressTipTextView);
        choose1TextView = (TextView) findViewById(R.id.choose1TextView);
        choose2TextView = (TextView) findViewById(R.id.choose2TextView);
        chooseLinearLayout = (LinearLayout) findViewById(R.id.chooseLinearLayout);
        commentTextView = (TextView) findViewById(R.id.commentTextView);
        commentNumTextView = (TextView) findViewById(R.id.commentNumTextView);
        commentLinearLayout = (LinearLayout) findViewById(R.id.commentLinearLayout);
        bodyTextView = (TextView) findViewById(R.id.bodyTextView);
        storeTextView = (TextView) findViewById(R.id.storeTextView);
        storeDescTextView = (TextView) findViewById(R.id.storeDescTextView);
        storeDescStatusTextView = (TextView) findViewById(R.id.storeDescStatusTextView);
        storeServerTextView = (TextView) findViewById(R.id.storeServerTextView);
        storeServerStatusTextView = (TextView) findViewById(R.id.storeServerStatusTextView);
        storeDeliveryTextView = (TextView) findViewById(R.id.storeDeliveryTextView);
        storeDeliveryStatusTextView = (TextView) findViewById(R.id.storeDeliveryStatusTextView);
        storeLinearLayout = (LinearLayout) findViewById(R.id.storeLinearLayout);
        goodsTitleTextView = (TextView) findViewById(R.id.goodsTitleTextView);
        mainListView = (DetailListView) findViewById(R.id.mainListView);
        scrollLinearLayout = (LinearLayout) findViewById(R.id.scrollLinearLayout);
        mainScrollView = (ScrollView) findViewById(R.id.mainScrollView);
        kefuTextView = (TextView) findViewById(R.id.kefuTextView);
        cartTextView = (TextView) findViewById(R.id.cartTextView);
        badge = new BadgeView(this, cartTextView);
        badge.setBadgePosition(BadgeView.POSITION_TOP_LEFT);// 设置显示位置

        joinCartTextView = (TextView) findViewById(R.id.joinCartTextView);
        buyTextView = (TextView) findViewById(R.id.buyTextView);
        bottomLinearLayout = (LinearLayout) findViewById(R.id.bottomLinearLayout);
        backgroundTextView = (TextView) findViewById(R.id.backgroundTextView);
        qrCodeCloseImageView = (ImageView) findViewById(R.id.qrCodeCloseImageView);
        qrCode1LineView = (View) findViewById(R.id.qrCode1LineView);
        qrCodeContentImageView = (ImageView) findViewById(R.id.qrCodeContentImageView);
        qrCode2LineView = (View) findViewById(R.id.qrCode2LineView);
        qrCodeOtherTextView = (TextView) findViewById(R.id.qrCodeOtherTextView);
        qrCodeRelativeLayout = (RelativeLayout) findViewById(R.id.qrCodeRelativeLayout);
        chooseImageView = (ImageView) findViewById(R.id.chooseImageView);
        chooseNameTextView = (TextView) findViewById(R.id.chooseNameTextView);
        choosePriceTextView = (TextView) findViewById(R.id.choosePriceTextView);
        chooseStorageTextView = (TextView) findViewById(R.id.chooseStorageTextView);
        chooseLine3View = (View) findViewById(R.id.chooseLine3View);
        chooseNumberTextView = (TextView) findViewById(R.id.chooseNumberTextView);
        chooseAddButton = (Button) findViewById(R.id.chooseAddButton);
        chooseNumberEditText = (EditText) findViewById(R.id.chooseNumberEditText);
        chooseSubButton = (Button) findViewById(R.id.chooseSubButton);
        chooseNumberRelativeLayout = (RelativeLayout) findViewById(R.id.chooseNumberRelativeLayout);
        chooseLine4View = (View) findViewById(R.id.chooseLine4View);
        chooseBuyButton = (Button) findViewById(R.id.chooseBuyButton);
        chooseCartButton = (Button) findViewById(R.id.chooseCartButton);
        chooseRelativeLayout = (RelativeLayout) findViewById(R.id.chooseRelativeLayout);
        mainRelativeLayout = (RelativeLayout) findViewById(R.id.mainRelativeLayout);

        mMActivity = GoodDetailActivity.this;
        mUserKeyString = Constant.mSharedPreferences.getString("userKeyString", "");
        bodyTextView.setOnClickListener(this);
        chooseAddButton.setOnClickListener(this);
        chooseSubButton.setOnClickListener(this);
        chooseBuyButton.setOnClickListener(this);
        chooseCartButton.setOnClickListener(this);
        joinCartTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.chooseAddButton:
                String temp = chooseNumberEditText.getText().toString();
                if (temp.isEmpty()) {
                    chooseNumberEditText.setText("1");
                } else {
                    int number = Integer.parseInt(temp);
                    temp = number + 1 + "";
                    chooseNumberEditText.setText(temp);
                }
                chooseNumberEditText.setSelection(chooseNumberEditText.getText().toString().length());
                break;
            case R.id.chooseSubButton:
                String tempSub = chooseNumberEditText.getText().toString();
                if (tempSub.isEmpty()) {
                    chooseNumberEditText.setText("1");
                } else {
                    if (!tempSub.equals("0")) {
                        int number = Integer.parseInt(tempSub);
                        tempSub = number - 1 + "";
                        chooseNumberEditText.setText(tempSub);
                    }
                }
                chooseNumberEditText.setSelection(chooseNumberEditText.getText().toString().length());
                break;
            case R.id.chooseBuyButton:
                ToastUtil.show(mMActivity, "立即购买");
                backgroundTextView.setVisibility(View.GONE);
                chooseRelativeLayout.setVisibility(View.GONE);
                qrCodeRelativeLayout.setVisibility(View.GONE);
                bottomLinearLayout.setVisibility(View.VISIBLE);
                String number = chooseNumberEditText.getText().toString();
                mCart_id = mS + "|" + number;
                mTypePresenter.getGoodsBuyNowFromF(BuyNowBean.class, mUserKeyString, mCart_id);
                break;
            case R.id.chooseCartButton:
                String quantity = chooseNumberEditText.getText().toString();
                if (quantity.isEmpty() || quantity.equals("0")) {
                    ToastUtil.show(GoodDetailActivity.this, "请确认数量是否正确");
                }
                mTypePresenter.getGoodsAddCartFromF(mUserKeyString, mS, quantity);
                break;
            case R.id.bodyTextView:
                Intent itdu=new Intent(GoodDetailActivity.this,GoodsItduActivity.class);
                itdu.putExtra("Link",mS);
                startActivity(itdu);
                break;
            case R.id.joinCartTextView:
                if (Constant.userLoginBoolean) {
                    showChoose();
                } else {
                    ToastUtil.show(GoodDetailActivity.this, "请先登录");
                }
                break;
        }
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
//        goodsViewPager.setAdapter(new DetailPicAdapter(list,GoodDetailActivity.this));
        commentTextView.setText("好评率"+t.getDatas().getGoods_evaluate_info().getGood_percent()+"%");
        commentNumTextView.setText(t.getDatas().getGoods_evaluate_info().getBad_percent()+"人评价");
        storeDescTextView.setText(t.getDatas().getStore_info().getStore_credit().getStore_desccredit().getText()+":"+t.getDatas().getStore_info().getStore_credit().getStore_desccredit().getCredit()+"分");
        storeServerTextView.setText(t.getDatas().getStore_info().getStore_credit().getStore_servicecredit().getText()+":"+t.getDatas().getStore_info().getStore_credit().getStore_servicecredit().getCredit()+"分");
        storeDeliveryTextView.setText(t.getDatas().getStore_info().getStore_credit().getStore_deliverycredit().getText()+":"+t.getDatas().getStore_info().getStore_credit().getStore_deliverycredit().getCredit()+"分");
        storeTextView.setText(t.getDatas().getStore_info().getStore_name());
        nameTextView.setText(t.getDatas().getGoods_info().getGoods_name());
        jingleTextView.setText(t.getDatas().getGoods_info().getGoods_jingle());
        addressTextView.setText(t.getDatas().getGoods_hair_info().getArea_name());
        addressTipTextView.setText(t.getDatas().getGoods_hair_info().getIf_store_cn()+"  "+t.getDatas().getGoods_hair_info().getContent());
        pricePromotionTextView.setText("￥ "+t.getDatas().getGoods_info().getGoods_promotion_price());
        saleNumTextView.setText("销量:"+t.getDatas().getGoods_info().getGoods_salenum()+"件");
        String goods_image = t.getDatas().getGoods_image();
        String[] split = goods_image.split(",");
        paresGoodsImage(split);

        goodsCmdAdapter.setData(t.getDatas().getGoods_commend_list());
        goodsCmdAdapter.notifyDataSetChanged();

        mTypePresenter.getImageFromServer(GoodDetailActivity.this, t.getDatas().getSpec_image().get(0), chooseImageView);
        chooseNameTextView.setText(t.getDatas().getGoods_info().getGoods_name());
        String pricePromotion = "￥" + t.getDatas().getGoods_info().getGoods_promotion_price();
        choosePriceTextView.setText(pricePromotion);
        String storage = "库存：" + t.getDatas().getGoods_info().getGoods_storage() + " 件";
        chooseStorageTextView.setText(storage);



    }
    private void paresGoodsImage(final String[] spilt) {

        list = new ArrayList<>();
//        imageViews = new ImageView[spilt.length];
        for (int i = 0; i < spilt.length; i++) {
            list.add((ImageView) mMActivity.getLayoutInflater().inflate(R.layout.include_image_view, null));
//            imageViews[i] = (ImageView) list.get(i).findViewById(R.id.includeImageView);

//            mTypePresenter.getImageFromServer(mMActivity,spilt[position], imageViews[i]);
            mTypePresenter.getImageFromServer(mMActivity,spilt[i], list.get(i));
        }

        goodsViewPager.setAdapter(new DetailPicAdapter(list,GoodDetailActivity.this));

    }
    @Override
    public void getGoodsItduData(String str) {

    }

    @Override
    public void getGoodsBuyNowData(BuyNowBean str) {


        Intent intent = new Intent(GoodDetailActivity.this,BuySetupActivity.class);
        Gson gson=new Gson();
        String json = gson.toJson(str);
        intent.putExtra("BuyNowBean", json);
        intent.putExtra("cart_id", mCart_id);
        intent.putExtra("ifcart", "");
        intent.putExtra("store_id", str.getDatas().getStore_cart_list().get_$1().getGoods_list().get(0).getStore_id());
        startActivity(intent);
    }

    int[] location;
    @Override
    public void getGoodsAddCartData(AddCartBean str) {
        if (str.getDatas().equals("1")) {
            backgroundTextView.setVisibility(View.GONE);
            chooseRelativeLayout.setVisibility(View.GONE);
            qrCodeRelativeLayout.setVisibility(View.GONE);
            bottomLinearLayout.setVisibility(View.VISIBLE);
            ToastUtil.show(GoodDetailActivity.this, "添加到购物车成功");

            mCurImageView = list.get(goodsViewPager.getCurrentItem());
            if(location == null){
                location = new int[2];
            }
            mCurImageView.getLocationInWindow(location);
            doAnim(mCurImageView.getDrawable(), location);
        }
    }

    @Override
    public void getGoodsPreIdData(PayDataBean str) {

    }

    private void showChoose() {

        backgroundTextView.setVisibility(View.GONE);
        chooseRelativeLayout.setVisibility(View.GONE);
        qrCodeRelativeLayout.setVisibility(View.GONE);
        bottomLinearLayout.setVisibility(View.GONE);

        backgroundTextView.setVisibility(View.VISIBLE);
        chooseRelativeLayout.setVisibility(View.VISIBLE);
        backgroundTextView.startAnimation(Constant.showAlphaAnimation);
        chooseRelativeLayout.startAnimation(Constant.showAlphaAnimation);

    }

    @Override
    public void add(View v) {
        int[] childCoordinate = new int[2];
        int[] parentCoordinate = new int[2];
        int[] shopCoordinate = new int[2];
        //1.分别获取被点击View、父布局、购物车在屏幕上的坐标xy。

        v.getLocationInWindow(childCoordinate);
        mainRelativeLayout.getLocationInWindow(parentCoordinate);
        cartTextView.getLocationInWindow(shopCoordinate);

        //2.自定义ImageView 继承ImageView
        MoveImageView img = new MoveImageView(this);
        img.setImageResource(R.mipmap.ic_goods_cart);
        //3.设置img在父布局中的坐标位置
        img.setX(childCoordinate[0] - parentCoordinate[0]);
        img.setY(childCoordinate[1] - parentCoordinate[1]);
        //4.父布局添加该Img
        mainRelativeLayout.addView(img);

        //5.利用 二次贝塞尔曲线 需首先计算出 MoveImageView的2个数据点和一个控制点
        PointF startP = new PointF();
        PointF endP = new PointF();
        PointF controlP = new PointF();
        //开始的数据点坐标就是 addV的坐标
        startP.x = childCoordinate[0] - parentCoordinate[0];
        startP.y = childCoordinate[1] - parentCoordinate[1];
        //结束的数据点坐标就是 shopImg的坐标
        endP.x = shopCoordinate[0] - parentCoordinate[0];
        endP.y = shopCoordinate[1] - parentCoordinate[1];
        //控制点坐标 x等于 购物车x；y等于 addV的y
        controlP.x = endP.x;
        controlP.y = startP.y;

        //启动属性动画
        ObjectAnimator animator = ObjectAnimator.ofObject(img, "mPointF", new PointFTypeEvaluator(controlP), startP, endP);
        animator.setDuration(1000);
        animator.addListener(this);
        animator.start();


        count++;
        badge.setText(count+"");
        badge.show();
        String quantity=count+"";
        mTypePresenter.getGoodsAddCartFromF(mUserKeyString, mS, quantity);
    }

    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {
        //动画结束后 父布局移除 img
        Object target = ((ObjectAnimator) animation).getTarget();
        mainRelativeLayout.removeView((View) target);
        //shopImg 开始一个放大动画
        Animation scaleAnim = AnimationUtils.loadAnimation(this, R.anim.shop_scale);
        cartTextView.startAnimation(scaleAnim);



    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }

    @Override
    public void showOrHideLoading(boolean flag) {

    }


    /**
     * 自定义估值器
     */
    public class PointFTypeEvaluator implements TypeEvaluator<PointF> {
        /**
         * 每个估值器对应一个属性动画，每个属性动画仅对应唯一一个控制点
         */
        PointF control;
        /**
         * 估值器返回值
         */
        PointF mPointF = new PointF();

        public PointFTypeEvaluator(PointF control) {
            this.control = control;
        }

        @Override
        public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
            return getBezierPoint(startValue, endValue, control, fraction);
        }

        /**
         * 二次贝塞尔曲线公式
         *
         * @param start   开始的数据点
         * @param end     结束的数据点
         * @param control 控制点
         * @param t       float 0-1
         * @return 不同t对应的PointF
         */
        private PointF getBezierPoint(PointF start, PointF end, PointF control, float t) {
            mPointF.x = (1 - t) * (1 - t) * start.x + 2 * t * (1 - t) * control.x + t * t * end.x;
            mPointF.y = (1 - t) * (1 - t) * start.y + 2 * t * (1 - t) * control.y + t * t * end.y;
            return mPointF;
        }
    }













    private void doAnim(Drawable drawable, int[] start_location){
        if(!isClean){
            setAnim(drawable,start_location);
        }else{
            try{
                animation_viewGroup.removeAllViews();
                isClean = false;
                setAnim(drawable,start_location);
            }catch(Exception e){
                e.printStackTrace();
            }
            finally{
                isClean = true;
            }
        }
    }
    /**
     * @Description: 创建动画层
     * @param
     * @return void
     * @throws
     */
    private FrameLayout createAnimLayout(){
        ViewGroup rootView = (ViewGroup)this.getWindow().getDecorView();
        FrameLayout animLayout = new FrameLayout(this);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT);
        animLayout.setLayoutParams(lp);
        animLayout.setBackgroundResource(android.R.color.transparent);
        rootView.addView(animLayout);
        return animLayout;

    }

    /**
     * @deprecated 将要执行动画的view 添加到动画层
     * @param vg
     *        动画运行的层 这里是frameLayout
     * @param view
     *        要运行动画的View
     * @param location
     *        动画的起始位置
     * @return
     */
    private View addViewToAnimLayout(ViewGroup vg,View view,int[] location){
        int x = location[0];
        int y = location[1];
        vg.addView(view);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
                mCurImageView.getWidth(), mCurImageView.getHeight());
        lp.leftMargin = x;
        lp.topMargin = y;
        view.setPadding(5, 5, 5, 5);
        view.setLayoutParams(lp);

        return view;
    }
    /**
     * dip，dp转化成px 用来处理不同分辨路的屏幕
     * @param context
     * @param dpValue
     * @return
     */
    private int dip2px(Context context, float dpValue){
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dpValue*scale +0.5f);
    }


    /**
     * 动画效果设置
     * @param drawable
     *       将要加入购物车的商品
     * @param start_location
     *        起始位置
     */
    private void setAnim(Drawable drawable,int[] start_location){


        Animation mScaleAnimation = new ScaleAnimation(1.5f,0.0f,1.5f,0.0f,Animation.RELATIVE_TO_SELF,0.1f,Animation.RELATIVE_TO_SELF,0.1f);
        mScaleAnimation.setDuration(AnimationDuration);
        mScaleAnimation.setFillAfter(true);


        final ImageView iview = new ImageView(this);
        iview.setImageDrawable(drawable);
        final View view = addViewToAnimLayout(animation_viewGroup,iview,start_location);
        view.setAlpha(0.6f);

        int[] end_location = new int[2];
        cartTextView.getLocationInWindow(end_location);
        int endX = end_location[0];
        int endY = end_location[1]-start_location[1];

        Animation mTranslateAnimation = new TranslateAnimation(0,endX,0,endY);
        Animation mRotateAnimation = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mRotateAnimation.setDuration(AnimationDuration);
        mTranslateAnimation.setDuration(AnimationDuration);
        AnimationSet mAnimationSet = new AnimationSet(true);

        mAnimationSet.setFillAfter(true);
        mAnimationSet.addAnimation(mRotateAnimation);
        mAnimationSet.addAnimation(mScaleAnimation);
        mAnimationSet.addAnimation(mTranslateAnimation);

        mAnimationSet.setAnimationListener(new Animation.AnimationListener(){

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub
                number++;
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // TODO Auto-generated method stub

                number--;
                if(number==0){
                    isClean = true;
                    myHandler.sendEmptyMessage(0);
                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

        });
        view.startAnimation(mAnimationSet);

    }
    /**
     * 内存过低时及时处理动画产生的未处理冗余
     */
    @Override
    public void onLowMemory() {
        // TODO Auto-generated method stub
        isClean = true;
        try{
            animation_viewGroup.removeAllViews();
        }catch(Exception e){
            e.printStackTrace();
        }
        isClean = false;
        super.onLowMemory();
    }
















}
