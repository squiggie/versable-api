package com.versable;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface VerseRepository extends MongoRepository<Verse, String> {

    @Override
    Verse findOne(String s);
}

