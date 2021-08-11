package dev.bahodir.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.bahodir.myapplication.adapter.RV1;
import dev.bahodir.myapplication.adapter.RV2;
import dev.bahodir.myapplication.adapter.VP;
import dev.bahodir.myapplication.databinding.FragmentMainWindowBinding;
import dev.bahodir.myapplication.user.Rv1User;
import dev.bahodir.myapplication.user.Rv2User;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainWindowFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainWindowFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainWindowFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainWindowFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainWindowFragment newInstance(String param1, String param2) {
        MainWindowFragment fragment = new MainWindowFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    private FragmentMainWindowBinding binding;

    private List<Rv1User> rv1UserList;
    private RV1 rv1;

    private Handler handler;
    private List<Integer> vpList;
    private VP vp;

    private List<Rv2User> rv2UserList;
    private RV2 rv2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMainWindowBinding.inflate(inflater, container, false);


        rv1List();
        rv1 = new RV1(rv1UserList);
        binding.rv1.setAdapter(rv1);


        vpLists();
        vp = new VP(vpList);
        binding.vp2.setAdapter(vp);
        handler = new Handler();
        handler.postDelayed(runnable, 1000);

        rv2List();
        rv2 = new RV2(rv2UserList);
        binding.rv2.setAdapter(rv2);

        return binding.getRoot();
    }

    private void rv2List() {
        rv2UserList = new ArrayList<>();
        rv2UserList.add(new Rv2User(R.drawable.samsungg,"$1500","$2000","Samsung Galaxy s21 Ultra"));
        rv2UserList.add(new Rv2User(R.drawable.mi10pro,"$1200","$1300","Xiaomi Mi 11 Pro"));
        rv2UserList.add(new Rv2User(R.drawable.samsungnote,"$1800","$2400","Samsung Note 20 Ultra"));
        rv2UserList.add(new Rv2User(R.drawable.huaweimate20pro,"$1000","$1200","Huawei Mate 20 Pro"));
        rv2UserList.add(new Rv2User(R.drawable.realmenarzo20,"$290","$500","Realme Narzo 20"));
        rv2UserList.add(new Rv2User(R.drawable.vivov15pro,"$180","$280","Vivo 15 Pro"));
    }

    private void vpLists() {
        vpList = new ArrayList<>();
        vpList.add(R.drawable.iphone);
        vpList.add(R.drawable.samsung);
        vpList.add(R.drawable.mi);
        vpList.add(R.drawable.huawei);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (binding.vp2.getCurrentItem() == vpList.size() - 1){
                binding.vp2.setCurrentItem(0);
            }
            else {
                binding.vp2.setCurrentItem(binding.vp2.getCurrentItem() + 1);
            }
            handler.postDelayed(this, 2000);
        }
    };

    private void rv1List() {
        rv1UserList = new ArrayList<>();
        rv1UserList.add(new Rv1User(R.drawable.smartphone, "Phones"));
        rv1UserList.add(new Rv1User(R.drawable.monitor, "Computer"));
        rv1UserList.add(new Rv1User(R.drawable.heart, "Health"));
        rv1UserList.add(new Rv1User(R.drawable.book, "Books"));
        rv1UserList.add(new Rv1User(R.drawable.shopping_cart, "Shopping"));
        rv1UserList.add(new Rv1User(R.drawable.news, "News"));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}