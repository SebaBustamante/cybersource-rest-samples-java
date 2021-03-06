package samples.riskManagement.coreServices;

import java.util.*;
import com.cybersource.authsdk.core.MerchantConfig;

import Api.*;
import Data.Configuration;
import Invokers.ApiClient;
import Model.*;

public class CustomerMatchDeniedPartiesList {
	private static String responseCode = null;
	private static String status = null;
	private static Properties merchantProp;

	public static RiskV1ExportComplianceInquiriesPost201Response run() {
	
		ValidateExportComplianceRequest requestObj = new ValidateExportComplianceRequest();

		Riskv1addressverificationsClientReferenceInformation clientReferenceInformation = new Riskv1addressverificationsClientReferenceInformation();
		clientReferenceInformation.code("verification example");
		clientReferenceInformation.comments("Export-basic");
		requestObj.clientReferenceInformation(clientReferenceInformation);

		Riskv1exportcomplianceinquiriesOrderInformation orderInformation = new Riskv1exportcomplianceinquiriesOrderInformation();
		Riskv1exportcomplianceinquiriesOrderInformationBillTo orderInformationBillTo = new Riskv1exportcomplianceinquiriesOrderInformationBillTo();
		orderInformationBillTo.address1("901 Metro Centre Blvd");
		orderInformationBillTo.administrativeArea("CA");
		orderInformationBillTo.country("US");
		orderInformationBillTo.locality("Foster City");
		orderInformationBillTo.postalCode("94404");
		Riskv1exportcomplianceinquiriesOrderInformationBillToCompany orderInformationBillToCompany = new Riskv1exportcomplianceinquiriesOrderInformationBillToCompany();
		orderInformationBillToCompany.name("A & C International Trade, Inc");
		orderInformationBillTo.company(orderInformationBillToCompany);

		orderInformationBillTo.firstName("ANDREE");
		orderInformationBillTo.lastName("AGNESE");
		orderInformationBillTo.email("test@domain.com");
		orderInformation.billTo(orderInformationBillTo);

		Riskv1exportcomplianceinquiriesOrderInformationShipTo orderInformationShipTo = new Riskv1exportcomplianceinquiriesOrderInformationShipTo();
		orderInformationShipTo.country("IN");
		orderInformationShipTo.firstName("DumbelDore");
		orderInformationShipTo.lastName("Albus");
		orderInformation.shipTo(orderInformationShipTo);


		List <Riskv1exportcomplianceinquiriesOrderInformationLineItems> lineItems =  new ArrayList <Riskv1exportcomplianceinquiriesOrderInformationLineItems>();
		Riskv1exportcomplianceinquiriesOrderInformationLineItems lineItems1 = new Riskv1exportcomplianceinquiriesOrderInformationLineItems();
		lineItems1.unitPrice("120.50");
		lineItems1.quantity(3);
		lineItems1.productSKU("123456");
		lineItems1.productName("Qwe");
		lineItems1.productCode("physical_software");
		lineItems.add(lineItems1);

		orderInformation.lineItems(lineItems);

		requestObj.orderInformation(orderInformation);

		RiskV1ExportComplianceInquiriesPost201Response result = null;
		try {
			merchantProp = Configuration.getMerchantDetails();
			ApiClient apiClient = new ApiClient();
			MerchantConfig merchantConfig = new MerchantConfig(merchantProp);
			apiClient.merchantConfig = merchantConfig;

			VerificationApi apiInstance = new VerificationApi(apiClient);
			result = apiInstance.validateExportCompliance(requestObj);

			responseCode = apiClient.responseCode;
			status = apiClient.status;
			System.out.println("ResponseCode :" + responseCode);
			System.out.println("ResponseMessage :" + status);
			System.out.println(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static void main(String args[]) throws Exception{
		
			run();
	}
}
