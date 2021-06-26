package com.imageupload.validator;

import javax.servlet.http.HttpServletRequest;

import com.imageupload.pojo.ProductImage;

public class UploadImageValidator {
	public ProductImage insertPath(HttpServletRequest httpServletRequest) {
		ProductImage productImage = new ProductImage();
		return productImage;
	}
}
