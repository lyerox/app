package com.iot.services.Plan;

import com.iot.domain.schedule.Plan;
import com.iot.domain.schedule.PlanStatus;
import com.iot.domain.schedule.PlanType;
import com.iot.repositories.party.VehicleRepository;
import com.iot.repositories.plan.PlanRepository;
import com.iot.repositories.plan.PlanStatusRepository;
import com.iot.repositories.plan.PlanTypeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by lyerox on 16-10-17.
 */
@Service
public class PlanServiceImpl implements PlanService{

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private PlanTypeRepository typeRepository;

    @Autowired
    private PlanStatusRepository statusRepository;

//    @Autowired
//    public void setPlanRepository(PlanRepository planRepository){
//        this.planRepository = planRepository;
//    }
//
//    @Autowired
//    public void setStatusRepository(PlanStatusRepository statusRepository){
//        this.statusRepository = statusRepository;
//    }
//
//    @Autowired
//    public void setTypeRepository(PlanTypeRepository typeRepository){
//        this.typeRepository = typeRepository;
//    }
//
    @Override
    public Plan getPlan(Long id){
        return planRepository.findOne(id);
    }

    @Override
    public void deletePlan(Long id){
       planRepository.delete(planRepository.findOne(id));
    }

    @Override
    @Transactional
    public Plan savePlan(Plan plan){

        return planRepository.saveAndFlush(plan);
    }

    @Override
    public List<Plan> getAllPlans(){
        return planRepository.findAll();
    }


    @Override
    public Page<Plan> getPlansByPage(Pageable pageable){
        return planRepository.findAll(pageable);
    }


    @Override
    public List<PlanStatus> getAllStatus(){

        return statusRepository.findAll();
    }

    @Override
    public List<PlanType> getAllTypes(){

        return typeRepository.findAll();
    }

}
