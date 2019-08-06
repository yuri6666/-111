package com.winit.common.utils;

import tk.mybatis.mapper.genid.GenId;

public class SimpleGenId implements GenId<Integer> {
    private Long    time;
    private Integer seq;

    @Override
    public synchronized Integer genId(String table, String column) {
        long current = System.currentTimeMillis();
        if (time == null || time != current) {
            time = current;
            seq = 1;
        } else if (current == time) {
            seq++;
        }
        return (int) ((time << 20) | seq);
    }
}

