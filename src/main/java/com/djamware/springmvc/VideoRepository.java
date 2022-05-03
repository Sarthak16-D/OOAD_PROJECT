package com.djamware.springmvc;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

import com.djamware.springmvc.model.Videos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends MongoRepository<Videos, BigInteger> {

    Videos findByVTitle(final String VTitle);

}