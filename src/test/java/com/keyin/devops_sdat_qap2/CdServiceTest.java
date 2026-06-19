package com.keyin.devops_sdat_qap2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CdServiceTest
{
    @Mock
    private CdRepository cdRepository;

    @InjectMocks
    private CdService cdService;

    Cd cd;
    Cd cd2;
    Cd cd3;
    Cd cd4;
    Cd cd5;
    Cd cd6;

    List<Cd> cdList;

    @BeforeEach
    void setUp()
    {
        cd = new Cd("Test album 1", "test artist name", "Test track listing", "Test genre", "Test label", "Test producer", LocalDate.of(2012, 10, 30));
        cd2 = new Cd("Test album 2", "test artist name", "Test track listing", "Test genre", "Test label", "Test producer", LocalDate.of(2012, 10, 30));
        cd3 = new Cd("Test album 3", "test artist name", "Test track listing", "Test genre", "Test label", "Test producer", LocalDate.of(2012, 10, 30));
        cd4 = new Cd("Test album 4", "test artist name", "Test track listing", "Test genre", "Test label", "Test producer", LocalDate.of(2012, 10, 30));
        cd5 = new Cd("Test album 5", "test artist name", "Test track listing", "Test genre", "Test label", "Test producer", LocalDate.of(2012, 10, 30));
        cd6 = new Cd("Test album 6", "test artist name", "Test track listing", "Test genre", "Test label", "Test producer", LocalDate.of(2012, 10, 30));

        cdList = List.of(cd, cd2, cd3, cd4, cd5, cd6);
    }

    @AfterEach
    void tearDown()
        {
            cd = null;
            cd2 = null;
            cd3 = null;
            cd4 = null;
            cd5 = null;
            cd6 = null;
        }

    @Test
    public void returnFullCdList()
    {
        Mockito.when(cdRepository.findAll()).thenReturn(cdList);

        Iterable<Cd> expected = cdService.getAllCds();

        Assertions.assertEquals(cdList, expected);
    }

    @Test
    public void getCdById()
    {
        Mockito.when(cdRepository.findById(1L)).thenReturn(java.util.Optional.of(cd));

        Cd expected = cdService.getCdById(1L);

        Assertions.assertEquals(cd, expected);
    }

    @Test
    public void saveNewCd_returnSavedCd()
    {
        Mockito.when(cdRepository.save(cd)).thenReturn(cd);

        Cd expected = cdService.saveCd(cd);

        Assertions.assertEquals(cd, expected);
    }

    @Test
    public void updateCd_returnUpdatedCd()
    {
        Cd updatedCd = new Cd("Test updated album", "test updated artist name", "Test updated track listing", "Test genre", "Test label", "Test producer", LocalDate.of(2012, 10, 30));

        Mockito.when(cdRepository.findById(1L)).thenReturn(java.util.Optional.of(cd));

        Mockito.when(cdRepository.save(Mockito.any(Cd.class))).thenReturn(updatedCd);

        Cd expected = cdService.updateCd(1L, updatedCd);

        Assertions.assertEquals("Test updated album", expected.getAlbumName());
    }

    @Test
    public void UpdateCd_CdNotFound()
    {
        Cd updatedCd = new Cd("Test updated album", "test updated artist name", "Test updated track listing", "Test genre", "Test label", "Test producer", LocalDate.of(2012, 10, 30));

        Mockito.when(cdRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        Cd expected = cdService.updateCd(1L, updatedCd);

        Assertions.assertNull(expected);
    }

    @Test
    public void deleteCdById()
    {
        Mockito.doNothing()
                .when(cdRepository)
                .deleteById(1L);

        cdService.deleteCdById(1L);

        Mockito.verify(cdRepository).deleteById(1L);
    }

    @Test
    public void seedCd()
    {
        Mockito.when(cdRepository.saveAll(Mockito.anyList())).thenReturn(cdList);

        List<Cd> expected = cdService.seedCds();

        Assertions.assertEquals(cdList, expected);
    }


}
