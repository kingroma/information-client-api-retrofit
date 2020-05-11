package api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import api.client.RetrofitTokenClient;
import api.common.ResultConfig;
import api.data.CommonData;
import api.data.ProgramData;
import api.data.ProgramProductData;
import api.retrofit.ProgramRetrofitApi;
import retrofit2.Response;

public class ProgramService {
	private static final Logger logger = LoggerFactory.getLogger(ProgramService.class);
	
	private ProgramRetrofitApi api = null ;
	
	public ProgramService() {
		api = RetrofitTokenClient.getProgramRetrofitApi();
	}
	
	public ProgramData getProgram(String programId) {
		ProgramData result = null ; 
		
		try {
			Response<CommonData<ProgramData>> response = api.getProgramInformation(programId).execute();
			
			if ( response.isSuccessful() ) {
				CommonData<ProgramData> cd = response.body();
				
				if ( ResultConfig.SUCCESS_CODE.equals(cd.getResultCode())) {
					result = cd.getResult() ; 
				}else { 
					System.out.println("[ " + cd.getResultCode() + " ] " + cd.getResultMessage());
					logger.error("[ " + cd.getResultCode() + " ] " + cd.getResultMessage());
				}
			}else {
				logger.error("response is not successful");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result ; 
	}
	
	public ProgramProductData getProgramProduct(String productId) {
		ProgramProductData result = null ; 
		
		try {
			Response<CommonData<ProgramProductData>> response = api.getProgramProductInformation(productId).execute();
			
			if ( response.isSuccessful() ) {
				CommonData<ProgramProductData> cd = response.body();
				
				if ( ResultConfig.SUCCESS_CODE.equals(cd.getResultCode())) {
					result = cd.getResult() ; 
				}else { 
					System.out.println("[ " + cd.getResultCode() + " ] " + cd.getResultMessage());
					logger.error("[ " + cd.getResultCode() + " ] " + cd.getResultMessage());
				}
			}else {
				logger.error("response is not successful");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result ; 
	}
	
	
	
	
}
