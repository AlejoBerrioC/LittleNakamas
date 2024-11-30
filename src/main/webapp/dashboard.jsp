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
                <form action="dashboard" method="post">
                    <input type="text" name="search" placeholder="Search..">
                    <button type="submit"><img src="static/images/Index/search.png" alt=""></button>
                </form>
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
                        <h1><c:out value="${enfants.size()}" /></h1>
                        <h3>Childrens</h3>
                    </div>
                    <div class="icon-case">
                        <img src="static/images/Index/students.png" alt="">
                    </div>
                </div>
                <div class="card">
                    <div class="box">
                        <h1><c:out value="${nbEmploye}" /></h1>
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
                        <a href="childrens.jsp" class="btn">View All</a>
                    </div>
                    <table>
                        <tr>
                            <th>Profile</th>
                            <th>Children Lastname</th>
                            <th>Parent Telephone</th>
                            <th>Childre Section</th>
                        </tr>
                        <c:forEach var = "enfant" items = "${enfants}">
                            <tr>
                                <td><img src="static/images/Index/user.png" alt=""></td>
                                <td><c:out value="${enfant.nomEnf}" /></td>
                                <td><c:out value="${enfant.parentEnf.numTel}" /></td>
                                <td><c:out value="${enfant.affectedSection(enfant.ageEnf)}" /></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>

</html>