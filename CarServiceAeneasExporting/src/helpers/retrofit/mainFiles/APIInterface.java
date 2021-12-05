package helpers.retrofit.mainFiles;



import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

	
	 
	 @GET("?format=json")
	    Call<OrderOutDetails> performOrder();
	 
	 
   
}