window.addEventListener('load', () => {
    let url = window.location.pathname;
    switch (true) {
        case url.includes('/index.html'):
            document.querySelectorAll('[href="./index.html"]')[1].classList.add('active')
            break;
        case url.includes('/about.html'):
            document.querySelector('[href="./about.html"]').classList.add('active')
            break;
        case url.includes('/lab4.html'):
            document.querySelector('[href="./lab4.html"]').classList.add('active')
            break;
        case url.includes('/lab5.html'):
            document.querySelector('[href="./lab5.html"]').classList.add('active')
            break;
        case url.includes('/lab6.html'):
            document.querySelector('[href="./lab6.html"]').classList.add('active')
            break;
        case url.includes('/lab7.html'):
            document.querySelector('[href="./lab7.html"]').classList.add('active')
            break;
        case url.includes('/lab8.html'):
            document.querySelector('[href="./lab8.html"]').classList.add('active')
            break;

    }
})