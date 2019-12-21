package com.twinai.eventsplatform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import com.twinai.eventsplatform.adapter.ItemAdapter;
import com.twinai.eventsplatform.databinding.MainActivityBinding;
import com.twinai.eventsplatform.network.NetworkModule;
import com.twinai.eventsplatform.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {


    public NavController navController;
    public NavHostFragment navHostFragment;
    MainActivityBinding binding;
    public NetworkModule networkModule;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.main_activity);
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        networkModule = new NetworkModule();
    }
}
