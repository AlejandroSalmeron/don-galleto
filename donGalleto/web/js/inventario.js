document.addEventListener('DOMContentLoaded', function () {
    const mobileMenuButton = document.getElementById('mobile-menu');
    const infoWindow = document.getElementById('info-window');
    const content = document.querySelector('.content');

    mobileMenuButton.addEventListener('click', function () {
        if (infoWindow.style.display === 'flex') {
            // Si la ventana de información está abierta, ciérrala
            infoWindow.style.transform = 'translateX(-300px)';
            content.classList.remove('content-shifted');
            mobileMenuButton.classList.remove('menu-toggle-shifted');
            // Espera a que termine la transición antes de ocultar la ventana de información
            setTimeout(() => {
                infoWindow.style.display = 'none';
            }, 300);
        } else {
            // Si la ventana de información está cerrada, ábrela
            infoWindow.style.display = 'flex';
            content.classList.add('content-shifted');
            mobileMenuButton.classList.add('menu-toggle-shifted');
            infoWindow.style.transform = 'translateX(0)';
        }
    });
});


function insertarGalleta() {
    let nombreGalleta = document.getElementById("txtNombreGalleta").value;
    let cantidadGalleta = document.getElementById("txtCantidadGalleta").value;
    let precioGalleta = document.getElementById("txtPrecioGalleta").value;
    let comentario = document.getElementById("txtComentarioGalleta").value;

    let galleta = JSON.stringify({nombre_galleta: nombreGalleta, cantidad_producida: cantidadGalleta, precio_galleta: precioGalleta, comentario: comentario});


    let parametros = new URLSearchParams({datos: galleta});
    fetch("../api/galleta/insertarGalleta",
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                debugger;
                if (data.error)
                    alert(data.error);
                else {

                    Swal.fire({
                        position: 'top-center',
                        icon: 'success',
                        title: 'Guardado correctamente',
                        showConfirmButton: false,
                        timer: 1500
                    });
                }
            });
}


function obtenerDatosGalleta(event) {
    debugger;
    var id;
    var botonPresionado = event.target;

    // Verificar si el clic ocurrió en el botón específico
    if (botonPresionado.id === 'btnn1') {
        id = "1";
    } else if (botonPresionado.id === 'btnn2') {
        id = "2";
    } else if (botonPresionado.id === 'btnn3') {
        id = "3";
    } else if (botonPresionado.id === 'btnn4') {
        id = "4";
    } else if (botonPresionado.id === 'btnn5') {
        id = "5";
    } else if (botonPresionado.id === 'btnn6') {
        id = "6";
    } else if (botonPresionado.id === 'btnn7') {
        id = "7";
    } else if (botonPresionado.id === 'btnn8') {
        id = "8";
    } else if (botonPresionado.id === 'btnn9') {
        id = "9";
    } else if (botonPresionado.id === 'btnn10') {
        id = "10";
    }

    let parametros = new URLSearchParams({id: id});
    fetch('../api/galleta/getGalleta',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                if (data.error) {
                    alert(data.error);
                } else {
                    cargarFormGalleta(data);
                }
            });
}

let galleta;
let id_galleta;
function cargarFormGalleta(data) {
//alert(i);
    galleta = data;
    document.getElementById("txtNombreGalleta2").value = galleta.nombre_galleta;
    document.getElementById("txtCantidadGalleta2").value = galleta.cantidad_producida;
    document.getElementById("txtPrecioGalleta2").value = galleta.precio_galleta;
    document.getElementById("txtComentarioGalleta2").value = galleta.comentario;
    id_galleta = galleta.id_galleta;
}


function getAllGalletas() {
    fetch('../api/galleta/getAllGalletas',
            {
                method: 'GET',
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                if (data.error) {
                    alert(data.error);
                } else {
                    cargarLabelGalleta(data);
                }
            });
}

function cargarLabelGalleta(data) {
    galleta = data;
    var miLabel = document.getElementById('lbll1');
    miLabel.textContent = galleta[0].cantidad_producida;
    var miLabel2 = document.getElementById('lbll2');
    miLabel2.textContent = galleta[1].cantidad_producida;
    var miLabel3 = document.getElementById('lbll3');
    miLabel3.textContent = galleta[2].cantidad_producida;
    var miLabel4 = document.getElementById('lbll4');
    miLabel4.textContent = galleta[3].cantidad_producida;
    var miLabel5 = document.getElementById('lbll5');
    miLabel5.textContent = galleta[4].cantidad_producida;
    var miLabel6 = document.getElementById('lbll6');
    miLabel6.textContent = galleta[5].cantidad_producida;
    var miLabel7 = document.getElementById('lbll7');
    miLabel7.textContent = galleta[6].cantidad_producida;
    var miLabel8 = document.getElementById('lbll8');
    miLabel8.textContent = galleta[7].cantidad_producida;
    var miLabel9 = document.getElementById('lbll9');
    miLabel9.textContent = galleta[8].cantidad_producida;
    var miLabel10 = document.getElementById('lbll10');
    miLabel10.textContent = galleta[9].cantidad_producida;
}


function actualizarGalleta() {
    let nombreGalleta = document.getElementById("txtNombreGalleta2").value;
    let cantidadGalleta = document.getElementById("txtCantidadGalleta2").value;
    let precioGalleta = document.getElementById("txtPrecioGalleta2").value;
    let comentario = document.getElementById("txtComentarioGalleta2").value;

    let galleta = JSON.stringify({id_galleta: id_galleta, nombre_galleta: nombreGalleta, cantidad_producida: cantidadGalleta, precio_galleta: precioGalleta, comentario: comentario});

    let parametros = new URLSearchParams({datos: galleta});
    fetch('../api/galleta/actualizarGalleta',
            {
                method: 'POST',
                body: parametros,
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                if (data.error) {
                    // mandarError();
                    alert(JSON.stringify(data));
                } else {
                    Swal.fire({
                        position: 'top-center',
                        icon: 'success',
                        title: 'Actualizado correctamente',
                        showConfirmButton: false,
                        timer: 1500
                    });
                }
            });

}
//--------------------------------------------------------------------------INGREDIENTE-------------------------------------------------------------------------------//


function insertarIngrediente() {
    let nombreIngrediente = document.getElementById("txtNombreIngrediente").value;
    let cantidadIngrediente = document.getElementById("txtCantidadIngrediente").value;
    let unidadMedida = document.getElementById("txtUnidadMedida").value;
    let ingrediente = JSON.stringify({nombre_ingrediente: nombreIngrediente, cantidad: cantidadIngrediente, unidad_medida: unidadMedida});
    let parametros = new URLSearchParams({datos: ingrediente});
    fetch("../api/ingrediente/insertarIngrediente",
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                if (data.error)
                    alert(data.error);
                else {

                    Swal.fire({
                        position: 'top-center',
                        icon: 'success',
                        title: 'Guardado correctamente',
                        showConfirmButton: false,
                        timer: 1500
                    });
                }
            });
}

function obtenerDatosIngrediente(event) {
    debugger;
    var id;
    var botonPresionado = event.target;
    // Verificar si el clic ocurrió en el botón específico
    if (botonPresionado.id === 'btn1') {
        id = "1";
    } else if (botonPresionado.id === 'btn2') {
        id = "2";
    } else if (botonPresionado.id === 'btn3') {
        id = "3";
    } else if (botonPresionado.id === 'btn4') {
        id = "4";
    } else if (botonPresionado.id === 'btn5') {
        id = "5";
    } else if (botonPresionado.id === 'btn6') {
        id = "6";
    } else if (botonPresionado.id === 'btn7') {
        id = "7";
    } else if (botonPresionado.id === 'btn8') {
        id = "8";
    }

    let parametros = new URLSearchParams({id: id});
    fetch('../api/ingrediente/getIngrediente',
            {
                method: 'POST',
                body: (parametros),
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                if (data.error) {
                    alert(data.error);
                } else {
                    cargarFormIngrediente(data);
                    cargarLabelIngrediente(data);
                }
            });
}

let ingrediente;
let id_ingrediente;
function cargarFormIngrediente(data) {
//alert(i);
    ingrediente = data;
    document.getElementById("txtNombreIngrediente2").value = ingrediente.nombre_ingrediente;
    document.getElementById("txtCantidadIngrediente2").value = ingrediente.cantidad;
    document.getElementById("txtUnidadMedida2").value = ingrediente.unidad_medida;
    id_ingrediente = ingrediente.id_ingrediente;
}

function abrirVentanaInventario() {
    // Abre una nueva ventana con la URL especificada
    window.location.replace('screens/inventario.html');
}

function getAllIngredientes() {
    fetch('../api/ingrediente/getAllIngredientes',
            {
                method: 'GET',
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                if (data.error) {
                    alert(data.error);
                } else {
                    cargarLabelIngrediente(data);
                }
            });
}

function cargarLabelIngrediente(data) {
    ingrediente = data;
    var miLabel = document.getElementById('lbl1');
    miLabel.textContent = ingrediente[0].cantidad;
    var miLabel2 = document.getElementById('lbl2');
    miLabel2.textContent = ingrediente[1].cantidad;
    var miLabel3 = document.getElementById('lbl3');
    miLabel3.textContent = ingrediente[2].cantidad;
    var miLabel4 = document.getElementById('lbl4');
    miLabel4.textContent = ingrediente[3].cantidad;
    var miLabel5 = document.getElementById('lbl5');
    miLabel5.textContent = ingrediente[4].cantidad;
    var miLabel6 = document.getElementById('lbl6');
    miLabel6.textContent = ingrediente[5].cantidad;
    var miLabel7 = document.getElementById('lbl7');
    miLabel7.textContent = ingrediente[6].cantidad;
    var miLabel8 = document.getElementById('lbl8');
    miLabel8.textContent = ingrediente[7].cantidad;
}


function actualizarIngrediente() {
    let nombreIngrediente = document.getElementById("txtNombreIngrediente2").value;
    let cantidadIngrediente = document.getElementById("txtCantidadIngrediente2").value;
    let unidadMedida = document.getElementById("txtUnidadMedida2").value;
    let ingrediente = JSON.stringify({id_ingrediente: id_ingrediente, nombre_ingrediente: nombreIngrediente, cantidad: cantidadIngrediente, unidad_medida: unidadMedida});
    let parametros = new URLSearchParams({datos: ingrediente});
    fetch('../api/ingrediente/actualizarIngrediente',
            {
                method: 'POST',
                body: parametros,
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
            }).then(response => response.json())
            .then(data => {
                if (data.error) {
                    // mandarError();
                    alert(JSON.stringify(data));
                } else {
                    Swal.fire({
                        position: 'top-center',
                        icon: 'success',
                        title: 'Actualizado correctamente',
                        showConfirmButton: false,
                        timer: 1500
                    });
                }
            });
}