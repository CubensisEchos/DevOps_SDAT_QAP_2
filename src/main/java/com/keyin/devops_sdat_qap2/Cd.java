package com.keyin.devops_sdat_qap2;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Cd
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String albumName;
    private String artistName;
    private String trackListing;
    private String producerName;
    private LocalDateTime ReleaseDate;

    public Cd()
    {

    }

    public Cd(String albumName, String artistName, String trackListing, String producerName, LocalDateTime ReleaseDate)
    {
        this.albumName = albumName;
        this.artistName = artistName;
        this.trackListing = trackListing;
        this.producerName = producerName;
        this.ReleaseDate = ReleaseDate;
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

    public String getProducerName()
    {
        return producerName;
    }

    public void setProducerName(String producerName)
    {
        this.producerName = producerName;
    }

    public LocalDateTime getReleaseDate()
    {
        return ReleaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate)
    {
        ReleaseDate = releaseDate;
    }
}
