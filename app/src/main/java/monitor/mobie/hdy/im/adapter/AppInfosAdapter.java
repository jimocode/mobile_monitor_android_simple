package monitor.mobie.hdy.im.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

import monitor.mobie.hdy.im.R;
import monitor.mobie.hdy.im.model.AppInfo;

/**
 * Created by hdy on 28/11/2018.
 */

public class AppInfosAdapter extends BaseAdapter {

    Context context;
    List<AppInfo> appInfos;

    public AppInfosAdapter() {
    }

    public AppInfosAdapter(Context context, List<AppInfo> infos) {
        this.context = context;
        this.appInfos = infos;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<AppInfo> getAppInfos() {
        return appInfos;
    }

    public void setAppInfos(List<AppInfo> appInfos) {
        this.appInfos = appInfos;
    }

    @Override
    public int getCount() {
        int count = 0;
        if (null != appInfos) {
            return appInfos.size();
        }
        return count;

    }

    @Override
    public Object getItem(int position) {
        return appInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.app_infos_item, null);
            viewHolder.app_infos_img = (ImageView) convertView.findViewById(R.id.app_infos_img);
            viewHolder.app_infos_name = (TextView) convertView.findViewById(R.id.app_infos_name);
            viewHolder.app_infos_pacakge_name = (TextView) convertView.findViewById(R.id.app_infos_pacakge_name);
            viewHolder.app_infos_switch = (Switch) convertView.findViewById(R.id.app_infos_switch);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (appInfos != null) {
            AppInfo appInfo = appInfos.get(position);
            viewHolder.app_infos_img.setBackground(appInfo.getDrawable());
            viewHolder.app_infos_name.setText(appInfo.getAppName());
            viewHolder.app_infos_switch.setChecked(appInfo.isOpen());
        }
        return convertView;
    }

    private class ViewHolder {
        ImageView app_infos_img;
        TextView app_infos_name;
        TextView app_infos_pacakge_name;
        Switch app_infos_switch;
    }
}