package com.example.eurotier.Pushers;

import com.example.eurotier.TierList.TierList;

public class ExcelPusher extends AbstractPusher{
    @Override
    public boolean push(TierList tierList) {
        return false;
    }

    @Override
    public String returnOnFailure() {
        return null;
    }
}
