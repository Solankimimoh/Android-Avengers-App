package com.example.solan.evenoddcolorchangeitemrv;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomeAdapter extends RecyclerView.Adapter<CustomeAdapter.MyViewHolder> {


    private static final String TAG = CustomeAdapter.class.getSimpleName();

    private Context context;
    private ArrayList<UserModel> userModelArrayList;
    private ItemClickListener itemClickListener;
    private int evenViewColor;
    private int oddViewColor;


    private static final int EVEN_VIEW_TYPE = 0;
    private static final int ODD_VIEW_TYPE = 1;

    public CustomeAdapter(Context context, ArrayList<UserModel> userModelArrayList, ItemClickListener itemClickListener, int evenViewColor, int oddViewColor) {
        this.context = context;
        this.userModelArrayList = userModelArrayList;
        this.itemClickListener = itemClickListener;
        this.evenViewColor = evenViewColor;
        this.oddViewColor = oddViewColor;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nameTv;
        TextView emailTv;
        UserModel userModel;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTv = itemView.findViewById(R.id.row_layout_name);
            emailTv = itemView.findViewById(R.id.row_layout_email);
            itemView.setOnClickListener(this);

            Log.e(TAG, "MyViewHolder: ");
        }

        public void setData(UserModel data) {
            this.userModel = data;
            nameTv.setText(data.getName());
            emailTv.setText(data.getEmail());
            Log.e(TAG, "setData: ");

        }

        @Override
        public void onClick(View v) {
            Log.e(TAG, "onClick: ");
            if (itemClickListener != null) {
                itemClickListener.onItemClick(userModel);
            }
        }


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = null;
        Log.e(TAG, "onCreateViewHolder: " + viewType);

        switch (viewType) {
            case 0:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.even_row_layout, viewGroup, false);
                break;
            case 1:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.odd_row_layout, viewGroup, false);
                break;
        }
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        UserModel userModel = userModelArrayList.get(i);
        myViewHolder.setData(userModel);
        Log.e(TAG, "onBindViewHolder: ");

        if (i % 2 == 0) {
            myViewHolder.itemView.setBackgroundColor(evenViewColor);
        } else {
            myViewHolder.itemView.setBackgroundColor(oddViewColor);
        }

    }


    @Override
    public int getItemViewType(int position) {
        Log.e(TAG, "getItemViewType: ");
        if (position % 2 == 0) {
            return EVEN_VIEW_TYPE;
        }
        return ODD_VIEW_TYPE;
    }

    @Override
    public int getItemCount() {
        Log.e(TAG, "getItemCount: ");
        return userModelArrayList.size();
    }

    void changeEvenItemBackGroudColor(int color) {
        evenViewColor = color;
    }

    void changeOddItemBackGroudColor(int color) {
        oddViewColor = color;
    }
}
