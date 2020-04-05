package Test;


import com.rohan.springcontactapp.configuration.SpringRootConfig;
import com.rohan.springcontactapp.dao.UserDAO;
import com.rohan.springcontactapp.domain.User;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class FindBy {

    
    public static void main(String[] args) {
       
         ApplicationContext ctx1=new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
        UserDAO userdao3=ctx1.getBean(UserDAO.class);
        
       // List<User> users= userdao3.findByProperty("userId", 1);
        List<User> users= userdao3.findByProperty("name", "Rohan");
        for(User u: users){
        
        System.out.println(u.getUserId()+" "+ u.getName()+ " "+ u.getEmail());
        }
        
    }
    
}
