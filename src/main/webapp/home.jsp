<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="static/css/styles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Admin Panel: Little Nakamas</title>
</head>

<body>
    <div class="side-menu">
        <div class="brand-name">
            <h1>Little Nakamas</h1>
            <img src="static/images/Index/logo_garderie.png" alt="logo-garderie" class="logo-garderie">
        </div>
        <div class="side-menu-items">
            <ul>
                <li>
                    <a href="dashboard" target="contentFrame">
                        <img src="static/images/Index/dashboard (2).png" alt="">&nbsp;Dashboard
                    </a>
                </li>
                <li>
                    <a href="enfant" target="contentFrame">
                        <img src="static/images/Index/reading-book (1).png" alt="">&nbsp;Childrens
                    </a>
                </li>               
                <li class="dropdown"><a href="employees" target="contentFrame"><img src="static/images/Index/employees.png" alt="">&nbsp;Employees</a>
                    <ul class="dropdown-content">
                        <li><a href="teachers" target="contentFrame"><img src="static/images/Index/teacher.png" alt="">&nbsp;Teachers</a></li>
                        <li><a href="admins" target="contentFrame"><img src="static/images/Index/admins.png" alt="">&nbsp;Admins</a></li>
                    </ul>
                </li>
                <li><a href="parents" target="contentFrame">
                        <img src="static/images/Index/parent.png" alt="">&nbsp;Parents
                    </a> 
                </li>
                <li>
                    <a href="aboutUs.jsp" target="contentFrame">
                        <img src="static/images/Index/aboutus.png" alt="">&nbsp;About Us 
                    </a>
                </li>
                <li>
                    <a href="settings.jsp" target="contentFrame">
                        <img src="static/images/Index/settings.png" alt="">&nbsp;Settings
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <div class="containerIndex">
        <iframe src="dashboard" name="contentFrame" id="contentFrame" width="100%" height="100%"></iframe>
    </div>

</body>

</html>