<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport"
    content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="css/student.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="js/main.js"></script>
    <title>MetaLife</title>
  </head>
  <body>
    <!--side bar-->
    <div class="side">
        <a href="#Add Friend" onclick="showAddfriend()">Add Friend</a>
        <p></p>
        <a href="#Create New Room" onclick="showCreate()">Create New Room</a>
        <p></p>
        <a href="#Edit Information" onclick="showedit()">Edit Info</a>

        <p>Your Friend</p>
        <button class="refresh" id="refresh" onclick="refresh()">Refresh</button>
        <ul id="friendlist">
            <!--以下为例子，friendlist从数据库那里拿到，后面按照这样的形式来展示-->
            <li class="friend">
                <img class="avatar" src="images/logo.png"/>
                Testing
            </li>
        </ul>
    </div>

    <!---chat area-->
    <div class="chatarea">
        <textarea id="displayarea" readonly></textarea>
        <textarea id="inputarea"></textarea>
        <button type="button">Send</button>
    </div>
    <!--send message using ajax script-->
    <script>

    </script>

    <!---add friend form-->
    <div class="addfriend" id="addfriend">
        <form action="" id="addfriendform" class="addfriendform">
            <h1>Add New Friend</h1>
            <label for="studentid"><b>Student ID</b></label>
                <input type="text" placeholder="Enter student ID" name="studentid" required>

                <div>
                    <input type="submit" value="Submit"/>
                </div>
                <div>
                    <button type="button" onclick="closeAddfriend()">Close</button>
                </div>
        </form>
    </div>

    <!---create new room form-->
    <div class="newroom" id="newroom">
        <form action="" id="newroomform" class="newroomform">
            <h1>Create New Chat Room</h1>
            <button class="loadchatfriend" id="loadchatfriend" onclick="getFriend()">Load Your Friend</button>
            <p></p>
            <div id="loadfriendnewroom">
            <!--以下为例子，friendlist从数据库那里拿到，后面按照这样的形式来展示-->
                <input type="checkbox" name="testing" value="testing"/>
                <label for="testing"> Username testing</label><br>
            </div>
            <p></p>
            <div>
                <input type="submit" value="Submit"/>
            </div>
            <div>
                <button type="button" onclick="closeCreate()">Close</button>
            </div>
        </form>
    </div>

    <!---edit form-->
    <div class="edit" id="edit">
        <form action="" id="editform" class="editform">
            <h1>Edit Your Information</h1>
            <label for="birthday"><b>Birthday</b></label>
            <input id="birthday" type="text" placeholder="dd/mm/yy" name="birthday" required>
            <input type="submit" value="Submit"/>
            <button type="button" onclick="closeEdit()">Close</button>
        </form>
    </div>
</body>
