package com.jss.jssatenmythri2016_17.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jss.jssatenmythri2016_17.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView unamet,unameid;
    String loginname,loginid;

    //Shared Pref by Ashwani - whole app preference
    SharedPreferences sharedPreferences;
    final String LOGIN_KEY="logged_in";
    final String PREF_NAME = "mythri";
    String USERNAME = "useername";
    String MYTHRI_ID = "mythri_id";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Mythri 2016");

        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        loginname = sharedPreferences.getString(USERNAME,"JSS");
        String id = sharedPreferences.getString(MYTHRI_ID,"mythri_dev_jss");
        if(!id.equals("mythri_dev_jss")) {
            loginid = "MYTHRI_16_"+id;
        }


        Fragment mf = new MainFragment();
        android.support.v4.app.FragmentManager transaction =getSupportFragmentManager();
        transaction.beginTransaction().replace(R.id.main_frame,new About()).commit();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header=navigationView.getHeaderView(0);
        unamet= (TextView)header.findViewById(R.id.uname);
        unameid= (TextView) header.findViewById(R.id.uid);
        unameid.setText(loginid);
        unamet.setText(loginname);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if(backCounter == 0){
                backCounter++;
                Toast.makeText(getApplicationContext(),"Press Back Again To Exit",Toast.LENGTH_SHORT).show();
            }else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.usergames){
            android.support.v4.app.FragmentManager transaction =getSupportFragmentManager();
            transaction.beginTransaction().replace(R.id.main_frame,new UserGames()).commit();
        }else if (id == R.id.games) {
            android.support.v4.app.FragmentManager transaction =getSupportFragmentManager();
            transaction.beginTransaction().replace(R.id.main_frame,new Games()).commit();
        }else if (id == R.id.notification) {
            android.support.v4.app.FragmentManager transaction =getSupportFragmentManager();
            transaction.beginTransaction().replace(R.id.main_frame,new Notification()).commit();
        }else if (id == R.id.home) {
            android.support.v4.app.FragmentManager transaction =getSupportFragmentManager();
            transaction.beginTransaction().replace(R.id.main_frame,new About()).commit();
        }else if(id == R.id.logout){
            clearPref();
        }else if(id == R.id.support){
            android.support.v4.app.FragmentManager transaction =getSupportFragmentManager();
            transaction.beginTransaction().replace(R.id.main_frame,new Support()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void clearPref() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(LOGIN_KEY,false);
        editor.apply();
        startActivity(new Intent(MainActivity.this,LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
        finish();
    }

    int backCounter = 0;

}
