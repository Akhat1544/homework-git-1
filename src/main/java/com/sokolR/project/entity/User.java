package com.sokolR.project.entity;


import java.util.List;

public record User(long id,
                   String name,
                   String email,
                   Cart cart,
                   List<String> bucket) {

}
