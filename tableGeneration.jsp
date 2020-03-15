<table border = 1>
<%
	int a = 1; 
	for(int i = 0; i < Integer.parseInt(request.getParameter("rows")); i++){
		out.write("<tr>");
			for(int q = 0; q < Integer.parseInt(request.getParameter("columns")); q++){
				if(a == (int)Math.ceil((Integer.parseInt(request.getParameter("rows"))* Integer.parseInt(request.getParameter("columns"))/2.0))){
					out.write("<td width='20px' height='20px' align='center'>"+a+"</td>");
				}else if (i == 0 || q == 0 ||  i == Integer.parseInt(request.getParameter("rows"))-1 || q == Integer.parseInt(request.getParameter("columns"))-1){
					out.write("<td width='20px' height='20px' align='center' bgcolor='red'>"+a+"</td>");
				}else{
					out.write("<td width='20px' height='20px' align='center' bgcolor='green'>"+a+"</td>");
				}
				a++;
			}
		out.write("</tr>");
	}
%>
</table>