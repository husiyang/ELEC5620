<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport"
    content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="css/manager.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="js/main.js"></script>
    <title>MetaLife</title>
  </head>
  <body>
    <!--side bar-->
    <div class="side">
        <a href="#View records" onclick="showViewRecords()">View records</a>
        <p></p>
        <a href="#Create New Room" onclick="showCreate()">Create New Room</a>
        <p></p>
        <a href="#Mute users" onclick="showMuteUsers()">Mute users</a>

        <p>Your Friend</p>
        <button class="refresh" id="refresh" onclick="refresh()">Refresh</button>
        <ul id="friendlist">
            <!--以下为例子，friendlist从数据库那里拿到，后面按照这样的形式来展示-->
            <li class="friend"><img class="avatar" src="/images/logo.png" width="100px" height="100px"/>Testing</li>
        </ul>

        <p>Your Chat Group</p>
        <button class="refresh" id="refresh" onclick="refreshchat()">Refresh</button>
        <ul id="chatlist">
            <li class="chat" onclick="showChat(this)">Testing Chat!!!</li>
        </ul>
    </div>

    <!---chat area 只考虑了发送文字的情况 并且显示中没有显示头像！需要添加！-->
    <div class="chatarea" id="chatarea">
        <p id="title"></p>
        <section class="displayarea" id="displayarea"></section>
        <input type="text" class="inputarea" id="inputarea" placeholder="Text here"/>
        <form method="post" enctype="multipart/form-data" id="imageForm">
            <input type="file" id="selectimage" accept="image/*" onchange="sendImg(this)" >
        </form>
        <section class="groupfriendarea" id="groupfriendarea">
            <h1>Group Friend List</h1>
            <ul class="groupfriendlist" id="groupfriendlist"></ul>
        </section>
        <button type="button" onclick="send()">Send</button>
        <button type="button" onclick="closeChat()">Close</button>
    </div>


    <!---create new room form-->
    <div class="newroom" id="newroom">
        <form action="" id="newroomform" class="newroomform">
            <h1>Create New Chat Room</h1>
            <button class="loadchatfriend" id="loadchatfriend" onclick="getFriend()">Load Your Friend</button>
            <p></p>
            <div id="loadfriendnewroom">
            <!--以下为例子，friendlist从数据库那里拿到，后面按照这样的形式来展示-->
                <input type="checkbox" name="Username" value="testing"/>
                <label for="testing">testing</label><br>
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

    <!---View records-->
    <div class="view" id="view">
        <form action="" id="viewRecords" class="viewRecords">
            <h1>View records</h1>
            <label class="studentid" for="contact_uid"><b>Student ID</b></label>
            <input id="contact_uid" type="text" placeholder="Input Student ID" name="contact_uid" required>
            <button type="button" onclick="submitView()">Submit</button>
            <section class="displayarea" id="displayarea"></section>
            <button type="button" onclick="closeView()">Close</button>
        </form>
    </div>

<!---Mute users-->
<div class="mute" id="mute">
    <form action="" id="muteUsers" class="muteUsers">
        <h1>Mute users</h1>
        <label class="studentid" for="studentid"><b>Student ID</b></label>
        <input id="studentid" type="text" placeholder="Input Student ID" name="contact_uid" required>
        <button type="button" onclick="Mute()">Mute</button>
        <button type="button" onclick="closeMute()">Close</button>
    </form>
</div>
</body>
