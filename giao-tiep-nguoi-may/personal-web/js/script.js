window.addEventListener('load', () => {
    let url = window.location.pathname;
    switch (url) {
        case '/index.html':
            document.querySelectorAll('[href="./index.html"]')[1].classList.add('active')
            break;
        case '/about.html':
            document.querySelector('[href="./about.html"]').classList.add('active')
            break;
        case '/lab4.html':
            document.querySelector('[href="./lab4.html"]').classList.add('active')
            break;
        case '/lab5.html':
            document.querySelector('[href="./lab5.html"]').classList.add('active')
            break;
        case '/lab6.html':
            document.querySelector('[href="./lab6.html"]').classList.add('active')
            break;

    }
})