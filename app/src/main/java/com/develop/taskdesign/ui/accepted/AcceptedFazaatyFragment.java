package com.develop.taskdesign.ui.accepted;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.develop.taskdesign.R;


public class AcceptedFazaatyFragment extends Fragment {

    public AcceptedFazaatyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_accepted_fazaaty, container, false);

        return view;
    }
}
