(function() {
  'use strict';

  angular.module('sahajApp.PurchaseOrder')
    .controller('PurchaseOrderCtrl', ['$scope','$http', function($scope,$http,SweetAlert) {
    
  ;
  
 
  
	
  $scope.re={};
  $scope.table1={};
  $scope.table2={};
  $scope.po={};
  $scope.PoList={};
  
  
  
  $scope.addpo = function(){
	  
		$scope.PoForm=true;
	};

	$scope.backToPoList = function(){
		$scope.PoForm=false;
		 $scope.invalid=true;
		 
	};
  
   
	$scope.PoListAll = function() {
	
		$http({
			method : 'GET',
			url : '/getpolist'
		}).success(function(data, status, headers, config) {
			$scope.PoList = data;
			//console.log(data);
		}).error(function(data, status, headers, config) {
			alert("failure");
		});
		
	};
  
  
	
	$scope.valid=function(){
		

		$http({
			method : 'GET',
			url : '/valid'
		}).success(function(data, status, headers, config) {
			 $scope.invalid=false;
			 if(data==true)
				 {
				 $scope.invalid=true;
				 alert("Invalid re11 or Expired");
				 }
			 
			//console.log(data);
		}).error(function(data, status, headers, config) {
			//alert("failure");
		});
	};
  
  
  
   $scope.clear=function(){
	   $scope.pdftable=false; 
	   $scope.producttable=false;
	   $scope.producttablecat=false;
	   $scope.re=null;
	   
		$http({
			method : 'GET',
			url : '/cleardata'
		}).success(function(data, status, headers, config) {
			
			 
		}).error(function(data, status, headers, config) {
			//alert("failure");
		});
		
   };

  $scope.getproducttable=function(){

		$http({
			method : 'GET',
			url : '/getfiledata'
		}).success(function(data, status, headers, config) {
			$scope.re = data[0];
		 
			console.log(data[0]);
		
			 if ($scope.re=='') {
			    $scope.pdftable=false;
			  }
			else
				{
				$scope.pdftable=true;
				}
			
			
			 
		}).error(function(data, status, headers, config) {
			//alert("failure");
		});
		
		
	
	 
		
		$http({
			method : 'GET',
			url : '/gettabledata'
		}).success(function(data1, status, headers, config) {
			$scope.table1 = data1;
			
			if ($scope.table1=='') {
			    $scope.producttable=false;
			  }
			else
				{
				$scope.PoForm=true;
				  $scope.producttable=true;
				}
			 
		}).error(function(data1, status, headers, config) {
			//alert("failure");
		});
	 
		
		
	/*	$http({
			method : 'GET',
			url : '/gettable2data'
		}).success(function(data, status, headers, config) {
			$scope.table2 = data;
			
			if ($scope.table2=='') {
			    $scope.producttablecat=false;
			  }
			else
				{
				  $scope.producttablecat=true;
				}
			 
		}).error(function(data, status, headers, config) {
			//alert("failure");
		});	*/
		
		
	  
  };
  
  $scope.getpocontract=function(){
	  
		$http({
			method : 'GET',
			url : '/getpocontract'
		}).success(function(data, status, headers, config) {
			$scope.po = data[0];
			 
		}).error(function(data, status, headers, config) {
			alert("failure");
		});
  
  };
  
	
	$scope.savedata = function() {
		$scope.formData = JSON.stringify($scope.po);

		var response = $http.post('savepocontract',$scope.formData);
		response.success(function(data, status, headers,
		config) {
			alert("Saved successfully......!");
	
});
		response.error(function(data, status, headers,
		config) {
			console.log(data);
		
});
	};
	
        
    }])
})();