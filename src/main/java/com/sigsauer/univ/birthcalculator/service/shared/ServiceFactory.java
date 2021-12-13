package com.sigsauer.univ.birthcalculator.service.shared;

import com.sigsauer.univ.birthcalculator.service.birth.BirthService;
import com.sigsauer.univ.birthcalculator.service.birth.BirthServiceImpl;
import com.sigsauer.univ.birthcalculator.service.user.UserService;
import com.sigsauer.univ.birthcalculator.service.user.UserServiceImpl;

public class ServiceFactory {

    private final static UserService userService = new UserServiceImpl();
    private final static BirthService birthService = new BirthServiceImpl();

    public static UserService getUserService() {
        return userService;
    }

    public static BirthService getBirthService() {
        return birthService;
    }
}
