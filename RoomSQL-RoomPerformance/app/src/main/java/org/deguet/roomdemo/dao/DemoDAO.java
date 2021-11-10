package org.deguet.roomdemo.dao;

import org.deguet.roomdemo.modele.DemoAlbum;
import org.deguet.roomdemo.modele.DemoHeure;
import org.deguet.roomdemo.modele.DemoPiste;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

@Dao
public abstract class DemoDAO {

    @Insert
    public abstract Long creerAlbum(DemoAlbum album);

    @Insert
    public abstract List<Long> creerAlbums(List<DemoAlbum> albums);

    @Insert
    public abstract Long creerPiste(DemoPiste piste);

    @Insert
    public abstract Long saveHeure(DemoHeure heure);


    @Query("SELECT * FROM DemoHeure")
    public abstract List<DemoHeure> lesHeures();

    @Query("SELECT * FROM DemoAlbum")
    public abstract List<DemoAlbum> tousLesAlbums();

    @Query("SELECT * FROM DemoAlbum WHERE artiste = :art")
    public abstract List<DemoAlbum> parArtiste(String art);

    @Transaction
    public Long creerAlbumPistes(DemoAlbum a, List<DemoPiste> ps){
        Long id = this.creerAlbum(a);
        for (DemoPiste p : ps){
            p.albumId = id;
            this.creerPiste(p);
        }
        return id;
    }

}
