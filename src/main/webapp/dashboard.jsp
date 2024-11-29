<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="static/css/styles.css">
    <title>Admin Panel: Little Nakamas</title>
</head>

<body>
    <div class="container">
        <div class="header">
            <div class="nav">
                <div class="search">
                    <input type="text" placeholder="Search..">
                    <button type="submit"><img src="static/images/Index/search.png" alt=""></button>
                </div>
                <div class="user">
                    <a href="parents" class="btn">Add New Children</a>
                    <img src="static/images/Index/notifications.png" alt="">
                    <div class="img-case">
                        <img src="static/images/Index/user.png" alt="">
                    </div>
                </div>
            </div>
        </div>
        <div class="content">
            <div class="cards">
                <div class="card">
                    <div class="box">
                        <h1><c:out value="${}"/></h1>
                        <h3>Childrens</h3>
                    </div>
                    <div class="icon-case">
                        <img src="static/images/Index/students.png" alt="">
                    </div>
                </div>
                <div class="card">
                    <div class="box">
                        <h1>53</h1>
                        <h3>Teachers</h3>
                    </div>
                    <div class="icon-case">
                        <img src="static/images/Index/teachers.png" alt="">
                    </div>
                </div>
                <div class="card">
                    <div class="box">
                        <h1>1</h1>
                        <h3>Schools</h3>
                    </div>
                    <div class="icon-case">
                        <img src="static/images/Index/schools.png" alt="">
                    </div>
                </div>
            </div>
            <div class="content-2">
                <div class="new-students">
                    <div class="title">
                        <h2>New Childrens</h2>
                        <a href="Childrens.jsp" class="btn">View All</a>
                    </div>
                    <table>
                        <tr>
                            <th>Profile</th>
                            <th>Name</th>
                            <th>option</th>
                        </tr>
                        <tr>
                            <td><img src="static/images/Index/user.png" alt=""></td>
                            <td>John Steve Doe</td>
                            <td><img src="static/images/Index/info.png" alt=""></td>
                        </tr>
                        <tr>
                            <td><img src="static/images/Index/user.png" alt=""></td>
                            <td>John Steve Doe</td>
                            <td><img src="static/images/Index/info.png" alt=""></td>
                        </tr>
                        <tr>
                            <td><img src="static/images/Index/user.png" alt=""></td>
                            <td>John Steve Doe</td>
                            <td><img src="static/images/Index/info.png" alt=""></td>
                        </tr>
                        <tr>
                            <td><img src="static/images/Index/user.png" alt=""></td>
                            <td>John Steve Doe</td>
                            <td><img src="static/images/Index/info.png" alt=""></td>
                        </tr>

                    </table>
                </div>
            </div>
        </div>
    </div>
</body>

</html>