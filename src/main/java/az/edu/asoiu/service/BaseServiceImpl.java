package az.edu.asoiu.service;

import az.edu.asoiu.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Hp on 21.05.2017.
 */
@Service
public class BaseServiceImpl implements BaseService {

    private final BaseRepository baseRepository;

    @Autowired
    public BaseServiceImpl(BaseRepository baseRepository) {
        this.baseRepository = baseRepository;
    }



}
