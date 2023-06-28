package com.example.eurotier.Pushers;

import com.example.eurotier.TierList.Row;

public class MockPusher extends AbstractPusher{
    @Override
    Object locate(String label) {
        System.out.println(label);
        return null;
    }

    @Override
    boolean write(Object location, Row row) {
        System.out.printf("%s: ", row.getLabel());
        for (String country: row.getCountries()) {
            System.out.printf("%s ", country);
        }
        System.out.println();
        return true;
    }
}
