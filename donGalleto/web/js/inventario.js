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
