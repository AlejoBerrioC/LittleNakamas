<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="static/css/stylesMenu.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>Students Panel: Little Nakamas</title>
</head>
<body>
    <div class="container">
        <div class="table">
            <div class="table-title">
                <div class="row">
                    <h1>Manage <b>Students</b></h1>
                </div>
                <div class="add-delete-boutons">
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#add-student-modal"><img src="static/images/Tables/add.png"><span>Add New Student</span></button>
                    <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#delete-student-modal"><img src="static/images/Tables/deleteT.png"><span>Delete</span></button>
                </div>
            </div>
            <div class="table-content">
                <table>
                    <thead>
                    <th></th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Last Name</th>
                    <th>Age</th>
                    <th>Parent</th>
                    <th>Actions</th>
                    </thead>
                    <tbody>
                        <tr>
                            <td>
                                <span class="checkbox">
                                    <input type="checkbox" id="checkbox1">
                                    <label for="checkbox1"></label>
                                </span>
                            </td>
                            <td>1</td>
                            <td>John</td>
                            <td>Doe</td>
                            <td>2</td>
                            <td>John Doe</td>
                            <td>
                                <a title="Edit" data-toggle="modal" data-target="#edit-student-modal"><img src="static/images/Tables/edit.png"></a>
                                <a title="Delete" data-toggle="modal" data-target="#delete-student-modal"><img src="static/images/Tables/delete.png"></a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <span class="checkbox">
                                    <input type="checkbox" id="checkbox2">
                                    <label for="checkbox2"></label>
                                </span>
                            </td>
                            <td>2</td>
                            <td>Juan</td>
                            <td>Berrio</td>
                            <td>3</td>
                            <td>Liliana Castaneda</td>
                            <td>
                                <a title="Edit" data-toggle="modal" data-target="#edit-student-modal"><img src="static/images/Tables/edit.png"></a>
                                <a title="Delete" data-toggle="modal" data-target="#delete-student-modal"><img src="static/images/Tables/delete.png"></a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    

    <!-- Add Student Modal -->
    <div id="add-student-modal" class="modal fade" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form>
                    <div class="modal-header">
                        <h3 class="modal-title">Add New Student</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Student Name</label>
                            <input type="text" class="form-control" placeholder="Enter Student Name">
                        </div>
                        <div class="form-group">
                            <label>Student Last Name</label>
                            <input type="text" class="form-control" placeholder="Enter Student Last Name">
                        </div>
                        <div class="form-group">
                            <label>Student Age</label>
                            <input type="text" class="form-control" placeholder="Enter Student Age">
                        </div>
                        <div class="form-group">
                            <label>Student Parent</label>
                            <input type="text" class="form-control" placeholder="Enter Student Parent">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary">Add Student</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- Delete Student Modal -->
    <div id="delete-student-modal" class="modal fade" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form>
                    <div class="modal-header">
                        <h3 class="modal-title">Delete Student</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <p>Are you sure you want to delete these records?</p>
                        <p class="text-warning"><small>This action cannot be undone.</small></p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary">Delete</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!--Edit Student Modal-->
    <div id="edit-student-modal" class="modal fade" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form>
                    <div class="modal-header">
                        <h3 class="modal-title">Edit Student</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Student Name</label>
                            <input type="text" class="form-control" placeholder="Enter Student Name">
                        </div>
                        <div class="form-group">
                            <label>Student Last Name</label>
                            <input type="text" class="form-control" placeholder="Enter Student Last Name">
                        </div>
                        <div class="form-group">
                            <label>Student Age</label>
                            <input type="text" class="form-control" placeholder="Enter Student Age">
                        </div>
                        <div class="form-group">
                            <label>Student Parent</label>
                            <input type="text" class="form-control" placeholder="Enter Student Parent">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn btn-primary">Edit Student</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>