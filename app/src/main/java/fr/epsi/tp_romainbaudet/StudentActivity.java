package fr.epsi.tp_romainbaudet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class StudentActivity extends AppCompatActivity {

    private TextView NomPrenom, Email, Groupe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            getSupportActionBar().setTitle(bundle.getString("Nom") + " " + bundle.getString("Prenom") );
        }
        setContentView(R.layout.activity_student);
        NomPrenom = findViewById(R.id.NomPrenom);
        Email = findViewById(R.id.Email);
        Groupe = findViewById(R.id.Groupe);

        NomPrenom.setText(bundle.getString("Nom") + " " + bundle.getString("Prenom"));
        Email.setText(bundle.getString("Email"));
        Groupe.setText(bundle.getString("Groupe"));
    }
}