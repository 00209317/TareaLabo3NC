package com.uca.capas.capas.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.capas.domain.Product;

@Controller
public class ProductController {
	
	private List<Product> productos = new ArrayList<Product>();

	@GetMapping("/compraProducto")
	public ModelAndView compraProducto(){
		ModelAndView mav = new ModelAndView();
		
		productos.add(new Product(0,"Batllefield1",10));
		productos.add(new Product(1,"FIFA 20",20));
		productos.add(new Product(2,"BatllefieldV",30));
		productos.add(new Product(3,"The Last Of Us",40));
		
		mav.setViewName("productos");
		mav.addObject("product", new Product());
		mav.addObject("producto", productos);
		
		return mav;
	}
	
	
	@PostMapping("/validar")
	public ModelAndView validar(Product producto) {
		ModelAndView mav = new ModelAndView();
		
		int cantidad_array = productos.get(producto.getId()).getCantidad();
		int cantidad_form = producto.getCantidad();
		
		if(cantidad_form <= cantidad_array) {
			mav.addObject("compra", productos.get(producto.getId()).getNombre() );
			mav.setViewName("compra");
		}else {
			mav.addObject("error", productos.get(producto.getId()).getNombre() );
			mav.setViewName("error");
		}
		
		return mav;
	}
	
}
