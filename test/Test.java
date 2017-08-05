import org.loong.acb.server.service.LoginRegisterService;
import org.loong.common.exception.LoongException;
import org.loong.common.retobj.ReturnSimpleHandle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.sf.json.JSONObject;

public class Test {

	public static void main(String[] args) throws LoongException {
		ApplicationContext context = new 
                ClassPathXmlApplicationContext(new String[] {"/config/spring/application*.xml"});
		
		// CategoryService service = (CategoryService)context.getBean("categoryServiceImpl");
		//UserService service = (UserService)context.getBean("userServiceImpl");
		LoginRegisterService service = (LoginRegisterService)context.getBean("loginRegisterServiceImpl");
		JSONObject parameter = new JSONObject();
		parameter.put("account", "q");
		parameter.put("password", "qwe");
		ReturnSimpleHandle handle = service.login(parameter);
		System.out.println(handle.toJson());
        
	}
}
