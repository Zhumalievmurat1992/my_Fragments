package com.example.myapplicationfragment;

import static com.example.myapplicationfragment.MainFragment.MASSAGE;
import static com.example.myapplicationfragment.MainFragment.THEME;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class SecondFragment1 extends Fragment {
    private EditText etTheme1, etMassage1;
    private Button btn_send1;

    public final static String THEME = "theme";
    public final static String MASSAGE = "massage";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        etTheme1 = view.findViewById(R.id.et_theme1);
        etMassage1 = view.findViewById(R.id.et_massage1);
        btn_send1 = view.findViewById(R.id.btn_send1);
        super.onViewCreated(view, savedInstanceState);
        btn_send1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) requireActivity();
                MainActivity.isMainFragment = false;
                Bundle bundle = new Bundle();
                Fragment fragment = new SecondFragment2();
                if (etTheme1.getText()!=null){
                    bundle.putString(THEME,etTheme1.getText().toString());
                }
                if (etMassage1.getText()!=null){
                    bundle.putString(MASSAGE,etMassage1.getText().toString());
                }
                fragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();

            }
        });
        Bundle bundle = getArguments();
        if (bundle != null) {
            String theme = bundle.getString(THEME);
            etTheme1.setText(theme);
        }
        if (bundle != null) {
            String theme = bundle.getString(MASSAGE);
            etMassage1.setText(theme);
        }

    }
}