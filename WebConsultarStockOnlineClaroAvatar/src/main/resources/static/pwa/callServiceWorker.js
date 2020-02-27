if ('serviceWorker' in navigator) {
  navigator.serviceWorker.register('../pwa/serviceWorker.js')
    .then(reg => console.log('Registro de serviceWorker exitoso', reg))
    .catch(err => console.warn('Error al tratar de registrar el serviceWorker', err))
}