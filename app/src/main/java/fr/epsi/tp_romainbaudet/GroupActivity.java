package fr.epsi.tp_romainbaudet;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GroupActivity extends AppCompatActivity {

    private Button Etudiant1, Etudiant2, Etudiant3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        Etudiant1 = findViewById(R.id.buttonEtudiant1);
        Etudiant2 = findViewById(R.id.buttonEtudiant2);
        Etudiant3 = findViewById(R.id.buttonEtudiant3);

        Etudiant1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GroupActivity.this, StudentActivity.class);
                Bundle bundle1 = new Bundle();
                bundle1.putString("Nom", "Baudet");
                bundle1.putString("Prenom", "Romain");
                bundle1.putString("Email", "romain@outlook.Fr");
                bundle1.putString("Groupe", "Groupe 1 EPSI3");
                intent.putExtras(bundle1);
                startActivity(intent);
            }
        });

        Etudiant2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GroupActivity.this, StudentActivity.class);
                Bundle bundle1 = new Bundle();
                bundle1.putString("Nom", "AURIAT");
                bundle1.putString("Prenom", "Alex");
                bundle1.putString("Email", "alexandre@outlook.Fr");
                bundle1.putString("Groupe", "Groupe 1 EPSI3");
                intent.putExtras(bundle1);
                startActivity(intent);
            }
        });

        Etudiant3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GroupActivity.this, StudentActivity.class);
                Bundle bundle1 = new Bundle();
                bundle1.putString("Nom", "Zawada");
                bundle1.putString("Prenom", "Vianney");
                bundle1.putString("Email", "vianou@outlook.Fr");
                bundle1.putString("Groupe", "Groupe 1 EPSI3");
                intent.putExtras(bundle1);
                startActivity(intent);
            }
        });
    }
};