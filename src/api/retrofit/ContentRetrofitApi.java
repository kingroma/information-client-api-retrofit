package api.retrofit;

import api.data.ContentData;
import api.data.ListData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ContentRetrofitApi {
	@GET("content/listAll")
	public Call<ListData<ContentData>> getContentAll();
	
	@GET("content/list")
	public Call<ListData<ContentData>> getContentWithContentType(
			@Query("contentType") String contentType 
			);
}
