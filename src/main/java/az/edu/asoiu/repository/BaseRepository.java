package az.edu.asoiu.repository;


import java.util.List;

/**
 * Created by Hp on 27.04.2017.
 */
public interface BaseRepository {

    List getDiseaseParamsWithLimit(Integer limit,String sort) throws Exception;

    List findAll(String key) throws Exception;
}
