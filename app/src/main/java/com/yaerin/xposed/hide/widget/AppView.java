package com.yaerin.xposed.hide.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yaerin.xposed.hide.R;
import com.yaerin.xposed.hide.bean.AppInfo;

public class AppView extends RelativeLayout {

    private AppInfo mAppInfo;

    private ImageView mIcon;
    private TextView mName;
    private TextView mPackage;

    public AppView(Context context, AppInfo info) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.view_app, this, true);
        mIcon = findViewById(R.id.app_icon);
        mName = findViewById(R.id.app_name);
        mPackage = findViewById(R.id.app_package);
        setAppInfo(info);
    }

    public AppView(Context context) {
        super(context);
    }

    public AppView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AppView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public AppInfo getAppInfo() {
        return mAppInfo;
    }

    public void setAppInfo(AppInfo info) {
        mAppInfo = info;
        mIcon.setImageDrawable(info.getIcon());
        mName.setText(info.getLabel());
        mPackage.setText(info.getPackageName());
        setChecked(info.isDisabled());
    }

    public boolean isChecked() {
        return mAppInfo.isDisabled();
    }

    public void setChecked(boolean checked) {
        mAppInfo.setDisabled(checked);
        setBackground(checked ? new ColorDrawable(0xFFE1A7A2) : null);
    }
}
