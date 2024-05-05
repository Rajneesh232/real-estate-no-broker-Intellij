package com.nobroker.service;

import com.nobroker.payload.OwnerPlanDto;

import java.util.List;

public interface OwnerPlanService {

    OwnerPlanDto createOwnerPlan(OwnerPlanDto ownerPlanDto);

    List<OwnerPlanDto> getAllOwnerPlan();

}
