
var myService = angular.module('myService', ['ngCookies']);

app.factory("User", ['$http', '$location', '$q', function($http, $location, $q) {
	
	var user = {};
	
	user.getPersonDetail = function() {
		console.log("hello hi")
			return	$http.get("https://order-checkout-service.cfapps.io/customerOrder/v1/cancelOrder?orderReferenceNumber=ORN-20171028044402746").then(function(resJson) {
				console.log(resJson.data.status);
				if (!resJson.data.status){
					return $q.reject();
				}else{
					return resJson.data;
				}
			}).catch(function(err) {
				console.log(err)
				return $q.reject(err);
				
			});
		return true;
	};
		
	return user;
}]);