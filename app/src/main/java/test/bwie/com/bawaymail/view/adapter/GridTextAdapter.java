package test.bwie.com.bawaymail.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import test.bwie.com.bawaymail.R;


/**
 * @ Description:
 * @ Date:2017/10/19
 * @ Author:贾秀坤
 */
public class GridTextAdapter extends BaseAdapter {

	private List<String> child_text_array = new ArrayList<String>();
	private Context mContext;

	public GridTextAdapter(Context context, List<String> child_text_array) {
		this.mContext = context;
		this.child_text_array = child_text_array;
	}

	@Override
	public int getCount() {
		return child_text_array.size();
	}

	@Override
	public Object getItem(int position) {
		return child_text_array.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHodler viewHodler = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.adapter_gridview, null);
			viewHodler = new ViewHodler();
			viewHodler.mTvType = (TextView) convertView
					.findViewById(R.id.ItemText);
			convertView.setTag(viewHodler);
		} else {
			viewHodler = (ViewHodler) convertView.getTag();
		}

		Log.i("-=======-", child_text_array.toString());

		viewHodler.mTvType.setText(child_text_array.get(position));
		return convertView;
	}

	private class ViewHodler {
		private TextView mTvType;
	}

}
