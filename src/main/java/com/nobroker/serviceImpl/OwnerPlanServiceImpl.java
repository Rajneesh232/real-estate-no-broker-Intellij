package com.nobroker.serviceImpl;

import com.nobroker.entity.OwnerPlan;
import com.nobroker.payload.OwnerPlanDto;
import com.nobroker.repository.OwnerPlanRepository;
import com.nobroker.service.OwnerPlanService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerPlanServiceImpl implements OwnerPlanService {

    @Autowired
    private OwnerPlanRepository ownerPlanRepository;

    @Autowired
    private ModelMapper modelMapper;

    public OwnerPlanServiceImpl(OwnerPlanRepository ownerPlanRepository) {
        this.ownerPlanRepository = ownerPlanRepository;
    }

    @Override
    public OwnerPlanDto createOwnerPlan(OwnerPlanDto ownerPlanDto) {
        OwnerPlan ownerPlan=mapToEntity(ownerPlanDto);
        OwnerPlan savedOwnerPlan = ownerPlanRepository.save(ownerPlan);
        OwnerPlanDto dto = mapToDto(savedOwnerPlan);
        return dto;
    }

    @Override
    public List<OwnerPlanDto> getAllOwnerPlan() {
        List<OwnerPlan> ownerPlans = ownerPlanRepository.findAll();
        List<OwnerPlanDto> ownerPlanDto = ownerPlans.stream().map(plan -> mapToDto(plan)).collect(Collectors.toList());

        return ownerPlanDto;
    }



    OwnerPlan mapToEntity(OwnerPlanDto ownerPlanDto){
       OwnerPlan ownerPlan= modelMapper.map(ownerPlanDto,OwnerPlan.class);
       return ownerPlan;
    }

    OwnerPlanDto mapToDto(OwnerPlan ownerPlan){
        OwnerPlanDto dto= modelMapper.map(ownerPlan,OwnerPlanDto.class);
        return dto;
    }
}
