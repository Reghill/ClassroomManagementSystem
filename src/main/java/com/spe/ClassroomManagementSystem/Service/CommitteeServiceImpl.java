package com.spe.ClassroomManagementSystem.Service;

import com.spe.ClassroomManagementSystem.Models.Committee;
import com.spe.ClassroomManagementSystem.Models.Login;
import com.spe.ClassroomManagementSystem.Models.TA;
import com.spe.ClassroomManagementSystem.Repository.CommitteeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommitteeServiceImpl implements CommitteeService{

    @Autowired
    private CommitteeRepository committeeRepository;

    @Override
    public String saveCommittee(Committee committee){
        String msg;
        try {
            committeeRepository.save(committee);
            msg = "Saved Committee Successfully";
        }catch (Exception e){
            msg = "Failed Saving Committee";
        }
        return msg;
    }

    @Override
    public Committee findByForeignId(Login login)
    {
        return  committeeRepository.findByForeignId(login);
    }
}
