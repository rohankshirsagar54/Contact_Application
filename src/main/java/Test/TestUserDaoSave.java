package Test;


import com.rohan.springcontactapp.configuration.SpringRootConfig;
import com.rohan.springcontactapp.dao.UserDAO;
import com.rohan.springcontactapp.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestUserDaoSave {

    public static void main(String[] args) {
       
        
        ApplicationContext ctx1=new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
        UserDAO userdao=ctx1.getBean(UserDAO.class);
        
        //taking from user at time of egistartion
        
        
        User u=new User();
        u.setName("ronny");
        u.setAddress("canada, up");
        u.setEmail("rohan87@gmail.com");
        u.setLoginName("ronny11");
        u.setPassword("ronny");
        u.setPhone("8082668821");
        u.setRole(1);
        u.setLoginStatus(1);
        
        userdao.save(u);
        
        System.out.print("completed");
    }
    
}
