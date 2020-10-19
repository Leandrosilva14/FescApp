'use strict';

var app = angular.module('fescApp')
	.controller('ProductMovementsCtrl', [ '$scope', '$sce', '$store', 'flash', 'ProductService', 'ProductMovementService', 'ListProductMovementByProductService', 'ListProductMovementByTypeService', function ($scope, $sce, $store, flash, productService, productMovementService, listProductMovementByProductService, listProductMovementByTypeService) {

    // Create newMovement
    $scope.newMovement = {};

    $scope.products = [];

    $scope.movementTypeSelected = null;
    $scope.productIdSelected = null;
    $scope.movementsByProductType = [];
    $scope.movementsByProduct = [];

    $scope.loadProducts = function() {
      productService.get(null, null, function(response) {
        $scope.products = response.products;
      }, function(response) {
        showErrorMessages('Erro ao carregar produtos. ', response);
      });
    }

    $scope.onChangeProductType = function() {
      $scope.movementsByProductType = [];
      listProductMovementByTypeService.get({productType: $scope.movementTypeSelected}, null, function(response) { 
        $scope.movementsByProductType = response.summaries;
      }, function(response) {
        showErrorMessages('Erro ao carregar movimentos. ', response);
      });
    }

    $scope.onChangeProduct = function() {
      $scope.movementsByProduct = [];
      listProductMovementByProductService.get({productId: $scope.productIdSelected}, null, function(response) {
        $scope.movementsByProduct = response.summaries;
      }, function(response) {
        showErrorMessages('Erro ao carregar movimentos. ', response);
      });
    }

    $scope.saveMovement = function() {
      productMovementService.post(null, {
        productId: $scope.newMovement.productId,
        type: $scope.newMovement.movementType,
        saleValue: $scope.newMovement.saleValue,
        saleDate: $scope.newMovement.saleDate,
        quantity: $scope.newMovement.movementedQuantity,
      }, function(response){
        flash.success = $scope.newMovement.product + ' foi criado com sucesso.';

        // clean scope from newMovement
        $scope.newMovement = {};

        $scope.movementTypeSelected = "";
        $scope.productIdSelected = "";
        $scope.movementsByProductType = [];
        $scope.movementsByProduct = [];
      }, function(response){
        showErrorMessages('Erro ao criar movimento. ', response);
      });
    }

    var showErrorMessages = function(messageDefault, response) {
        console.log(response);

        var message = messageDefault;

        if(response.status == 401) {
          message += "Não autorizado";
        } else if(response.data && response.data.message) {
          message += response.data.message;
        }

        if(response.data && response.data.errors && response.data.errors.length > 0) {
          response.data.errors.forEach(function(error) {
            message += "<br>" + error;
          });
        }

        flash.error = $sce.trustAsHtml(message);
    }

    $scope.loadProducts();
}]);