package fr.epsi.tp_romainbaudet;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EpsiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("tag", "############## onCreate ################# :" + getClass().getSimpleName());
    }

    @Override
    public void finish() {
        super.finish();
        Log.d("tag","############## finish ################# :"+getClass().getSimpleName());
    }
};
