const SwalM = Swal.mixin({
    toast: true,
    position: 'top-end',
    showConfirmButton: false,
    timer: 3000,
    timerProgressBar: true,
    onOpen: (toast) => {
        toast.addEventListener('mouseenter', Swal.stopTimer)
        toast.addEventListener('mouseleave', Swal.resumeTimer)
    }
})

Toast = {
    success: function (message,position) {
        SwalM.fire({
            position: position||'top',
            icon: 'success',
            title: message,
            showConfirmButton: false,
            timer: 3000
        })
    },

    error: function (message,position) {
        SwalM.fire({
            position: position||'top',
            icon: 'error',
            title: message,
            showConfirmButton: false,
            timer: 3000
        })
    },

    warning: function (message,position) {
        SwalM.fire({
            position: position||'top',
            icon: 'warning',
            title: message,
            showConfirmButton: false,
            timer: 3000
        })
    }
};