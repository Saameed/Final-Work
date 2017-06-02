package az.edu.asoiu.entity;

import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Hp on 27.05.2017.
 */
public class Test {


    public static void main(String[] args) {
        String key = " salam    semed    necesen    ";
        String searchParam = key.trim();
        String[] searchArray = null;
        searchArray = searchParam.split(" ");
        List<String> list = new ArrayList<String>(Arrays.asList(searchArray));
        list.removeAll(Arrays.asList(" ",""));

        System.out.println(list);
    }
}
