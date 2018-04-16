package com.ksm.smplayerproject.Tool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceHelper {

	private SharedPreferences sp;

	private SharedPreferences.Editor et;

	private Context act;
	
	private String name;

	@SuppressLint("CommitPrefEdits")
	public SharedPreferenceHelper(Context context, String spName) {
		
		this.act = context;
		this.name = spName;
		if (act != null) {
			sp = act.getSharedPreferences(name, 0);
			et = sp.edit();
		}
	}

	// 存储
	public void putValue(String key, String value) {
		if(StrKit.notBlank(key)){
			et.putString(key, value);
			et.commit();
		}
	}

	// 取值
	public String getValue(String key) {
				if(null!=sp){
					return	sp.getString(key, "");
				}else{
					return "";
				}

	}
	
    //清除其中指定的数据
	public void delValue(String key) {
		et.remove(key);
		et.commit();
	}
	//清除sharepreference中的数据
	public void clearshared() {
		et.clear();
		et.commit();
	}
}
