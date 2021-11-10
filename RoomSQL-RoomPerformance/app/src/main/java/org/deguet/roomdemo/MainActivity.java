package org.deguet.roomdemo;

import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.deguet.roomdemo.dao.MaBD;
import org.deguet.roomdemo.modele.DemoAlbum;
import org.deguet.roomdemo.modele.DemoHeure;

import java.time.LocalTime;
import java.util.Date;
import java.text.SimpleDateFormat;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;


public class MainActivity extends AppCompatActivity {

    DemoHeure demoHeure = new DemoHeure();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaBD bd = Room.databaseBuilder(getApplicationContext(), MaBD.class, "Heure")
                .allowMainThreadQueries()
                .build();
        Toast.makeText(getApplicationContext(), "Premier lancement", Toast.LENGTH_SHORT).show();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onPause() {
        super.onPause();

        MaBD bd = Room.databaseBuilder(getApplicationContext(), MaBD.class, "Heure")
                .allowMainThreadQueries()
                .build();

        demoHeure.heure = LocalTime.now().toString();
        bd.dao().saveHeure(demoHeure);
    }

    @Override
    protected void onResume() {
        super.onResume();

        TextView heure1 = (TextView)findViewById(R.id.heure);
        heure1.setText(demoHeure.heure);
    }
}
