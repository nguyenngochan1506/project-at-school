window.addEventListener('load', () => {
    let url = window.location.pathname;
    switch (url) {
        case '/project-at-school/giao-tiep-nguoi-may/personal-web/index.html':
            document.querySelectorAll('[href="./index.html"]')[1].classList.add('active')
            break;
        case '/project-at-school/giao-tiep-nguoi-may/personal-web/about.html':
            document.querySelector('[href="./about.html"]').classList.add('active')
            break;
        case '/project-at-school/giao-tiep-nguoi-may/personal-web/lab4.html':
            document.querySelector('[href="./lab4.html"]').classList.add('active')
            break;
        case '/project-at-school/giao-tiep-nguoi-may/personal-web/lab5.html':
            document.querySelector('[href="./lab5.html"]').classList.add('active')
            break;
        case '/project-at-school/giao-tiep-nguoi-may/personal-web/lab6.html':
            document.querySelector('[href="./lab6.html"]').classList.add('active')
            break;

    }
})