import java.util.List;

import api.data.ContentData;
import api.data.ProgramData;
import api.data.ProgramProductData;
import api.service.ContentService;
import api.service.ProgramService;
import api.service.UserService;
import common.util.ObjectUtil;

public class Main {

	public static void main(String[] args) {
		//PropertyConfigurator.configure("-Dlog4j.configuration=file:/C:\\Users\\admin\\Desktop\\project\\my2\\information-client-api-retrofit\\log4j.xml");
		
		String userId = "kingroma";
		String userPw = "4235";
		
		UserService us = new UserService();
		
		String token = us.getToken(userId, userPw);
		
		System.out.println("token > " + token);
		
		
		ProgramService ps = new ProgramService();
		ProgramData pd = ps.getProgram("1");
		System.out.println(pd);
		
		ProgramProductData ppd = ps.getProgramProduct("1");
		System.out.println(ppd);
		
		ContentService sc = new ContentService();
		List<ContentData> cd = sc.getContentAll();
		System.out.println(cd);
		
		cd = sc.getContentWithContentType(ContentData.ContentType.contentBasic.toString());
		System.out.println(cd);
	}

	@Override
	public String toString() {
		return ObjectUtil.changeObjValueToString(this);
	}
}
