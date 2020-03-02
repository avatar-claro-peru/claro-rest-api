/** *********************** trackingstockController - MLL ************************ */
app.controller('trackingstockController', function($scope, $http, $location, $modal, $window, 
		$cookies, $log) {
		
	$scope.trackingstocks = [];
	$scope.trackingstock = {};
	$scope.editTrackingstock = {};
	$scope.currentPageTrackingstock = 1;
	$scope.numPerPageTrackingstock = 20;
	$scope.maxSizeTrackingstock = 20;
	
	
	/** ******************************************************************* */
	/** *********************** CRUD Trackingstock ************************ */
	/** ******************************************************************* */
	$scope.listarTrackingstocks = function() {
		$http({
			method : 'GET',
			url : hostname + apiTrackingstock + 'listar'
		}).then(function(response) {
			$scope.$watch("currentPageTrackingstock + numPerPageTrackingstock", function() {
			    var begin = (($scope.currentPageTrackingstock - 1) * $scope.numPerPageTrackingstock)
			    , end = begin + $scope.numPerPageTrackingstock;   
			    $scope.trackingstocks = response.data.slice(begin, end);
			  });
		}, function(response) {
			$log.info(response.data);
			$log.info(response.status);
		});
	};
		
	$scope.editarTrackingstock = function(trackingstock) {
		$http({
			method : 'GET',
			url : hostname + apiTrackingstock + 'listar/' + trackingstock.id
		}).then(function(response) {
			$scope.editTrackingstock = response.data;
		}, function(response) {
			$log.info(response.status);
		});
		
		$modal.open({
			templateUrl : 'html/modal_update_trackingstock.html',
			controller : 'modalUpdateTrackingstock',
			scope : $scope,
			resolve : {}
		});
	};
	
	$scope.eliminarTrackingstock = function(trackingstock) {
		$http({
			method : 'DELETE',
			url : hostname+ apiTrackingstock + 'eliminar/' + trackingstock.id
		}).then(function(response) {
			$scope.listarTrackingstocks();
		}, function(response) {
			$log.info(response.data);
			$log.info(response.status);
		});
		
	};
	
	$scope.guardarTrackingstock = function() {
		$modal.open({
			templateUrl : 'html/modal_create_trackingstock.html',
			controller : 'modalCreateTrackingstock',
			scope : $scope,
			resolve : {}
		});
	};
	
	
	
	/** ************************************************************ */
	/** *********************** Adicionales ************************ */
	/** ************************************************************ */
											
	$scope.listarTrackingstocks();

});

/** *********************** modalCreateTrackingstock ************************ */
app.controller('modalCreateTrackingstock', function($scope, $http, $modalInstance) {
	
	$scope.trackingstock = {};

	$scope.cancel = function() {
		$modalInstance.dismiss('cancel');
	};
		
	/***Funcion Crear Trackingstock***/
	$scope.btnGuardar = function() {
		
		/** 1.Validacion de campos frontend - INICIO*/
		if ($scope.trackingstock == null) {
				angular.element('#txtCodigo').focus();
				swal({
					  title: "Complete todos los campos...",
					  text: " ",
					  icon: "error",
					  button: false,
					  timer: 1500,
					});
				
		} else if ($scope.trackingstock.stockmaterial == null) {
			angular.element('#txtStockMaterial').focus();
			swal({
				  title: "Ingrese stock para el Equipo.",
				  text: " ",
				  icon: "error",
				  button: false,
				  timer: 1500,
				});
			
		} else if ($scope.trackingstock.stockchip == null) {
			angular.element('#txtStockChip').focus();
			swal({
				  title: "Ingrese stock para el Chip.",
				  text: " ",
				  icon: "error",
				  button: false,
				  timer: 1500,
				});
			
		} else {
			
			/** 2.Validacion en la API - INICIO*/
			$http({
				method : 'POST',
				url : hostname + apiTrackingstock + 'registrar',
				data : $scope.trackingstock
			}).then(function(response) {
				
				if (response.data.codigo == "1" || response.data.codigo == "-1") {
					swal({
						  title: "No se pudo registrar",
						  text: response.data.mensaje,
						  icon: "error",
						  button: false,
						  timer: 2000,
						});
					return false;
				} else {
					swal({
						  title: "Se registró correctamente.",
						  text: " ",
						  icon: "success",
						  button: false,
						  timer: 1500,
						});
					$scope.cancel();
					$scope.listarTrackingstocks();
				}
			});
		}
	};

});

/** *********************** modalUpdateTrackingstock ************************ */
app.controller('modalUpdateTrackingstock', function($scope, $log, $http,$location,
		$modalInstance) {
	
	$scope.trackingstocks = [];
	$scope.trackingstockActualizar = {};

	$scope.cancel = function() {
		$modalInstance.dismiss('cancel');
	};
		
	/***Funcion Editar Trackingstock***/
	$scope.btnActualizar = function() {
		
		$scope.trackingstockActualizar = $scope.editTrackingstock;
		
		$http({
			method : 'PUT',
			url : hostname + apiTrackingstock + 'actualizar',
			data : $scope.trackingstockActualizar
		}).then(function(response) {
			if (response.data.codigo == "1") {
				angular.element('#txtCodigo').focus();
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
				  title: "Se actualizó correctamente.",
				  text: " ",
				  icon: "success",
				  button: false,
				  timer: 1500,
				});
			$scope.trackingstocks.push(response.data);
			$scope.listarTrackingstocks();
			$scope.cancel();
		});
	};

});