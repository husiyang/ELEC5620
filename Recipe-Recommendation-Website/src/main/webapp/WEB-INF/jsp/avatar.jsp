<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport"
    content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="css/avatar.css">
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="js/main.js"></script>
    <title>MetaLife</title>
  </head>
	<body>
		<img src="images/logo.png"/>
    	<h2>Generate Avatar</h2>
		<form method="post" enctype="multipart/form-data" id="avatarForm">
			<img id="preview"/>
			<div>
				<label for="selectimage" class="button" onclick="uploadAvatar()">
					<P></P>
					<div style="line-height: 40px; text-align: center;  margin: auto; width: 150px; height: 40px; color: #FFFFFF; background: #8d21ae;">Select Image</div>
				</label>
				<input type="file" id="selectimage" style="display: none;" accept="image/*">
			</div>
			<div>
				<label class="button" id="generate">
					<P></P>
					<div style="line-height: 40px; text-align: center;  margin: auto; width: 150px;height: 40px; color: #FFFFFF; background: #8d21ae;">Start Generate</div>
				</label>
			</div>
		</form>

	</body>
</html>
