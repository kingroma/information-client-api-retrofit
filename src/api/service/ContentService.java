package api.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import api.client.RetrofitTokenClient;
import api.common.ResultConfig;
import api.data.ContentData;
import api.data.ListData;
import api.retrofit.ContentRetrofitApi;
import retrofit2.Response;

public class ContentService {
	private static final Logger logger = LoggerFactory.getLogger(ContentService.class);
	
	private ContentRetrofitApi api = null ; 
	
	public ContentService() {
		api = RetrofitTokenClient.getContentRetrofitApi();
	}
	
	public List<ContentData> getContentAll() {
		List<ContentData> result = null ; 
		
		try {
			Response<ListData<ContentData>> response = api.getContentAll().execute();
			
			if ( response.isSuccessful() ) {
				ListData<ContentData> cd = response.body();
				
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
	
	public List<ContentData> getContentWithContentType(String contentType) {
		List<ContentData> result = null ; 
		
		try {
			Response<ListData<ContentData>> response = api.getContentWithContentType(contentType).execute();
			
			if ( response.isSuccessful() ) {
				ListData<ContentData> cd = response.body();
				
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
