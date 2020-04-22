<%@ page import="com.shop.connectionDB.CountryDB"%>
<%@ page import="com.shop.connectionDB.UserDB"%>
<%@ page import="com.shop.controller.UserValidity"%>
<%@ page import="com.shop.user.User"%>

<%@ page import ="java.util.ArrayList"%>


<!DOCTYPE html>
<html lang="en">
<html>
  <head>
    <title></title>

    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" type="text/css" href="css/registrationForm.css">
    <link rel="stylesheet" type="text/css" href="css/util.css">
  </head>
	<%%>
  <body>


		
	<%    
		String loginLog = request.getParameter("emailLog");
		String passwordLog = request.getParameter("passwordLog");
		
		String loginReg = request.getParameter("loginReg");
		String passwordReg = request.getParameter("passwordReg");
		String re_passwordReg = request.getParameter("re_passwordReg");
		String firstNameReg = request.getParameter("firstNameReg");
		String lastNameReg = request.getParameter("lastNameReg");
		String ageReg = request.getParameter("ageReg");
		String genderReg = request.getParameter("genderReg");
		String countryReg = request.getParameter("countryReg");
		String commentsReg = request.getParameter("commentsReg");
		String termsOfServiceReg = request.getParameter("checkboxReg");
		
		boolean errorLog = false;
		boolean errorReg = false;
		
		if(request.getParameter("buttonLog") != null){
			errorLog = UserValidity.loginAuthorization(loginLog, passwordLog);
		}else if(request.getParameter("buttomReg") != null ){
			errorReg = UserValidity.checkReg(loginReg,passwordReg,re_passwordReg, firstNameReg, lastNameReg, ageReg, genderReg, countryReg, termsOfServiceReg);
		}
		
		
		
		if(loginLog == null && loginReg == null || errorLog || errorReg){%>
	
	<%@ include file = "jsp/res_auth.jsp"%>
    <div class="wrap-login">
        	<div class="scene">
            	<div class="<%= request.getParameter("buttomReg")!= null ? "card is-flipped": "card"%>">
		            <div class="card-face card-face-front">
			            <form method = "post">
				            <span class="login-form-title p-b-26">
				                Welcome
				            </span>
				            <span class="login-form-title p-b-48">
				                <img src="img/logo/logo1.png" alt="Логотип">
				             </span>


		                  	<div class="wrap-input">
		                     	<input class="input p-l-r-5" type="text" name="emailLog" value="<%= request.getParameter("emailLog")== null ? "": request.getParameter("emailLog")%>"> 
		                     	<span class="focus-input" placeholder="Email"></span>
		                  	</div>
		                  	<div class="error m-b-15">
		                    	<span name='errorEmail'><%= errorLog == true ? "email address or password is not correct":""%></span>
		                  	</div>


		                  	<div class="wrap-input">
		                      	<span class="btn-show-pass">
		                        	<i class="zmdi zmdi-eye"></i>
		                      	</span>
		                      	<input class="input p-l-r-5" type="password" name="passwordLog" >
		                      	<span class="focus-input" placeholder="Password"></span>
		                  	</div>
		                  	<div class="error m-b-17">
		                    	<span name="errorPassword"><%= errorLog == true ? "email address or password is not correct":""%></span>
		                  	</div>


		                  	<div class="container-login-form-btn">
		                      	<input type="submit"  value="Login" class="login-form-btn" name="buttonLog">
		                  	</div>

		                  	<div class="text-center">
		                    	<span class="txt1">
		                      		Do no have an account? <i class="txt2"> Sign Up</i>
		                    	</span>
		                  	</div>
		                </form>
	                </div>


	                <div class="card-face card-face-back"> 
	                	<form method = "post">
		                  	<span class="login-form-title p-b-10">
		                    REGISTRATION
		                  	</span>


		                  	<div class="wrap-input">
		                     	<input class="input p-l-r-5" type="text" name="loginReg" value="<%= request.getParameter("loginReg") == null ? "": request.getParameter("loginReg")%>"> 
		                     	<span class="focus-input" placeholder="Login"></span>
		                  	</div>
		                  	<div class="error">
		                   	 	<span name="errorLoginReg"><%= errorReg == true ?  UserValidity.loginValidity(loginReg) : ""%></span>
		                  	</div>


		                   	<div class="wrap-input">
		                      	<span class="btn-show-pass">
		                        	<i class="zmdi zmdi-eye"></i>
		                      	</span>
		                      	<input class="input p-l-r-5" type="password" name="passwordReg" >
		                      	<span class="focus-input" placeholder="Password"></span>
		                  	</div>
		                  	<div class="error">
		                    	<span name="errorPasswordReg"><%= errorReg == true ?  UserValidity.passwordValidity(passwordReg) : ""%></span>
		                  	</div>


		                  	<div class="wrap-input">
		                      	<span class="btn-show-pass">
		                        	<i class="zmdi zmdi-eye"></i>
		                      	</span>
		                      	<input class="input p-l-r-5" type="password" name="re_passwordReg" >
		                      	<span class="focus-input" placeholder="Re-password"></span>
		                 	 </div>
		                  	<div class="error">
		                    	<span name="errorRe_passwordReg"><%= errorReg == true ?  UserValidity.passwordReconciliation(passwordReg, re_passwordReg) : ""%></span>
		                  	</div>


							<div class="wrap-two-box">
			                  	<div class="wrap-input m-r-5">
			                     	<input class="input" type="text" name="firstNameReg" value="<%= request.getParameter("firstNameReg")== null ? "": request.getParameter("firstNameReg")%>"> 
			                     	<span class="focus-input" placeholder="First Name"></span>
			                  	</div>

			                	<div class="wrap-input">
			                     	<input class="input" type="text" name="lastNameReg" value="<%= request.getParameter("lastNameReg")== null ? "": request.getParameter("lastNameReg")%>"> 
			                     	<span class="focus-input" placeholder="Last Name"></span>
			                  	</div>
			             	</div>
			           		<div class="wrap-two-box">
								<div class="error  m-r-5 width-er">
				                	<span name="errorFirstNameReg"><%= errorReg == true ?  UserValidity.checkLength(firstNameReg) : ""%></span>
				            	</div>
				            	<div class="error width-er">
				                    <span name="errorLastNameReg"><%= errorReg == true ?  UserValidity.checkLength(lastNameReg) : ""%></span>
				            	</div>
			            	</div>			   



							<div class="wrap-two-box">
					            <div class="wrap-input-age-gender m-r-5">
					                <input class="input" type="number" name="ageReg" min='0' max='100' value="<%= request.getParameter("ageReg") == null ? "": request.getParameter("ageReg")%>">
					                <span class="focus-input" placeholder="Age"></span>
					            </div>
				                  
				                <div class="wrap-input-age-gender">
					                <select class="input" name="genderReg">
					                   	<option></option>
					                   	<option <%= (request.getParameter("genderReg")!=null && request.getParameter("genderReg").equals("Female")) ? "selected" : ""%>>Female</option>
					                   	<option <%= (request.getParameter("genderReg")!=null && request.getParameter("genderReg").equals("Male")) ? "selected" : ""%>>Male</option>
					                </select>
					                <span class="focus-input" placeholder="Gender"></span>
				                </div>
							</div>	

							<div class="wrap-two-box">
								<div class="error m-r-5 width-er">
					                <span name="errorAgeReg"><%= errorReg == true ?  UserValidity.ageValidity(ageReg) : ""%></span>
					            </div>
					            <div class="error width-er">
					                <span name="errorGenderReg"><%= errorReg == true ?  UserValidity.checkLength(genderReg) : ""%></span>
					            </div>
			            	</div>			


							<div class="wrap-input">
		                   		<select class="input" name="countryReg">
									<%!ArrayList<String> arr = CountryDB.countryAll();%>
									<%for(int i = 0; i < arr.size(); i++){
											out.write("<option " +((request.getParameter("countryReg")!=null && request.getParameter("countryReg").equals(arr.get(i))) ? "selected" : "")+">" + (i == 0 ? "":arr.get(i))+ "</option>");
										}
									%>
								
								</select> 
		                    	<span class="focus-input" placeholder="Country"></span>
		                  	</div>
		                  	<div class="error">
		                    	<span name="errorCountryReg"><%= errorReg == true ?  UserValidity.checkLength(countryReg) : ""%></span>
		                  	</div>
		                  
							<div class="wrap-input m-b-15">
								<textarea class="input" name="commentsReg"><%= request.getParameter("commentsReg") == null? "" : request.getParameter("commentsReg")%></textarea>
		                    	<span class="focus-input" placeholder="Comments"></span>
		                 	</div>


							<div class="wrap-two-box">
				                <div class="wrap-box-check-buttom m-r-35 p-t-9">
				                    <span class="span-agreement p-t-5">I accept to the <a href="html/termsOfAnAgreement.html"><i>terms of service</i></a></span> 
				                    <input class="input-ch" type="checkbox" name="checkboxReg">
				                </div>
			                  	
			                	<div class="wrap-box-check-buttom">
				                 	<input class="input-b" type="submit" value="SEND" name="buttomReg">
			                	</div>
							</div>
     						<div class="error" style='width:60%;'>
				                 <span name="errorCheckReg"><%= errorReg == true ?  UserValidity.checkTermsOfService(termsOfServiceReg) : ""%></span>
				            </div>
	            	</div>
            	</div>
        	</div>
		</div>  
		<%}else{
			if(request.getParameter("buttomReg") != null){
				out.write(UserDB.add(new User(loginReg, passwordReg, firstNameReg, lastNameReg, ageReg, genderReg, countryReg, commentsReg, termsOfServiceReg)) ? "You are registered" : "A user with the same login exists.");
			}else{
				out.write("you are authorized");
			};
		}%>
	</body>
	<script src="js/registrationForm.js"></script>
</html>