package test.bwie.com.bawaymail.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.model.bean.AddressAddBean;
import test.bwie.com.bawaymail.model.bean.AddressBean;
import test.bwie.com.bawaymail.model.bean.AddressEditBean;
import test.bwie.com.bawaymail.model.bean.AreaBean;
import test.bwie.com.bawaymail.model.bean.CityBean;
import test.bwie.com.bawaymail.model.bean.ProvinceBean;
import test.bwie.com.bawaymail.model.utils.Constant;
import test.bwie.com.bawaymail.model.utils.ToastUtil;
import test.bwie.com.bawaymail.presenter.AddressPresenter;
import test.bwie.com.bawaymail.view.iview.AddressView;

public class AddressEditActivity extends AppCompatActivity implements AddressView {

    private ImageView leftImageView;
    private ImageView rightImageView;
    private TextView titleTextView;
    private Spinner provinceSpinner;
    private Spinner citySpinner;
    private Spinner areaSpinner;
    private EditText addressEditText;
    private EditText mobilePhoneEditText;
    private EditText trueNameEditText;
    private CheckBox defaultCheckBox;
    private LinearLayout mainLinearLayout;
    private AddressPresenter mPrenster;
    private ArrayList<String> provinceIdList;
    private ArrayList<String> provinceNameList;
    private ArrayList<String> cityIdList;
    private ArrayList<String> cityNameList;
    private ArrayList<String> areaIdList;
    private ArrayList<String> areaNameList;
    private String mUserKeyString;
    private String cityString;
    private String areaString;
    private String cityIdString;
    private String areaIdString;
    private String provinceString;
    private String mCityId;
    private String mCityName;
    private String mAreaId;
    private String mAreaName;
    private String mProvinceString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_edit);
        initView();
    }
    @Override
    protected void onResume() {
        super.onResume();
        initControl();
    }

    private void initControl() {
        mPrenster = new AddressPresenter();
        mPrenster.attachView(this);
        mPrenster.getAddressProvinceData(mUserKeyString);

        provinceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view;
                textView.setGravity(Gravity.CENTER);
                textView.setTextSize(14.0f);
                mPrenster.getAddressCityData(mUserKeyString,provinceIdList.get(i));
                mProvinceString = provinceNameList.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view;
                textView.setGravity(Gravity.CENTER);
                textView.setTextSize(14.0f);
                mPrenster.getAddressAreaData(mUserKeyString,cityIdList.get(i));
                mCityId = cityIdList.get(i);
                mCityName = cityNameList.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        areaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view;
                textView.setGravity(Gravity.CENTER);
                textView.setTextSize(14.0f);
                mAreaId = areaIdList.get(i);
                mAreaName = areaNameList.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        leftImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        rightImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
        }
    private void initView() {
        mUserKeyString = Constant.mSharedPreferences.getString("userKeyString", "");
        leftImageView = (ImageView) findViewById(R.id.leftImageView);
        rightImageView = (ImageView) findViewById(R.id.rightImageView);
        titleTextView = (TextView) findViewById(R.id.titleTextView);
        provinceSpinner = (Spinner) findViewById(R.id.provinceSpinner);
        citySpinner = (Spinner) findViewById(R.id.citySpinner);
        areaSpinner = (Spinner) findViewById(R.id.areaSpinner);
        addressEditText = (EditText) findViewById(R.id.addressEditText);
        mobilePhoneEditText = (EditText) findViewById(R.id.mobilePhoneEditText);
        trueNameEditText = (EditText) findViewById(R.id.trueNameEditText);
        defaultCheckBox = (CheckBox) findViewById(R.id.defaultCheckBox);
        mainLinearLayout = (LinearLayout) findViewById(R.id.mainLinearLayout);


        //初始化参数
        titleTextView.setText("添加收货地址");
        rightImageView.setImageResource(R.mipmap.ic_action_write);
    }

    private void submit() {
        // validate
        String addressEditTextString = addressEditText.getText().toString().trim();
        if (TextUtils.isEmpty(addressEditTextString)) {
            Toast.makeText(this, "addressEditTextString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String mobilePhoneEditTextString = mobilePhoneEditText.getText().toString().trim();
        if (TextUtils.isEmpty(mobilePhoneEditTextString)) {
            Toast.makeText(this, "请输入手机号码", Toast.LENGTH_SHORT).show();
            return;
        }

        String trueNameEditTextString = trueNameEditText.getText().toString().trim();
        if (TextUtils.isEmpty(trueNameEditTextString)) {
            Toast.makeText(this, "请输入真实姓名", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        Map<String, String> map=new HashMap<>();
        map.put("key", mUserKeyString);
        map.put("true_name", trueNameEditText.getText().toString());
        map.put("mob_phone", mobilePhoneEditText.getText().toString());
        map.put("city_id", mCityId);
        map.put("area_id", mAreaId);
        map.put("address", addressEditText.getText().toString());
        map.put("area_info", mProvinceString + " " + mCityName + " " + mAreaName);
        if (defaultCheckBox.isChecked()) {
            map.put("is_default", "1");
        } else {
            map.put("is_default", "0");
        }
        mPrenster.getAddressAddData(map);

    }

    @Override
    public void getAddressData(AddressBean str) {

    }

    @Override
    public void getAddressProvinceData(ProvinceBean str) {
        provinceIdList=new ArrayList<>();
        provinceNameList=new ArrayList<>();
        ProvinceBean.DatasBean datas = str.getDatas();
        List<ProvinceBean.DatasBean.AreaListBean> area_list = datas.getArea_list();
        for(int x=0; x< area_list.size(); x++){
            provinceIdList.add(area_list.get(x).getArea_id());
            provinceNameList.add(area_list.get(x).getArea_name());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, provinceNameList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        provinceSpinner.setAdapter(adapter);
    }

    @Override
    public void getAddressCityData(CityBean str) {
        cityIdList=new ArrayList<>();
        cityNameList=new ArrayList<>();
        List<CityBean.DatasBean.AreaListBean> area_list = str.getDatas().getArea_list();
        for(int x=0; x< area_list.size(); x++){
            cityIdList.add(area_list.get(x).getArea_id());
            cityNameList.add(area_list.get(x).getArea_name());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cityNameList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(adapter);
    }

    @Override
    public void getAddressAreaData(AreaBean str) {
        areaIdList=new ArrayList<>();
        areaNameList=new ArrayList<>();
        List<AreaBean.DatasBean.AreaListBean> area_list = str.getDatas().getArea_list();
        for(int x=0; x< area_list.size(); x++){
            areaIdList.add(area_list.get(x).getArea_id());
            areaNameList.add(area_list.get(x).getArea_name());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, areaNameList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        areaSpinner.setAdapter(adapter);
    }

    @Override
    public void getAddressAddData(AddressAddBean str) {
        Log.d("xxxx","添加"+str.getCode());
        if(str.getCode()==200){
            ToastUtil.show(AddressEditActivity.this,"收货地址添加成功");
            finish();
        }
    }

    @Override
    public void getAddressEditData(AddressEditBean str) {

    }


    @Override
    public void showOrHideLoading(boolean flag) {

    }
}
