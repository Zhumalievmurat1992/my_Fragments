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


public class SecondFragment2 extends Fragment {
    private EditText etTheme2, etMassage2;
    private Button btn_send2;

    public final static String THEME = "theme";
    public final static String MASSAGE = "massage";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        etTheme2 = view.findViewById(R.id.et_theme2);
        etMassage2 = view.findViewById(R.id.et_massage2);
        btn_send2 = view.findViewById(R.id.btn_send2);
        super.onViewCreated(view, savedInstanceState);
        btn_send2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) requireActivity();
                MainActivity.isMainFragment = false;
                Bundle bundle = new Bundle();

                SecondFragment2 fragment = new SecondFragment2();

                if (etTheme2.getText()!=null){
                    bundle.putString(THEME,etTheme2.getText().toString());
                }
                if (etMassage2.getText()!=null){
                    bundle.putString(MASSAGE,etMassage2.getText().toString());
                }
                fragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();

            }
        });
        Bundle bundle = getArguments();
        if (bundle != null) {
            String theme = bundle.getString(THEME);
            etTheme2.setText(theme);
        }
        if (bundle != null) {
            String theme = bundle.getString(MASSAGE);
            etMassage2.setText(theme);
        }
    }
}