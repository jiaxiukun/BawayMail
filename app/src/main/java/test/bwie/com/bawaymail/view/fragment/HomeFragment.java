package test.bwie.com.bawaymail.view.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.model.bean.Bean;
import test.bwie.com.bawaymail.model.utils.Constant;
import test.bwie.com.bawaymail.model.utils.NetUtils;
import test.bwie.com.bawaymail.model.utils.OkHttpManager;
import test.bwie.com.bawaymail.presenter.HomePresenter;
import test.bwie.com.bawaymail.view.adapter.HomeRecyclerViewAdapter;
import test.bwie.com.bawaymail.view.iview.IView;

public class HomeFragment extends Fragment implements IView {
    private HomePresenter homePresenter;
    private List<String> list_image = new ArrayList<String>();
    private List<Bean.DatasBean.GoodsListBean> beanList = new ArrayList<>();
    private RecyclerView recyclerView;
    private GridLayoutManager manager;
    private TextView imageView;

    private View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, null);
        //判断是否有网络
        boolean networkAvailable = NetUtils.isNetworkAvailable(getActivity());
        if (networkAvailable) {
            initData();
            initView(view);
            Toast.makeText(getActivity(), "您已连接网络", Toast.LENGTH_SHORT).show();
        } else {
            //没有网络时 跳转设置页面
            AlertDialog.Builder b = new AlertDialog.Builder(getActivity()).setTitle("没有可用的网络").setMessage("请开启GPRS或WIFI网路连接");
            b.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Intent mIntent = new Intent("android.settings.WIRELESS_SETTINGS");
                    startActivity(mIntent);
                }
            }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    //errorImage.setVisibility(View.VISIBLE);
                }
            }).create();
            b.show();
        }
        return view;
    }

    private void initData() {
    }

    private void initView(final View view) {
        imageView = (TextView) view.findViewById(R.id.retard_image);
        beanList.clear();
        imageView.setVisibility(View.VISIBLE);
        OkHttpManager.getInstance().asyncJsonStringByURL(Constant.LINK_MOBILE_GOODS_SEARCH, new OkHttpManager.Func1() {
            private GridLayoutManager manager;
            @Override
            public void onResponse(String result) {
                imageView.setVisibility(View.GONE);
                System.out.println(result);
                recyclerView = (RecyclerView) view.findViewById(R.id.home_frag_recycler);
                String replace = result.replace("192.168.56.1", "169.254.204.134");
                Gson gson = new Gson();
                Bean bean = gson.fromJson(replace, Bean.class);
                beanList = bean.datas.goods_list;
                list_image = new ArrayList<String>();
                for (int i = 0; i < 4; i++) {
                    list_image.add(beanList.get(i).goods_image_url);
                }
                manager = new GridLayoutManager(getContext(), 2);
                manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        int type = recyclerView.getAdapter().getItemViewType(position);
                        if (type < 3) {
                            return manager.getSpanCount();
                        } else {
                            return 1;
                        }
                    }
                });
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(new HomeRecyclerViewAdapter(beanList, list_image, getActivity()));
            }
        });
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(!hidden){
            initView(view);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }


    @Override
    public void showOrHideLoading(boolean flag) {


    }
}
