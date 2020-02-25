/** *********************** stockonlineController ************************ */
app.controller('stockonlineController', function($scope, $http, $location, $modal, $window, 
		$cookies, $log) {
		
	$scope.stockonlines = [];
	$scope.stockonline = {};
	$scope.editStockonline = {};
	$scope.currentPageStockonline = 1;
	$scope.numPerPageStockonline = 20;
	$scope.maxSizeStockonline = 20;
	
	
	/** ************************************************************ */
	/** *********************** CRUD stockonline ************************ */
	/** ************************************************************ */
	$scope.listarStockonlines = function() {
		$http({
			method : 'GET',
			url : hostname + apiStockonline + 'listar'
		}).then(function(response) {
			$scope.$watch("currentPageStockonline + numPerPageStockonline", function() {
			    var begin = (($scope.currentPageStockonline - 1) * $scope.numPerPageStockonline)
			    , end = begin + $scope.numPerPageStockonline;   
			    $scope.stockonlines = response.data.slice(begin, end);
			  });
		}, function(response) {
			$log.info(response.data);
			$log.info(response.status);
		});
	};
		
	$scope.editarStockonline = function(stockonline) {
		$http({
			method : 'GET',
			url : hostname + apiStockonline + 'listar/' + stockonline.id
		}).then(function(response) {
			$scope.editStockonline = response.data;
		}, function(response) {
			$log.info(response.status);
		});
		
		$modal.open({
			templateUrl : 'html/modal_update_stockonline.html',
			controller : 'modalUpdateStockonline',
			scope : $scope,
			resolve : {}
		});
	};
	
	$scope.eliminarStockonline = function(stockonline) {
		$http({
			method : 'DELETE',
			url : hostname+ apiStockonline + 'eliminar/' + stockonline.id
		}).then(function(response) {
			$scope.listarStockonlines();
		}, function(response) {
			$log.info(response.data);
			$log.info(response.status);
		});
		
	};
	
	$scope.guardarStockonline = function() {
		$modal.open({
			templateUrl : 'html/modal_create_stockonline.html',
			controller : 'modalCreateStockonline',
			scope : $scope,
			resolve : {}
		});
	};
	
	
	
	/** ************************************************************ */
	/** *********************** Adicionales ************************ */
	/** ************************************************************ */
											
	$scope.listarStockonlines();

});



/** *********************** modalCreateStockonline ************************ */
app.controller('modalCreateStockonline', function($scope, $http, $modalInstance) {
	
	$scope.stockonline = {};

	$scope.cancel = function() {
		$modalInstance.dismiss('cancel');
	};
		
	/***Funcion Crear Stockonline***/
	$scope.btnGuardar = function() {
		
		/** 1.Validacion de campos frontend - INICIO*/
		if ($scope.stockonline == null) {
				angular.element('#txtCodigo').focus();
				swal({
					  title: "Ingrese código del estado.",
					  text: " ",
					  icon: "error",
					  button: false,
					  timer: 1500,
					});
				
		} else if ($scope.stockonline.valor == null) {
			angular.element('#txtValor').focus();
			swal({
				  title: "Ingrese valor del Estado.",
				  text: " ",
				  icon: "error",
				  button: false,
				  timer: 1500,
				});
			
		} else {
			
			/** 2.Validacion en la API - INICIO*/
			$http({
				method : 'POST',
				url : hostname + apiStockonline + 'registrar',
				data : $scope.stockonline
			}).then(function(response) {
				
				if (response.data.codigo == "1" || response.data.codigo == "-1") {
					swal({
						  title: "No se pudo registrar el Estado.",
						  text: response.data.mensaje,
						  icon: "error",
						  button: false,
						  timer: 2000,
						});
					return false;
				} else {
					swal({
						  title: "Se registró el Estado correctamente.",
						  text: " ",
						  icon: "success",
						  button: false,
						  timer: 1500,
						});
					$scope.cancel();
					$scope.listarStockonlines();
				}
			});
		}
	};

});

/** *********************** modalUpdateStockonline ************************ */
app.controller('modalUpdateStockonline', function($scope, $log, $http,$location,
		$modalInstance) {
	
	$scope.stockonlines = [];
	$scope.stockonlineActualizar = {};

	$scope.cancel = function() {
		$modalInstance.dismiss('cancel');
	};
		
	/***Funcion Editar Stockonline***/
	$scope.btnActualizar = function() {
		
		$scope.stockonlineActualizar = $scope.editStockonline;
		
		$http({
			method : 'PUT',
			url : hostname + apiStockonline + 'actualizar',
			data : $scope.stockonlineActualizar
		}).then(function(response) {
			if (response.data.codigo == "1") {
				angular.element('#txtCodigoEdit').focus();
				swal({
					  title: "Debes completar los campos correctamente.",
					  text: " ",
					  icon: "error",
					  button: false,
					  timer: 1500,
					});
				return false;
			}
			swal({
				  title: "Se actualizó el Estado.",
				  text: " ",
				  icon: "success",
				  button: false,
				  timer: 1500,
				});
			$scope.stockonlines.push(response.data);
			$scope.listarStockonlines();
			$scope.cancel();
		});
	};

});
