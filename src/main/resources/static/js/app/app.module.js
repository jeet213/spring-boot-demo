var app = angular.module('app', ['ngRoute', 'myController']);

app.config(function($routeProvider){
	
	$routeProvider
	.when('/', {
		controller: 'homeCtrl',
		templateUrl: '/templates/test.html'
	})
		
});