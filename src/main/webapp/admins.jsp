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
    <title>Administrators Panel: Little Nakamas</title>
</head>
<body>
    <div class="container">
        <div class="table">
            <div class="table-title">
                <div class="row">
                    <h1>Manage <b>Administrators</b></h1>
                </div>
                <div class="add-delete-boutons">
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#add-admins-modal"><img src="static/images/Tables/add.png"><span>Add New Administrator</span></button>
                </div>
            </div>
            <div class="table-content">
                <table>
                    <thead>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Last Name</th>
                    <th>Phone Number</th>
                    <th>Email</th>
                    <th>Actions</th>
                    </thead>
                    <tbody>
                        <c:forEach var="admin" items="${admins}">
                            <tr>
                                <td><c:out value="${admin.numEmp}"/></td>
                                <td><c:out value="${admin.preEmp}"/></td>
                                <td><c:out value="${admin.nomEmp}"/></td>
                                <td><c:out value="${admin.numTel}"/></td>
                                <td><c:out value="${admin.emailProf}"/></td>
                                <td>
                                    <a title="Edit" data-toggle="modal" data-target="#edit-admins-modal"
                                    data-admin-number="${admin.numEmp}"
                                    data-admin-name="${admin.preEmp}"
                                    data-admin-lastname="${admin.nomEmp}"
                                    data-admin-telephone="${admin.numTel}"
                                    data-admin-email="${admin.emailProf}">
                                        <img src="static/images/Tables/edit.png">
                                    </a>
                                    <a title="Delete" data-toggle="modal" data-target="#delete-admins-modal" data-admin-number="${admin.numEmp}"><img src="static/images/Tables/delete.png"></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    

    <!-- Add Administrator Modal -->
    <div id="add-admins-modal" class="modal fade" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form method="post" action="admins">
                    <div class="modal-header">
                        <h3 class="modal-title">Add New Administrator</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Administrator Name</label>
                            <input type="text" name="admin-name" class="form-control" placeholder="Enter Administrator Name">
                        </div>
                        <div class="form-group">
                            <label>Administrator Last Name</label>
                            <input type="text" name="admin-lastname" class="form-control" placeholder="Enter Administrator Last Name">
                        </div>
                        <div class="form-group">
                            <label>Administrator Phone Number</label>
                            <input type="text" name="admin-number" class="form-control" placeholder="Enter Administrator Phone Number">
                        </div>
                        <div class="form-group">
                            <label>Administrator Email</label>
                            <input type="text" name="admin-email" class="form-control" placeholder="Enter Administrator Email">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary">Add Administrator</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- Delete Administrator Modal -->
    <div id="delete-admins-modal" class="modal fade" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form method="get" action="adminsDelete" id="delete-admin-form">
                    <div class="modal-header">
                        <h3 class="modal-title">Delete Administrator</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <p>Are you sure you want to delete these records?</p>
                        <p class="text-warning"><small>This action cannot be undone.</small></p>
                        <input type="hidden" name="admin-number" id="modal-admin-number"/>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary">Delete</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!--Edit Administrator Modal-->
    <div id="edit-admins-modal" class="modal fade" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form method="post" action="adminsEdit" id="edit-admin-form">
                    <div class="modal-header">
                        <h3 class="modal-title">Edit Administrator</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                    <input type="hidden" name="admin-old-number" id="modal-admin-old-number"/>
                        <div class="form-group">
                            <label>Administrator Name</label>
                            <input type="text" name="admin-new-name" class="form-control" id="modal-admin-new-name">
                        </div>
                        <div class="form-group">
                            <label>Administrator Last Name</label>
                            <input type="text" name="admin-new-lastname" class="form-control" id="modal-admin-new-lastname">
                        </div>
                        <div class="form-group">
                            <label>Administrator Phone Number</label>
                            <input type="text" name="admin-new-telephone" class="form-control" id="modal-admin-new-telephone">
                        </div>
                        <div class="form-group">
                            <label>Administrator Email</label>
                            <input type="text" name="admin-new-email" class="form-control" id="modal-admin-new-email">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary">Edit Administrator</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script>
        $(document).on('click', '[data-target="#delete-admins-modal"]', function () {
            var adminNumEmp = $(this).data('admin-number');

            $('#modal-admin-number').val(adminNumEmp);
        });

        $(document).on('click', '[data-target="#edit-admins-modal"]', function () {
            var adminNumEmp = $(this).data('admin-number');
            var adminPren = $(this).data('admin-name');
            var adminNom = $(this).data('admin-lastname');
            var adminTelephone = $(this).data('admin-telephone');
            var adminEmail = $(this).data('admin-email');

            $('#modal-admin-old-number').val(adminNumEmp);
            $('#modal-admin-new-number').val(adminNumEmp);
            $('#modal-admin-new-name').val(adminPren);
            $('#modal-admin-new-lastname').val(adminNom);
            $('#modal-admin-new-telephone').val(adminTelephone);
            $('#modal-admin-new-email').val(adminEmail);

        });
    </script>
</body>
</html>