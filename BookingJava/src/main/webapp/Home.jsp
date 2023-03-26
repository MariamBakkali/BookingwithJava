<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <!-- Bootstrap Font Icon CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <!-- Custom CSS-->
    <link rel="stylesheet" href="css/styles.css">
    <!-- favicon   -->
    <link rel="icon" type="image/x-icon" href="img/favicon.ico">

    <!-- Font family-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=BIZ+UDPGothic&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Libre+Baskerville:wght@700&display=swap" rel="stylesheet">


<script src="js/jquery.min.js"></script>
<script src="js/jquery-searchbox.js"></script>

    <title>Felizadas</title>
</head>
<body>


    <div class="container-fluid p-5 text-center">
        <h1 class="mt-5">Felizadas</h1>
        <p>Escapadas para ti y para ser feliz.</p>
        <!--span class="colorAzul">: )</span-->
    </div>

    <div class="container imgPortada">
       <!--img src="https://images.unsplash.com/photo-1464822759023-fed622ff2c3b?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=80&raw_url=true&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170" 
       class="imgPortada"/--> 
       <p style="padding-bottom: 17px; margin-right:20px;">:</p><p>)</p>  
    </div>

    <div class="container-fluid pt-5 text-center">
        <p class="my-5 pb-2" style="font-size: 30px; font-weight: bold;">Busca tu momento <span class="colorAzul">feliz</span>.</p>
    </div>


    
    <div class="container">

        <!-- Filtro de búsqueda -->
        <div class="mt-5 mb-5">
            <div class="row gy-2">
                <div class="col-sm-3">
                	<form  action="ServletViaje" method="post">
                    <input type="text" class="form-control col-sm-3 filtroHome bi-chevron-down" list="datalistOptions" id="exampleDataList" placeholder="Destino">
						<datalist id="datalistOptions" name="viajes" class="col-sm-3 filtroHome" >
						    <c:forEach items="${ListaViajes}" var="viaje">
						    
						        <c:out option value="${viaje.precioVia}"/></option>
						        <option value="hola">
							     
						    </c:forEach>
	                    </datalist>
				</form>
                </div>
                
                <!-- Modelo base -->
                <div class="col-sm-3">
                <form  action="ServletViaje" method="post">
                    <input type="text" class="form-control" list="datalistOptions" id="exampleDataList" placeholder="Precio">
						<select id="datalistOptions" name="viajes" class="col-sm-3 filtroHome" >
						    <c:forEach items="${ListaViajes}" var="viaje">
						    
						        <option value="${viaje.idViaje}">${viaje.precioVia}</option>
							     
						    </c:forEach>
	                    </select>
				</form>
                </div>
                <!-- End Modelo base -->
                
                
                <div class="col-sm-3">
                    <input class="filtroHome bi-chevron-down" list="datalistOptions" id="exampleDataList" placeholder="Duración">
                    <datalist id="datalistOptions" class="col-sm-3 filtroHome">
                        <option value="San Francisco">
                        <option value="New York">
                        <option value="Seattle">
                        <option value="Los Angeles">
                        <option value="Chicago">
                    </datalist>
                </div>
                <div class="col-sm-3">
                    <input class="filtroHome bi-chevron-down" list="datalistOptions" id="exampleDataList" placeholder="Hotel">
                    <datalist id="datalistOptions" class="col-sm-3 filtroHome">
                        <option value="San Francisco">
                        <option value="New York">
                        <option value="Seattle">
                        <option value="Los Angeles">
                        <option value="Chicago">
                    </datalist>
                </div>
            </div>      
        </div>
        <!-- End Filtro de búsqueda -->

        
        <div class="mt-5 mb-5">
            <div class="row gy-2">

                <!-- Card (3) -->
                <div class="col-md-4 mb-5">
                    <a href="#"><img class="card-img-top" src="https://www.w3schools.com/bootstrap5/img_avatar1.png" alt="Card image"></a>
                    <div class="card-body">
                        <div class="d-block w-100 float-sm-start">
                            <p class="card-title float-sm-start nombreVia" style="max-width: 65%;">Barcelona Secreta</p>
                            <p class="float-sm-end fw-bold precioVia" style="max-width: 35%;">3333 €</p>
                        </div>
                        <div class="d-block w-100 float-sm-start mb-4">
                            <span class="bi-geo-alt-fill me-3 float-sm-start" style="color:rgb(107, 107, 107)"> Lugar</span>
                            <span class="bi-calendar2-week-fill me-3 float-sm-start" style="color:rgb(107, 107, 107)"> Días</span>
                            <span class="bi-house-fill me-3 float-sm-start" style="color:rgb(107, 107, 107)"> Hotel</span>
                        </div>  
                        <a href="#" class="mt-3 btnInfo">+ info</a>
                        
                    </div>
                </div>
                 <!-- End Card (3)-->
                
            </div>
        </div>
        


	</div>
</body>
</html>