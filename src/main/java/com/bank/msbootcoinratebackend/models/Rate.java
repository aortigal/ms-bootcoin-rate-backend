package com.bank.msbootcoinratebackend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rate implements Serializable {

    private static final long serialVersionUID = 1L;

    private String currency;
    private String date;
    private String buy;
    private String sell;

}