<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page de Log</title>


</head>
<body>
	
	

	


	<form action="<%=request.getContextPath()%>/Login" method="post">


		<div class="container mt-5">
			<div class="row d-flex justify-content-center">
				<div class="col-md-6">
					<div class="card px-5 py-5" id="form1">
						<div class="form-data" v-if="!submitted">
							<div class="forms-inputs mb-4">
							
								<span style="margin-right:20;">Email or username</span>
								
								 <input  autocomplete="off"
									type="text" name="login" v-model="email"
									v-bind:class="{'form-control':true, 'is-invalid' : !validEmail(email) && emailBlured}"
									v-on:blur="emailBlured = true" value="${login }">
								<div class="invalid-feedback">A valid email is required!</div>
							</div>
							<div class="forms-inputs mb-4">
								<span style="margin-right:85;">Password</span> <input autocomplete="off" type="password"
									name="password" v-model="password"
									v-bind:class="{'form-control':true, 'is-invalid' : !validPassword(password) && passwordBlured}"
									v-on:blur="passwordBlured = true" value="${password }">
								<div class="invalid-feedback">Password must be 8
									character!</div>
							</div>
							<div class="mb-3">
								<button v-on:click.stop.prevent="submit"
									class="btn btn-dark w-100">Login</button>
							</div>
							<div class="row" align="center">
								<a href="<%=request.getContextPath()%>/MotDePasse">Mot de
									passe oublié</a> 
								<label for="scales">Se souvenir de moi	<input type="checkbox" id="scales" name="scales"></label>
							
							</div>
							<div class="success-data" v-else>

				<div class="text-center d-flex flex-column">
					 <span class="text-center fs-1"></span>
						<div class="mb-3">
							<a href="<%=request.getContextPath()%>/CreerCompte"><button type="button"
								class="btn btn-dark w-100">S'enregistrer</button></a>
								
						</div>
						<div>
						<a href="<%=request.getContextPath()%>/"><button type="button"
								class="btn btn-dark w-100">Annuler</button></a>
								</div>
				</div>
			</div>
						</div>

					</div>
				</div>
			</div>
		</div>
		
			
		
	</form>


	<script>
    const senha = document.querySelector('.senha');
	const btn = document.querySelector('.btn');

	btn.onclick = () =>
	
	{
		if (senha.type === 'password') 
		{
			senha.type = 'text'
			btn.src = 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR8SA14-A-zoRaiJ2GdUiESsisaFiHNYrUZtjtjZqnth0D_KdfkwzQWIdCjbzhAoYKPTvs&usqp=CAU'
		}
		else
		{
			senha.type = 'password'
			btn.src = 'https://icon-library.com/images/icon-eyes/icon-eyes-12.jpg'
		}
	}
    </script>


</body>
<link rel="stylesheet" href="Style.css">
<link rel="stylesheet"
	href=" https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/vue@2.6.12/dist/vue.js">

</html>