package jpabook.jpashop.domain;

import jdk.jfr.Enabled;
import lombok.Getter;

@Enabled
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;
}
