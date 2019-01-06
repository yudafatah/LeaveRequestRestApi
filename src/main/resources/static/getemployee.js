GET: $(document).ready(
		function() {

			// GET REQUEST
			$("#getALlBooks").click(function(event) {
				event.preventDefault();
				ajaxGet();
			});

			// DO GET
			function ajaxGet() {
				$.ajax({
					type : "GET",
					url : "profile/employees",
					success : function(result) {
						if (result.status == "success") {
							$('#getResultDiv ul').empty();
							var custList = "";
							$.each(result.data,
									function(i, employee) {
										 custList = "Employee Name  "
												+ employee.employeeName
												+ ", Gender  = " + employee.gender
												+ "<br>";
										$('#getResultDiv .list-group').append(
												custList)
									});
							console.log("Success: ", result);
						} else {
							$("#getResultDiv").html("<strong>Error Showing Data</strong>");
							console.log("Fail: ", result);
						}
					},
					error : function(e) {
						$("#getResultDiv").html("<strong>Error Get URL</strong>");
						console.log("ERROR: ", e);
					}
				});
			}
		})