package api.retrofit;

import api.data.CommonData;
import api.data.ProgramData;
import api.data.ProgramProductData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProgramRetrofitApi {
	@GET("program/information/{PROGRAM_ID}")
	public Call<CommonData<ProgramData>> getProgramInformation(
			@Path("PROGRAM_ID") String programId 
			);
	
	@GET("program/product/information/{PRODUCT_ID}")
	public Call<CommonData<ProgramProductData>> getProgramProductInformation(
			@Path("PRODUCT_ID") String productId 
			);
}
