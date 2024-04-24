$(document).on("click", "#btnagregar", function(){
    $("#txtnombre").val("");
    $("#txtapellido").val("");
    $("#txtemail").val("");
    $('#txtemail').prop('readonly', false);
    $("#txtusuario").val("");
    $('#txtusuario').prop('readonly', false);
    $("#txtpassword").val("");
    $("#hddidusuario").val("0");
    $("#switchusuario" ).hide();
    $("#chkactivo").prop("checked", false);
    $("#divmensajepassword").show();
    $("#btnenviar").hide();
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $.ajax({
            type: "GET",
            url: "/seguridad/usuario/"+$(this).attr("data-usuid"),
            dataType: "json",
            success: function(resultado){
                $("#txtnombre").val(resultado.nombres);
                $("#txtapellido").val(resultado.apellidos);
                $("#txtemail").val(resultado.email);
                $('#txtemail').prop('readonly', true);
                $("#txtusuario").val(resultado.nomusuario);
                $('#txtusuario').prop('readonly', true);
                $("#hddidusuario").val(resultado.idusuario);
                $("#switchusuario").show();
                $("#divmensajepassword").hide();
                $("#btnenviar").show();
                if(resultado.activo){
                    $("#chkactivo").prop("checked", true);
                }else
                    $("#chkactivo").prop("checked", false);
            }
    });
    $("#modalNuevo").modal("show");
});

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/seguridad/usuario",
        contentType: "application/json",
        data: JSON.stringify({
            idusuario: $("#hddidusuario").val(),
            nomusuario: $("#txtusuario").val(),
            nombres: $("#txtnombre").val(),
            apellidos: $("#txtapellido").val(),
            email: $("#txtemail").val(),
            activo: $('#chkactivo').prop('checked')
        }),
        success: function(resultado){
            /*if(resultado.respuesta){
                listarUsuarios();
            }*/
            alert(resultado.mensaje);
        }
    });
    $("#modalNuevo").modal("hide");
});


function listarUsuarios(){
    $.ajax({
        type: "GET",
        url: "/product/listar",
        dataType: "json",
        success: function(resultado){
            $("#tblproducto > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblproducto > tbody").append("<tr>"+
                    "<td>"+value.productid+"</td>"+
                    "<td>"+value.productname+"</td>"+
                    "<td>"+value.unitprice+"</td>"+
                    "<td>"+value.categories.categoryname+"</td>"+
                    "<td>"+value.suppliers.companyname+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-idsala='"+value.productid+"'"+
                                     "data-descsala='"+value.productname+"'"+
                                     "data-asientos='"+value.unitprice+"'"+
                                     "data-idestado='"+value.categories.categoryid+"'"+
                                     "data-idestado='"+value.suppliers.supplierid+"'"+
                                     "data-descontinuado='"+value.discontinued+"'"+
                                     "><i class='fas fa-edit'></i></button>"+
                    "</td></tr>");
            })
        }
    })
}