package com.versable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class VerseController {
    @Autowired
    private VerseRepository mVerseRepository;
    private VotdRepository mVotdRepository;

    @RequestMapping(value = "/verses/",method = RequestMethod.POST)
    public Map<String, Object> createVerse(@RequestBody Map<String, Object> verseMap){
        Verse verse = new Verse(verseMap.get("book").toString(),
                Integer.parseInt(verseMap.get("chapter").toString()),
                Integer.parseInt(verseMap.get("verseNum").toString()),
                verseMap.get("verse").toString(),
                verseMap.get("translation").toString(),
                verseMap.get("tags").toString()
                );
        mVerseRepository.save(verse);
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("message", "Verse created successfully");
        response.put("verse", verse);
        return response;
    }

    @RequestMapping(value = "/verses/", method = RequestMethod.GET)
    public Map<String, Object> getVerse(){
        List<Verse> verses = mVerseRepository.findAll();
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("verses",verses);
        return response;
    }

    @RequestMapping(value = "/verses/{id}", method = RequestMethod.GET)
    public Map<String, Object> getVerseById(@PathVariable String id){
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        if (id.contains("random")){
            List<Verse> verses = mVerseRepository.findAll();
            response.put("verses",verses.get(ThreadLocalRandom.current().nextInt(0,verses.size() + 1)));
        } else {
            Verse verse = mVerseRepository.findOne(id);
            response.put("verses",verse);
        }
        return response;
    }

    @RequestMapping(value = "/votd/", method = RequestMethod.GET)
    public Map<String, Object> getVOTD(){
        Calendar now = Calendar.getInstance();
        now.clear(Calendar.HOUR);
        now.clear(Calendar.MINUTE);
        now.clear(Calendar.SECOND);
        now.clear(Calendar.MILLISECOND);
        Votd votd = mVotdRepository.findOne("{\"date\":\"" + now.getTimeInMillis() + "\"}");
        Verse verse = mVerseRepository.findOne("{\"_id\":\"" + votd.getVerseID() + "\"}");
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("verse",verse);
        return response;
    }

    @RequestMapping(value = "/votd/",method = RequestMethod.POST)
    public Map<String, Object> createVotd(@RequestBody Map<String, Object> votdMap){
        Votd votd = new Votd(votdMap.get("verseID").toString(),votdMap.get("imageURL").toString(),Long.valueOf(votdMap.get("date").toString()));
        mVotdRepository.save(votd);
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("message", "Votd created successfully");
        response.put("verse", votd);
        return response;
    }
}
