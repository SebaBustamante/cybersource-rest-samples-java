// 53
// Code Generated: getAllPaymentInstruments[Retrieve all Payment Instruments associated with an Instrument Identifier]

package samples.Token_Management;
import java.*;
import java.util.*;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;

import com.cybersource.authsdk.core.MerchantConfig;

import Api.*;
import Data.Configuration;
import Invokers.ApiClient;
import Invokers.ApiException;
import Model.*;

public class RetrieveallPaymentInstrumentsassociatedwithanInstrumentIdentifier{
	private static String responseCode = null;
	private static String status = null;
	private static Properties merchantProp;

	public static void main(String args[]) throws Exception
	{
		// Accept required parameters from args[] and pass to run.
		run( "", "" );
	}
	public static TmsV1InstrumentIdentifiersPaymentInstrumentsGet200Response run( String profileid, String tokenId ){
	
		Long offset = null;
		Long limit = null;

		TmsV1InstrumentIdentifiersPaymentInstrumentsGet200Response result = null;
		try
		{
			merchantProp = Configuration.getMerchantDetails();
			ApiClient apiClient = new ApiClient();
			MerchantConfig merchantConfig = new MerchantConfig(merchantProp);
			apiClient.merchantConfig = merchantConfig;

			InstrumentIdentifierApi apiInstance = new InstrumentIdentifierApi(apiClient);
			result = apiInstance.getAllPaymentInstruments( profileid, tokenId, offset, limit );

			responseCode = apiClient.responseCode;
			status = apiClient.status;
			System.out.println("ResponseCode :" + responseCode);
			System.out.println("ResponseMessage :" + status);
			System.out.println(result);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	return result;
	}
}


//****************************************************************************************************

