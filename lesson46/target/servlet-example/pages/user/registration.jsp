<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<div>

    <!--<form action="<%=request.getServletContext().getContextPath()%>/user/registration" method="post">-->
        <!---->
    <!--</form>-->

    <form class="form-horizontal" action='' method="POST">
        <fieldset>
            <div id="legend">
                <legend class="">Register</legend>
            </div>

            <div class="control-group">
                <!-- Login -->
                <label class="control-label"  for="login">Login</label>
                <div class="controls">
                    <input type="text" id="login" name="login" placeholder="" class="input-xlarge">
                    <p class="help-block">Login can contain any letters or numbers, without spaces</p>
                </div>
            </div>

            <div class="control-group">
                <!-- E-mail -->
                <label class="control-label" for="email">E-mail</label>
                <div class="controls">
                    <input type="text" id="email" name="email" placeholder="" class="input-xlarge">
                    <p class="help-block">Please provide your E-mail</p>
                </div>
            </div>

            <div class="control-group">
                <!-- Password-->
                <label class="control-label" for="password">Password</label>
                <div class="controls">
                    <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
                    <p class="help-block">Password should be at least 4 characters</p>
                </div>
            </div>

            <div class="control-group">
                <!-- Password -->
                <label class="control-label"  for="password_confirm">Password (Confirm)</label>
                <div class="controls">
                    <input type="password" id="password_confirm" name="password_confirm" placeholder="" class="input-xlarge">
                    <p class="help-block">Please confirm password</p>
                </div>
            </div>

            <div class="control-group">
                <!-- Role -->
                <label class="control-label" for="user-role">User role</label>

                <div id="user-role">
                    <div class="controls">
                        <span>Admin</span><input type="radio" id="user-role-admin" name="user-role" placeholder=""
                                                 class="input-xlarge">

                        <span>Simple</span><input type="radio" id="user-role-simple" name="user-role" placeholder=""
                                                  class="input-xlarge" checked>
                    </div>
                </div>
            </div>




            <div class="control-group">
                <!-- Button -->
                <div class="controls">
                    <button class="btn btn-success" id="registerBtn">Register</button>
                </div>
            </div>




        </fieldset>
    </form>

</div>


<script src="registration.js"></script>

</body>
</html>