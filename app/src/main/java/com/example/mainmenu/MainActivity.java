package com.example.mainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mainmenu.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        menu.findItem(R.id.help_menu_item).setIntent(
                new Intent(this, Help.class));
        menu.findItem(R.id.settings_menu_item).setIntent(
                new Intent(this, Setting.class));
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setMainMenu();
        setlistenerListview();

    }

    public void setMainMenu(){
        String [] menuItem={getString(R.string.menu_item_play),getString(R.string.menu_item_scores),getString(R.string.menu_item_settings),getString(R.string.menu_item_help)};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.item_listview, menuItem);
        binding.listview.setAdapter(adapter);

    }
    public void setlistenerListview(){
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view;
                String strText = textView.getText().toString();
                if (strText.equalsIgnoreCase(getResources().getString(
                        R.string.menu_item_play))) {
                    startActivity(new Intent(MainActivity.this,
                            Game.class));
                } else if (strText.equalsIgnoreCase(getResources().getString(
                        R.string.menu_item_help))) {
                    startActivity(new Intent(MainActivity.this,
                            Help.class));
                } else if (strText.equalsIgnoreCase(getResources().getString(
                        R.string.menu_item_settings))) {
                    startActivity(new Intent(MainActivity.this,
                            Setting.class));
                } else if (strText.equalsIgnoreCase(getResources().getString(
                        R.string.menu_item_scores))) {
                    startActivity(new Intent(MainActivity.this,
                            Score.class));
                }
            }
        });
    }
}