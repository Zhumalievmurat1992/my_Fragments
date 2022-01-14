package com.example.myapplicationfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class MainFragment extends Fragment {
    private EditText etTheme, etMassage;
    private Button btn_send;

    public final static String THEME = "theme";
    public final static String MASSAGE = "massage";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etTheme = view.findViewById(R.id.et_theme);
        etMassage = view.findViewById(R.id.et_massage);
        btn_send = view.findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) requireActivity();
                MainActivity.isMainFragment = false;
                Bundle bundle = new Bundle();
                Fragment fragment = new SecondFragment1();
                if (etTheme.getText()!=null){
                bundle.putString(THEME,etTheme.getText().toString());
                }
                if (etMassage.getText()!=null){
                    bundle.putString(MASSAGE,etMassage.getText().toString());
                }
                fragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();

            }
        });
    }
}