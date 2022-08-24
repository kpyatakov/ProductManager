package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)

public class Smartphone extends Product {
    private String maker;


    public Smartphone(int id, String name, int price, String maker) {
        super(id, name, price);
        this.maker = maker;
    }

    @Override
    public boolean matches(String search) {
        return super.matches(search) || maker.equals(search);
    }


}