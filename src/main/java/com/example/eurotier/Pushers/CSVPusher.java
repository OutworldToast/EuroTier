package com.example.eurotier.Pushers;

import com.example.eurotier.TierList.Row;
import com.example.eurotier.TierList.TierList;

public class CSVPusher extends AbstractPusher{

    @Override
    Object locate(String label) {
        return null;
    }

    @Override
    boolean write(Object location, Row row) {
        return false;
    }

}
