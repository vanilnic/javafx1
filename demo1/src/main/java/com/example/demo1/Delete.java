package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Delete {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        ObservableList<String> observableList = FXCollections.observableList(list);
        observableList.addListener(new ListChangeListener<String>() {
            @Override
            public void onChanged(Change<? extends String> c) {
                System.out.println("List was changed");
            }
        });

        observableList.add("one");
        list.add("two");
        System.out.println(list.size());
        System.out.println(observableList.size());
    }
}
