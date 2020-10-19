'use strict';

/**
 * @ngdoc overview
 * @name fescApp
 * @description
 * # fescApp
 *
 * Main module of the application.
 */
angular
  .module('fescApp', [
    /*'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'*/
    'ngResource',
    'ngRoute',
    'ngAnimate',
    'angular-flash.service', 
    'angular-flash.flash-alert-directive',
    'AppServices'
  ])
  .config(function ($routeProvider,$locationProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .when('/products', {
        templateUrl: 'views/products/product.html',
        controller: 'ProductsCtrl'
      })
      .when('/product-movements', {
        templateUrl: 'views/products/product-movement.html',
        controller: 'ProductMovementsCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });

    // Set HTML5 Styles Urls.
    // $locationProvider
    //   .html5Mode(true);

    $locationProvider.hashPrefix('');
  });
