<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport"
    content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="css/register.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="js/main.js"></script>
    <title>MetaLife</title>
  </head>
  <body>
    <img src="images/logo.png"/>
    <h2>Create Your Account</h2>
    <form action="" id="registerform" class="registerform">
        <div class="form-group">
            <input class="textbox" type="text" placeholder="Username" name="username"required autofocus>
        </div>
        <P></P>
        <div class="form-group">
            <input id="studentid" class="textbox" type="text" placeholder="Student ID (if applicable)" name="studentid">
        </div>
        <P></P>
        <div class="form-group">
            <input class="textbox" type="password" placeholder="Password" name="password" required>
        </div>
        <p></p>
        <div class="form-group">
            <input class="button" type="submit" value="Register">
        </div>
        <div class="form-group">
            <button onclick="login()" type="button" class="button1" >Already have an account? Login now!</button>
        </div>
    </form>
  </body>
</html>
