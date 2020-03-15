<form action = "tableGeneration.jsp">
	<table>
		<caption>Create table <br>(enter odd numbers)</caption>
		<tr>
			<td>Rows:</td>
			<td>
				<input type = "text" name = "rows" required pattern="^\d*[13579]$"></input>
			</td>
		</tr>
		<tr>
			<td>Columns:</td>
			<td>
				<input type = "text" name = "columns" required pattern="^\d*[13579]$"></input>
			</td>
		</tr>
		<tr>
			<td></td>
			<td align="right">
				<input type = "submit" value = "CREATE" name = "row"></input>
			</td>
		</tr>
	</table>
</form>