package Test;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.rohan.springcontactapp.configuration.SpringRootConfig;
import javax.activation.DataSource;
//import javax.activation.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


public class TestDataSource {

   
    public static void main(String[] args) {
   
ApplicationContext  ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);       

ComboPooledDataSource jdbc =  (ComboPooledDataSource) ctx.getBean("bussService");

//DataSource ds=ctx.getBean(DataSource.class);

JdbcTemplate jt=new JdbcTemplate((jdbc));

String sql="INSERT INTO user(`name`, `phone`, `email`, `address`, `loginName`, `password`) VALUES (?,?,?,?,?,?)";

Object[] param= new Object[]{"Rohan", "8082668841", "rohan.net", "Mumbai", "rohan", "rohan123"};
jt.update(sql,param);

System.out.println("SQL executed");
    }
    
}
