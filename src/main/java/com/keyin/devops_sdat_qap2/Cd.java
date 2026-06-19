package com.keyin.devops_sdat_qap2;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Cd
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String albumName;
    private String artistName;

    @Column(columnDefinition = "TEXT")
    private String trackListing;
    private String genre;

    private String Label;
    private String producerName;
    private LocalDate ReleaseDate;

    public Cd()
    {

    }

    public Cd(String albumName, String artistName, String trackListing, String genre, String label, String producerName, LocalDate ReleaseDate)
    {
        this.albumName = albumName;
        this.artistName = artistName;
        this.trackListing = trackListing;
        this.genre = genre;
        this.Label = label;
        this.producerName = producerName;
        this.ReleaseDate = ReleaseDate;
    }

    public Long getId()
    {
        return id;
    }

    public String getAlbumName()
    {
        return albumName;
    }

    public void setAlbumName(String albumName)
    {
        this.albumName = albumName;
    }

    public String getArtistName()
    {
        return artistName;
    }

    public void setArtistName(String artistName)
    {
        this.artistName = artistName;
    }

    public String getTrackListing()
    {
        return trackListing;
    }

    public void setTrackListing(String trackListing)
    {
        this.trackListing = trackListing;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public String getLabel()
    {
        return Label;
    }

    public void setLabel(String label)
    {
        Label = label;
    }

    public String getProducerName()
    {
        return producerName;
    }

    public void setProducerName(String producerName)
    {
        this.producerName = producerName;
    }

    public LocalDate getReleaseDate()
    {
        return ReleaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate)
    {
        ReleaseDate = releaseDate;
    }
}
