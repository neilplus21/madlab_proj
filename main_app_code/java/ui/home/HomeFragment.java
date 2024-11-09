package com.example.food_ordering_app.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_ordering_app.R;
import com.example.food_ordering_app.adapters.HomeHorAdapter;
import com.example.food_ordering_app.adapters.HomeVerAdapter;
import com.example.food_ordering_app.adapters.UpdateVerticalRec;
import com.example.food_ordering_app.databinding.FragmentHomeBinding;
import com.example.food_ordering_app.databinding.FragmentSlideshowBinding;
import com.example.food_ordering_app.models.HomeHorModel;
import com.example.food_ordering_app.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements UpdateVerticalRec {

    RecyclerView homeHorizontalRec,homeVerticalRec;
    ArrayList<HomeHorModel> homeHorModelList;
    HomeHorAdapter homeHorAdapter;

    ArrayList<HomeVerModel> homeVerModelList;
    HomeVerAdapter homeVerAdapter;

    private FragmentHomeBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final ConstraintLayout textView = binding.textHome;


        homeHorizontalRec=root.findViewById(R.id.home_hor_rec);
        homeVerticalRec=root.findViewById(R.id.home_ver_rec);

        /////// Horizontal
        homeHorModelList=new ArrayList<>();

        homeHorModelList.add(new HomeHorModel(R.drawable.breakfast,"Breakfast"));
        homeHorModelList.add(new HomeHorModel(R.drawable.lunch,"Lunch"));
        homeHorModelList.add(new HomeHorModel(R.drawable.cury,"Curry"));
        homeHorModelList.add(new HomeHorModel(R.drawable.chinese,"Chinese"));
        homeHorModelList.add(new HomeHorModel(R.drawable.breads,"Breads"));

        homeHorAdapter=new HomeHorAdapter(homeHorModelList,getActivity(), this);
        homeHorizontalRec.setAdapter(homeHorAdapter);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);


        ///////////Vertical
        homeVerModelList = new ArrayList<>();

        /*homeVerModelList.add(new HomeVerModel(R.drawable.vanas,"Idli Sambar","Veg | Breakfast","$50"));
        homeVerModelList.add(new HomeVerModel(R.drawable.vanas,"Vada Sambar","Veg | Breakfast","$50"));
        homeVerModelList.add(new HomeVerModel(R.drawable.vanas,"Plain Dosa","Veg | Breakfast","$50"));
        homeVerModelList.add(new HomeVerModel(R.drawable.vanas,"Masala Dosa","Veg | Breakfast","$50"));
        homeVerModelList.add(new HomeVerModel(R.drawable.vanas,"Omelette","Non-Veg | Breakfast","$50"));
*/
        homeVerAdapter=new HomeVerAdapter(getActivity(),homeVerModelList);
        homeVerticalRec.setAdapter(homeVerAdapter);

        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        /*homeVerticalRec.setHasFixedSize(true);
        homeVerticalRec.setNestedScrollingEnabled(false);*/

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void callBack(int position, ArrayList<HomeVerModel> list) {
        homeVerAdapter=new HomeVerAdapter(getContext(),list);
        homeVerAdapter.notifyDataSetChanged();

        homeVerticalRec.setAdapter(homeVerAdapter);
    }
}