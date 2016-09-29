package com.jss.jssatenmythri2016_17.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jss.jssatenmythri2016_17.R;
import com.jss.jssatenmythri2016_17.util.Text_Getter_Setter;

public class Support extends Fragment {

    LinearLayout karancontact,manishcontact,dikshantcontact;
    TextView karannumber,manishnumber,dikshantnumber;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_support, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        karancontact = (LinearLayout)view.findViewById(R.id.callKaran);
        manishcontact = (LinearLayout)view.findViewById(R.id.callManish);
        dikshantcontact = (LinearLayout)view.findViewById(R.id.callDikshant);

        karannumber = (TextView)view.findViewById(R.id.karannumber);
        manishnumber = (TextView)view.findViewById(R.id.manishnumber);
        dikshantnumber = (TextView)view.findViewById(R.id.dikshantnumber);

        karancontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCall(karannumber.getText().toString());
            }
        });
        manishcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCall(manishnumber.getText().toString());
            }
        });
        dikshantcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCall(dikshantnumber.getText().toString());
            }
        });





    }

    public void onCall(String number) {

        if(Build.VERSION.SDK_INT >= 23) {
            int permissionCheck = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE);

            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                        getActivity(),
                        new String[]{Manifest.permission.CALL_PHONE},
                        123);
            } else {
                startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:"+number)));
            }
        }else{
            startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:"+number)));
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {

            case 123:
                if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                } else {
                    Log.d("TAG", "Call Permission Not Granted");
                }
                break;

            default:
                break;
        }
    }


}
