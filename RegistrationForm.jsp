<!--Логика, а потом вывод-->
<%
	String[] errorArr = new String[10];
	boolean cherkError = true;
	if(request.getParameter("Login")!= null){
		int amountError=0;
		
		if(request.getParameter("Login").length() == 0 || !request.getParameter("Login").matches("^[a-zA-Z0-9]{1,}"+"((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})*"+"@"+"[a-zA-Z0-9]{1,}"+"((\\.|\\_|-{0,1})[a-zA-Z0-9]{1,})*"+"\\.[a-zA-Z]{2,}$")){	
			errorArr[0] = "Incorrect E-Mail";
			amountError++;
		}
		if(request.getParameter("Name").length() == 0 || !request.getParameter("Name").matches("^[a-zA-Z]+$")){
			errorArr[1] = "Empty name";
			amountError++;
		}
		
		if(request.getParameter("Password").length() == 0 || !request.getParameter("Password").matches("(?=.*[0-9]{2,})(?=.*[a-z]{2,})(?=.*[A-Z]{2,})[0-9a-zA-Z!@#$%^&*]{8,}")){
			errorArr[2] = "Password must contain at least 8 characters, 2 digits, 2 headers only in Latin";
			amountError++;
		}
		if(request.getParameter("Password").length() == 0 || !request.getParameter("Re-password").equals(request.getParameter("Password"))){
            errorArr[3] = "Password mismatch";
			amountError++;
        }
		try{
			if(request.getParameter("Age").length() == 0 || !(Integer.parseInt(request.getParameter("Age"))>=12) || !(Integer.parseInt(request.getParameter("Age"))<=100)){
				errorArr[4] = "Age must be between 12 and 100 years old";
				amountError++;
			}
		}catch(NumberFormatException e){
			errorArr[4] = "Age must be between 12 and 100 years old";
			amountError++;
		}
		
		if(request.getParameter("Gender") == null){
            errorArr[5] = "No gender selected";
			amountError++;
        }
		
		if(request.getParameter("Address").equals("0")){
            errorArr[6] = "No address selected";
        }
		if(request.getParameter("Comments").length() == 0){
            errorArr[7] = "Empty Comments";
			amountError++;
        }
		
		if(request.getParameter("Amigo")== null){
            errorArr[8] = "No agreement";
			amountError++;
        }
		
		if(amountError == 0){
			cherkError = false;
		}
	}
%>

<!--Был применен метод "POST" потому что он скрывает информацию от пользователя при отправке на сервер и не сохранет данные в логах-->
<form method = 'POST' action = ''>
	<table>
		<style>
		   .cell {
			width: 90px;
			padding: 5px;
			border: 1px solid black;
		   }
		</style>
	<%
	if(cherkError){
		String[][] fields = new String[][]{{"Login", "Name","Password", "Re-password", "Age", "Gender", "Address", "Comments", "Amigo", "Registration"}, {"text", "text", "password", "password", "number", "radio","","","checkbox","submit"}};	
		for(int i = 0; i < fields[0].length; i++){
			out.write("<tr><td class='cell'>" + fields[0][i]+":" + "</td> <td align = 'center' class='cell' >");
			if(fields[0][i].equals("Gender")){
				out.write("F<input type = '"+fields[1][i]+"', name = '" + fields[0][i] + "' value='F'/>");
				out.write("M<input type = '"+fields[1][i]+"', name = '" + fields[0][i] + "' value='M'/>");
			}else if(fields[0][i].equals("Address")){
				out.write("<select name='"+fields[0][i]+"'>");
					for(int a = 0; a <= 10; a++) out.write("<option value='"+a+"'>"+ (a==0?"":"Address "+a)  +"</option>");
				out.write("</select>");
			}else if(fields[0][i].equals("Comments")){
				out.write("<textarea name='"+fields[0][i]+"'></textarea>");
			}else{
				out.write("<input type = '"+fields[1][i]+"', name = '" + fields[0][i] + "' "+(fields[0][i].equals("Age")? "min='0' max='100'":"")+(fields[0][i].equals("Registration")? "value = 'SEND'":"")+"/>");
			}
			out.write("</td><td>" + (errorArr[i] == null ? "" : errorArr[i]) + "</td></tr>");			
		}
	}else{
		out.write("You are registered");
	}
	%>
	</table>
</form>	

