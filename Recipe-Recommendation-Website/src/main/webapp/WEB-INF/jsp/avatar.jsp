<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport"
    content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="css/avatar.css">
    <title>MetaLife</title>
  </head>
	<body>
		<img src="images/logo.png"/>
    	<h2>Generate Avatar</h2>
		<form method="post" enctype="multipart/form-data">
			<img id="preview"/>
			<div>
				<label for="selectimage" class="button">
					<P></P>
					<div style="line-height: 40px; text-align: center;  margin: auto; width: 150px; height: 40px; color: #FFFFFF; background: #8d21ae;">Select Image</div>
				</label>
				<input type="file" id="selectimage" style="display: none;" accept="image/*">
			</div>
			<div>
				<label class="button">
					<P></P>
					<div style="line-height: 40px; text-align: center;  margin: auto; width: 150px;height: 40px; color: #FFFFFF; background: #8d21ae;">Start Generate</div>
				</label>
			</div>
		</form>

		<script>

			let preview = document.getElementById('preview');
			let selectimage = document.getElementById('selectimage');

			selectimage.addEventListener("change", function() {
				preview.style.backgroundImage = '';
				let file = selectimage.files[0];
				let reader = new FileReader();
				reader.readAsDataURL(file);
				reader.onload = function(event) {
					let imgsrc= event.target.result;
					preview.src = imgsrc
				};
			});

		</script>

	</body>
</html>
