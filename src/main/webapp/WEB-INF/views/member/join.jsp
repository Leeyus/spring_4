<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		
		var check =false;
		
		/* $("#id").change(function() {
			check=false;
		}); */
		
		$("#id").blur(function() {
			var id = $(this).val();
			$.get("./idCheck?id="+id, function(result) {
				result = result.trim();//공백제거
				var msg = '사용할수 없는 아이디입니다.';
				if(result != 0){
					msg='사용가능한 아이디입니다.';
					check=true;
				} else{
					check=false;
					$("#id").val('');
				} 
				$("#result").html(msg);
			});
		});
		
		$("#btn").click(function() {
			if(check){
			$("#frm").submit();
			}else{
				alert("중복확인 ㄱㄱ");
			}
		});
	});
	
	
	/* var msg = '${msg}';
	if(msg != ''){
		alert(msg);
	}
	 */
</script>
</head>
<body>
<h1>Member Join</h1>

<form action="./join" method="post" id="frm">
	id : <input type="text" name="id" id="id"><br>
	<p id="result"></p>
	pw: <input type="password" name="pw"><br>
	name: <input type="text" name="name"><br>
	email : <input type="email" name="email"><br>
	phone : <input type="text" name="phone"><br>
	address : <input type="text" name="address"><br>
	<!-- <input type="hidden" value="1" name="grade"> -->
	<input type="button" value="JOIN" id="btn">
</form>






</body>
</html>