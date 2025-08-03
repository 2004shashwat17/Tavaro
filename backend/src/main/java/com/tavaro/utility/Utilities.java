package com.tavaro.utility;

import com.tavaro.exception.JobPortalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.tavaro.entity.Sequence; // ✅ your custom class



public class Utilities {

    public static MongoOperations mongoOperations;

    @Autowired
    public void setMongoOperations(MongoOperations mongoOperation){
        Utilities.mongoOperations=mongoOperation;
    }

    public static Long getNextSequence(String key) throws JobPortalException {
        Query query = new Query(Criteria.where("_id").is(key));
        Update update = new Update();
        update.inc("seq", 1);
        FindAndModifyOptions options = new FindAndModifyOptions();
        options.returnNew(true);
        Sequence seq = mongoOperations.findAndModify(query, update, options, Sequence.class);
        if(seq==null)throw new JobPortalException("Unable to get sequence id for key :" + key);
        return seq.getSeq();
    }
}
