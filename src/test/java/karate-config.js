function fn() {
  var env = karate.env; // get system property 'karate.env'
  karate.log('karate.env system property was:', env);
  if (!env) {
    env = 'uat';
  }
  var config;
  if (env == 'qa') {
  var config = {
    env: env,
	myVarName: 'someValue',
	    GM_DMS_URL:'http://uqlw029.qa.oec.local:9010/evolution/dms-service/SecuredMenus',
    	JLR_DMS_URL:'http://UQLW029.qa.oec.local:9020/jlrmp/dms-service/Menus',
    	OPEL_DMS_URL:'http://uqlw029.qa.oec.local/evolution/dms-service/SecuredMenus',
    	OPEL_EPYX_URL:'http://epyx1link.clifford-thames.com/axis/services/EPYX1linkServiceSOAP', //no QC url
    	OPEL_ESA_URL:'http://uqlw029.qa.oec.local/evolution/dms-service/esa',
    	OPEL_WALLET_URL:'http://uqlw029.qa.oec.local/evolution/dms-service/Wallet',
    	HYU_DMS_URL:'http://1038434uqlw012.qa.oec.local:8080/hyundaimp/dms-service/Menus',
    	HYU_EVHC_URL:'http://1038434uqlw012.qa.oec.local:8080/hyundaimp/dms-service/Evhc',
    	HYU_FLEET_URL:'http://1038434uqlw012.qa.oec.local:8080/hyundaimp/dms-service/Fleet'
  }
  } else if (env == 'uat') {
  var config = {
    env: env,
	myVarName: 'someValue',
	GM_DMS_URL: 'https://preprod.gmdealerpricing.com/evolution/dms-service/SecuredMenus',
	JLR_DMS_URL: 'https://uat.jlr-menupricing.com/jlrmp/dms-service/Menus',
	OPEL_DMS_URL: 'https://pp.opel-vauxhall-menupricing.com/evolution/dms-service/SecuredMenus',
	OPEL_EPYX_URL: 'http://epyx1link.clifford-thames.com/axis/services/EPYX1linkServiceSOAP',
	OPEL_ESA_URL: 'https://pp.opel-vauxhall-menupricing.com/evolution/dms-service/esa',
	OPEL_WALLET_URL: 'https://pp.opel-vauxhall-menupricing.com/evolution/dms-service/Wallet',
	HYU_DMS_URL: 'https://uat.hyundaimp.com/dms-service/Menus',
    HYU_EVHC_URL: 'https://uat.hyundaimp.com/dms-service/Evhc',
    HYU_FLEET_URL: 'https://uat.hyundaimp.com/dms-service/Fleet'
  }
  } else if (env == 'prd') {
    var config = {
      env: env,
  	myVarName: 'someValue',
  	GM_DMS_URL: 'https://www.gmdealerpricing.com/evolution/dms-service/SecuredMenus',
  	JLR_DMS_URL: 'https://jlr-menupricing.com/jlrmp/dms-service/Menus',
  	OPEL_DMS_URL: 'https://www.gme-menupricing.com/evolution/dms-service/Menus',
  	OPEL_EPYX_URL: 'http://epyx1link.clifford-thames.com/axis/services/EPYX1linkServiceSOAP',
  	OPEL_ESA_URL: 'https://www.gme-menupricing.com/evolution/dms-service/esa',
  	OPEL_WALLET_URL: 'https://www.gme-menupricing.com/evolution/dms-service/Wallet',
  	HYU_DMS_URL: 'https://www.hyundaimp.com/dms-service/Menus',
    HYU_EVHC_URL: 'https://www.hyundaimp.com/hyundaimp/dms-service/Evhc',
    HYU_FLEET_URL: 'https://www.hyundaimp.com/dms-service/Fleet'
    }
  }
  return config;
}
