package com.versable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class VerseController {
    @Autowired
    private VerseRepository mVerseRepository;

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
}
