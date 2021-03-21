package fr.epsi.tp_romainbaudet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class HomeActivity extends EpsiActivity {

    private Button Zone1, Zone2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Zone1 = findViewById(R.id.buttonZone1);
        Zone2 = findViewById(R.id.buttonZone2);

        Zone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, GroupActivity.class);
                startActivity(intent);
            }
        });

        Zone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });
    }
};
