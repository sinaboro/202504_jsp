package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.ProductVO;

@WebServlet("/productUpdate.do")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code = request.getParameter("code");
		
		ProductVO pVo = ProductDAO.getInstance().selectProductByCode(code);
		
		request.setAttribute("product", pVo);
		
		request.getRequestDispatcher("product/productUpdate.jsp")
			.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		
		String encType = "utf-8";
		
		int sizeLimit = 20*1024*1024; //20MB
		
		MultipartRequest multi = new MultipartRequest(
				request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
		
//		System.out.println(path);
		
		int code = Integer.parseInt(multi.getParameter("code"));
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String  pictureUrl = multi.getFilesystemName("pictureUrl");
		String description = multi.getParameter("description");
		
		//수정시 이미지 첨부를 하지않으면, 기본 이미지 사용(noimage.gif)
		if(pictureUrl == null) {
			pictureUrl = multi.getParameter("nonmakeImg");
		}
		
		ProductVO pVo = new ProductVO();
		pVo.setCode(code);
		pVo.setName(name);
		pVo.setPrice(price);
		pVo.setPictureUrl(pictureUrl);
		pVo.setDescription(description);
		
		ProductDAO.getInstance().updateProduct(pVo);
		
		response.sendRedirect("productList.do"); //리스트 목록 이동
	}

}
