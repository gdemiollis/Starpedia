package fr.and1droid.starpedia.service;

import com.swapi.model.People;

import java.util.ArrayList;
import java.util.List;

public class PeopleServiceImpl implements PeopleService {

    @Override
    public void execute(RequestCallback<List<People>> requestCallback) {
        List<People> result = new ArrayList<>();
        result.add(buildPeople(1));
        result.add(buildPeople(2));
        result.add(buildPeople(3));
        result.add(buildPeople(4));
        requestCallback.onSuccess(result);
    }

    private People buildPeople(int i) {
        People people = new People();
        people.name = "People " + i;
        people.birthYear = "198" + i;
        people.eyeColor = i % 2 == 0 ? "Blue" : "Dark";
        people.hairColor = i % 2 == 0 ? "Blond" : "Brown";
        people.gender = i % 2 == 0 ? "Male" : "Female";
        people.height = "18" + i;
        return people;
    }
}
