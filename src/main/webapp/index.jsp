<html ng-app="app">
<head>
  <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css"/>
</head>
<body ng-controller="MainCtrl" class="container">

<div class="menu-container">
  <b>Menu: </b>
  <a ng-repeat="menu in menuList"
     ng-href="{{ '#' + menu.url }}">
    {{ menu.text }}
  </a>
</div>

<main ng-view></main>

<script src="bower_components/angular/angular.min.js"></script>
<script src="bower_components/angular-route/angular-route.min.js"></script>
<script src="bower_components/angular-messages/angular-messages.min.js"></script>
<script src="js/menu.js"></script>
<script src="js/index.js"></script>
<script src="component/product/productController.js"></script>
<script src="component/product/productService.js"></script>
<script src="component/product/ProductCategoryService.js"></script>
<script src="component/cart/cartService.js"></script>
<script src="component/cart/cartController.js"></script>

</body>
</html>
