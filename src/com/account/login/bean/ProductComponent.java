package com.account.login.bean;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.account.login.dto.ProductDTO;

@Component
@RequestMapping("/")
@Cacheable(value="productCache")
public class ProductComponent {
	public ProductComponent() {
		System.out.println(this.getClass().getSimpleName());
	}
	@RequestMapping(value="/save.dos",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute ProductDTO productDTO){
		System.out.println("invoked add product");
		System.out.println(productDTO);
		return "product";
	}
}
