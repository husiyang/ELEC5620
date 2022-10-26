<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport"
    content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="css/visitor.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="js/main.js"></script>
    <title>MetaLife</title>
  </head>
  <body>
    <!--side bar-->
    <div class="side">
        <p>Your Chat Group</p>
        <button class="refresh" id="refresh" onclick="refreshchat()">Refresh</button>
        <ul id="chatlist">
            <li class="chat" onclick="showChat(this)">Testing Chat!!!</li>
        </ul>
    </div>


    <div class="chatarea" id="chatarea">
      <p id="title"></p>
      <section class="displayarea" id="displayarea"></section>
      <input type="text" class="inputarea" id="inputarea" placeholder="Text here"/>
      <form method="post" enctype="multipart/form-data" id="imageForm">
        <input type="file" id="selectimage" accept="image/*" onchange="sendImg(this)" >
      </form>
      <button type="button" onclick="send()">Send</button>
      <button type="button" onclick="closeChat()">Close</button>
  </div>

</body>
