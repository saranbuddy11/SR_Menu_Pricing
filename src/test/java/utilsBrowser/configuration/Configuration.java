package utilsBrowser.configuration;


import model.Market;

import java.util.Properties;

public class Configuration {
    private String url;
    private String dealerId;
    private String usDealerId;
    private String mxDealerId;
    private String caDealerId;
    private String userId;
    private String password;
    private String invalidDealerId;
    private String invalidUserId;
    private String invalidPassword;
    private Market market;
    private Long maxSearchTime;
    private String apiURl;
    private String apiURL1;
    private String apiURL2;
    private String inputExcelFileName;
    private String outputExcelFileName;
    private String usCountryCode;
    private String mxCountryCode;
    private String caCountryCode;
    private String salesUserId;
    private String spainDealerId;
    private String spainUserId;
    private String spainPassword;
    private String newUser;
    private String newPassword;
    private String nonUKRetailCode;
    private String nonUKSalesUSerId;
    private String nonUKSalesPassword;
    private String nonUKAdminUSerId;
    private String nonUKAdminPassword;
    private Market nonUKMarket;
    private String singleBrandedDealerID;
    private String singleBrandedUserID;
    private String singleBrandedDealerPassword;
    private String MMDealerID;
    private String MMUserID;
    private String MMDealerPassword;

    public Long getMaxSearchTime() {
        return maxSearchTime;
    }

    public String getUrl() {
        return url;
    }

    public String getSalesUserId() {
        return salesUserId;
    }

    public String getAPIUrl() {
        return apiURl;
    }

    public String getAPIUrl1() {
        return apiURL1;
    }

    public String getAPIUrl2() {
        return apiURL2;
    }

    public String getDealerId() {
        return dealerId;
    }

    public String getDataUSDealerId() {
        return usDealerId;
    }

    public String getDataMXDealerId() {
        return mxDealerId;
    }

    public String getDataCADealerId() {
        return caDealerId;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getInvalidUserId() {
        return invalidUserId;
    }

    public String getInvalidPassword() {
        return invalidPassword;
    }

    public String getInvalidDealerId() {
        return invalidDealerId;
    }

    public String getInputExcelFileName() {
        return inputExcelFileName;
    }

    public String getOutputExcelFileName() {
        return outputExcelFileName;
    }

    public String getUSCountryCode() {
        return usCountryCode;
    }

    public String getMXCountryCode() {
        return mxCountryCode;
    }

    public String getCACountryCode() {
        return caCountryCode;
    }

    public Market getMarket() {
        return market;
    }

    public String getSpainUserId() {
        return spainUserId;
    }

    public String getSpainPassword() {
        return spainPassword;
    }

    public String getSpainDealerId() {
        return spainDealerId;
    }

    public String getNewUser() {
        return newUser;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getNonUKRetailCode() {
        return nonUKRetailCode;
    }

    public String getNonUKSalesUSerId() {
        return nonUKSalesUSerId;
    }

    public String getNonUKSalesPassword() {
        return nonUKSalesPassword;
    }

    public String getNonUKAdminUSerId() {
        return nonUKAdminUSerId;
    }

    public String getNonUKAdminPassword() {
        return nonUKAdminPassword;
    }

    public Market getNonUKMarket() { return nonUKMarket; }

    public String getSingleBrandedDealerID() {
        return singleBrandedDealerID;
    }

    public String getSingleBrandedUserID() {
        return singleBrandedUserID;
    }

    public String getSingleBrandedDealerPassword() {
        return singleBrandedDealerPassword;
    }

    public String getMMDealerID() {
        return MMDealerID;
    }

    public String getMMUserID() {
        return MMUserID;
    }

    public String getMMDealerPassword() {
        return MMDealerPassword;
    }

    public Configuration(Properties properties) {
        this.url = properties.getProperty("url");
        this.dealerId = properties.getProperty("dealerId");
        this.usDealerId = properties.getProperty("usDealerID");
        this.mxDealerId = properties.getProperty("mxDealerID");
        this.caDealerId = properties.getProperty("caDealerID");
        this.userId = properties.getProperty("userId");
        this.salesUserId = properties.getProperty("salesUserId");
        this.password = properties.getProperty("password");
        this.market = Market.valueOf(properties.getProperty("market"));
        this.invalidUserId = properties.getProperty("invalidUserId");
        this.invalidPassword = properties.getProperty("invalidPassword");
        this.invalidDealerId = properties.getProperty("invalidDealerId");
        this.maxSearchTime = Long.parseLong(properties.getProperty("maxsearchtime"));
        this.apiURl = properties.getProperty("apiURL");
        this.apiURL1 = properties.getProperty("apiURL1");
        this.apiURL2 = properties.getProperty("apiURL2");
        this.inputExcelFileName = properties.getProperty("inputExcelFileName");
        this.outputExcelFileName = properties.getProperty("outputExcelFileName");
        this.usCountryCode = properties.getProperty("usCountryCode");
        this.mxCountryCode = properties.getProperty("mxCountryCode");
        this.caCountryCode = properties.getProperty("caCountryCode");
        this.spainDealerId = properties.getProperty("spainDealerId");
        this.spainUserId = properties.getProperty("spainUserId");
        this.spainPassword = properties.getProperty("spainPassword");
        this.newUser = properties.getProperty("newUser");
        this.newPassword = properties.getProperty("newPassword");
        this.nonUKRetailCode = properties.getProperty("nonUKRetailCode");
        this.nonUKSalesUSerId = properties.getProperty("nonUKSalesUSerId");
        this.nonUKSalesPassword = properties.getProperty("nonUKSalesPassword");
        this.nonUKAdminUSerId = properties.getProperty("nonUKAdminUSerId");
        this.nonUKAdminPassword = properties.getProperty("nonUKAdminPassword");
        this.nonUKMarket = Market.valueOf(properties.getProperty("nonUKMarket"));
        this.singleBrandedDealerID = properties.getProperty("singleBrandedDealerID");
        this.singleBrandedUserID = properties.getProperty("singleBrandedUserID");
        this.singleBrandedDealerPassword = properties.getProperty("singleBrandedDealerPassword");
        this.MMDealerID = properties.getProperty("MMDealerID");
        this.MMUserID = properties.getProperty("MMUserID");
        this.MMDealerPassword = properties.getProperty("MMDealerPassword");
    }
}