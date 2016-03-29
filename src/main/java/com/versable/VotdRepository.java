package com.versable;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface VotdRepository extends MongoRepository<Votd, String> {

    @Override
    Votd findOne(String s);
}

