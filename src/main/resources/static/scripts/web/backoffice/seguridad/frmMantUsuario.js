$(document).on("click", "#btnagregar", function(){
    $("#txtnombre").val("");
    $("#txtapellido").val("");
    $("#txtemail").val("");
    $("#txtusuario").val("");
    $("#txtpassword").val("");
    $("#hddidusuario").val("0");
    $("#switchusuario" ).hide();
    $("#chkactivo").prop("checked", false);
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
                $("#txtusuario").val(resultado.nomusuario);
                $("#hddidusuario").val($(this).attr("data-usuid"));
                $("#switchusuario").show();
                if(resultado.activo){
                    $("#chkactivo").prop("checked", true);
                }else
                    $("#chkactivo").prop("checked", false);
            }
    });
    /*$("#txtapellido").val($(this).attr("data-usuape"));
    $("#txtemail").val($(this).attr("data-usuemail"));
    $("#txtusuario").val($(this).attr("data-usuario"));
    $("#txtpassword").val("");
    $("#hddidusuario").val($(this).attr("data-usuid"));
    $("#switchusuario" ).show();
    console.log($(this).attr("data-activo"));
    if($(this).attr("data-activo") === "true"){
        $("#chkactivo").prop("checked", true);
    }else
        $("#chkactivo").prop("checked", false);*/
    $("#modalNuevo").modal("show");
});

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/product/registrar",
        contentType: "application/json",
        data: JSON.stringify({
            productid: $("#hddidprod").val(),
            productname: $("#txtnomproducto").val(),
            unitprice: $("#txtpreciounit").val(),
            categoryid: $("#cbocategoria").val(),
            supplierid: $("#cboproveedor").val(),
            discontinued: $('#chkdescontinuado').prop('checked')
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarUsuarios();
            }
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