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
            padding: 100px;
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
    <div class="image-text">
        <img class="elm" src="photo-1587593810167-a84920ea0781.avif" alt="Garage Pro">  <!-- ← CHEMIN EXACT -->
        <div class="elm">
            <h2>Bienvenue au Poulet !</h2>
            <p>Votre spécialiste en production de poulet depuis 2021</p>
            <button>Ajouter au panier</button>
        </div>
    </div>
</body>
</html>