
	<main>
	<div class = "ss-menu">
		<div class="war-head-menu">
			<div class="war-head-menu-products">
				<ul class="war-head-menu-products-items">
					<li class="menu-items"><a href="./"><i class="fa fa-users"></i> Company</a></li>
					<li><a href=""><i class="fa fa-id-card"></i> Club</a></li>
					<li><a href=""><i class="fa fa-street-view"></i> Stores</a></li>
					<li><a href=""><i class="fa fa-address-book"></i> Contacts</a></li>
				</ul>
			</div>
			<div class="war-head-menu-logo">
					<a><i class="fa fa-wpexplorer"></i></a>
			</div>
			<div class="war-head-menu-support">
				<ul class="war-head-menu-support-items">
					<li><a href="./telescopes"><i class="fa fa-star-o"></i> Production</a></li>
					<li><a href=""><i class="fa fa-bicycle"></i> Delivery</a></li>
					<li><a><i class="fa fa-shopping-bag p-l-r-5"></i> Cart</a>
						<div class = "goods-cart">
							<div class = "goods-cart-cells">
								<form class="carts" action="./listOrder">
									<c:forEach items="${sessionScope.cart}" var="item">
										<div class = 'cart-cell' id='${item.key.id}'>
											<div><img src='./resources/static/img/telescopes/${item.key.linkImg}'></div>
											<div>
												<div class='price-delete'>
													<div>${item.key.name}</div>
													<div>${item.key.price}</div>
													<div><input type='number' class = 'order' value = '1' id='${item.key.id}' min='1' max='10'></div>
												</div>
											</div>
											<div><i class='fa fa-times' style='color: red;' id='${item.key.id}' ></i></div>
										</div>
									</c:forEach>
							</div>	
							<div>
								<input class = "buttom-cart" type="submit" name="order">
							</div>
							</form>
						</div>
						
					</li>
					

					<c:choose>
					    <c:when test="${sessionScope.user == null}">
					        <li class="reg-auto">
								<span>
									<i class="fa fa-user-circle-o p-l-r-5"></i> Sing in
								</span>
							</li>
					    </c:when>
					    <c:when test="${sessionScope.user != null}">
					        <li>
								<span>
									<i class="fa fa-user-circle-o p-l-r-5"></i>Hello, ${sessionScope.user.firstName}
									<ul class='submenu'>
										<li><a href='./account'>Account</a></li>
										<li><a href='' class="js_logout_account">Exit</a></li>
									</ul>
								</span>
							</li>
					    </c:when>
					</c:choose>
				</ul>
			</div>
		</div>
	</div>
	</main>
		<div class="overlay js-overlay-campaing">
					    <div class="wrap-login  js-popup-campaing">
				        	<div class="scene">
				            	<div class="card">
						            <div class="card-face card-face-front">
							            <form method = "post"  class= "auth" >
								            <span class="login-form-title p-b-26">
								                Welcome
								            </span>
								            <span class="login-form-title p-b-26">
								                	<i class="fa fa-wpexplorer"></i>
								             </span>
								             
						                     <span class="login-form-res p-b-26">
								               		
								             </span>



						                  	<div class="wrap-input">
						                     	<input class="input p-l-r-5" type="text" name="emailLog" value="" > 
						                     	<span class="focus-input" placeholder="Email"></span>
						                  	</div>
						                  	<div class="error m-b-15">
						                    	<span id='errorEmail'></span>
						                  	</div>


						                  	<div class="wrap-input">
						                      	<span class="btn-show-pass">
						                        	<i class="zmdi zmdi-eye"></i>
						                      	</span>
						                      	<input class="input p-l-r-5" type="password" name="passwordLog" >
						                      	<span class="focus-input" placeholder="Password"></span>
						                  	</div>
						                  	<div class="error m-b-17">
						                    	<span id="errorPassword"></span>
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
					                	<form method = "post" class="reg">
						                  	<span class="login-form-title p-b-10">
						                    REGISTRATION
						                  	</span>


						                  	<div class="wrap-input">
						                     	<input class="input p-l-r-5" type="text" name="loginReg" value=""> 
						                     	<span class="focus-input" placeholder="Login"></span>
						                  	</div>
						                  	<div class="error">
						                   	 	<span id="errorLoginReg"></span>
						                  	</div>


						                   	<div class="wrap-input">
						                      	<span class="btn-show-pass">
						                        	<i class="zmdi zmdi-eye"></i>
						                      	</span>
						                      	<input class="input p-l-r-5" type="password" name="passwordReg" >
						                      	<span class="focus-input" placeholder="Password"></span>
						                  	</div>
						                  	<div class="error">
						                    	<span id="errorPasswordReg"></span>
						                  	</div>


						                  	<div class="wrap-input">
						                      	<span class="btn-show-pass">
						                        	<i class="zmdi zmdi-eye"></i>
						                      	</span>
						                      	<input class="input p-l-r-5" type="password" name="re_passwordReg" >
						                      	<span class="focus-input" placeholder="Re-password"></span>
						                 	 </div>
						                  	<div class="error">
						                    	<span id="errorRe_passwordReg"></span>
						                  	</div>


											<div class="wrap-two-box">
							                  	<div class="wrap-input m-r-5">
							                     	<input class="input" type="text" name="firstNameReg" value=""> 
							                     	<span class="focus-input" placeholder="First Name"></span>
							                  	</div>

							                	<div class="wrap-input">
							                     	<input class="input" type="text" name="lastNameReg" value="">
							                     	<span class="focus-input" placeholder="Last Name"></span>
							                  	</div>
							             	</div>
							           		<div class="wrap-two-box">
												<div class="error  m-r-5 width-er">
								                	<span id="errorFirstNameReg"></span>
								            	</div>
								            	<div class="error width-er">
								                    <span id="errorLastNameReg"></span>
								            	</div>
							            	</div>			   



											<div class="wrap-two-box">
									            <div class="wrap-input-age-gender m-r-5">
									                <input class="input" type="number" name="ageReg" min='0' max='100' value="">
									                <span class="focus-input" placeholder="Age"></span>
									            </div>
								                  
								                <div class="wrap-input-age-gender">
									                <select class="input" name="genderReg">
									                   	<option value = "1"></option>
									                   	<option>Female</option>
									                   	<option>Male</option>
									                </select>
									                <span class="focus-input" placeholder="Gender"></span>
								                </div>
											</div>	

											<div class="wrap-two-box">
												<div class="error m-r-5 width-er">
									                <span id="errorAgeReg"></span>
									            </div>
									            <div class="error width-er">
									                <span id="errorGenderReg"></span>
									            </div>
							            	</div>			


											<div class="wrap-input">
						                   		<select class="input js-country" name="countryReg">
													<option value = "1"></option>
												</select> 
						                    	<span class="focus-input" placeholder="Country"></span>
						                  	</div>
						                  	<div class="error">
						                    	<span id="errorCountryReg"></span>
						                  	</div>
						                  
											<div class="wrap-input m-b-15">
												<textarea class="input" name="commentsReg"></textarea>
						                    	<span class="focus-input" placeholder="Comments"></span>
						                 	</div>


											<div class="wrap-two-box">
								                <div class="wrap-box-check-buttom m-r-10 p-t-9">
								                    <span class="span-agreement p-t-6">I accept to the <a href="html/termsOfAnAgreement.html"><i>terms of service</i></a></span> 
								                    <input class="input-ch" type="checkbox" name="checkboxReg">
								                </div>
							                  	
							                	<div class="wrap-box-check-buttom">
								                 	<input class="input-b" type="submit" value="SEND" name="buttomReg">
							                	</div>
											</div>
				     						<div class="error check" >
								                 <span id="errorCheckReg"></span>
								            </div>
								            <div class="text-center-back">
						                    	<span class="txt1">
						                      		Do have an account? <i class="txt2"> Sign in</i>
						                    	</span>
						                  	</div>
								   		</form>
						            </div>
				            	</div>
				        	</div>
						</div>  
					</div>
