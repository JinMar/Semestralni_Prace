package tul.ppj.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tul.ppj.entities.Autor;

/**
 * Created by Marek on 28.05.2016.
 */
@Repository
public interface repo extends MongoRepository<Autor
        , String> {
}