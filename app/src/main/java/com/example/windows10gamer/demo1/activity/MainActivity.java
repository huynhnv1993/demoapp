package com.example.windows10gamer.demo1.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.example.windows10gamer.demo1.R;
import com.example.windows10gamer.demo1.adapter.CategAdapter;
import com.example.windows10gamer.demo1.model.Categ;
import com.example.windows10gamer.demo1.ultil.CheckConnection;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewmanhinhchinh;
    NavigationView navigationView;
    ListView listViewmanhinhchinh;
    DrawerLayout drawLayout;
    ArrayList<Categ> arrCateg;
    CategAdapter categAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Mapping();
        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
            ActionBar();
            ActionViewFlipper();
        }else {
            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");
            finish();
        }

    }

    private void ActionViewFlipper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://cdn2.tgdd.vn/qcao/24_05_2017_11_34_31_Op-Lung-iPhone-40K-800-300.png");
        mangquangcao.add("https://cdn.tgdd.vn/qcao/12_05_2017_16_16_18_Asus-Zenfone-800-300.png");
        mangquangcao.add("https://cdn4.tgdd.vn/qcao/26_05_2017_10_52_51_Galaxy-A3-800-300-2-(1).png");
        mangquangcao.add("https://cdn2.tgdd.vn/qcao/26_05_2017_22_17_52_TGDD-Oppo-F3-800-300.png");
        for (int i=0 ; i<mangquangcao.size() ; i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_slide_in);
        viewFlipper.setOutAnimation(animation_slide_out);

    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void Mapping() {
        toolbar = (Toolbar) findViewById(R.id.toolbarmanhinhchinh);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewflippermanhinhchinh);
        recyclerViewmanhinhchinh = (RecyclerView) findViewById(R.id.recyclerviewmanhinhchinh);
        listViewmanhinhchinh = (ListView) findViewById(R.id.listviewmanhinhchinh);
        navigationView = (NavigationView) findViewById(R.id.navigationmahinhchinh);
        drawLayout = (DrawerLayout) findViewById(R.id.drawerlayoutmanhinhchinh);
        arrCateg = new ArrayList<>();
        arrCateg.add(0,new Categ(0,"Trang chính","http://icons.iconarchive.com/icons/fps.hu/free-christmas-flat-circle/512/home-icon.png"));
        arrCateg.add(1,new Categ(0,"Liên hệ","https://cdn2.iconfinder.com/data/icons/picons-basic-1/57/basic1-039_address_book-512.png"));
        arrCateg.add(2,new Categ(0,"Thông tin","https://cdn3.iconfinder.com/data/icons/vector-icons-for-mobile-apps-2/512/Info_black-512.png"));
        categAdapter = new CategAdapter(arrCateg,getApplicationContext());
        listViewmanhinhchinh.setAdapter(categAdapter);
    }
}
