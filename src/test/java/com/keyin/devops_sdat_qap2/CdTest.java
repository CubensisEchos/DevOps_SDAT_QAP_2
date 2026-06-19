package com.keyin.devops_sdat_qap2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CdTest
{
    Cd cd;

    @BeforeEach
    void setup()
    {
        cd = new Cd("The Black Album", "Metallica", "1. testing track listings", "Thrash metal", "Test label", "Test producer", LocalDate.of(1995, 2, 13));
    }

    @AfterEach
    void tearDown()
        {
        cd = null;
        }

    @Test
    void TestCdCreation()
    {
        Assertions.assertEquals("The Black Album", cd.getAlbumName());
        Assertions.assertEquals("Metallica", cd.getArtistName());
        Assertions.assertEquals("1. testing track listings", cd.getTrackListing());
        Assertions.assertEquals("Thrash metal", cd.getGenre());
        Assertions.assertEquals("Test label", cd.getLabel());
        Assertions.assertEquals("Test producer", cd.getProducerName());
        Assertions.assertEquals(LocalDate.of(1995, 2, 13), cd.getReleaseDate());
    }

    @Test
    void TestCdSetter()
    {
        cd.setGenre("Test genre");
        cd.setLabel("Tested label");

        Assertions.assertEquals("Test genre", cd.getGenre());
        Assertions.assertEquals("Tested label", cd.getLabel());
    }
}
