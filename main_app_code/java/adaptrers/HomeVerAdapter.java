package com.example.food_ordering_app.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_ordering_app.R;
import com.example.food_ordering_app.models.CartModel;
import com.example.food_ordering_app.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeVerAdapter extends RecyclerView.Adapter<HomeVerAdapter.ViewHolder> {


    Context context;
    ArrayList<HomeVerModel> list;





    public HomeVerAdapter(Context context, ArrayList<HomeVerModel> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public HomeVerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_vertical_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeVerAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.foodName.setText(list.get(position).getName());
        holder.foodCat.setText(list.get(position).getCat());
        holder.foodPrice.setText(list.get(position).getPrice());

        holder.addCart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                CartModel cartItem = new CartModel(
                        holder.addCart.getText().toString(), // Assuming 1 as quantity for simplicity, you can modify it
                        list.get(position).getPrice(),
                        list.get(position).getName(),
                        list.get(position).getImage()
                );

                CartSingleton.getInstance().addItem(cartItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView foodName,foodCat,foodPrice,addCart;
        Button add,sub;
        int count=0;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.ver_image);
            foodName=itemView.findViewById(R.id.foodName);
            foodCat=itemView.findViewById(R.id.foodCat);
            foodPrice=itemView.findViewById(R.id.foodPrice);
            addCart=itemView.findViewById(R.id.quantityText);
            add=itemView.findViewById(R.id.add);
            sub=itemView.findViewById(R.id.sub);

            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    increment();
                }
            });
            sub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    decrement();
                }
            });
        }
        public void increment(){
            count++;

            addCart.setText(""+count);
        }

        public void decrement(){
            if(count<=0) count=0;
            else count--;

            addCart.setText(""+count);
        }
    }


}
