package com.example.demo1;

import javafx.beans.property.*;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Main5 {
    public static void main(String[] args){
        IntegerProperty integerProperty = new SimpleIntegerProperty(5);
        IntegerProperty integerProperty1 = new ReadOnlyIntegerWrapper(5);

        IntegerBinding integerBinding = new IntegerBinding() {
            {
                super.bind(integerProperty, integerProperty1);
            }
            @Override
            protected int computeValue() {
                return integerProperty.get() + integerProperty1.get();
            }
        };
        System.out.println(integerBinding.get());
        integerProperty.set(1);
        System.out.println(integerBinding.get());
    }
}
class User {
    StringProperty stringProperty = new SimpleStringProperty("Max");
    public String getStringProperty() {
        return stringProperty.get();
    }
    public StringProperty stringPropertyProperty() {
        return stringProperty;
    }
    public void setStringProperty(String stringProperty) {
        this.stringProperty.set(stringProperty);
    }
}
