package com.rodrigo.turingmachines.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.rodrigo.turingmachines.R;
import com.rodrigo.turingmachines.adapters.BeltAdapter;
import com.rodrigo.turingmachines.objects.BeltItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private BeltAdapter adapter;
    private RecyclerView rvBelt;
    private List<BeltItem> belt;

    private String status ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        rvBelt = findViewById(R.id.rvBelt);

        belt = new ArrayList<>();
        belt.add(new BeltItem("l",""));
        belt.add(new BeltItem("l",""));
        belt.add(new BeltItem("l",""));
        belt.add(new BeltItem("l",""));
        belt.add(new BeltItem("+",""));
        belt.add(new BeltItem("l",""));
        belt.add(new BeltItem("l",""));
        belt.add(new BeltItem("l",""));
        belt.add(new BeltItem("l",""));

        adapter = new BeltAdapter(this,belt);
        rvBelt.setAdapter(adapter);
        rvBelt.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        shuffle();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Intent i;
        if (id == R.id.nav_palindrome) {
             i = new Intent(MainActivity.this,PalindromeActivity.class);
             startActivity(i);
        } else if (id == R.id.nav_pattern) {
            i = new Intent(MainActivity.this,PatternsActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_addition) {
            i = new Intent(MainActivity.this,AdditionActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_substr) {
            i = new Intent(MainActivity.this,SubstractionActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_multi) {
            i = new Intent(MainActivity.this,MultiplicationActivity.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private int pos =0;

    private void shuffle(){
        if(pos<belt.size()){
            new CountDownTimer(1000, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    // do something after 1s
                }

                @Override
                public void onFinish() {
                    // do something end times 5s
                    if(pos!=0){
                        belt.get(pos-1).setCurrentStatus("");
                    }
                    belt.get(pos).setCurrentStatus("q");
                    adapter.notifyDataSetChanged();


                    pos++;
                    shuffle();
                }

            }.start();
        }

    }
}
