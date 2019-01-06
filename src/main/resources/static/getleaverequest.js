/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
GET: $(window).on('load',
        function () {

            // GET REQUEST
//			$("#getALlBooks").click(function(event) {
//				event.preventDefault();
            ajaxGet();
//			});

            // DO GET
            function ajaxGet() {
                $.ajax({
                    type: "GET",
                    url: "lr/leaverequests",
                    success: function (result) {
                        if (result.status == "success") {
                            $('#getResultDiv ul').empty();
                            var custList = "";
                            $.each(result.data,
                                    function (i, lr) {
//                                        var tr = $('<tr/>');
//                                        $(tr).append("<td>" + lr. + "</td>");
//                                        $(tr).append("<td>" + data.report[i].Dia + "</td>");
//                                        $(tr).append("<td>" + data.report[i].Local + "</td>");
//                                        $('.table1').append(tr);
                                    });
                            console.log("Success: ", result);
                        } else {
                            $("#getResultDiv").html("<strong>Error Showing Data</strong>");
                            console.log("Fail: ", result);
                        }
                    },
                    error: function (e) {
                        $("#getResultDiv").html("<strong>Error Get URL</strong>");
                        console.log("ERROR: ", e);
                    }
                });
            }
        })

