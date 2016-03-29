package com.versable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class VotdController {
    @Autowired
    private VotdRepository mVotdRepository;
    private VerseRepository mVerseRepository;

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
        response.put("verses",verse);
        return response;
    }

    @RequestMapping(value = "/votd/",method = RequestMethod.POST)
    public Map<String, Object> createVotd(@RequestBody Map<String, Object> votdMap){
        Calendar now = Calendar.getInstance();
        now.clear(Calendar.HOUR);
        now.clear(Calendar.MINUTE);
        now.clear(Calendar.SECOND);
        now.clear(Calendar.MILLISECOND);
        Votd votd = new Votd(votdMap.get("verseID").toString(),votdMap.get("imageURL").toString(),now.getTimeInMillis());
        mVotdRepository.save(votd);
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("message", "VOTD created successfully");
        response.put("verse", votd);
        return response;
    }

}
