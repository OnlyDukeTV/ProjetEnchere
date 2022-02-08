<!DOCTYPE html>
<html>
  <head>
    <title>Enregistrement</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
    <style>
      html, body {
      min-height: 100%;
      }
      body, div, form, input, select, p { 
      padding: 0;
      margin: 0;
      outline: none;
      font-family: Roboto, Arial, sans-serif;
      font-size: 16px;
      color: #eee;
      }
      body {
      background: url("/uploads/media/default/0001/01/b5edc1bad4dc8c20291c8394527cb2c5b43ee13c.jpeg") no-repeat center;
      background-size: cover;
      }
      h1, h2 {
      text-transform: uppercase;
      font-weight: 400;
      }
      h2 {
      margin: 0 0 0 8px;
      }
      .main-block {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      height: 100%;
      padding: 25px;
      background: rgba(0, 0, 0, 0.5); 
      }
      .left-part, form {
      padding: 25px;
      }
      .left-part {
      text-align: center;
      }
      .fa-graduation-cap {
      font-size: 72px;
      }
      form {
      background: rgba(0, 0, 0, 0.7); 
      }
      .title {
      display: flex;
      align-items: center;
      margin-bottom: 20px;
      }
      .info {
      display: flex;
      flex-direction: column;
      }
      input, select {
      padding: 5px;
      margin-bottom: 30px;
      background: transparent;
      border: none;
      border-bottom: 1px solid #eee;
      }
      input::placeholder {
      color: #eee;
      }
      option:focus {
      border: none;
      }
      option {
      background: black; 
      border: none;
      }
      .checkbox input {
      margin: 0 10px 0 0;
      vertical-align: middle;
      }
      .checkbox a {
      color: #26a9e0;
      }
      .checkbox a:hover {
      color: #85d6de;
      }
      .btn-item, button {
      padding: 10px 5px;
      margin-top: 20px;
      border-radius: 5px; 
      border: none;
      background: #26a9e0; 
      text-decoration: none;
      font-size: 15px;
      font-weight: 400;
      color: #fff;
      }
      .btn-item {
      display: inline-block;
      margin: 20px 5px 0;
      }
      button {
      width: 100%;
      }
      button:hover, .btn-item:hover {
      background: #85d6de;
      }
      @media (min-width: 568px) {
      html, body {
      height: 100%;
      }
      .main-block {
      flex-direction: row;
      height: calc(100% - 50px);
      }
      .left-part, form {
      flex: 1;
      height: auto;
      }
      }
    </style>
  </head>
  <body>
    <div class="main-block">
      <div class="left-part">
        <i class="fas fa-graduation-cap"></i>
        <h1>Register</h1>      
      </div>
        <form action="<%=request.getContextPath()%>/CreerCompte" method="post">
        <div class="title">
          <i class="fas fa-pencil-alt"></i> 
          <h2>Register here</h2>
        </div>
        <div class="info">
         
        
            <div class="row mt-2">
                <div class="col-md-6">
                    <label class="labels">Pseudo</label><input type="text"
                        class="form-control" name="pseudo"
                        value="${utilisateur.pseudo}">
                </div>
                <div class="col-md-6">
                    <label class="labels">Nom</label><input type="text"
                        class="form-control" name="nom" value="${utilisateur.nom}">
                </div>
                <div class="col-md-6">
                    <label class="labels">Pr�nom</label><input type="text"
                        class="form-control" name="prenom"
                        value="${utilisateur.prenom}">
                </div>
                <div class="col-md-12">
                    <label class="labels">Email/Login</label><input type="text"
                        class="form-control" name="email" value="${utilisateur.email}">
                </div>
               



            </div>
            <div class="row mt-2">
                <div class="col-md-12">
                    <label class="labels">Num�ro Mobile</label><input type="text"
                        class="form-control" name="telephone"
                        value="${utilisateur.telephone}">
                </div>
                <div class="col-md-12">
                    <label class="labels">Address </label><input type="text"
                        class="form-control" name="rue" value="${utilisateur.rue}">
                </div>
                <div class="col-md-12">
                    <label class="labels">Code Postale</label><input type="text"
                        class="form-control" name="codePostal"
                        value="${utilisateur.codePostal}">
                </div>
                <div class="col-md-12">
                    <label class="labels">Ville</label><input type="text"
                        class="form-control" name="ville" value=" ${utilisateur.ville}">
                </div>
                <div class="col-md-12">
                    <label class="labels">Mot de passe</label><input
                        type="text" class="form-control" name="password" required>
                </div>
                <div class="col-md-12">
                    <label class="labels">Confirmation mot de passe</label><input
                        type="text" class="form-control" name="password_conf">
                </div>
            </div>

            <div class="mt-5 text-center">
                <button class="btn btn-primary profile-button" type="submit">S'enregistrer</button>
                  <a href="<%=request.getContextPath()%>/AccueilNonConnecter" >
                 <button class="btn btn-primary profile-button" type="button">Annuler</button>
                 </a>
            </div>
            

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

        </div>
        
          
        </div>

       
  </body>
</html>