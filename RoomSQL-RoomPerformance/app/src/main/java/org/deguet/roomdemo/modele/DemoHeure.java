package org.deguet.roomdemo.modele;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalTime;


@Entity
public class DemoHeure {
    @PrimaryKey (autoGenerate = true)
    public Long id;

    @ColumnInfo
    public String heure;
}
