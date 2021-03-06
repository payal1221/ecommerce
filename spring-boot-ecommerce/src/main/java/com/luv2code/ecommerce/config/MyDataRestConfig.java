package com.luv2code.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.luv2code.ecommerce.entity.Product;
import com.luv2code.ecommerce.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {		 
		
		HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.DELETE,HttpMethod.POST};
		
		//disable the Http methods for Products :PUT,Post and DELETE
		
		config.getExposureConfiguration()
			.forDomainType(Product.class)
			.withItemExposure((metdata , httpMethods) -> httpMethods.disable(theUnsupportedActions))
			.withCollectionExposure((metdata , httpMethods) -> httpMethods.disable(theUnsupportedActions));
		
		//disable the Http methods for ProductCategory :PUT,Post and DELETE
		
				config.getExposureConfiguration()
					.forDomainType(ProductCategory.class)
					.withItemExposure((metdata , httpMethods) -> httpMethods.disable(theUnsupportedActions))
					.withCollectionExposure((metdata , httpMethods) -> httpMethods.disable(theUnsupportedActions));
		
	}
	
	

}
