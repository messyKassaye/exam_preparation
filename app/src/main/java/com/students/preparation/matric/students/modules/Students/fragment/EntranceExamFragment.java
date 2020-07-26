package com.students.preparation.matric.students.modules.Students.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.students.preparation.matric.students.R;
import com.students.preparation.matric.students.adapter.TabViewPageAdapter;


public class EntranceExamFragment extends Fragment {



    //tab layout
    private TabLayout tabLayout;
    LinearLayout naturalLayout,socialLayout;

    public EntranceExamFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view= inflater.inflate(R.layout.fragment_entrance_exam2, container, false);

        tabLayout = view.findViewById(R.id.subjectTab);
        tabLayout.addTab(tabLayout.newTab().setText("Natural"),true);
        tabLayout.addTab(tabLayout.newTab().setText("Social"));

        naturalLayout = view.findViewById(R.id.naturalTab);
        socialLayout = view.findViewById(R.id.socialTab);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition()==0){
                    socialLayout.setVisibility(View.GONE);
                    naturalLayout.setVisibility(View.VISIBLE);
                    setExamType();
                }else {
                    naturalLayout.setVisibility(View.GONE);
                    socialLayout.setVisibility(View.VISIBLE);
                    setExamType();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

    public void setExamType(){
        SharedPreferences preferences = getActivity().getSharedPreferences("Images",0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("examType","Exam");
        editor.commit();
    }
}
