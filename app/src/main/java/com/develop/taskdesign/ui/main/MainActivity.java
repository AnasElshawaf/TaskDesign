package com.develop.taskdesign.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.develop.taskdesign.R;
import com.develop.taskdesign.adapter.TabAdapter;
import com.develop.taskdesign.ui.accepted.AcceptedFazaatyFragment;
import com.develop.taskdesign.ui.accepted.AcceptedOthersFragment;
import com.develop.taskdesign.ui.cancelled.CancelledFazaatyFragment;
import com.develop.taskdesign.ui.cancelled.CancelledOthersFragment;
import com.develop.taskdesign.ui.pending.PendingFazaatyFragment;
import com.develop.taskdesign.ui.pending.PendingOthersFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView tvOthers;
    private TextView tvFazaaty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        setUpTapFazaaty();

    }

    private void initViews() {
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        tvOthers = findViewById(R.id.tv_others);
        tvFazaaty = findViewById(R.id.tv_fazaaty);

        tvFazaaty.setOnClickListener(this);
        tvOthers.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_others:
                setUpTapOthers();
                break;

            case R.id.tv_fazaaty:
                setUpTapFazaaty();
                break;
        }
    }

    private void setUpTapFazaaty() {
        tvOthers.setBackground(MainActivity.this.getResources().getDrawable(R.drawable.bk_button_unselected));
        tvFazaaty.setBackground(MainActivity.this.getResources().getDrawable(R.drawable.bk_button));
        tvOthers.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        tvFazaaty.setTextColor(getResources().getColor(R.color.black));
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new CancelledFazaatyFragment(), "تم الالغاء");
        adapter.addFragment(new AcceptedFazaatyFragment(), "تم القبول");
        adapter.addFragment(new PendingFazaatyFragment(), "قيد الانتظار");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setUpTapOthers() {
        tvFazaaty.setBackground(MainActivity.this.getResources().getDrawable(R.drawable.bk_button_unselected));
        tvOthers.setBackground(MainActivity.this.getResources().getDrawable(R.drawable.bk_button));
        tvFazaaty.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        tvOthers.setTextColor(getResources().getColor(R.color.black));
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new CancelledOthersFragment(), "تم الالغاء");
        adapter.addFragment(new AcceptedOthersFragment(), "تم القبول");
        adapter.addFragment(new PendingOthersFragment(), "قيد الانتظار");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
