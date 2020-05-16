package com.spe.ClassroomManagementSystem.Controller;

import com.spe.ClassroomManagementSystem.Models.Login;
import com.spe.ClassroomManagementSystem.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public RedirectView logIntoSystem(@RequestParam("username") String username,
                                      @RequestParam("password") String password,
                                      @RequestParam("usertype") String usertype,
                                      HttpSession session
                                      ) {
        boolean loginSuccess = loginService.checkCredentials(username, password, usertype, session);
        RedirectView rv = new RedirectView();
        if(loginSuccess == false) {
            rv.setUrl("InvalidLogin.jsp");
        } else {
            Login user=loginService.findByUsernameAndPassword(username,password);
            session.setAttribute("loginId",user.getLoginId());
            session.setAttribute("userName",user.getUserName());
            switch (usertype) {
                case "admin":
                    session.setAttribute("admin_login", "admin_login");
                    rv.setUrl("AdminDashboard.jsp");
                    break;
                case "professor":
                    session.setAttribute("professor_login", "professor_login");
                    rv.setUrl("ProfessorDashboard.jsp");
                    break;
                case "ta":
                    session.setAttribute("ta_login", "ta_login");
                    rv.setUrl("TADashboard.jsp");
                    break;
                case "committee":
                    session.setAttribute("committee_login", "committee_login");
                    rv.setUrl("CommitteeDashboard.jsp");
                    break;
                case "sac":
                    session.setAttribute("sac_login", "sac_login");
                    rv.setUrl("SACDashboard.jsp");
                    break;
            }
        }
        return rv;
    }



//    @RequestMapping("/checkLogin/professor")
//    public RedirectView checkLogin(HttpSession session){
//        RedirectView rv = new RedirectView();
//        if (session != null){
//           rv.setUrl("ProfessorDashboard.jsp");
//        }
//        else {
//            rv.setUrl("index.html");
//        }
//        return rv;
//    }
}
