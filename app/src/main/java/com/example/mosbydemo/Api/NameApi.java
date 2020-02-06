package com.example.mosbydemo.Api;

import com.example.mosbydemo.Model.Name;

import java.util.ArrayList;
import java.util.List;

public class NameApi {
    public static List<Name> getNames() {
        ArrayList<Name> names = new ArrayList<>();
        names.add(new Name("Aman","Singh"));
        names.add(new Name("Shubham","Goyal"));
        names.add(new Name("Anu","Jain"));
        names.add(new Name("Arya","Sinha"));
        names.add(new Name("Madan","Mohan"));
        names.add(new Name("Swati","Suman"));
        names.add(new Name("Shruti","Suman"));
        names.add(new Name("Swati","Agrawal"));

        return names;
    }


}