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


public class SecondFragment3 extends Fragment {
    private EditText etTheme3, etMassage3;
    private Button btn_send3;
    public final static String THEME = "theme";
    public final static String MASSAGE = "massage";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second3, container, false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        etTheme3 = view.findViewById(R.id.et_theme3);
        etMassage3 = view.findViewById(R.id.et_massage3);
        btn_send3 = view.findViewById(R.id.btn_send3);
        super.onViewCreated(view, savedInstanceState);
        btn_send3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) requireActivity();
                MainActivity.isMainFragment = false;
                Bundle bundle = new Bundle();

                SecondFragment3 fragment = new SecondFragment3();

                if (etTheme3.getText()!=null){
                    bundle.putString(THEME,etTheme3.getText().toString());
                }
                if (etMassage3.getText()!=null){
                    bundle.putString(MASSAGE,etMassage3.getText().toString());
                }
                fragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();

            }
        });
        Bundle bundle = getArguments();
        if (bundle != null) {
            String theme = bundle.getString(THEME);
            etTheme3.setText(theme);
        }
        if (bundle != null) {
            String theme = bundle.getString(MASSAGE);
            etMassage3.setText(theme);
        }
    }
}