package com.keyin.devops_sdat_qap2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class CdService
{
    @Autowired
    CdRepository cdRepository;

    public Cd saveCd(Cd cd)
    {
        return cdRepository.save(cd);
    }

    public List<Cd> getAllCds()
    {
        return cdRepository.findAll();
    }

    public Cd getCdById(Long id)
    {
        return cdRepository.findById(id).get();
    }

    public void deleteCdById(Long id)
    {
        cdRepository.deleteById(id);
    }

    public List<Cd> seedCds()
    {
        List<Cd> cds = List.of(
                new Cd("Slaughter of the Soul", "At The Gates", "1.Blinded by Fear, 2.Slaughter of the Soul, 3.Cold, 4.Under a Serpent Sun, 5.Into the Dea Sky, 6.Suicide Nation, 7.World of Lies, 8.Unto Others, 9.Nausea, 10.Need, 11.The Flames of the End", "Melodic death metal", "Earache", "Fredrik Nordström", LocalDate.of(1995, 11, 14)),
                new Cd("South of Heaven", "Slayer", "1.South of Heaven, 2.Silent Scream, 3.Live Undead, 4. Behind the Crooked Cross, 5.Mandatory Suicide, 6.Ghosts of War, 7.Read Between the Lies, 8. Cleanse the Soul, 9.Dissident Aggressor, 10.Spill the Blood", "Thrash metal", "Def Jam", "Rick Ruben", LocalDate.of(1988, 7, 5)),
                new Cd("British Steel", "Judas Priest", "1.Rapid Fire, 2.Metal Gods, 3.Breaking the Law, 4.Grinder, 5.United, 6.You Don't Have to Be Old to Be Wise, 7.Living After Midnight, 8.The Rage, 9.Steeler", "Heavy metal", "Columbia", "Tom Allom", LocalDate.of(1980, 4,11)),
                new Cd("Symbolic", "Death", "1.Symbolic, 2.Zero Tolerance, 3.Empty Words, 4.Scared Serenity, 5.1,000 Eyes, 6.Without Judgement, 7.Crystal Mountain, 8.Misanthrope, 9.Perennial Quest", "Death metal", "Roadrunner", "Jim Morris", LocalDate.of(1995, 3, 21)),
                new Cd("Bad Magic", "Motörhead", "1. Victory or Die, 2.Thunder & Lightning, 3.Fire Storm Hotel, 4.Shoot Out All of Your Lights, 5.The Devil, 6.Electricity, 7.Evil Eye, 8.Teach Them How to Bleed, 9.Till the End, 10.Tell Me Who to Kill, 11.Choking on Yoour Screams, 12.When the Sky Comes Looking for You, 13.Sympathy for the Devil", "Hard rock", "UDR","Cameron Webb", LocalDate.of(2015, 8,28)),
                new Cd("Vulgar Display of Power", "Pantera", "1.Mouth for War, 2.A New Level, 3.Walk, 4.Fucking Hostile, 5.This Love, 6.Rise, 7.No Good, 8.Live in a Hole, 9.Regular People, 10.By Demons Be Driven, 11.Hollow", "Groove metal", "Atco", "Terry Date/Vinnie Paul", LocalDate.of(1992, 2,24)),
                new Cd("Rust in Peace", "Megadeth", "1.Holy Wars... The Punishment Due, 2.Hanger 18, 3.Take No Prisoners, 4.Five Magics, 5.Poison Was the Cure, 6.Lucretia, 7.Tornado of Souls, 8.Dawn Patrol, 9.Rust in Peace... Polaris", "Thrash metal", "Capitol Records", "Dave Mustaine/Mike Clink", LocalDate.of(1990, 9, 24)),
                new Cd("Powerslave", "Iron Maiden", "1.Aces High, 2.2 Minutes to Midnight, 3.Losfer Words, 4.Flash of the Blade, 5.The Duellists, 6.Back in the Village, 7.Powerslave, 8.Rime of the Ancient Mariner", "Heavy metal", "Capitol Records", "Martin Birch", LocalDate.of(1984, 8, 6))
        );
        return cdRepository.saveAll(cds);
    }
}
