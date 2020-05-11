package api.retrofit;

import api.data.UserData;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserRetrofitApi {
	@POST("user/login")
	public Call<UserData> getUserToken(
			@Query("userId") String userId , 
			@Query("userPw") String userPw 
			);
}
