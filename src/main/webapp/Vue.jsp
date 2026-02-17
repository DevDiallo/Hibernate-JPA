<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
        .image-text {
            display: flex;
            align-items: center;
            gap: 20px;
            padding: 20px;
            width: 100% ; 
            height : 300px 
         }
        .elm {
	        flex : 1 ; 
	        width: 100%;
	        height: 100%
        }
        .image-text img {
            object-fit: cover;
            border-radius: 8px;
        }
        .image-textrgb(34, 243, 44){
            margin: 0;
            color: #333;
        }
    </style>
</head>
<body>
	<div class="panier">
		<h3>Panier : ${NbrElement} poulets</h3>
		<form action="controller" method="GET">
			<button name="voirPanier" type="submit" value="btn-voirPanier">Voir Panier</button>
		</form>
	</div>
    <div class="image-text">
        <img class="elm" src="photo-1587593810167-a84920ea0781.avif" alt="Garage Pro">  <!-- ← CHEMIN EXACT -->
        <div class="elm">
            <h2>Bienvenue au Poulet !</h2>
            <p>Votre spécialiste en production de poulet depuis 2021</p>
            
            <h4>Poids : ${InfoPoulet.poids} Kg</h4>
            <h4>Prix : ${InfoPoulet.prix} EURO</h4>
            <form action="controller" method="GET">
            	<button name="Ajout-Panier" type="submit" value="btn-ajoutPanier">Ajouter au panier</button>
            </form>
        </div>
    </div>
</body>
</html>