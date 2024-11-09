package com.example.food_ordering_app.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.food_ordering_app.R;
import com.example.food_ordering_app.adapters.CartAdapter;
import com.example.food_ordering_app.adapters.CartSingleton;
import com.example.food_ordering_app.models.CartModel;

import java.util.ArrayList;
import java.util.List;

public class MyCratFragment extends Fragment {

    ArrayList<CartModel> list;
    CartAdapter cartAdapter;
    RecyclerView recyclerView;
    TextView TotalPriceText;
    Button b1;

    public MyCratFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_crat, container, false);

        b1=view.findViewById(R.id.button2);
        TotalPriceText=view.findViewById(R.id.TotalPriceText);
        recyclerView=view.findViewById(R.id.cart_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        list=new ArrayList<>(CartSingleton.getInstance().getCartItems());

        cartAdapter=new CartAdapter(list);
        recyclerView.setAdapter(cartAdapter);
        //calculateTotalPrice();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTotalPrice();
            }
        });

        return view;
    }

    public void calculateTotalPrice(){
        double totalPrice=0.0;
        for(CartModel item:list){
            String priceString = item.getPrice().replace("$", "");
            double price = Double.parseDouble(priceString);
            int quantity = Integer.parseInt(item.getQuantity());
            totalPrice += price * quantity;
        }
        TotalPriceText.setText("₹ "+totalPrice);
    }
}