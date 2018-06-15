package com.hotel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.entity.Room;
import com.hotel.service.RoomService;
@WebServlet("/room")
public class RoomController extends BaseController {
    
	private static final long serialVersionUID = 1L;

	public String execute(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		RoomService roomService=new RoomService();
		List<Room> roomList=roomService.roomList();
		 request.setAttribute("roomlist", roomList);
		request.getRequestDispatcher("roomlist.jsp").forward(request, response);
		return null;
	}
}
