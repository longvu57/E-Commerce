<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<header class="dash-toolbar">
                
                <div class="tools">
                    <div class="dropdown tools-item">
                        <a href="#" class="" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-user"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu1">
                            <a class="dropdown-item" href="">
                            <security:authorize access="isAuthenticated()">
								<security:authentication property="principal" var = "user"/> Welcome ${user.username}
							</security:authorize></a>
                            <a class="dropdown-item" href="<c:url value="logout"/>">Logout</a>
                        </div>
                    </div>
                </div>
            </header>