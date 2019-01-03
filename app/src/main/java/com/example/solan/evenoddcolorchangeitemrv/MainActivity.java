
package com.example.solan.evenoddcolorchangeitemrv;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener, View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ArrayList<UserModel> userModelArrayList;
    private CustomeAdapter customeAdapter;
    private RecyclerView recyclerView;
    private TextView evenTv;
    private TextView oddTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.activity_main_rv);
        evenTv = findViewById(R.id.activity_main_even_tv);
        oddTv = findViewById(R.id.activity_main_odd_tv);

        evenTv.setOnClickListener(this);
        oddTv.setOnClickListener(this);


        userModelArrayList = new ArrayList<>();

        userModelArrayList.add(new UserModel("XYZ", "xyz@gmail.com"));
        userModelArrayList.add(new UserModel("MNP", "mnp@gmail.com"));
        userModelArrayList.add(new UserModel("XYZ", "xyz@gmail.com"));
        userModelArrayList.add(new UserModel("ABC", "abc@gmail.com"));
        userModelArrayList.add(new UserModel("PQR", "pqr@gmail.com"));
        userModelArrayList.add(new UserModel("XYZ", "xyz@gmail.com"));
        userModelArrayList.add(new UserModel("XYZ", "xyz@gmail.com"));
        userModelArrayList.add(new UserModel("MNP", "mnp@gmail.com"));
        userModelArrayList.add(new UserModel("XYZ", "xyz@gmail.com"));
        userModelArrayList.add(new UserModel("PQR", "pqr@gmail.com"));
        userModelArrayList.add(new UserModel("MNP", "mnp@gmail.com"));
        userModelArrayList.add(new UserModel("XYZ", "xyz@gmail.com"));
        userModelArrayList.add(new UserModel("DEF", "def@gmail.com"));

        customeAdapter = new CustomeAdapter(MainActivity.this, userModelArrayList, this, Color.WHITE, Color.WHITE);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(customeAdapter);


    }

    @Override
    public void onItemClick(UserModel userModel) {
        Toast.makeText(this, "User", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_even_tv:
                changeColorOfEvenItems();
                break;
            case R.id.activity_main_odd_tv:
                changeColorOfOddItems();
                break;
        }
    }

    private void changeColorOfOddItems() {
        customeAdapter.changeOddItemBackGroudColor(Color.GREEN);
        customeAdapter.notifyDataSetChanged();
    }

    private void changeColorOfEvenItems() {
        customeAdapter.changeEvenItemBackGroudColor(Color.RED);
        customeAdapter.notifyDataSetChanged();
    }

}
