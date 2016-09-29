package com.jss.jssatenmythri2016_17.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.jss.jssatenmythri2016_17.R;
import com.jss.jssatenmythri2016_17.activity.registeration.RegisterationActivity;
import com.jss.jssatenmythri2016_17.helper.AccessServiceAPI;
import com.jss.jssatenmythri2016_17.util.Common;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SplashActivity extends AppCompatActivity {

    SharedPreferences pref;
    final String LOGIN_KEY="logged_in";
    final String IS_REGISTERATION = "registeration";
    Animation animation;
    final String PREF_NAME = "mythri";
    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logo = (ImageView)findViewById(R.id.logo);
        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoomin);
        pref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        logo.setAnimation(animation);
        logo.setVisibility(View.VISIBLE);
        m_AccessServiceAPI = new AccessServiceAPI();
        animation.start();
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                new TaskRegister().execute();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }


    private ProgressDialog m_ProgresDialog;
    private AccessServiceAPI m_AccessServiceAPI;
    public class TaskRegister extends AsyncTask<String, Void, Integer> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            m_ProgresDialog = ProgressDialog.show(SplashActivity.this, "Please wait", "Will take only a moment...", true);
        }

        @Override
        protected Integer doInBackground(String... params) {
            Map<String, String> postParam = new HashMap<>();
            try{
                String jsonString = m_AccessServiceAPI.getJSONStringWithParam_POST(Common.SERVICE_CHECK_VERSION_URL, postParam);
                JSONObject jsonObject = new JSONObject(jsonString);
                JSONObject object = jsonObject.getJSONObject("version");
                return object.getInt("version");
            }catch (Exception e) {
                e.printStackTrace();
                return Common.RESULT_ERROR;
            }

        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            m_ProgresDialog.dismiss();

            try {
                PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
                int verCode = pInfo.versionCode;
                if(verCode < integer){
                    alertUpgrade();
                }else{
                    boolean isLoggedIn = pref.getBoolean(LOGIN_KEY,false);
                    boolean isRegisteration = pref.getBoolean(IS_REGISTERATION,false);
                    if(isLoggedIn && !isRegisteration) {
                        //Open MainActivity
                        startActivity(new Intent(SplashActivity.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        finish();
                    }else if(isLoggedIn && isRegisteration){
                        startActivity(new Intent(SplashActivity.this, RegisterationActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        finish();
                    }
                    else {
                        //Open Login Screen
                        startActivity(new Intent(SplashActivity.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        finish();
                    }
                }

            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    public void alertUpgrade(){
        final AlertDialog.Builder upgradeAlert = new AlertDialog.Builder(this);
        upgradeAlert.setTitle("Update!!");
        upgradeAlert.setCancelable(false);
        upgradeAlert.setMessage("An Updated Version is available on Play Store, Please Update application to use extra functionalities of app.");
        upgradeAlert.setPositiveButton("Yes",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.jss.jssatenmythri2016_17"));
                startActivity(i);
            }
        });
        upgradeAlert.show();
    }
}

