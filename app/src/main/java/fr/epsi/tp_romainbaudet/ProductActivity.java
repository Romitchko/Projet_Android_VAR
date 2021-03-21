package fr.epsi.tp_romainbaudet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Explode;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProductActivity extends AppCompatActivity {
    private TextView Description;
    private ImageView Picture_url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setEnterTransition(new Explode());
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            getSupportActionBar().setTitle(bundle.getString("name"));
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_product);

        Description = findViewById(R.id.Description);
        Picture_url = findViewById(R.id.Picture_url);


        Description.setText(bundle.getString("Description"));
        Picasso.get().load(bundle.getString("Picture_url")).fit().centerCrop().into(Picture_url);
    }
}