<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="static/css/stylesMenu.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Teachers Panel: Little Nakamas</title>
</head>
<body>
    <div class="container">
        <div class="table">
            <div class="table-title">
                <div class="row">
                    <h1>Manage <b>Teachers</b></h1>
                </div>
                <div class="add-delete-boutons">
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#add-teacher-modal"><img src="static/images/Tables/add.png"><span>Add New Teacher</span></button>
                </div>
            </div>
            <div class="table-content">
                <table>
                    <thead>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Last Name</th>
                    <th>Diploma</th>
                    <th>Number Students</th>
                    <th>Actions</th>
                    </thead>
                    <tbody>
                        <c:forEach var="teacher" items="${teachers}" >
                            <tr>
                                <td><c:out value="${teacher.numEmp}"/></td>
                                <td><c:out value="${teacher.preEmp}"/></td>
                                <td><c:out value="${teacher.nomEmp}"/></td>
                                <td><c:out value="${teacher.diplome}"/></td>
                                <td><c:out value="${teacher.nbEnfant}"/></td>
                                <td>
                                    <a title="Edit" data-toggle="modal" data-target="#edit-teacher-modal"
                                    data-teacher-number="${teacher.numEmp}"
                                    data-teacher-name="${teacher.preEmp}"
                                    data-teacher-lastname="${teacher.nomEmp}"
                                    data-teacher-diplome="${teacher.diplome}"
                                    data-teacher-nbEnfant="${teacher.nbEnfant}">
                                        <img src="static/images/Tables/edit.png">
                                    </a>
                                    <a title="Delete" data-toggle="modal" data-target="#delete-teacher-modal" data-teacher-number="${teacher.numEmp}"><img src="static/images/Tables/delete.png"></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    

    <!-- Add Teacher Modal -->
    <div id="add-teacher-modal" class="modal fade" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form method="post" action="teachers">
                    <div class="modal-header">
                        <h3 class="modal-title">Add New Teacher</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Teacher Name</label>
                            <input type="text" name="educ-name" class="form-control" placeholder="Enter Teacher Name">
                        </div>
                        <div class="form-group">
                            <label>Teacher Last Name</label>
                            <input type="text" name="educ-lastname" class="form-control" placeholder="Enter Teacher Last Name">
                        </div>
                        <div class="form-group">
                            <label>Teacher Diploma</label>
                            <input type="text" name="educ-diploma" class="form-control" placeholder="Enter Teacher Diploma">
                        </div>
                        <div class="form-group">
                            <label>Number Childrens</label>
                            <input type="number" name="educ-numchildrens" class="form-control" placeholder="Enter Number Childrens">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary">Add Teacher</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- Delete Teacher Modal -->
    <div id="delete-teacher-modal" class="modal fade" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form method="get" action="teachersDelete" id="delete-teachers-form">
                    <div class="modal-header">
                        <h3 class="modal-title">Delete Teacher</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <p>Are you sure you want to delete these records?</p>
                        <p class="text-warning"><small>This action cannot be undone.</small></p>
                        <input type="hidden" name="teacher-number" id="modal-teacher-number"/>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary">Delete</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!--Edit Teacher Modal-->
    <div id="edit-teacher-modal" class="modal fade" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form method="post" action="teachersEdit" id="edit-teacher-form">
                    <div class="modal-header">
                        <h3 class="modal-title">Edit Teacher</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                    <input type="hidden" name="teacher-old-number" id="modal-teacher-old-number"/>
                        <div class="form-group">
                            <label>Teacher Name</label>
                            <input type="text" name="teacher-new-name" class="form-control" id="modal-teacher-new-name">
                        </div>
                        <div class="form-group">
                            <label>Teacher Last Name</label>
                            <input type="text" name="teacher-new-lastname" class="form-control" id="modal-teacher-new-lastname">
                        </div>
                        <div class="form-group">
                            <label>Teacher Diploma</label>
                            <input type="text" name="teacher-new-diplome" class="form-control" id="modal-teacher-new-diplome">
                        </div>
                        <div class="form-group">
                            <label>Number Students</label>
                            <input type="number" name="teacher-new-nbenfant" class="form-control" id="modal-teacher-new-nbenfant">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary">Edit Teacher</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script>
        $(document).on('click', '[data-target="#delete-teacher-modal"]', function () {
            var teacherNumEmp = $(this).data('teacher-number');

            $('#modal-teacher-number').val(teacherNumEmp);
        });

        $(document).on('click', '[data-target="#edit-teacher-modal"]', function () {
            var teacherNumEmp = $(this).data('teacher-number');
            var teacherPren = $(this).data('teacher-name');
            var teacherNom = $(this).data('teacher-lastname');
            var teacherDiplome = $(this).data('teacher-diplome');
            var teacherNbEnfant = $(this).data('teacher-nbenfant');

            $('#modal-teacher-old-number').val(teacherNumEmp);
            $('#modal-teacher-new-number').val(teacherNumEmp);
            $('#modal-teacher-new-name').val(teacherPren);
            $('#modal-teacher-new-lastname').val(teacherNom);
            $('#modal-teacher-new-diplome').val(teacherDiplome);
            $('#modal-teacher-new-nbenfant').val(teacherNbEnfant);
        });
    </script>
</body>
</html>