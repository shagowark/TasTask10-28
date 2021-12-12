package LogicModule;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LogicTest {

    @org.junit.jupiter.api.Test
    void filterAparts1() {
        ArrayList<Apartment> apartsList = new ArrayList<>();

        Apartment apart1 = new Apartment("1asd", 3, 12, 4, 50);
        apartsList.add(apart1);
        Apartment apart2 = new Apartment("1a12d", 3, 20, 6, 70);
        apartsList.add(apart2);
        Apartment apart3 = new Apartment("1assdad", 1, 11, 2, 30);
        apartsList.add(apart3);
        Apartment apart4 = new Apartment("1asda1sd", 2, 15, 5, 40);
        apartsList.add(apart4);

        AdvertFilter filter = new AdvertFilter(2, -1, -1,
                -1, 3, -1, -1, 40);

        ArrayList<Apartment> goodAparts = new ArrayList<>();
        goodAparts.add(apart4);
        assertIterableEquals(goodAparts, Logic.filterAparts(apartsList, filter));
    }

    @org.junit.jupiter.api.Test
    void filterAparts2() {
        ArrayList<Apartment> apartsList = new ArrayList<>();

        Apartment apart1 = new Apartment("1312asd", 1, 12, 4, 50);
        apartsList.add(apart1);
        Apartment apart2 = new Apartment("das1asd", 2, 20, 6, 60);
        apartsList.add(apart2);
        Apartment apart3 = new Apartment("1dasdasd", 1, 10, 2, 25);
        apartsList.add(apart3);
        Apartment apart4 = new Apartment("1asddsadasd", 3, 45, 10, 80);
        apartsList.add(apart4);

        AdvertFilter filter = new AdvertFilter(-1, -1, 12,
                -1, 5, -1, -1, -1);

        ArrayList<Apartment> goodAparts = new ArrayList<>();
        goodAparts.add(apart2);
        goodAparts.add(apart4);
        assertIterableEquals(goodAparts, Logic.filterAparts(apartsList, filter));
    }

    @org.junit.jupiter.api.Test
    void filterAparts3() {
        ArrayList<Apartment> apartsList = new ArrayList<>();

        Apartment apart1 = new Apartment("1312asd", 1, 12, 4, 50);
        apartsList.add(apart1);
        Apartment apart2 = new Apartment("das1asd", 2, 20, 6, 60);
        apartsList.add(apart2);
        Apartment apart3 = new Apartment("1dasdasd", 1, 10, 2, 25);
        apartsList.add(apart3);
        Apartment apart4 = new Apartment("1asddsadasd", 3, 45, 10, 80);
        apartsList.add(apart4);

        AdvertFilter filter = new AdvertFilter(-1, -1, 12,
                -1, 11, -1, -1, -1);

        ArrayList<Apartment> goodAparts = new ArrayList<>();
        assertIterableEquals(goodAparts, Logic.filterAparts(apartsList, filter));
    }

    @org.junit.jupiter.api.Test
    void filterAparts4() {
        ArrayList<Apartment> apartsList = new ArrayList<>();

        Apartment apart1 = new Apartment("1312asd", 1, 12, 4, 50);
        apartsList.add(apart1);
        Apartment apart2 = new Apartment("das1asd", 2, 20, 6, 60);
        apartsList.add(apart2);
        Apartment apart3 = new Apartment("1dasdasd", 1, 10, 2, 25);
        apartsList.add(apart3);
        Apartment apart4 = new Apartment("1asddsadasd", 3, 45, 10, 80);
        apartsList.add(apart4);

        AdvertFilter filter = new AdvertFilter(-1, -1, -1,
                -1, -1, -1, -1, -1);

        ArrayList<Apartment> goodAparts = new ArrayList<>();
        goodAparts.add(apart1);
        goodAparts.add(apart2);
        goodAparts.add(apart3);
        goodAparts.add(apart4);
        assertIterableEquals(goodAparts, Logic.filterAparts(apartsList, filter));
    }
}