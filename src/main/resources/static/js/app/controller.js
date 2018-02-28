var myController = angular.module('myController', []);


//home controller
myController.controller("homeCtrl",['$scope', '$location','User',function($scope, $location,User) {	
	
	init = function() {
		
		User.getPersonDetail().then(function(resJson) {
			
			console.log("###"+JSON.stringify(resJson.data))
			
			//$scope.personDetail=resJson;

		}).catch(function(err) {
			
				console.log(err);
		})
	};
	
	init();
}]);


//accountsByUseTemp Controller

/*myController.controller("accountsByUseTempCtrl",['$scope', '$location',function($scope, $location) {


}]);
*/
//SearchByNuIDTemp Controller

/*myController.controller("SearchByNuIDCtrl",['$scope', '$location',function($scope, $location) {


}]);*/