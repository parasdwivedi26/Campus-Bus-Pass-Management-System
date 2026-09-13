package com.campusbuspass.service;

import com.campusbuspass.db.DB;
import java.time.Year;

public class PassIdGenerator {
    public String nextPassId() {
        int next = DB.passes().stream().mapToInt(pass -> Integer.parseInt(pass.getPassId().substring(pass.getPassId().lastIndexOf('-') + 1))).max().orElse(0) + 1;
        return "BP-" + Year.now().getValue() + "-" + String.format("%05d", next);
    }
}
