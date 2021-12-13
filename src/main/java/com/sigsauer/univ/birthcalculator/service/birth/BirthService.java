package com.sigsauer.univ.birthcalculator.service.birth;

import com.sigsauer.univ.birthcalculator.service.birth.bean.BirthTimer;

import java.util.Date;

public interface BirthService {

    BirthTimer calculateTimeUntilBirthday(Long userId, Date birthday);

}
