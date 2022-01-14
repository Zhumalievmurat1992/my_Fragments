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

import com.google.android.material.imageview.ShapeableImageView;


public class SecondFragment4 extends Fragment {

    private EditText etTheme4, etMassage4;
    private Button btn_send4;

    public final static String THEME = "theme";
    public final static String MASSAGE = "massage";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second4, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        etTheme4 = view.findViewById(R.id.et_theme4);
        etMassage4 = view.findViewById(R.id.et_massage4);
        btn_send4 = view.findViewById(R.id.btn_send4);
        super.onViewCreated(view, savedInstanceState);
        btn_send4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) requireActivity();
                MainActivity.isMainFragment = false;
                Bundle bundle = new Bundle();

                SecondFragment4 fragment = new SecondFragment4();

                if (etTheme4.getText() != null) {
                    bundle.putString(THEME, etTheme4.getText().toString());
                }
                if (etMassage4.getText() != null) {
                    bundle.putString(MASSAGE, etMassage4.getText().toString());
                }
                fragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

            }
        });
        Bundle bundle = getArguments();
        if (bundle != null) {
            String theme = bundle.getString(THEME);
            etTheme4.setText(theme);
        }
        if (bundle != null) {
            String theme = bundle.getString(MASSAGE);
            etMassage4.setText(theme);
        }

    }
}