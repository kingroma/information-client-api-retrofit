package api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import api.client.RetrofitClient;
import api.common.ResultConfig;
import api.common.RetrofitConfig;
import api.data.UserData;
import api.retrofit.UserRetrofitApi;
import retrofit2.Response;

public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	private UserRetrofitApi api = null ; 
	
	public UserService() {
		api = RetrofitClient.getUserRetrofitApi();
		
	}
	
	public String getToken(String userId , String userPw) {
		String token = null ; 
		try {
			Response<UserData> response = api.getUserToken(userId, userPw).execute();
			if ( response.isSuccessful() ) {
				UserData ud = response.body();
				
				if ( ResultConfig.SUCCESS_CODE.equals(ud.getResultCode())) {
					token = ud.getResult();
				}else { 
					logger.error("[ " + ud.getResultCode() + " ] " + ud.getResultMessage());
				}
			}else {
				logger.error("response is not successful");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if ( token != null && !token.isEmpty() ) {
			RetrofitConfig.TOKEN = token ;
		}
		
		return token ; 
	}
}
