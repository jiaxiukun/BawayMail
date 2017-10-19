package test.bwie.com.bawaymail.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

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
import test.bwie.com.bawaymail.model.utils.ToastUtil;
import test.bwie.com.bawaymail.presenter.TypePresenter;
import test.bwie.com.bawaymail.view.adapter.ExpandableGridAdapter;
import test.bwie.com.bawaymail.view.adapter.MyLeftAdapter;
import test.bwie.com.bawaymail.view.iview.TypeView;

import static test.bwie.com.bawaymail.R.id.class_elv;


public class ClassFragment extends Fragment implements TypeView<ClassBean> {

    private RecyclerView recycler;
    private TypePresenter mPresenter;
    private MyLeftAdapter mLeftAdapter;
    private ExpandableListView mExpand;
    private List<Map<String, Object>> list;
    private String[][] mArr;
    private int currentGroup;
    private int sign = -1;// 控制列表的展开
    private List<ShopDetailBean.DatasBean.ClassListBean> mClass_list;
    int pos = 0;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_class, null);
        initView(view);
        initData();
        return view;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {

            initData();
            initView(view);

        }
    }

    private void initData() {
        mPresenter = new TypePresenter();
        mPresenter.attachView(this);
        mLeftAdapter = new MyLeftAdapter(getActivity());
        mLeftAdapter.setPresenter(mPresenter);
        recycler.setAdapter(mLeftAdapter);
        mPresenter.getDataFromF(TypeBean.class);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void initView(View view) {
        recycler = (RecyclerView) view.findViewById(R.id.recycler);
        mExpand = (ExpandableListView) view.findViewById(class_elv);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(manager);
        recycler.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        mExpand.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                if (currentGroup == groupPosition) {
                    if (sign == -1) {
                        // 展开被选的group
                        mExpand.expandGroup(groupPosition);
                        // 设置被选中的group置于顶端
                        mExpand.setSelectedGroup(groupPosition);
                        sign = groupPosition;
                        currentGroup = groupPosition;
                        mPresenter.getShopFromF(mClass_list.get(groupPosition).getGc_id(), ShopDetailBean.class);
                    } else if (sign == groupPosition) {
                        mExpand.collapseGroup(sign);
                        sign = -1;
                    } else {
                        mExpand.collapseGroup(sign);
                        // 展开被选的group
                        mExpand.expandGroup(groupPosition);
                        // 设置被选中的group置于顶端
                        mExpand.setSelectedGroup(groupPosition);
                        sign = groupPosition;
                    }
                } else {
                    sign = groupPosition;
                    currentGroup = groupPosition;
                    mPresenter.getShopFromF(mClass_list.get(groupPosition).getGc_id(), ShopDetailBean.class);
                }
                return false;
            }
        });
    }


    @Override
    public void getDataSuc(TypeBean classBean) {
        final List<TypeBean.DatasBean.ClassListBean> class_list = classBean.getDatas().getClass_list();
        mLeftAdapter.setData(class_list);
        mLeftAdapter.notifyDataSetChanged();
        mLeftAdapter.setOnitemClickListener(new MyLeftAdapter.OnitemClickListener() {
            @Override
            public void onClick(int position) {
                ToastUtil.show(getActivity(), class_list.get(position).getGc_name());

                mPresenter.getShopDataFromF(class_list.get(position).getGc_id(), ShopDetailBean.class);
                currentGroup = 0;
                sign = currentGroup;
            }
        });
        mPresenter.getShopDataFromF(class_list.get(0).getGc_id(), ShopDetailBean.class);
    }

    @Override
    public void getDataErr(String str, int code) {

    }

    @Override
    public void getShopDetailSuc(ShopDetailBean t) {
        mClass_list = t.getDatas().getClass_list();
        list = new ArrayList<>();
        for (int i = 0; i < mClass_list.size(); i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("txt", mClass_list.get(i).getGc_name());
            list.add(map);
        }

        mPresenter.getShopFromF(mClass_list.get(0).getGc_id(), ShopDetailBean.class);
    }

    @Override
    public void getShopSuc(ShopDetailBean t) {
        List<ShopDetailBean.DatasBean.ClassListBean> class_list = t.getDatas().getClass_list();
        mArr = new String[1][class_list.size()];
        for (int i = 0; i < class_list.size(); i++) {
            mArr[0][i] = class_list.get(i).getGc_name();

        }

        ExpandableGridAdapter adapter = new ExpandableGridAdapter(getActivity(), list, mArr);
        mExpand.setAdapter(adapter);
        mExpand.expandGroup(currentGroup);

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

    }


    @Override
    public void showOrHideLoading(boolean flag) {

    }
}
