(function() {
  'use strict';

  angular.module('sahajApp.Item')
    .controller('ItemCtrl', ['$scope','$http', function($scope,$http) {
     
    	
    	$scope.item={};
    	$scope.saleRate={};
    	$scope.saleRateList=[];
    	$scope.companyDetailsList = {};
    	$scope.saleRateList.stateId=[];
    	$scope.item.equivalentItemId=[];
    	$scope.item.equiItem=[];
 
    	$scope.showItemForm = function() {
//    		angular.element('#tabTwo').removeClass("active");
//    		angular.element('#tabOne').addClass("active");
//    		angular.element('#liTwo').removeClass("active");
//    		angular.element('#liOne').addClass("active");
//    		angular.element('#tab2').removeClass("active");
//    		angular.element('#tab1').addClass("active");
//    		angular.element('#next').removeClass("next");
//    		angular.element('#finish').removeClass("finish");
//    		angular.element('#previous').addClass("previous");
    		$scope.getCompanyDetailsList();
    		$scope.getUomList();
    		$scope.getSectorList();
    		$scope.getItemCategoryList();
    		$scope.getStateList();
    		$scope.getItemNameList();
    		$scope.item.activeStatus = "activeStatus";
    		 $scope.item={};
    		$scope.item.saleRateList=[];
    		$scope.saleRateList=[];
    		$scope.saleRateList.length = 0;
    		$scope.itemForm=true;
    		
    		$scope.item.showToSubdealer = 'false';
    		$scope.item.acceptTarget = 'false';
    		$scope.item.dailyStock = 'false';
    		$scope.item.restrictSaleQty = 'false';
    		$scope.item.activeStatus = 'false';
    		
    	};
    	
 	$scope.saveItem = function(itemFormValid) {
 		if(itemFormValid){
 		if($scope.item.showToSubdealer1 == true || $scope.item.showToSubdealer2 == true){
			  $scope.item.showToSubdealer = true;
			} else {
				$scope.item.showToSubdealer = false;
			}
 		
 		if($scope.item.acceptTarget1 == true || $scope.item.acceptTarget2 == true){
			  $scope.item.acceptTarget = true;
			} else {
				$scope.item.acceptTarget = false;
			}
 		
 		if($scope.item.dailyStock1 == true || $scope.item.dailyStock2 == true){
			  $scope.item.dailyStock = true;
			} else {
				$scope.item.dailyStock = false;
			}
 		
 		if($scope.item.restrictSaleQty1 == true || $scope.item.restrictSaleQty2 == true){
			  $scope.item.restrictSaleQty = true;
			} else {
				$scope.item.restrictSaleQty = false;
			}
 		
 		if($scope.item.activeStatus1 == true || $scope.item.activeStatus2 == true){
			  $scope.item.activeStatus = true;
			} else {
				$scope.item.activeStatus = false;
			}
 		
 		
 		
 		
 		console.log($scope.item);
 		
		$scope.item.saleRateList = $scope.saleRateList;
		$scope.item = JSON.stringify($scope.item);
			var response = $http.post('saveItem',$scope.item);
			response.success(function(data, status, headers,
					config) {
				$scope.list = data;
				 $scope.getItemList();
				    $scope.item={};
					$scope.item.saleRateList=[];
				alert("Item Saved Successfully...",'','success');
				 $scope.getItemList();
				    $scope.item={};
					$scope.item.saleRateList=[];
			});
			response.error(function(data, status, headers,
					config) {
				//SweetAlert.swal("Error In Adding Customer Category...",'','error');
			});
 		}else
 			{
 			alert("Enter Valid Data...",'','success');
 			}
		};
		
	
	
	$scope.hideItemForm = function() {
		$scope.itemForm=false;
		$scope.updateItem=false;
	};
	
	$scope.getCompanyDetailsList = function() {
		$http({
			method : 'GET',
			url : '/getCompanyDetailsList'
		}).success(function(data, status, headers, config) {
			
			$scope.companyDetailsList = data;
		}).error(function(data, status, headers, config) {
			console.log("failure");
		});
	};
	
	$scope.getUomList = function() {
		$http({
			method : 'GET',
			url : '/getUomList'
		}).success(function(data, status, headers, config) {
			$scope.uomList = data;
			//console.log("$scope.companyDetailsList======"+JSON.stringify($scope.uomList));
		}).error(function(data, status, headers, config) {
			console.log("failure");
		});
	};
	
	$scope.getSectorList = function() {
		$http({
			method : 'GET',
			url : '/getSectorList'
		}).success(function(data, status, headers, config) {
			$scope.sectorList = data;
		}).error(function(data, status, headers, config) {
			console.log("failure");
		});
	};
	
	$scope.getItemCategoryList = function() {
		$http({
			method : 'GET',
			url : '/getItemCategoryList'
		}).success(function(data, status, headers, config) {
			$scope.itemCategoryList = data;
			//console.log("$scope.companyDetailsList======"+JSON.stringify($scope.itemCategoryList));
		}).error(function(data, status, headers, config) {
			console.log("failure");
		});
	};
	
	$scope.getStateList = function() {
		$http({
			method : 'GET',
			url : '/getStateList'
		}).success(function(data, status, headers, config) {
			$scope.stateList = data;
			//console.log("$scope.companyDetailsList======"+JSON.stringify($scope.itemCategoryList));
		}).error(function(data, status, headers, config) {
			console.log("failure");
		});
	};

	$scope.addStateList = function() { 
	    $scope.addStateListFinal();
	    $scope.saleRate.stateId =  undefined;
	    $scope.saleRate = {};
	    $scope.saleRate = undefined;
	  };

	    $scope.addStateListFinal = function() {
	    	$scope.stateIDComma = $scope.saleRate.stateId.toString();
		    $scope.saleRateList.push({
		      "stateId":$scope.saleRate.stateId,
		      "saleRateWith": $scope.saleRate.saleRateWith,
		      "rate":$scope.saleRate.rate,	      
		      "stateIDComma":$scope.stateIDComma,
		    });
	   
	  };

	 $scope.deleteStateListFinal = function(index){ 
	    $scope.saleRateList .splice(index,1);
		  };
		  
	$scope.getItemNameList = function() {
				$http({
					method : 'GET',
					url : '/getItemNameList'
				}).success(function(data, status, headers, config) {
					$scope.itemNameList = data;
					//console.log("$scope.companyDetailsList======"+JSON.stringify($scope.itemCategoryList));
				}).error(function(data, status, headers, config) {
					console.log("failure");
				});
			};
	
		$scope.getItemList = function() {
				$http({
					method : 'GET',
					url : '/getItemList'
				}).success(function(data, status, headers, config) {
					$scope.itemList = data;
					//console.log($scope.itemList);
				}).error(function(data, status, headers, config) {
					console.log("failure");
				});
			};
			$scope.item.equivalent=[];
			$scope.item.equiItem = [];
			
			$scope.getItemDetails = function(itemId) {
				$scope.formData = JSON.stringify($scope.item);
				$scope.updateItem = true;
				$scope.getCompanyDetailsList();
				$scope.getUomList();
				$scope.getSectorList();
				$scope.getItemCategoryList();
				$scope.getStateList();
				$scope.getItemNameList();
				
				var response = $http.post('getItemDetails',itemId);
				response.success(function(data, status, headers,config) {
					$scope.item = data;	
				   $scope.saleRateList=$scope.item.saleRateList;
				   angular.forEach($scope.saleRateList, function(value, key){       
						 value.stateId =  value.stateIDComma.replace(/, +/g, ",").split(",").map(Number);
					  });
				});
				response.error(function(data, status, headers,config) {
					console.log("+++++++++");
				});
			};
			
			$scope.updateItemMaster = function() {
				
				if($scope.item.showToSubdealer1 == true || $scope.item.showToSubdealer2 == true){
					  $scope.item.showToSubdealer = true;
					} else {
						$scope.item.showToSubdealer = false;
					}
		 		
		 		if($scope.item.acceptTarget1 == true || $scope.item.acceptTarget2 == true){
					  $scope.item.acceptTarget = true;
					} else {
						$scope.item.acceptTarget = false;
					}
		 		
		 		if($scope.item.dailyStock1 == true || $scope.item.dailyStock2 == true){
					  $scope.item.dailyStock = true;
					} else {
						$scope.item.dailyStock = false;
					}
		 		
		 		if($scope.item.restrictSaleQty1 == true || $scope.item.restrictSaleQty2 == true){
					  $scope.item.restrictSaleQty = true;
					} else {
						$scope.item.restrictSaleQty = false;
					}
		 		
		 		if($scope.item.activeStatus1 == true || $scope.item.activeStatus2 == true){
					  $scope.item.activeStatus = true;
					} else {
						$scope.item.activeStatus = false;
					}
				console.log(JSON.stringify($scope.item));
			
				$scope.item.saleRateList = $scope.saleRateList;
				$scope.item = JSON.stringify($scope.item);
					var response = $http.post('updateItem',$scope.item);
					response.success(function(data, status, headers,
							config) {
						$scope.list = data;
						$scope.itemForm=false;
						$scope.updateItem=false;
						alert("Item Updated Successfully...",'','success');
					    $scope.getItemList();
					    $scope.item={};
						$scope.item.saleRateList=[];
					});
					response.error(function(data, status, headers,
							config) {
						//SweetAlert.swal("Error In Adding Customer Category...",'','error');
					});
			};
			
			$scope.deleteItem = function(itemId) {
				$scope.formData = JSON.stringify($scope.item);

				console.log(itemId);
				var response = $http.post('deleteItem',itemId);
				response.success(function(data, status, headers,config) {
				alert("Item Deleted Successfully...",'','success');
				$scope.getItemList();
				});
				response.error(function(data, status, headers,config) {

				});
			};
		
    }])
})();

